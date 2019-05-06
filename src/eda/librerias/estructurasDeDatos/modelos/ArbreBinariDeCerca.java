package eda.librerias.estructurasDeDatos.modelos;
public interface ArbreBinariDeCerca<E extends Comparable <E>> {
    void inserir(E e);
    void esborrar(E e);
    boolean cercar(E e);
    boolean esBuit();
    String preOrdre();
    String inOrdre();
    String postOrdre();
    E max();
    E min();
    E successor(E e);
}