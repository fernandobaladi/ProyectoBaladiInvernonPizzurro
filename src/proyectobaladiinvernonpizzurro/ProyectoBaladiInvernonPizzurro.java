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
       /* Vista v= new Vista();
         v.setVisible(true);         
         v.setResizable(false);
         v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         v.setLocationRelativeTo(null);
         
        Hormiga[] colonia = new Hormiga[v.nHormigas];
        
        for (int i = 0; i < colonia.length; i++) {
            Hormiga h = new Hormiga( v.listaDeCiudades.pFisrt, v.cityCounter+1);
            colonia[i]=h;
        }*/
       ListaVertices vertices = new ListaVertices("Vertices");
        vertices.agregarAlFinal("Bogotá", 1);
        vertices.agregarAlFinal("Caracas", 2);
        vertices.agregarAlFinal("Maracay", 3);
        vertices.agregarAlFinal("Apure", 4);
        vertices.agregarAlFinal("Nueva York", 5);
        vertices.agregarAlFinal("Miami", 6);
        
        vertices.pFisrt.nodosAristasAdyacentes.agregarAlFinal(10, "Caracas", 2);
        vertices.pFisrt.nodosAristasAdyacentes.agregarAlFinal(15, "Maracay", 3);
        vertices.pFisrt.nodosAristasAdyacentes.agregarAlFinal(20, "Apure", 4);
        vertices.pFisrt.nodosAristasAdyacentes.agregarAlFinal(25, "Nueva York", 5);
        vertices.pFisrt.nodosAristasAdyacentes.agregarAlFinal(30, "Miami", 6);
        
        vertices.pFisrt.pNext.nodosAristasAdyacentes.agregarAlFinal(10, "Bogotá", 1);
        vertices.pFisrt.pNext.nodosAristasAdyacentes.agregarAlFinal(35, "Maracay", 3);
        vertices.pFisrt.pNext.nodosAristasAdyacentes.agregarAlFinal(40, "Apure", 4);
        vertices.pFisrt.pNext.nodosAristasAdyacentes.agregarAlFinal(45, "Nueva York", 5);
        vertices.pFisrt.pNext.nodosAristasAdyacentes.agregarAlFinal(50, "Miami", 6);
        
        vertices.pFisrt.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(15, "Bogotá", 1);
        vertices.pFisrt.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(35, "Caracas", 2);
        vertices.pFisrt.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(55, "Apure", 4);
        vertices.pFisrt.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(60, "Nueva York", 5);
        vertices.pFisrt.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(65, "Miami", 6);
        
        vertices.pFisrt.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(20, "Bogotá", 1);
        vertices.pFisrt.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(40, "Caracas", 2);
        vertices.pFisrt.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(55, "Maracay", 3);
        vertices.pFisrt.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(70, "Nueva York", 5);
        vertices.pFisrt.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(75, "Miami", 6);
        
        vertices.pFisrt.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(25, "Bogotá", 1);
        vertices.pFisrt.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(45, "Caracas", 2);
        vertices.pFisrt.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(60, "Maracay", 3);
        vertices.pFisrt.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(70, "Apure", 4);
        vertices.pFisrt.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(80, "Miami", 6);
        
        vertices.pFisrt.pNext.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(30, "Bogotá", 1);
        vertices.pFisrt.pNext.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(50, "Caracas", 2);
        vertices.pFisrt.pNext.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(65, "Maracay", 3);
        vertices.pFisrt.pNext.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(75, "Apure", 4);
        vertices.pFisrt.pNext.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(80, "Nueva York", 5);
        
        Hormiga h = new Hormiga(vertices.pFisrt.pNext, vertices.nNodos);
        h.irASiguienteCiudad(vertices,0);
        h.irASiguienteCiudad(vertices, 1);
        h.irASiguienteCiudad(vertices, 2);
        h.irASiguienteCiudad(vertices, 3);
        h.irASiguienteCiudad(vertices, 4);

        
    }
    
}
