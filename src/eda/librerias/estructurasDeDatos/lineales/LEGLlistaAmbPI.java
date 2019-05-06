package eda.librerias.estructurasDeDatos.lineales;

import eda.librerias.estructurasDeDatos.modelos.LlistaAmbPI;
import eda.librerias.estructurasDeDatos.lineales.NodeLEG;


public class LEGLlistaAmbPI<E> implements LlistaAmbPI<E> {
    //atributs
    NodeLEG<E> PI_ant, inici, fi;
    int talla;
    
    //metodes
    public LEGLlistaAmbPI(){
	PI_ant = inici = fi  = new NodeLEG<E>(null);	
	talla = 0;
    }
    public void inserir(E e){
	PI_ant.seg = new NodeLEG<E>(e, PI_ant.seg);

	//inserim a la fi?
	if (fi.seg != null)
	    fi = fi.seg;

	seguent();
	talla++;
    }
    // SII !esFi(): elimina la dada que ocupa el seu PI
    public void eliminar(){
	if (!esFi()){
	    PI_ant.seg = PI_ant.seg.seg;
	    talla--;
	    // m'he carregat l'ultim?
	    if (PI_ant.seg == null){
		fi=PI_ant;
	    }
	}
    }
    // SII !esFi(): torna la dada que ocupa el PI
    public E recuperar(){
	if (PI_ant.seg==null) return null;
	return PI_ant.seg.dada;
    }
    // situa el PI de una llista en el seu inici
    public void inici(){
	PI_ant=inici;
    }
    // SII !esFi(): avanc,a el PI d'una llista
    public void seguent(){
	if (!esFi())
	    PI_ant = PI_ant.seg;
    }
    
    // comprova si el PI esta darrere de l'ultim element
    public boolean esFi(){
	return PI_ant == fi;
    }
    
    public boolean esBuida(){
	return talla == 0;
    }

    public void fi(){ // situa el PI darrere de l'ultim element
	PI_ant = fi;
    }
    
    public int talla(){
	return talla;
    }
}

