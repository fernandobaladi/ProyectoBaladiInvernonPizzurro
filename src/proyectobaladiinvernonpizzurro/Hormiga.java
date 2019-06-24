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
    public int[] cRecorridas;
    public NodoVertice ciudadInicial;
    public NodoVertice ciudadActual;
    
    public int alfa = 1;
    public int beta = 1;
    
    public double Q = 1;
    public double ro = 0.5;

    public Hormiga(NodoVertice ciudadInicial, int nCiudades) {
        this.ciudadInicial = ciudadInicial;
        this.ciudadActual = ciudadInicial;
        this.nCiudades = nCiudades;
        this.cRecorridas = new int[nCiudades+1];
        
        for (int i = 0; i < this.cRecorridas.length; i++) {
            this.cRecorridas[i] = 0;
        }
    }
    
    
    public int costo = 0;
    public int[] arrayAristas;
    public double[] arrayPrueba;
    
    
    public void irASiguienteCiudad(ListaVertices vertices, int númeroDeCiudadesYaRecorridas) {
        
        System.out.println("\n\n\n...................................");//..................

        NodoArista nodoDeListaAristas = ciudadActual.nodosAristasAdyacentes.primerNodo(); 
        double[] array = new double[ciudadActual.nodosAristasAdyacentes.nNodos + 1];
        array[0] = 0;


        double sumatoria = 0;

        for (int i = 0; i < ciudadActual.nodosAristasAdyacentes.nNodos; i++) {

            double qlq = (double) 1/nodoDeListaAristas.distancia;
            double numero =  Math.pow(nodoDeListaAristas.feromonas, alfa) * Math.pow(qlq, beta);

            array[i+1] = numero;
            sumatoria += array[i+1];

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


        array2[array2.length-1] = 1 ;



        System.out.println("");//.....................


        double random = Math.random();
        System.out.println("RANDOM: " + random);


        System.out.println("");//.....................

        int contador = 0;

        System.out.println("");//.....................



        while (! (random >= array2[contador] && random <= array2[contador+1])) {
            contador++;
        }

        System.out.println("CONTADOR: " + contador);


        System.out.println("\n");//.......................



        //el contador es el numero de ciudad en la lista de aristas a la cual fue la hormiga
        NodoArista nodo = ciudadActual.nodosAristasAdyacentes.primerNodo();

        for (int i = 0; i < contador; i++) {
            nodo = nodo.pNext;
        }

        int idCiudad = nodo.id;


        //para que no se repitan las ciudades
        boolean delWhile = false;

        while (delWhile == false) {

            for (int i = 0; i < cRecorridas.length; i++) {

                if (cRecorridas[i] == idCiudad) {

                    i = cRecorridas.length;
                    delWhile = false;

                } else {
                    delWhile = true;
                }
            }


            if (delWhile == false) {

                random = Math.random();
                contador = 0;
                nodo = ciudadActual.nodosAristasAdyacentes.primerNodo();

                while (! (random >= array2[contador] && random <= array2[contador+1])) {
                    contador++;
                }

                for (int i = 0; i < contador; i++) {
                    nodo = nodo.pNext;
                }
                idCiudad = nodo.id;
            }
        }


        cRecorridas[númeroDeCiudadesYaRecorridas + 1] = idCiudad;



        System.out.println("NUEVO CONTADOR: " + contador);

        costo += nodo.distancia;

        arrayAristas[númeroDeCiudadesYaRecorridas] = nodo.id;

        NodoVertice nodoSiguiente = vertices.pFirst;

        while (nodoSiguiente.id != idCiudad) {
            nodoSiguiente = nodoSiguiente.pNext;
        }


        ciudadActual = nodoSiguiente;


        System.out.println(nodoSiguiente.etiqueta);
        System.out.println(nodoSiguiente.id);


        System.out.println("\n\nLista de los id:");
        for (int i = 0; i < cRecorridas.length; i++) {
            System.out.println(cRecorridas[i]);
        }


        System.out.println("\n\nLista de los id de aristas:");
        for (int i = 0; i < arrayAristas.length; i++) {
            System.out.println(arrayAristas[i]);
        }
        
        
        
        


        //para regresar a la primera ciudad
        //.............................................................
        if (cRecorridas[cRecorridas.length - 2] != 0) {
            
            nodo = ciudadActual.nodosAristasAdyacentes.primerNodo();

            while (nodo.id != cRecorridas[0]) {
                nodo = nodo.pNext;
            }

            idCiudad = nodo.id;
            costo += nodo.distancia;
            
            //cRecorridas[cRecorridas.length - 1] += idCiudad;
            //arrayAristas[númeroDeCiudadesYaRecorridas] = nodo.id;

            nodoSiguiente = vertices.pFirst;
            while (nodoSiguiente.id != idCiudad) {
                nodoSiguiente = nodoSiguiente.pNext;
            }

            ciudadActual = nodoSiguiente;
            
        }
        
    }
    
    
    
    
    public void actualizarFeromonas(int costo, ListaVertices vertices) {
        
        
        for (int i = 0; i < arrayAristas.length; i++) {
        
            NodoVertice nodoV = vertices.pFirst;

            while (nodoV.id != cRecorridas[i]) {
                nodoV = nodoV.pNext;
            }


            NodoArista nodoA = nodoV.nodosAristasAdyacentes.pFirst;

            while (nodoA.id != arrayAristas[i]) {
                nodoA = nodoA.pNext;
            }
            
            
            
            if (nodoA == nodoV.nodosAristasAdyacentes.pFirst) {

                nodoV.nodosAristasAdyacentes.pFirst.feromonas = Q / costo;
                arrayPrueba[0] = nodoV.nodosAristasAdyacentes.pFirst.feromonas;

            } else {

                NodoArista nodoAristaAuxiliar = nodoV.nodosAristasAdyacentes.pFirst;
                
                while (nodoAristaAuxiliar.pNext != nodoA) {
                    nodoAristaAuxiliar = nodoAristaAuxiliar.pNext;
                }
                
                nodoAristaAuxiliar.pNext.feromonas = Q / costo;
                arrayPrueba[i] = nodoAristaAuxiliar.pNext.feromonas;
            }
       
        }
        
        
        
    }
    
    
    public double[] globales = new double[30];
    
    public void feromonasGlobal(ListaVertices vertices) {
        
        NodoVertice nodoV = vertices.pFirst;
        NodoArista nodoA = nodoV.nodosAristasAdyacentes.pFirst;
        
        for (int i = 0; i < vertices.getnNodos() - 1; i++) {
            
            nodoV.nodosAristasAdyacentes.pFirst.feromonas = (1 - ro) * nodoA.feromonas;
            globales[i] = nodoV.nodosAristasAdyacentes.pFirst.feromonas;
            
            for (int j = 0; j < nodoV.nodosAristasAdyacentes.getnNodos() - 1; j++) {
                
                nodoA.pNext.feromonas = (1 - ro) * nodoA.pNext.feromonas;
                
                globales[j+i] = nodoA.pNext.feromonas;
                
                nodoA = nodoA.pNext;
                
                
            }
            
            nodoV = nodoV.pNext;
            nodoA = nodoV.nodosAristasAdyacentes.pFirst;
        }
    }
    
    
    
    public void recorrerTodasLasCiudades(Hormiga hormiga, ListaVertices vertices) {
        
        for (int i = 0; i < nCiudades - 1; i++) {
            hormiga.irASiguienteCiudad(vertices, i);
        }
        
        actualizarFeromonas(this.costo, vertices);
    }
    
    
}
