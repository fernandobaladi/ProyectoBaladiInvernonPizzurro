/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobaladiinvernonpizzurro;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Invernon
 */
public class CreateLabelDynamically extends JFrame {
    JPanel Jpan;
    Cities_[] cities;
    int[] path;
    
    public CreateLabelDynamically(Cities_[] cities, int[] path){
        
        this.cities = cities;
        this.path = path;
        Jpan = new JPanel();
        setLayout(null);
        Jpan.setLayout(null);
        Jpan.setBounds(50,50,550,550);
        Jpan.setOpaque(true);
        Jpan.setBackground( Color.CYAN );
        
        add(Jpan);
    }
    
    public void PanelRepaint(){
        Jpan.validate();
        Jpan.repaint();
    }
    
    public void PaintCity( JLabel label , int posX, int posY ){
        label.setBounds(posX, posY, 54, 40);
        Jpan.add(label);
        
        this.PanelRepaint();
    }
     
     public void paint (Graphics g){
    
         // Por cada camino se crea una línea 
         
         for (int i=0; i<this.path.length; i++){
            g.setColor(Color.blue);
            if (i==path.length-1){
            
                g.drawLine(this.cities[i].posX + 20, this.cities[i].posY + 20, this.cities[0].posX + 20, this.cities[0].posY + 20);
            }
            else {
            
                 g.drawLine(this.cities[i].posX + 20, this.cities[i].posY + 20, this.cities[i+1].posX + 20, this.cities[i+1].posY + 20);
            }
            //g.drawLine(100*i, 100*i, 400, 400);

         }
         
         for (int i=0; i < cities.length; i++) {
            if( cities[i] != null ){
                //PaintCity( cities[i].label, cities[i].posX , cities[i].posY ); //Esta es para que se pinte en el cuadro extra. Se tiene que desactivar el otro.
                g.setColor(Color.black);
                g.fillRect(cities[i].posX, cities[i].posY, 40, 40);
                g.drawString(cities[i].name, cities[i].posX, cities[i].posY + 50 );
               // g.drawRect(cities[i].posX, cities[i].posY, 50, 50);
            }
        }  
    }
}
