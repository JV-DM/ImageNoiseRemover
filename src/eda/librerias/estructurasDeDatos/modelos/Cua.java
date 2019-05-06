package eda.librerias.estructurasDeDatos.modelos;
public interface Cua<E> {
    // insereix l'Element e en una Cua, o el situa a la fi
    void encuar(E e);
    // si !esBuida(), obte i elimina de la cua
    // l'Element que ocupa el principi
    E desencuar();
    // si !esBuida(), obte l'Element que ocupa el
    // principi, el primer en ordre D'Insercio
    E primer();
    // comprova si la cua esta buida
    boolean esBuida();
}
