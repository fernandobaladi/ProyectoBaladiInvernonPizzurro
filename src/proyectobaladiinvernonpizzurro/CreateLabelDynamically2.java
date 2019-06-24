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
    Hormiga[] h;
    //Cities_[] cities;
    int[] path;
    ListaVertices listaDeCiudades;
    
    public CreateLabelDynamically2( int AntsNum, int Iterations, Hormiga[] h, ListaVertices listaDeCiudades){
        
        //this.cities = cities;
        this.AntsNum = AntsNum;
        this.Iterations = Iterations;
        this.path = path;
        Jpanel = new JPanel();
        setLayout(null);
        Jpanel.setLayout(null);
        Jpanel.setBounds(50,50,550,1050);
        Jpanel.setOpaque(true);
        Jpanel.setBackground( Color.red );
        this.h = h;
        add(Jpanel);
        this.listaDeCiudades = listaDeCiudades;
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
               g.drawString( ("|     " + aux + "       |         "  + aux2 + "   " ) , 50, 80+(20*pos) );
//               g.drawString (("|     " + aux + "       |         "  + aux2 + "   "+ 
//                       h[i].costo +"     |     "+ caminoDeLaHormiga(i)[0]+" "+ caminoDeLaHormiga(i)[1]+" "+ caminoDeLaHormiga(i)[2]+" "
//                       + caminoDeLaHormiga(i)[3]+" "+ caminoDeLaHormiga(i)[4]+" "+ caminoDeLaHormiga(i)[5]+" "+ caminoDeLaHormiga(i)[6]+" "+ caminoDeLaHormiga(i)[7]+
//                       " "+ caminoDeLaHormiga(i)[8]+" "+ caminoDeLaHormiga(i)[9]+" "+ caminoDeLaHormiga(i)[10]+" "+ caminoDeLaHormiga(i)[11]+" "+ caminoDeLaHormiga(i)[12]+" " 
//                               +"     "), 50, 80+(20*pos));
//               

               pos ++;
               
            }
        }
//         this.PanelRepaint();
        
    }
    
    public int[] caminoDeLaHormiga(int numeroHormigaEnArray) {
        
        Hormiga hor = h[numeroHormigaEnArray];
        hor.recorrerTodasLasCiudades(hor, listaDeCiudades);
        
        hor.cRecorridas = new int[listaDeCiudades.getnNodos()+1];
        hor.arrayAristas = new int[listaDeCiudades.getnNodos()];
        hor.arrayPrueba = new double[listaDeCiudades.getnNodos()];
        
        
        hor.cRecorridas[0] = hor.ciudadInicial.id;
        
        for (int i = 0; i < hor.cRecorridas.length - 1; i++) {
            hor.cRecorridas[i+1] = 0;
        }
        
        for (int i = 0; i < hor.arrayAristas.length; i++) {
            hor.arrayAristas[i] = 0;
        }
        
        hor.cRecorridas[listaDeCiudades.getnNodos()] = hor.ciudadInicial.id;
        hor.arrayAristas[listaDeCiudades.getnNodos()-1] = hor.ciudadInicial.id;
        
        
        hor.recorrerTodasLasCiudades(hor, listaDeCiudades);
        hor.feromonasGlobal(listaDeCiudades);
        
        return hor.cRecorridas;
        
    }
}
