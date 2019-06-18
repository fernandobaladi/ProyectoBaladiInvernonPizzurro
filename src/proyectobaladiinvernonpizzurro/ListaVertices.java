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
public class ListaVertices {
    NodoVertice pFisrt;
    NodoVertice pLast;
    String nombre;
    int nNodos;

    public ListaVertices(String nombre) {
        this.nombre = nombre;
        this.nNodos = 0;
        this.pFisrt = null;
        this.pLast = null;
    }

    public NodoVertice getpFisrt() {
        return pFisrt;
    }

    public void setpFisrt(NodoVertice pFisrt) {
        this.pFisrt = pFisrt;
    }

    public NodoVertice getpLast() {
        return pLast;
    }

    public void setpLast(NodoVertice pLast) {
        this.pLast = pLast;
    }
    
    
    
    public boolean esVacio(){
        if (this.pFisrt==null) {
            return true;
        }else{
            return false;
        }
    }
    
    public NodoVertice primerNodo(){
        return this.pFisrt;
    }
    
    public NodoVertice últimoNodo(){
    
        return this.pLast;
    }
    
    public NodoVertice nodoSiguiente(NodoVertice nPrev){
    
        if (nPrev!=null){
           nPrev=nPrev.pNext;  
           return nPrev;
        }else{
            return null;
        }
    }
    
    public void agregarAlFinal(String etiqueta, int numeroDeNodo){
        NodoVertice nNuevo = new NodoVertice(etiqueta, numeroDeNodo);
        if (esVacio()) {
            pFisrt = nNuevo;
            pLast = nNuevo;
        } else{
            NodoVertice aux = pFisrt;
            while(aux.pNext != null){
                aux = aux.pNext;
            }
            aux.setpNext(nNuevo);
            pLast = nNuevo;
        }
        nNodos++;
    }
    
    public void eliminar(NodoVertice nPrev){
    
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
                NodoVertice n = nPrev.pNext;
                nPrev.pNext=n.pNext;
                nNodos=-1;
            }
        }
    }
   

    public void limpiarLista(){
        this.pFisrt = null;
        this.pLast = null;
        this.nNodos = 0;
    }
}
