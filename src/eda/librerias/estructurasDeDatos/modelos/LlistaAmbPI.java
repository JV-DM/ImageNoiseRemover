package eda.librerias.estructurasDeDatos.modelos;

public interface LlistaAmbPI<E> {
    // insereix e abans del PI, que roman inalterat
    void inserir(E e);
    // SII !esFi(): elimina la dada que ocupa el seu PI
    void eliminar();
    // SII !esFi(): torna la dada que ocupa el PI
    E recuperar();
    // situa el PI de una llista en el seu inici
    void inici();
    // SII !esFi(): avanc,a el PI d'una llista
    void seguent();
    // comprova si el PI esta darrere de l'ultim element
    boolean esFi();
    boolean esBuida(); // comprova si la llista esta buida
    void fi(); // situa el PI darrere de l'ultim element
    int talla(); // torna la talla de la llista
}
