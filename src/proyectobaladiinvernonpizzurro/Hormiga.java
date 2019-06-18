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
    public int nCiudades; //Al saber el número de ciudades se pude deducir cuántas faltan por recorrer
    public int[] cRecorridas; //Al saber cuáles ciudades se recorrieron se puede saber cuáles quedan por recorrer
    public NodoVertice ciudadInicial;
    public NodoVertice ciudadActual;

    public Hormiga(NodoVertice ciudadInicial, int nCiudades) {
        this.ciudadInicial = ciudadInicial;
        this.ciudadActual = ciudadInicial;
        this.nCiudades = nCiudades;
        this.cRecorridas = new int[nCiudades-1];
        for (int i = 0; i < this.cRecorridas.length; i++) {
            this.cRecorridas[i] = 0;
        }
    }
    
    
    
    
}
