package eda.aplicaciones;
import eda.librerias.estructurasDeDatos.modelos.Map;
import eda.librerias.estructurasDeDatos.deDispersion.TaulaHash;
import eda.librerias.estructurasDeDatos.modelos.LlistaAmbPI;
import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class TestTaulaHash {
    public static void main(String[] args) {
	//Map<String, Integer> taula = new TaulaHash(10000);
	TaulaHash<String, Integer> taula = new TaulaHash(10000);
	try {
	    Scanner fitx = new Scanner( new File(args[0]));
	    while (fitx.hasNext()){
		String paraula = fitx.next().toLowerCase();
		Integer numVoltes = taula.recuperar(paraula);
		if(numVoltes == null) {//primera aparicio en el text
		    taula.inserir(paraula,1);
		}else{
		    taula.inserir(paraula,numVoltes + 1);
		}
	    }

	    fitx.close();	    
	}
	catch (FileNotFoundException e) {
	    System.out.println("Error " + e.getMessage());
	    e.printStackTrace();
	}
	System.out.println("Mancha = "+taula.recuperar("Mancha"));

	// LlistaAmbPI<String> llista = taula.claus();
	// llista.inici();
	// while (!llista.esFi()) {
	//     System.out.println(llista.recuperar());
	//     llista.seguent();
	// }

	System.out.println("El factor de carrega es "+taula.factorCarrega());
	System.out.println("La desviacio tipica es "+taula.desviacioTipica());

	System.out.println(taula.histograma());


	    
    }

}

