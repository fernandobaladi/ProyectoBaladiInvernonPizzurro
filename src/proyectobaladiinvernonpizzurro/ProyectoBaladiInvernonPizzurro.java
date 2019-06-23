/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobaladiinvernonpizzurro;

import javafx.geometry.HorizontalDirection;
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
        Vista v= new Vista();
        v.setVisible(true);         
        v.setResizable(false);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setLocationRelativeTo(null);
         
        /*Hormiga[] colonia = new Hormiga[v.nHormigas];
        
        for (int i = 0; i < colonia.length; i++) {
            Hormiga h = new Hormiga( v.listaDeCiudades.pFisrt, v.cityCounter+1, v.listaDeCiudades);
            colonia[i]=h;
        }*/
       /*ListaVertices vertices = new ListaVertices("Vertices");
        vertices.agregarAlFinal("Bogotá", 1);
        vertices.agregarAlFinal("Caracas", 2);
        vertices.agregarAlFinal("Maracay", 3);
        vertices.agregarAlFinal("Apure", 4);
        vertices.agregarAlFinal("Nueva York", 5);
        vertices.agregarAlFinal("Miami", 6);
        
        vertices.pFirst.nodosAristasAdyacentes.agregarAlFinal(10, "Caracas", 2);
        vertices.pFirst.nodosAristasAdyacentes.agregarAlFinal(15, "Maracay", 3);
        vertices.pFirst.nodosAristasAdyacentes.agregarAlFinal(20, "Apure", 4);
        vertices.pFirst.nodosAristasAdyacentes.agregarAlFinal(25, "Nueva York", 5);
        vertices.pFirst.nodosAristasAdyacentes.agregarAlFinal(30, "Miami", 6);
        
        vertices.pFirst.pNext.nodosAristasAdyacentes.agregarAlFinal(10, "Bogotá", 1);
        vertices.pFirst.pNext.nodosAristasAdyacentes.agregarAlFinal(35, "Maracay", 3);
        vertices.pFirst.pNext.nodosAristasAdyacentes.agregarAlFinal(40, "Apure", 4);
        vertices.pFirst.pNext.nodosAristasAdyacentes.agregarAlFinal(45, "Nueva York", 5);
        vertices.pFirst.pNext.nodosAristasAdyacentes.agregarAlFinal(50, "Miami", 6);
        
        vertices.pFirst.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(15, "Bogotá", 1);
        vertices.pFirst.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(35, "Caracas", 2);
        vertices.pFirst.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(55, "Apure", 4);
        vertices.pFirst.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(60, "Nueva York", 5);
        vertices.pFirst.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(65, "Miami", 6);
        
        vertices.pFirst.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(20, "Bogotá", 1);
        vertices.pFirst.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(40, "Caracas", 2);
        vertices.pFirst.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(55, "Maracay", 3);
        vertices.pFirst.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(70, "Nueva York", 5);
        vertices.pFirst.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(75, "Miami", 6);
        
        vertices.pFirst.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(25, "Bogotá", 1);
        vertices.pFirst.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(45, "Caracas", 2);
        vertices.pFirst.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(60, "Maracay", 3);
        vertices.pFirst.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(70, "Apure", 4);
        vertices.pFirst.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(80, "Miami", 6);
        
        vertices.pFirst.pNext.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(30, "Bogotá", 1);
        vertices.pFirst.pNext.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(50, "Caracas", 2);
        vertices.pFirst.pNext.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(65, "Maracay", 3);
        vertices.pFirst.pNext.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(75, "Apure", 4);
        vertices.pFirst.pNext.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(80, "Nueva York", 5);
        
        Hormiga h1 = new Hormiga(vertices.pFirst.pNext.pNext, vertices.nNodos, vertices);
        
        h1.irASiguienteCiudad(vertices);
        h1.irASiguienteCiudad(vertices);
        h1.irASiguienteCiudad(vertices);
        h1.irASiguienteCiudad(vertices);
*/
        
    }
    
}
