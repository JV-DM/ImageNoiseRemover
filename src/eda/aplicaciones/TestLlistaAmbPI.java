package eda.aplicaciones;

import eda.librerias.estructurasDeDatos.modelos.LlistaAmbPI;
import eda.librerias.estructurasDeDatos.lineales.LEGLlistaAmbPI;

public class TestLlistaAmbPI {
    public static void main(String[] args) {
	LlistaAmbPI<Integer> llista = new LEGLlistaAmbPI<Integer>();

	for (int i = 0; i < 10; i++) {
	    llista.inici();
	    llista.inserir(i);
	}

	//llista.inici();
	while(!llista.esBuida()){
	    llista.inici();
	    Integer val = llista.recuperar();
	    System.out.println(val);
	    //llista.seguent();
	    llista.eliminar();
	}

    }

}
