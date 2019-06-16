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
public class NodoArista {
    public int distancia;
    public NodoArista pNext;
    public String etiqueta;
    public ListaAristas listaA = new ListaAristas("Lista de Aristas");

    public NodoArista(int distancia, String etiqueta) {
        this.distancia = distancia;
        this.etiqueta = etiqueta;
        this.pNext = null;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    
    public NodoArista getpNext() {
        return pNext;
    }

    public void setpNext(NodoArista pNext) {
        this.pNext = pNext;
    }

    
}
