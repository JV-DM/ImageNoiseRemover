package eda.aplicaciones;
import java.util.*;
import java.io.*;
import eda.librerias.util.Ordenacio;

public class TestSelect {
    public static void main(String[] args) {
	final int NUMREP=5;
	
	Random gen = new Random();
	int talla = 10;
	Integer [] vec = new Integer[talla];
	   
	for (int i = 0; i < vec.length; i++) {
	    vec[i] = gen.nextInt(10);	   
	}

	Integer valor = Ordenacio.select(vec,5);
	for (int i = 0; i < vec.length ; i++) {
	    System.out.println(i+" "+vec[i]);
	}

	System.out.println("el quint es "+ valor);


			   

    }
}
