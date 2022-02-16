package com.estructura;


// La clase arbol
public class Arbol {

    // Atributos de la clase
    private Nodo raiz;
    private int altura;
    private int cantidadNodos;
    private int cantidadHojas;
    private int cantidadNodosInternos;

    public Arbol() {
        raiz = null;
        altura = 0;
        cantidadNodos = 0;
        cantidadHojas = 0;
        cantidadNodosInternos = 0;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getCantidadNodos() {
        return cantidadNodos;
    }

    public void setCantidadNodos(int cantidadNodos) {
        this.cantidadNodos = cantidadNodos;
    }

    public int getCantidadHojas() {
        return cantidadHojas;
    }

    public void setCantidadHojas(int cantidadHojas) {
        this.cantidadHojas = cantidadHojas;
    }

    public int getCantidadNodosInternos() {
        return cantidadNodosInternos;
    }

    public void setCantidadNodosInternos(int cantidadNodosInternos) {
        this.cantidadNodosInternos = cantidadNodosInternos;
    }

    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo aux = raiz;
            while (true) {
                if (dato < aux.getDato()) {
                    if (aux.getIzquierdo() == null) {
                        aux.setIzquierdo(nuevo);
                        break;
                    } else {
                        aux = aux.getIzquierdo();
                    }
                } else {
                    if (aux.getDerecho() == null) {
                        aux.setDerecho(nuevo);
                        break;
                    } else {
                        aux = aux.getDerecho();
                    }
                }
            }
        }
    }

    // Eliminar un nodo
    public void eliminar(int dato) {
        Nodo aux = raiz;
        Nodo padre = null;
        while (aux.getDato() != dato) {
            padre = aux;
            if (dato < aux.getDato()) {

                aux = aux.getIzquierdo();
            } else {
                aux = aux.getDerecho();
            }
            if (aux == null) {
                return;
            }
        }
        if (aux.getIzquierdo() == null && aux.getDerecho() == null) {
            if (aux == raiz) {
                raiz = null;
            } else if (dato < padre.getDato()) {
                padre.setIzquierdo(null);
            } else {
                padre.setDerecho(null);
            }
        } else if (aux.getIzquierdo() == null) {
            if (aux == raiz) {
                raiz = aux.getDerecho();
            } else if (dato < padre.getDato()) {
                padre.setIzquierdo(aux.getDerecho());
            } else {
                padre.setDerecho(aux.getDerecho());
            }
        } else if (aux.getDerecho() == null) {
            if (aux == raiz) {
                raiz = aux.getIzquierdo();
            } else if (dato < padre.getDato()) {
                padre.setIzquierdo(aux.getIzquierdo());
            } else {
                padre.setDerecho(aux.getIzquierdo());
            }
        } else {
            Nodo reemplazo = obtenerReemplazo(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (dato < padre.getDato()) {
                padre.setIzquierdo(reemplazo);
            } else {
                padre.setDerecho(reemplazo);

            }
            reemplazo.setIzquierdo(aux.getIzquierdo());
        }
    }

    private Nodo obtenerReemplazo(Nodo aux) {
        Nodo reemplazoPadre = aux;
        Nodo reemplazo = aux;
        Nodo auxiliar = aux.getDerecho();
        while (auxiliar != null) {
            reemplazoPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.getIzquierdo();
        }
        if (reemplazo != aux.getDerecho()) {
            reemplazoPadre.setIzquierdo(reemplazo.getDerecho());
            reemplazo.setDerecho(aux.getDerecho());
        }
        return reemplazo;
    }


}
