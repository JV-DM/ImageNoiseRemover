package eda.librerias.estructurasDeDatos.jerarquicos;

import org.w3c.dom.Node;

public class NodeABC<E> {
    private E e;
    NodeABC<E> esq, dre;
    public NodeABC(E e){
        this(e,null,null);
    }
    public NodeABC(E e, NodeABC<E> esq, NodeABC<E> dre){
        this.e = e;
        this.esq = esq;
        this.dre = dre;
    }
    public E valor(){ return e;}
    public void setValor(E e){
        this.e = e;
    }
}
