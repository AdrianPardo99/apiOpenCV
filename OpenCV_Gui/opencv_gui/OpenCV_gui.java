/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencv_gui;

import Interfaces.GeneraFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author developercrack
 */
public class OpenCV_gui {

    /**
     * @param args the command line arguments
     */
    static {
        //System.load("-Djava.library.path=\"/home/developercrack/OpenCV/build/lib\"");
        switch (System.getProperty("os.name")) {
            case "Linux":
                JOptionPane.showMessageDialog(null, "The app works in Linux OS",
                        "Information", JOptionPane.INFORMATION_MESSAGE);
                System.load(System.getProperty("user.home")
                        + "/OpenCV/build/lib/libopencv_java342.so");
                break;
            default:
                System.out.println("Error not working in this OS");
                System.exit(1);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        final GeneraFrame gf = new GeneraFrame();
        gf.initAll();

    }

}
