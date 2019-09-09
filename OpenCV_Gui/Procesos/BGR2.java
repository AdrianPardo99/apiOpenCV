/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Herramientas.Elementos;
import Herramientas.Utils;
import java.util.ArrayList;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Adrian Pardo
 */
public class BGR2 {

    private int alto, ancho, des, lim;
    private Mat imagenOri, imagenNew;
    private String url, nombre = "", nombre2[] = {"Roja", "Verde", "Azul"};
    private final Utils u = new Utils();
    private final Elementos com;

    public BGR2(int des, String url, Elementos com) {
        this.des = des;
        this.url = url;
        this.com = com;
        for (int i = 0; i < url.length(); i++) {
            char c = url.charAt(i);
            if (c == '\\') {
                nombre += "/";
            } else {
                nombre += url.charAt(i);
            }
        }
        carga(nombre);
    }

    private void carga(String url) {
        imagenOri = Imgcodecs.imread(url);
        ancho = imagenOri.width();
        alto = imagenOri.height();
        procesos();

    }

    private void guarda(String url, Mat img, int op) {
        Imgcodecs.imwrite(url, img);
        u.fondoLabel(url, com.lblFotosBGR2[op + 1]);
    }

    private void procesos() {
        imagenNew = new Mat();
        switch (des) {
            case 0:
                BGR2RGB();
                break;
            case 1:
                BGR2HLS();
                break;
            case 2:
                BGR2HSV();
                break;
            case 3:
                BGR2Lab();
                break;
            case 4:
                BGR2YUV();
                break;
            case 5:
                BGR2GRAY();
                break;
            case 6:
                BGR2GRAYMaxMin();
                break;
            case 7:
                Gauss2();
                break;
        }
        if (des >= 0 && des <= 6) {
            capasRGB();
            capasRGB_BW();
            Gauss();
        }
    }

    private void BGR2RGB() {
        Imgproc.cvtColor(imagenOri, imagenNew, Imgproc.COLOR_BGR2RGB);
        guarda("bgr2.jpg", imagenNew, 0);
    }

    private void BGR2HLS() {
        Imgproc.cvtColor(imagenOri, imagenNew, Imgproc.COLOR_BGR2HLS);
        guarda("bgr2.jpg", imagenNew, 0);
    }

    private void BGR2HSV() {
        Imgproc.cvtColor(imagenOri, imagenNew, Imgproc.COLOR_BGR2HSV);
        guarda("bgr2.jpg", imagenNew, 0);
    }

    private void BGR2Lab() {
        Imgproc.cvtColor(imagenOri, imagenNew, Imgproc.COLOR_BGR2Lab);
        guarda("bgr2.jpg", imagenNew, 0);
    }

    private void BGR2YUV() {
        Imgproc.cvtColor(imagenOri, imagenNew, Imgproc.COLOR_BGR2YUV);
        guarda("bgr2.jpg", imagenNew, 0);
    }

    private double[] minMAX(double pixel[]) {
        double min_max[] = new double[]{pixel[0], pixel[0]};
        for (int i = 0; i < pixel.length; i++) {
            if (min_max[0] > pixel[i]) {
                min_max[0] = pixel[i];
            }
            if (min_max[1] < pixel[i]) {
                min_max[1] = pixel[i];
            }
        }
        return min_max;
    }

    private void BGR2GRAY() {
        imagenNew = new Mat(alto, ancho, CvType.CV_8UC1);
        Imgproc.cvtColor(imagenOri, imagenNew, Imgproc.COLOR_BGR2GRAY);
        guarda("grayOpen.jpg", imagenNew, 0);
    }

