package com.estructura;


// Nodo para la clase arbol
public class Nodo {

    // Atributos
    private int dato;

    public Nodo(){
        this.dato = 0;
    }

    public Nodo(int dato){
        this.dato = dato;
    }

    public int getDato(){
        return this.dato;
    }

    public void setDato(int dato){
        this.dato = dato;
    }

    // retornar siguiente
    public Nodo getSiguiente(){
        return null;
    }
    public Nodo setSiguiente(Nodo siguiente){
        return null;
    }


    // retornar nodo izquierdo
    public Nodo getIzquierdo(){
        return null;
    }
    public Nodo setIzquierdo(Nodo izquierdo){
        return null;
    }

    public Nodo getDerecho() {
        return null;
    }

    public Nodo setDerecho(Nodo derecho) {
        return null;
    }



    // remplazo ObtenerReemplazo(nodo aux)
    public Nodo ObtenerReemplazo(Nodo aux){
        return null;
    }
}
