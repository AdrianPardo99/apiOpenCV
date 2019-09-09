/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Eventos.General;
import Eventos.Spinner;
import Herramientas.Elementos;
import Herramientas.Utils;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Adrian Pardo
 */
public class GeneraFrame {

    private final Elementos com;

    public GeneraFrame() {
        com = new Elementos();
    }

    public void initAll(){
        creaFrame("OpenCV", 700, 680);
    }
    
    private void creaFrame(String name, int alto, int ancho) {
        com.jfrPrincipal = new JFrame(name);
        com.jfrPrincipal.setResizable(false);
        com.jfrPrincipal.setLayout(null);
        com.jfrPrincipal.setBounds(0, 0, ancho, alto);
        com.jfrPrincipal.setLocationRelativeTo(null);
        com.jfrPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Declara();
        com.jfrPrincipal.setVisible(true);
    }

    private void Declara() {
        com.lblBusqueda = new JLabel("Ubicación");
        com.lblBGR2 = new JLabel[19];
        com.lblFotosBGR2 = new JLabel[19];
        com.lblFondo = new JLabel();
        com.txtUbicacion = new JTextField();
        com.btnAceptar = new JButton("Buscar");
        com.cbmTratado = new JComboBox();
        for (int i = 0; i < com.lblBGR2.length; i++) {
            com.lblBGR2[i] = new JLabel();
        }
        for (int i = 0; i < com.lblFotosBGR2.length; i++) {
            com.lblFotosBGR2[i] = new JLabel();
        }
        com.btnGuardar = new JButton("Aceptar");
        com.files = new JFileChooser(System.getProperty("user.home")
                + System.getProperty("file.separator") + "Imágenes");
        com.spn1 = new JSpinner(new SpinnerNumberModel(150, 1, 255, 1));
        com.spn2 = new JSpinner(new SpinnerNumberModel(200, 1, 255, 1));
        Ubica();
    }

