/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobaladiinvernonpizzurro;

import java.awt.Color;
import static java.awt.FlowLayout.CENTER;
import static java.awt.FlowLayout.TRAILING;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Invernon
 * 
 */
public class Ants_ {
  Integer posX=0, posY=0, ID;
  JLabel label;

    public Ants_() {
        this.label = AntLabel();
    }

    public Ants_(Integer posX, Integer posY, Integer Id) {
       
        this.ID = Id;
        this.label = AntLabel();
        this.AntPosition(posX, posY);
               
    }
   
    public JLabel AntLabel(){
        JLabel antIconLabel = new JLabel();   
        
        //Características de los labels      
        antIconLabel.setFont(new java.awt.Font("Arial", 1, 12));        
        antIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectobaladiinvernonpizzurro/littleant2.png")));
        antIconLabel.setBackground(new java.awt.Color(213,204,206));
        antIconLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        antIconLabel.setVisible(true);
        antIconLabel.setOpaque(true);
        antIconLabel.setText((this.ID).toString());
     
        return antIconLabel;
    }
    
    public void AntPosition( int posX , int posY ){
        this.posX = posX;
        this.posY = posY;
        this.label.setBounds( posX, posY ,40,40);
        this.label.setSize(40,25);
    }
    
    public void TotalDistance () {
    
        
    }
    
    
}