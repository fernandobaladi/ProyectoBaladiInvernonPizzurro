/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobaladiinvernonpizzurro;

/**
 *
 * @author edwardpizzurro
 */
public class ColoniaHormigasMatriz {
    
    int numCiudades = 4;
    int feromonasIniciales = 1;
    //int[][] grafo = new int[numCiudades][numCiudades];
    
    //parale a esta matriz... esta es la matriz de adyacencia
    double[][] grafo = {{0, 2, 3, 4}, 
                     {2, 0, 3, 4}, 
                     {2, 3, 0, 4}, 
                     {2, 3, 4, 0}};
    
    
    
    
    
    public int escogerProximaCiudad(int ciudadPartir) {
        
        //aqui creo un array donde oy a guardar las probabilidades de cada uno
        double[] array = new double[grafo.length];
        double sumatoriaArray = 0.0;
        
        //este for ira multiplicando cada feromonda por (1/distancia). También
        //se anade cada uno en la variable sumatoria, para luego dividir cada
        //elemento entre la sumatoria, como el video
        for (int i = 0; i < grafo.length; i++) {
            
            if (! (grafo[ciudadPartir-1][i] == 0) ){
                array[i] = (double) feromonasIniciales * (1 / grafo[ciudadPartir-1][i]);
            
            } else {
                array[i] = 0;
            }
            
            sumatoriaArray += array[i];
        }
        
        //aqui es donde divido cada elemento entre la sumatoria
        for (int i = 0; i < array.length; i++) {
            
            array[i] = array[i] / sumatoriaArray;
        }
        
        //este es el mismo array que el "array", solo que este tiene un 0 al principio
        //y un 1 al final. Para hacerlo como la linea de numeros del video
        double[] array2 = new double[array.length + 1]; 
        array2[0] = 0;
        
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0.0) {
                array2[i] = array[i];
            } 
        }
        
        array2[array2.length-1] = 1;
        
        //asi te queda el arrray2 despues de todo eso
        //[0      ,  0.46   ,    0.31,     0,23     ,   1]
        
        
        //aqui se escoge el numero random (que escogi ese por ahora) y trato de hacer la vaina
        //que no funciono de seleccionar la ciudad...
        double randomNumber = 0.6;
        int contador = 0;
        
        while (! (randomNumber >= array2[contador] && randomNumber <= array2[contador+1] )) {
            
            contador++;
        }
        
        return contador;
        
    }
    
}
