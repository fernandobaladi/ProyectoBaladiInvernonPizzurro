/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobaladiinvernonpizzurro;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author Invernon
 */
public class Cities_ {
    
    Integer posX, posY, ID;
    String name;
    JLabel label;
    Boolean delete;

    public Cities_(Integer posX, Integer posY, Integer ID, String name, JLabel label, Boolean delete) {
        this.posX = posX;
        this.posY = posY;
        this.ID = ID;
        this.name = name;
        this.label = label;
        this.delete = delete;
    }
    
    public Cities_( String name , int Id ) {
        this.name = name;
        this.posX = 0;
        this.posY = 0;
        this.ID = Id;
        this.delete = false;
        this.label = this.CityLabel();
        
         
    }
   
    public Cities_() {
        
    }
    
    public void destroyCity () {
        
    } 
    
    public JLabel CityLabel(){
        JLabel CityImagejLabel = new JLabel();   
        //Características de los labels 
        CityImagejLabel.setFont(new java.awt.Font("Arial", 0, 8)); 
        CityImagejLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectobaladiinvernonpizzurro/city.png")));
        CityImagejLabel.setBackground(new java.awt.Color(213,204,206));
        CityImagejLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CityImagejLabel.setVisible(!this.delete);
        CityImagejLabel.setOpaque(true);
        
//        final String name = this.name;
//            CityImagejLabel.addMouseListener(new MouseAdapter() {
//
//                public void mouseEntered(MouseEvent mEvt) {
//                    CityImagejLabel.setToolTipText("ADADADADADADA");
//            }
//        });
        
        return CityImagejLabel;
    }
    
    public void CityPosition( int posX , int posY ){
        this.posX = posX;
        this.posY = posY;
        this.label.setBounds( posX, posY ,60,40);
    }
    
    
}
