/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobaladiinvernonpizzurro;

/**
 *
 * @author Fernando Baladi
 */
public class Hormiga {
   public int nCiudades;
    public int[] cRecorridas; //Al saber cuáles ciudades se recorrieron se puede saber cuáles quedan por recorrer
    public NodoVertice ciudadInicial;
    public NodoVertice ciudadActual;
    
    public int alfa = 1;
    public int beta = 1;

    public Hormiga(NodoVertice ciudadInicial, int nCiudades) {
        this.ciudadInicial = ciudadInicial;
        this.ciudadActual = ciudadInicial;
        this.nCiudades = nCiudades;
        this.cRecorridas = new int[nCiudades - 1];
        
        for (int i = 0; i < this.cRecorridas.length; i++) {
            this.cRecorridas[i] = 0;
        }
    }
    
    
    public void irASiguienteCiudad(ListaVertices vertices) {
        
        
        NodoArista nodoDeListaAristas = ciudadActual.nodosAristasAdyacentes.primerNodo();
        double[] array = new double[ciudadActual.nodosAristasAdyacentes.nNodos + 1];
        array[0] = 0;
        
        double sumatoria = 0;
        
        
        for (int i = 0; i < ciudadActual.nodosAristasAdyacentes.nNodos; i++) {
            
            double qlq = (double) 1/nodoDeListaAristas.distancia;
            double numero =  Math.pow(nodoDeListaAristas.feromonas, alfa) * Math.pow(qlq, beta);
            
            array[i+1] = numero;
            
            nodoDeListaAristas = ciudadActual.nodosAristasAdyacentes.nodoSiguiente(nodoDeListaAristas);
            
            sumatoria += array[i+1];
            
            
        }
        
        for (int i = 1; i < array.length; i++) {
            
            array[i] = array[i] / sumatoria;     
        }
        
        //el array ahora seria algo asi como [0, 0.23, 0.47, 0.15, 0.15]
        
        double[] array2 = new double[array.length];
        array2[0] = 0;
        
        for (int i = 0; i < array.length-1; i++) {
            array2[i+1] = array[i+1] + array2[i];
        }
        array2[array2.length-1]=1;
        double random = 0.3;
        int contador = 0;
        
        for (int i = 0; i <array2.length; i++) {
            System.out.println(array2[i]);
        }
        while (! (random >= array2[contador] && random <= array2[contador+1] )) {
            contador++;
        }
        //el contador es el numero de ciudad en la lista de aristas a la cual fue la hormiga
        NodoArista nodo = ciudadActual.nodosAristasAdyacentes.primerNodo();
        for (int i = 0; i < contador; i++) {    
            
            nodo = nodo.pNext;
        }
        int idCaracas = nodo.id;
        NodoVertice nodoSiguiente = vertices.pFisrt;
        while (nodoSiguiente.id!=idCaracas) {
            nodoSiguiente = nodoSiguiente.pNext;
        }
        this.setCiudadActual(nodoSiguiente);
//aun falta asignar la ciudad actual al id obtenido
        System.out.println(nodoSiguiente.etiqueta);
        System.out.println(nodoSiguiente.id);
        
    }

    public NodoVertice getCiudadActual() {
        return ciudadActual;
    }

    public void setCiudadActual(NodoVertice ciudadActual) {
        this.ciudadActual = ciudadActual;
    }
    
}
