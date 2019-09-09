/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Herramientas.*;
import java.io.File;
import Procesos.BGR2;
import java.awt.HeadlessException;

/**
 *
 * @author Adrian Pardo
 */
public class General implements ActionListener{

    private final int des;
    private final Elementos com;
    private final Utils u = new Utils();
    private BGR2 b;
    private String url;

    public General(int des, Elementos com) {
        this.des = des;
        this.com = com;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (des) {
            case 0:
                ubica();
                break;
            case 1:
                change2();
                break;
        }
    }

    private void ubica() {
        String auxiliar;
        try {
            com.files.showOpenDialog(this.com.jfrPrincipal);
            File abre = com.files.getSelectedFile();
            if (abre != null) {
                auxiliar = abre.getPath();
                url = auxiliar;
                u.bgrLabel(abre.getAbsolutePath(), com.lblFotosBGR2[0]);
                com.spn1.setEnabled(true);
                com.spn2.setEnabled(true);
                com.cbmTratado.setEnabled(true);
            }
        } catch (HeadlessException e) {
            System.out.println("Error " + e.getClass().getName() + ": " + e.getMessage());
        }
        com.txtUbicacion.setText(url);
    }

    private void change2() {
        int op = 0;
        for (int i = 0; i != com.cbmTratado.getItemCount(); i++) {
            if (com.cbmTratado.getSelectedIndex() == i) {
                op = i;
            }
        }
        b = new BGR2(op, com.txtUbicacion.getText(), com);
    }
}