package eda.aplicaciones;
import java.util.*;
import java.io.*;
import eda.librerias.util.Ordenacio;

public class TestOrdenacio {
    public static void main(String[] args) {
	final int NUMREP=5;
	
	Random gen = new Random();
	for (int talla = 100000; talla < 100000000; talla+=100000) {
	    Integer [] vec = new Integer[talla];
	    long temps_total_merge=0, temps_total_quick=0;
	    for (int rep = 0; rep < NUMREP; rep++) {			
		//omplir-lo aleatoriament
		for (int i = 0; i < vec.length; i++) {
		    vec[i] = gen.nextInt(1000);
		}

		long abans1 = System.nanoTime();
		Ordenacio.mergeSort(vec);
		temps_total_merge += System.nanoTime() - abans1;
		
		long abans2 = System.nanoTime();
		Ordenacio.quickSort(vec);
		temps_total_quick += System.nanoTime() - abans2;
	       
	    }
	    System.out.print(talla+ " "+ (temps_total_merge)/1000000000.0/NUMREP);
	    System.out.println("  " + (temps_total_quick)/1000000000.0/NUMREP);

	     
	}

    }
}
