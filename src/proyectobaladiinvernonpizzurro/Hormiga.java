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
    
    
    public void irASiguienteCiudad(ListaVertices vertices, int númeroDeCiudadesYaRecorridas) {
        
        
        NodoArista nodoDeListaAristas = ciudadActual.nodosAristasAdyacentes.primerNodo();
        double[] array = new double[ciudadActual.nodosAristasAdyacentes.nNodos + 1 - númeroDeCiudadesYaRecorridas];
        array[0] = 0;
        
        double sumatoria = 0;
        
        
        for (int i = 0; i < ciudadActual.nodosAristasAdyacentes.nNodos; i++) {
        
            
                if(!haSidoRecorridoNodo(nodoDeListaAristas)){
                    double qlq = (double) 1/nodoDeListaAristas.distancia;
                    double numero =  Math.pow(nodoDeListaAristas.feromonas, alfa) * Math.pow(qlq, beta);

                    array[i+1] = numero;
                    sumatoria += array[i+1];
                    if (isFull(array)) {
                        i = ciudadActual.nodosAristasAdyacentes.nNodos;
                    }
                    
                }else{
                    
                    i--;
                
                }
                System.out.println(haSidoRecorridoNodo(nodoDeListaAristas));
                nodoDeListaAristas = ciudadActual.nodosAristasAdyacentes.nodoSiguiente(nodoDeListaAristas);
            
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
        double random = Math.random();
        System.out.println(random + " este es el random");
        int contador = 0;
        
        for (int i = 0; i <array2.length; i++) {
            System.out.println(array2[i]);
        }
        while (! (random >= array2[contador] && random <= array2[contador+1])) {
            contador++;
            System.out.println(contador + "este es el contador");
        }
        contador+=númeroDeCiudadesYaRecorridas;
        //el contador es el numero de ciudad en la lista de aristas a la cual fue la hormiga
        NodoArista nodo = ciudadActual.nodosAristasAdyacentes.primerNodo();
        for (int i = 0; i < contador; i++) {    
            System.out.println(nodo.etiqueta + " con nodo número " +nodo.id);
            nodo = nodo.pNext;
        }
        int idCiudad = nodo.id;
        NodoVertice nodoSiguiente = vertices.pFisrt;
        while (nodoSiguiente.id!=idCiudad) {
            nodoSiguiente = nodoSiguiente.pNext;
        }
        this.setCiudadActual(nodoSiguiente);
        System.out.println(nodoSiguiente.etiqueta);
        System.out.println(nodoSiguiente.id);
        this.cRecorridas[númeroDeCiudadesYaRecorridas] = nodoSiguiente.id;
        
    }

    public NodoVertice getCiudadActual() {
        return ciudadActual;
    }

    public void setCiudadActual(NodoVertice ciudadActual) {
        this.ciudadActual = ciudadActual;
    }
 
    public boolean haSidoRecorridoNodo(NodoArista nodoDeListaAristas){
        
        for (int i = 0; i < this.cRecorridas.length; i++) {
            if (this.cRecorridas[i]==nodoDeListaAristas.id || nodoDeListaAristas.id == this.ciudadInicial.id) {
                return true;
            }
        }
        return false;
    }

    public boolean haSidoRecorridoNodoVertice(NodoVertice nodoSiguiente){
        
        for (int i = 0; i < this.cRecorridas.length; i++) {
            if (this.cRecorridas[i]==nodoSiguiente.id || nodoSiguiente.id == this.ciudadInicial.id) {
                return true;
            }
        }
        return false;
    }
    
    public boolean haSidoRecorridoContador(int contador){
        
        for (int i = 0; i < this.cRecorridas.length; i++) {
            if (this.cRecorridas[i]==contador || contador == this.ciudadInicial.id) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isFull(double[] array){
        for (int i = 1; i < array.length; i++) {
            if (array[i]==0) {
                return false;
            }
        }
        return true;
    }
}
