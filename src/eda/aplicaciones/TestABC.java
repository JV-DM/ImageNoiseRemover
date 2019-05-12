package eda.aplicaciones;
import  eda.librerias.estructurasDeDatos.jerarquicos.ABB;
import java.util.Random;

public class TestABC {
	public static void main(String[] args) {
		ABB<Integer> a = new ABB();
		Random gen = new Random();

		for(int i = 0; i < 1000000; i=i*2+1) { // Todos son correctos
			int num_nodos = i;
			for (int j = 0; j < num_nodos; j++) {
				a.insertar(j);
			}
			a.reconstruirEquilibrado();
			long now = System.nanoTime();
			if(a.teDosFills()){
				long later = System.nanoTime();
				System.out.println(i + " " + (later - now));
			}
		}
	}


}
