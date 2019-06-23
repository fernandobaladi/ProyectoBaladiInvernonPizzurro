/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobaladiinvernonpizzurro;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Fernando Baladi
 */
public class Ants_ {
    Integer posX=0, posY=0, ID=0;
    JLabel label;

    public Ants_() {
        this.label = AntLabel();
    }

    public Ants_(Integer posX, Integer posY, Integer Id) {
        System.out.println("posX: " + posX+ " pos Y: " + posY);
        this.label = AntLabel();
        this.AntPosition(posX, posY);
        this.ID = Id;
               
    }
   
    public JLabel AntLabel(){
        JLabel antIconLabel = new JLabel();   
        
        //Características de los labels         
        antIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectobaladiinvernonpizzurro/littleant2.png")));
        antIconLabel.setBackground(Color.getHSBColor(213,204,206));
        antIconLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        antIconLabel.setVisible(true);
        antIconLabel.setOpaque(true);    
        
        return antIconLabel;
    }
    
    public void AntPosition( int posX , int posY ){
        this.posX = posX;
        this.posY = posY;
        this.label.setBounds( posX, posY ,40,40);
        this.label.setSize(20, 20);
    }
    
}
