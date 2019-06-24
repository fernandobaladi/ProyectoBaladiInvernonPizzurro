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
public class ListaAristas {
    public NodoArista pFirst;
    public NodoArista pLast;
    public String nombre;
    public int nNodos;

    public ListaAristas(String nombre) {
        this.nombre = nombre;
        this.nNodos = 0;
        this.pFirst = null;
        this.pLast = null;
    }

    public NodoArista getpFirst() {
        return pFirst;
    }
    
    public int getnNodos() {
        return 13;
    }
    
    public void setpFirst(NodoArista pFirst) {
        this.pFirst = pFirst;
    }

    public NodoArista getpLast() {
        return pLast;
    }

    public void setpLast(NodoArista pLast) {
        this.pLast = pLast;
    }

    
    
    public boolean esVacio(){
        if (this.pFirst==null) {
            return true;
        }else{
            return false;
        }
    }
    
    public NodoArista primerNodo(){
        return this.pFirst;
    }
    
    
    public NodoArista nodoSiguiente(NodoArista nPrev){
    
        if (nPrev!=null){
           nPrev=nPrev.pNext;  
           return nPrev;
        }else{
            return null;
        }
    }
    
    public void agregarAlFinal(int peso, String etiqueta, int id){
        NodoArista nNuevo = new NodoArista(peso, etiqueta, id);
        if (esVacio()) {
            pFirst = nNuevo;
        } else{
            NodoArista aux = pFirst;
            while(aux.pNext != null){
                aux = aux.pNext;
            }
            aux.setpNext(nNuevo);
            pLast = nNuevo;
        }
        nNodos++;
    }
    
    public void eliminar(NodoArista nPrev){
    
        if (esVacio()) {
            System.out.println("No hay nada para eliminar, la lista está vacía");    
        }else{
            if (nPrev.pNext==pLast) {
                nPrev.pNext=null;
                pLast=nPrev;
                nNodos=-1;
            }
            else if(nPrev.pNext==null){
                System.out.println("Este es el último nodo.");
            }else{
                NodoArista n = nPrev.pNext;
                nPrev.pNext=n.pNext;
                nNodos=-1;
            }
        }
    }

    public void limpiarLista(){
        this.pFirst = null;
        this.pLast = null;
        this.nNodos = 0;
    }   
}
