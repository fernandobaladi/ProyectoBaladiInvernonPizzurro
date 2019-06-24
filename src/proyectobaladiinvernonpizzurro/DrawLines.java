/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobaladiinvernonpizzurro;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Invernon
 */
public class DrawLines extends JPanel{
    
    public void paintComponent (Graphics g) {
    
        
        g.setColor(Color.red);
        g.drawLine(100, 100, 300, 300);
    }

    public DrawLines() {
    }
    
    
}
