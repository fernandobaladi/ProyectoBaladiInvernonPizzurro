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
public class CreateLabelDynamically2 extends JFrame {
    JPanel Jpanel;
    int AntsNum, Iterations, pos;
    //Cities_[] cities;
    //int[] path;
    
    public CreateLabelDynamically2( int AntsNum, int Iterations){
        
        //this.cities = cities;
        this.AntsNum = AntsNum;
        this.Iterations = Iterations;
        //this.path = path;
        Jpanel = new JPanel();
        setLayout(null);
        Jpanel.setLayout(null);
        Jpanel.setBounds(50,50,550,1050);
        Jpanel.setOpaque(true);
        Jpanel.setBackground( Color.red );
        
        add(Jpanel);
    }
//    
    public void PanelRepaint(){
        Jpanel.validate();
        Jpanel.repaint();
    }
         
    public void paint (Graphics g){
            
         pos = 0;
         
         g.drawString (("   " + "hormiga" + "      "  + "iteración" + "      "  + "distancia" + "      " + "recorrido"), 40, 60);
         
         for (int i = 1; i <= this.AntsNum; i++) {
        
            g.setColor(Color.black);
            String aux = String.valueOf(i);
                        
            for (int j = 1; j <= this.Iterations; j++ ) {
                
                String aux2 = String.valueOf(j);
            
               System.out.println("a1 " + aux + "a2 " + aux2);
               g.drawString (("|     " + aux + "       |         "  + aux2 + "        |          "), 50, 80+(20*pos));
               
               pos ++;
               
            }
        }
//         this.PanelRepaint();
        
    }
}
