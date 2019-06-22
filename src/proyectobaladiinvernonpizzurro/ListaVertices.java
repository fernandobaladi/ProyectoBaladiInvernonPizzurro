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
    NodoVertice pFirst;
    NodoVertice pLast;
    String nombre;
    int nNodos;

    public ListaVertices(String nombre) {
        this.nombre = nombre;
        this.nNodos = 0;
        this.pFirst = null;
        this.pLast = null;
    }

    public NodoVertice getpFisrt() {
        return pFirst;
    }

    public void setpFisrt(NodoVertice pFisrt) {
        this.pFirst = pFisrt;
    }

    public NodoVertice getpLast() {
        return pLast;
    }

    public void setpLast(NodoVertice pLast) {
        this.pLast = pLast;
    }
    
    
    
    public boolean esVacio(){
        if (this.pFirst==null) {
            return true;
        }else{
            return false;
        }
    }
    
    public NodoVertice primerNodo(){
        return this.pFirst;
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
            pFirst = nNuevo;
            pLast = nNuevo;
        } else{
            NodoVertice aux = pFirst;
            while(aux.pNext != null){
                aux = aux.pNext;
            }
            aux.setpNext(nNuevo);
            pLast = nNuevo;
        }
        nNodos++;
    }
    
    public void eliminar(NodoVertice nodo){
    
        if (esVacio()) {
            System.out.println("No hay nada para eliminar, la lista está vacía");    
        }else{
            if(nodo.pNext==null) {
                System.out.println("Este es el último nodo.");
                
            }
            else if (nodo.pNext==pLast){
                nodo.pNext=null;
                pLast=nodo;
                nNodos=-1;
            }else{
                NodoVertice n = nodo.pNext;
                nodo.pNext=n.pNext;
                nNodos=-1;
            }
        }
    }
    
    public void eliminarPorID (int id){
        
        if(esVacio()){
            
            System.out.println("La lista esta vacía o no existe el indice.");
        } else if(id == this.pFirst.id){
            
            this.pFirst = this.pFirst.pNext;
            this.nNodos--;
        } else {
            
        getNodoVertice(id-1).pNext = getNodoVertice(id).pNext;
        this.nNodos--;
        }
    
    } 
   
    public NodoVertice getNodoVertice(int id){
        
        NodoVertice Aux = this.pFirst;
        
        if(esVacio()){
            System.out.println("La lista esta vacia.");
            return null;
            
        } else if(this.pFirst.id == id){
                return this.pFirst;
              
        } else {
            
            for (int i = 0; i < this.nNodos; i++) {
                
                Aux = Aux.pNext;
                if(Aux.id == id)
                    return Aux;
            }
        }
        System.out.println("El dato solicitado no esta en la lista");
        return null;
    }

    public void eliminarPrimero(NodoVertice nodo){
        
        this.pFirst = nodo.pNext;
        
    }
    public void limpiarLista(){
        this.pFirst = null;
        this.pLast = null;
        this.nNodos = 0;
    }
}
