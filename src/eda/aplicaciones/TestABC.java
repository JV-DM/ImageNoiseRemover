package eda.aplicaciones;
import  eda.librerias.estructurasDeDatos.jerarquicos.ABB;
import java.util.Random;

public class TestABC {
    public static void main(String[] args) {
	ABB<Integer> a = new ABB();
	Random gen = new Random();
	
	for (int i = 0; i < 31; i++) {
	    //a.insertar(i);
	    //arbre.inserir(gen.nextInt(1000));
	}

	a.insertar(0);
	System.out.println(a.teDosFills());
	a.reconstruirEquilibrado();
	System.out.println(a.teDosFills());
    }

}