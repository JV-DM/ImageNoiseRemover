package eda.librerias.estructurasDeDatos.modelos;
public interface Map<C, V> {
    // insereix/actualitza la entrada (c,v) torna
    // valor anterior o null si no estava
    V inserir(C c, V v);
    // elimina entrada con clau c, torna su
    // valor associat, o null si no existeix
    V eliminar(C c);
    // torna el valor associat a la clau c
    // o null si no existia eixa entrada
    V recuperar(C c);
    boolean esBuida();
    int talla();
    // torna una ListaConPI que conte totes les claus
    LlistaAmbPI<C> claus();
}
