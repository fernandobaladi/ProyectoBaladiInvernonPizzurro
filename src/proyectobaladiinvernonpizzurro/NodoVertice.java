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
public class NodoVertice {
    
    ListaAristas nodosAristasAdyacentes = new ListaAristas("Lista de nodos");
    public NodoVertice pNext;
    public int numeroDeNodo;
    public String etiqueta;
    public NodoArista ady = nodosAristasAdyacentes.pFirst;

    public NodoVertice(String etiqueta, int numeroDeNodo) {
        this.numeroDeNodo = numeroDeNodo;
        this.etiqueta = etiqueta;
        this.pNext = null;
    }


    public NodoVertice getpNext() {
        return pNext;
    }

    public void setpNext(NodoVertice pNext) {
        this.pNext = pNext;
    }
}
