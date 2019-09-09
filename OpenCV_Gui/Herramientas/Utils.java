/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramientas;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Adrian Pardo
 */
public class Utils {

    public void fondoLabel(String url, JLabel lbl) {
        try {
            File fl=new File(".");
            ImageIcon i=new ImageIcon(fl.getCanonicalPath()+"/"+url);
            i=new ImageIcon(i.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH));
            lbl.setIcon(i);
        } catch (IOException e) {
            System.out.println("Error "+e.getClass().getName()+": "+e.getMessage());
        }
    }
    
    public void bgrLabel(String url,JLabel lbl){
        try{
            ImageIcon icon=new ImageIcon(url);
            icon=new ImageIcon(icon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH));
            lbl.setIcon(icon);
            lbl.setOpaque(false);
            lbl.repaint();
        }catch(Exception e){
            System.out.println("Error "+e.getClass().getName()+": "+e.getMessage());
        }
    }
}
