/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Eventos;

import Herramientas.Elementos;
import Procesos.BGR2;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Adrian Pardo
 */
public class Spinner implements ChangeListener{

    private final int min,max;
    private final Elementos com;
    private BGR2 b;
    
    public Spinner(Elementos com) {
        this.com = com;
        this.min = (int) com.spn1.getValue();
        this.max = (int) com.spn2.getValue();
    }
    
    
    @Override
    public void stateChanged(ChangeEvent e) {
        b=new BGR2(7, com.txtUbicacion.getText(), com);
    }
    
}
