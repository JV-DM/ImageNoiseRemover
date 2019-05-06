package eda.librerias.estructurasDeDatos.lineales;

import eda.librerias.estructurasDeDatos.lineales.NodeLEG;
import eda.librerias.estructurasDeDatos.modelos.Cua;

public class NodeLegCua<E> implements Cua<E> {
    //atributs
    NodeLEG<E> primer, ultim;

    //metodes
    public NodeLegCua(){
	primer=ultim=null;
    }
    
    public void encuar(E e){
	//NodeLEG<E> nou = new NodeLEG<E>(e);
	//ultim.seg = nou;
	if (ultim == null){ // la cua estava buida
	    ultim=primer= new NodeLEG<E>(e);
	}else{
	    ultim.seg = new NodeLEG<E>(e);
	    ultim = ultim.seg;
	}
    }
    // si !esBuida(), obte i elimina de la cua
    // l'Element que ocupa el principi
    public E desencuar(){

	if (esBuida()) return null;//cua buida
	
	E aTornar = primer.dada;
	primer = primer.seg;

	if (primer == null) ultim=null; //sols hi havia un
	return aTornar;

    }
    
    public E primer(){
	if (primer==null) return null;
	return primer.dada;
    }
    // comprova si la cua esta buida
    public boolean esBuida(){
	return primer==null;
    }

    
}
