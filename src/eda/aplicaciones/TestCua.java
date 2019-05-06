package eda.aplicaciones;

import  eda.librerias.estructurasDeDatos.modelos.Cua;
import  eda.librerias.estructurasDeDatos.lineales.ArrayCua;
import  eda.librerias.estructurasDeDatos.lineales.NodeLegCua;

public class TestCua {
    public static void main(String[] args) {
	//Cua<Integer> cua = new ArrayCua<Integer>();	
	Cua<Integer> cua = new NodeLegCua<Integer>();
	for (int i = 0; i < 100; i++) {
	    cua.encuar(i);	    
	}

	//System.out.println(cua);
	while(!cua.esBuida()){
	    System.out.println(cua.desencuar());
	}

    }

}
