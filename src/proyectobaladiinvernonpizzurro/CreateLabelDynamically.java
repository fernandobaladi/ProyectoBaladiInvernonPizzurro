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
    
    public CreateLabelDynamically(){
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
    
    protected void paintComponent (Graphics g) {
    
        g.setColor(Color.red);
        g.drawLine(100, 100, 300, 300);
    }
}