    private void Ubica() {
        com.lblBGR2[0].setText("Foto Original");
        com.lblBGR2[1].setText("BGR2");
        com.lblBGR2[2].setText("Red");
        com.lblBGR2[3].setText("Green");
        com.lblBGR2[4].setText("Blue");
        com.lblBGR2[5].setText("RedGray");
        com.lblBGR2[6].setText("GreenGray");
        com.lblBGR2[7].setText("BlueGray");
        com.lblBGR2[8].setText("Ecualizado");
        com.lblBGR2[9].setText("Histograma");
        com.lblBGR2[10].setText("Gray1");
        com.lblBGR2[11].setText("ThreshBin");
        com.lblBGR2[12].setText("ThreshBinI");
        com.lblBGR2[13].setText("ThreshMask");
        com.lblBGR2[14].setText("ThreshOtsu");
        com.lblBGR2[15].setText("ThreshTozero");
        com.lblBGR2[16].setText("ThreshTozeroIn");
        com.lblBGR2[17].setText("ThreshTrian");
        com.lblBGR2[18].setText("ThreshTrunc");
        com.lblBusqueda.setBounds(10, 10, 60, 30);
        com.txtUbicacion.setBounds(80, 10, 410, 30);
        com.lblFondo.setBounds(0, 0, 
                com.jfrPrincipal.getWidth(), 
                com.jfrPrincipal.getHeight());
        com.lblBGR2[0].setBounds(25, 50, 90, 30);
        com.lblBGR2[1].setBounds(10, 250, 90, 30);
        com.lblBGR2[2].setBounds(90, 250, 90, 30);
        com.lblBGR2[3].setBounds(170, 250, 90, 30);
        com.lblBGR2[4].setBounds(250, 250, 90, 30);
        com.lblBGR2[5].setBounds(330, 250, 90, 30);
        com.lblBGR2[6].setBounds(410, 250, 90, 30);
        com.lblBGR2[7].setBounds(490, 250, 90, 30);
        com.lblBGR2[8].setBounds(580, 250, 90, 30);
        com.lblBGR2[9].setBounds(10, 390, 90, 30);
        com.lblBGR2[10].setBounds(90, 390, 90, 30);
        com.lblBGR2[11].setBounds(170, 390, 90, 30);
        com.lblBGR2[12].setBounds(250, 390, 90, 30);
        com.lblBGR2[13].setBounds(330, 390, 90, 30);
        com.lblBGR2[14].setBounds(410, 390, 90, 30);
        com.lblBGR2[15].setBounds(490, 390, 90, 30);
        com.lblBGR2[16].setBounds(580, 390, 90, 30);
        com.lblBGR2[17].setBounds(10, 530, 90, 30);
        com.lblBGR2[18].setBounds(90, 530, 90, 30);
        com.lblFotosBGR2[0].setBounds(10, 90, 70, 90);
        com.lblFotosBGR2[1].setBounds(10, 290, 70, 90);
        com.lblFotosBGR2[2].setBounds(90, 290, 70, 90);
        com.lblFotosBGR2[3].setBounds(170, 290, 70, 90);
        com.lblFotosBGR2[4].setBounds(250, 290, 70, 90);
        com.lblFotosBGR2[5].setBounds(330, 290, 70, 90);
        com.lblFotosBGR2[6].setBounds(410, 290, 70, 90);
        com.lblFotosBGR2[7].setBounds(490, 290, 70, 90);
        com.lblFotosBGR2[8].setBounds(580, 290, 70, 90);
        com.lblFotosBGR2[9].setBounds(10, 430, 70, 90);
        com.lblFotosBGR2[10].setBounds(90, 430, 70, 90);
        com.lblFotosBGR2[11].setBounds(170, 430, 70, 90);
        com.lblFotosBGR2[12].setBounds(250, 430, 70, 90);
        com.lblFotosBGR2[13].setBounds(330, 430, 70, 90);
        com.lblFotosBGR2[14].setBounds(410, 430, 70, 90);
        com.lblFotosBGR2[15].setBounds(490, 430, 70, 90);
        com.lblFotosBGR2[16].setBounds(580, 430, 70, 90);
        com.lblFotosBGR2[17].setBounds(10, 570, 70, 90);
        com.lblFotosBGR2[18].setBounds(90, 570, 70, 90);
        com.cbmTratado.setBounds(90, 150, 90, 30);

        com.spn1.setBounds(200, 150, 50, 30);
        com.spn2.setBounds(270, 150, 50, 30);
        com.btnAceptar.setBounds(500, 10, 100, 30);
        com.btnGuardar.setBounds(340, 200, 100, 30);
        Agrega();
    }

    private void Agrega() {
        com.jfrPrincipal.add(com.lblBusqueda);
        com.jfrPrincipal.add(com.txtUbicacion);
        for (JLabel lblBGR2 : com.lblBGR2) {
            com.jfrPrincipal.add(lblBGR2);
        }
        for (JLabel lblFotosBGR2 : com.lblFotosBGR2) {
            com.jfrPrincipal.add(lblFotosBGR2);
        }
        com.jfrPrincipal.add(com.cbmTratado);
        com.jfrPrincipal.add(com.btnAceptar);
        com.jfrPrincipal.add(com.spn1);
        com.jfrPrincipal.add(com.spn2);
        Eventos();
    }

    private void Eventos() {

        for (int i = 0; i != com.combo.length; i++) {
            com.cbmTratado.addItem(com.combo[i]);
        }

        for (int i = 0; i != com.lblFotosBGR2.length; i++) {
            com.lblFotosBGR2[i].setBorder(LineBorder.createBlackLineBorder());
        }
        com.btnAceptar.addActionListener(new General(0, com));
        com.cbmTratado.addActionListener(new General(1, com));
        com.spn1.addChangeListener(new Spinner(com));
        com.spn2.addChangeListener(new Spinner(com));
        com.txtUbicacion.setEditable(false);
        com.cbmTratado.setEnabled(false);
        com.spn1.setEnabled(false);
        com.spn2.setEnabled(false);
    }

}
