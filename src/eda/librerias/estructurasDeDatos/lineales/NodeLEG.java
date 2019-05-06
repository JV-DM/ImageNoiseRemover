package eda.librerias.estructurasDeDatos.lineales;


public class NodeLEG<E> {
    //atributs
    E dada;
    NodeLEG<E> seg;

    public NodeLEG(E dada){
	this.dada = dada;
	seg=null;
    }

    public NodeLEG(E dada, NodeLEG<E> seg){
	this.dada = dada;
	this.seg=seg;
    }
}
