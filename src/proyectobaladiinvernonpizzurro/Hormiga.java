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
    public ListaVertices verticesPorRecorrer = new ListaVertices("Lista para recordar los vértices que faltan por recorrer");
    public NodoVertice ciudadInicial;
    public NodoVertice ciudadActual;
    
    public int alfa = 1;
    public int beta = 1;

    public Hormiga(NodoVertice ciudadInicial, int nCiudades, ListaVertices vertices) {
        this.ciudadInicial = ciudadInicial;
        this.ciudadActual = ciudadInicial;
        this.nCiudades = nCiudades;
        
        NodoVertice nodoAuxiliar = vertices.pFirst;
        
        for (int i = 0; i < this.nCiudades; i++) {
            if(nodoAuxiliar.id==ciudadInicial.id){
                nodoAuxiliar = nodoAuxiliar.pNext;
            }
            else{
                verticesPorRecorrer.agregarAlFinal(nodoAuxiliar.etiqueta, nodoAuxiliar.id);
                nodoAuxiliar = nodoAuxiliar.pNext;
            }
        }
        nodoAuxiliar = verticesPorRecorrer.pFirst;
        /*for (int i = 0; i < verticesPorRecorrer.nNodos; i++) {
            System.out.println(nodoAuxiliar.etiqueta);
            nodoAuxiliar = nodoAuxiliar.pNext;
        }*/
    }
    
    public void irASiguienteCiudad(ListaVertices vertices) {
        
        
        NodoArista nodoDeListaAristas = ciudadActual.nodosAristasAdyacentes.primerNodo();
        double[] array = new double[verticesPorRecorrer.nNodos + 1];
        array[0] = 0;
        double sumatoria = 0;
        
        ingresarProbabilidadEnElArray(array, sumatoria, nodoDeListaAristas);
        
         
        //el array ahora seria algo asi como [0, 0.23, 0.47, 0.15, 0.15]
        int idCiudad = escogeCiudad(array);
        
        NodoVertice nodoSiguiente = vertices.pFirst;
        while (nodoSiguiente.id!=idCiudad) {
            nodoSiguiente = nodoSiguiente.pNext;
        }
        this.setCiudadActual(nodoSiguiente);
        System.out.println(nodoSiguiente.etiqueta);
        System.out.println(nodoSiguiente.id);
        verticesPorRecorrer.eliminarPorID(nodoSiguiente.id);
        
        
        
    }


    public NodoVertice getCiudadActual() {
        return ciudadActual;
    }

    public void setCiudadActual(NodoVertice ciudadActual) {
        this.ciudadActual = ciudadActual;
    }
 
    public boolean hayQueRecorrer(NodoArista nodoArista){
        
        NodoVertice nodoAuxiliar = verticesPorRecorrer.pFirst;
        for (int i = 0; i < this.verticesPorRecorrer.nNodos; i++) {
            if (nodoAuxiliar.id == nodoArista.id) {
                return true;
            }
            nodoAuxiliar = nodoAuxiliar.pNext;
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
    
    public int escogeCiudad (double array[]){
    
    
    NodoVertice nodoAuxiliar = verticesPorRecorrer.pFirst; //De este nodo auxiliar se obtendran los demás id para la matriz
        double[][] matriz = new double[array.length][2];
        matriz[0][1] = 0; //A la derecha del Array estará el id de la ciudad a la que hay que visitar y la izquierda el de la probabilidad
        matriz[0][0] = nodoAuxiliar.id;
        System.out.println("Orden del random = " + matriz[1][0]);
        
        for (int i = 0; i < array.length-2; i++) {
            nodoAuxiliar = nodoAuxiliar.pNext;
            matriz[i+1][0] = nodoAuxiliar.id;
            matriz[i+1][1] = array[i+1] + matriz[i][1];
            System.out.println("Orden del random = " + matriz[i+1][1]);
        }
        
        
        matriz[matriz.length-1][0] = -1;
        matriz[matriz.length-1][1] = 1;
        double random = Math.random();
        System.out.println(random + " este es el random");
        
    
        int i=0;
        while ((random >= matriz[i][1] && random <= matriz[i+1][0])) {
            i++;
        }
        
        int idCiudad = (int) matriz[i-1][0];
        return idCiudad;
    
    }
    
    
    
    public void ingresarProbabilidadEnElArray(double array[], double sumatoria, NodoArista nodoDeListaAristas){
    
    
        for (int i = 0; i <this.ciudadActual.nodosAristasAdyacentes.nNodos; i++) {

                if (hayQueRecorrer(nodoDeListaAristas)) {
                    double qlq = (double) 1/nodoDeListaAristas.distancia;
                    double numero =  Math.pow(nodoDeListaAristas.feromonas, alfa) * Math.pow(qlq, beta);
                    array[i+1] = numero;
                    System.out.println(nodoDeListaAristas.etiqueta);
                    sumatoria += array[i+1];
                    nodoDeListaAristas = ciudadActual.nodosAristasAdyacentes.nodoSiguiente(nodoDeListaAristas);   
                    if (isFull(array)) {
                        i=ciudadActual.nodosAristasAdyacentes.nNodos;
                    }
                }else{
                    nodoDeListaAristas = ciudadActual.nodosAristasAdyacentes.nodoSiguiente(nodoDeListaAristas);   
                    i--;
                }
        }



        for (int i = 1; i < array.length; i++) {

            array[i] = array[i] / sumatoria;     
        }
        
    
    }
}