    private void BGR2GRAYMaxMin() {
        double colorOri[], colorNew, min_max[];
        imagenNew = new Mat(alto, ancho, CvType.CV_8UC1);
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                colorOri = imagenOri.get(j, i);
                min_max = minMAX(colorOri);
                colorNew = (min_max[0] + min_max[1]) / 2;
                imagenNew.put(j, i, colorNew);
            }
        }
        guarda("bgr2grayMaxMinProm.jpg", imagenNew, 0);
    }

    private void capasRGB() {
        double pixel[];
        for (int i = 0; i != 3; i++) {
            imagenNew = imagenOri.clone();
            for (int j = 0; j != ancho; j++) {
                for (int k = 0; k != alto; k++) {
                    pixel = imagenNew.get(k, j);
                    switch (i) {
                        case 0:
                            imagenNew.put(k, j, new double[]{0, 0, pixel[2]});
                            break;
                        case 1:
                            imagenNew.put(k, j, new double[]{0, pixel[1], 0});
                            break;
                        default:
                            imagenNew.put(k, j, new double[]{pixel[0], 0, 0});
                            break;
                    }
                }
            }
            guarda("Capa " + nombre2[i] + ".jpg", imagenNew, i + 1);
        }
    }

    private void capasRGB_BW() {
        ArrayList<Mat> bgr = new ArrayList<>();
        Core.split(imagenOri, bgr);
        guarda("capaAzulGris.jpg", bgr.get(0), 4);
        guarda("capaVerdeGris.jpg", bgr.get(1), 5);
        guarda("capaRojaGris.jpg", bgr.get(2), 6);
        imagenNew = new Mat();
        Imgproc.cvtColor(imagenOri, imagenNew, Imgproc.COLOR_BGR2GRAY);
        Imgproc.equalizeHist(imagenNew, imagenNew);
        guarda("imgHisEcualizado.jpg", imagenNew, 7);
        imagenNew = new Mat();
        Imgproc.cvtColor(imagenOri, imagenNew, Imgproc.COLOR_BGR2GRAY);
        ArrayList<Mat> bgr2 = new ArrayList<>();
        Core.split(imagenOri, bgr2);
        MatOfInt size = new MatOfInt(256);
        MatOfFloat rango = new MatOfFloat(0.0f, 256.0f);
        Mat hist = new Mat();
        Imgproc.calcHist(bgr, new MatOfInt(0), new Mat(), hist, size, rango, false);
        guardaGraficoHistograma("Histograma.jpg", hist);
    }

    private void guardaGraficoHistograma(String url, Mat his) {
        int anchoHis = 600;
        int altoHis = 600;
        long bin = Math.round(anchoHis / 256);
        Mat histImage = new Mat(altoHis, anchoHis, CvType.CV_8UC1);
        Core.normalize(his, his, 3, histImage.rows(), Core.NORM_MINMAX);
        for (int i = 1; i != 256; i++) {
            double x1 = bin * (i - 1);
            double y1 = altoHis - Math.round(his.get(i - 1, 0)[0]);
            double x2 = bin * (i);
            double y2 = altoHis - Math.round(his.get(i, 0)[0]);
            Imgproc.line(histImage, new Point(x1, y1), new Point(x2, y2), new Scalar(255, 0, 0), 2, 8, 0);
        }
        guarda(url, histImage, 8);
    }

    private void Gauss() {
        imagenNew = new Mat(alto, ancho, CvType.CV_8UC1);
        Imgproc.cvtColor(imagenOri, imagenNew, Imgproc.COLOR_BGR2GRAY);
        String a, b;
        a = com.spn1.getValue().toString();
        b = com.spn2.getValue().toString();
        double m1 = Double.parseDouble(a), m2 = Double.parseDouble(b);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C);
        guarda("bwGauss.jpg", imagenNew, 9);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 0);
        guarda("bwGauss1.jpg", imagenNew, 10);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 1);
        guarda("bwGauss2.jpg", imagenNew, 11);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 7);
        guarda("bwGauss3.jpg", imagenNew, 12);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 8);
        guarda("bwGauss4.jpg", imagenNew, 13);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 3);
        guarda("bwGauss5.jpg", imagenNew, 14);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 4);
        guarda("bwGauss6.jpg", imagenNew, 15);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 16);
        guarda("bwGauss7.jpg", imagenNew, 16);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 2);
        guarda("bwGauss8.jpg", imagenNew, 17);
    }

    private void Gauss2() {
        imagenNew = new Mat(alto, ancho, CvType.CV_8UC1);
        Imgproc.cvtColor(imagenOri, imagenNew, Imgproc.COLOR_BGR2GRAY);
        String a, b;
        a = com.spn1.getValue().toString();
        b = com.spn2.getValue().toString();
        double m1 = Double.parseDouble(a), m2 = Double.parseDouble(b);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C);
        guarda("bwGauss.jpg", imagenNew, 9);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 0);
        guarda("bwGauss1.jpg", imagenNew, 10);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 1);
        guarda("bwGauss2.jpg", imagenNew, 11);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 7);
        guarda("bwGauss3.jpg", imagenNew, 12);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 8);
        guarda("bwGauss4.jpg", imagenNew, 13);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 3);
        guarda("bwGauss5.jpg", imagenNew, 14);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 4);
        guarda("bwGauss6.jpg", imagenNew, 15);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 16);
        guarda("bwGauss7.jpg", imagenNew, 16);
        Imgproc.threshold(imagenNew, imagenNew, m1, m2, 2);
        guarda("bwGauss8.jpg", imagenNew, 17);
    }
}
