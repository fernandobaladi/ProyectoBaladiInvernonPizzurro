/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobaladiinvernonpizzurro;

import javax.swing.JFrame;

/**
 *
 * @author Fernando Baladi
 */
public class ProyectoBaladiInvernonPizzurro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vista v= new Vista();
         v.setVisible(true);         
         v.setResizable(false);
         v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         v.setLocationRelativeTo(null);
    }
    
}
