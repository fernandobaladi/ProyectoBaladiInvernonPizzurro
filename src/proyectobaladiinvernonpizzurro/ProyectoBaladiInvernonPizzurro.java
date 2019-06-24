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
        
        
        ProyectoBaladiInvernonPizzurro proyecto = new ProyectoBaladiInvernonPizzurro();
        ListaVertices vertices = new ListaVertices("Vertices");
        vertices.agregarAlFinal("Bogotá", 1);
        vertices.agregarAlFinal("Caracas", 2);
        vertices.agregarAlFinal("Maracay", 3);
        vertices.agregarAlFinal("Apure", 4);
        vertices.agregarAlFinal("Nueva York", 5);
        vertices.agregarAlFinal("Miami", 6);
        
        //bogota
        vertices.pFirst.nodosAristasAdyacentes.agregarAlFinal(10, "Caracas", 2);
        vertices.pFirst.nodosAristasAdyacentes.agregarAlFinal(15, "Maracay", 3);
        vertices.pFirst.nodosAristasAdyacentes.agregarAlFinal(20, "Apure", 4);
        vertices.pFirst.nodosAristasAdyacentes.agregarAlFinal(25, "Nueva York", 5);
        vertices.pFirst.nodosAristasAdyacentes.agregarAlFinal(30, "Miami", 6);
        
        //caracas
        vertices.pFirst.pNext.nodosAristasAdyacentes.agregarAlFinal(10, "Bogotá", 1);
        vertices.pFirst.pNext.nodosAristasAdyacentes.agregarAlFinal(35, "Maracay", 3);
        vertices.pFirst.pNext.nodosAristasAdyacentes.agregarAlFinal(40, "Apure", 4);
        vertices.pFirst.pNext.nodosAristasAdyacentes.agregarAlFinal(45, "Nueva York", 5);
        vertices.pFirst.pNext.nodosAristasAdyacentes.agregarAlFinal(50, "Miami", 6);
        
        //maracay
        vertices.pFirst.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(15, "Bogotá", 1);
        vertices.pFirst.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(35, "Caracas", 2);
        vertices.pFirst.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(55, "Apure", 4);
        vertices.pFirst.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(60, "Nueva York", 5);
        vertices.pFirst.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(65, "Miami", 6);
        
        //apure
        vertices.pFirst.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(20, "Bogotá", 1);
        vertices.pFirst.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(40, "Caracas", 2);
        vertices.pFirst.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(55, "Maracay", 3);
        vertices.pFirst.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(70, "Nueva York", 5);
        vertices.pFirst.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(75, "Miami", 6);
        
        //new york
        vertices.pFirst.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(25, "Bogotá", 1);
        vertices.pFirst.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(45, "Caracas", 2);
        vertices.pFirst.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(60, "Maracay", 3);
        vertices.pFirst.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(70, "Apure", 4);
        vertices.pFirst.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(80, "Miami", 6);
        
        //miami
        vertices.pFirst.pNext.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(30, "Bogotá", 1);
        vertices.pFirst.pNext.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(50, "Caracas", 2);
        vertices.pFirst.pNext.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(65, "Maracay", 3);
        vertices.pFirst.pNext.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(75, "Apure", 4);
        vertices.pFirst.pNext.pNext.pNext.pNext.pNext.nodosAristasAdyacentes.agregarAlFinal(80, "Nueva York", 5);
        
        
        Hormiga h = new Hormiga(vertices.pFirst.pNext, vertices.nNodos);//1
        proyecto.crearHormigaYRecorrer(vertices, h);//2
        //h.cRecorridas //3
        
        //la hormiga tiene una propiedad que es un array llamado cRecorridas. Ese array tiene dentro los
        //id de las ciudades que recorrio. El primero es la ciudad donde empieza, y el ultimo tambien es donde
        //empieza, porque tiene que terminar ahi ps.
        //h.cRecorridas
        
        
        //si te sirve, también tiene un array de las aristas por las que paso, pero no se si te sirva
        //h.arrayAristas
        
        
        //lo de varias hormigas,, seria repetir esas 3 lineas de codigo (las que puse en comentario)
        //las veces que el usuario diga.
        

    }
    
    //este metodo hace todo, hace que la hormiga recorra todas las ciudades y actualiza
    //las feromonas
    public void crearHormigaYRecorrer(ListaVertices vertices, Hormiga h) {
        
        //Hormiga h = new Hormiga(vertices.pFirst.pNext, vertices.nNodos);;
        
        h.cRecorridas = new int[vertices.getnNodos()+1];
        h.arrayAristas = new int[vertices.getnNodos()];
        
        
        
        h.cRecorridas[0] = h.ciudadInicial.id;
        
        for (int i = 0; i < h.cRecorridas.length - 1; i++) {
            h.cRecorridas[i+1] = 0;
        }
        
        
        
        for (int i = 0; i < h.arrayAristas.length; i++) {
            h.arrayAristas[i] = 0;
        }
        
        
        h.cRecorridas[vertices.getnNodos()] = h.ciudadInicial.id;
        h.arrayAristas[vertices.getnNodos()-1] = h.ciudadInicial.id;
        
        
        h.recorrerTodasLasCiudades(h, vertices);
        h.feromonasGlobal(vertices);
        
    }
    
}
