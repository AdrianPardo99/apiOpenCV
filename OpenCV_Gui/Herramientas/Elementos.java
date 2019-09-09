/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramientas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JFileChooser;

/**
 *
 * @author Adrian Pardo
 */
public class Elementos {

    public JFrame jfrPrincipal;
    public JLabel lblBusqueda, lblBGR2[], lblFotosBGR2[], lblFondo;
    public JButton btnAceptar, btnGuardar;
    public JTextField txtUbicacion;
    public JComboBox cbmTratado, cbmThre1, cbmThre2;
    public JSpinner spn1, spn2;
    public JFileChooser files;
    public final Object[] combo = {"BGR2RGB", "BGR2HLS", "BGR2HSV", "BGR2Lab", "BGR2YUV", "BGR2GRAY", "BGR2GRAYMaxMin"};
    public final int puntos1[] = new int[255];
}
