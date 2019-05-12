package eda.aplicaciones;
import  eda.librerias.estructurasDeDatos.jerarquicos.ABB;
import java.util.Random;

public class TestABC {
	public static void main(String[] args) {
		ABB<Integer> a = new ABB();
		Random gen = new Random();

		for (int i = 62; i > 31; i--) {
			a.insertar(i);
			//arbre.inserir(gen.nextInt(1000));
		}
		a.reconstruirEquilibrado();
		if (a.teDosFills()) {
			System.out.println("Test para arbol equilibrado correcto");
		}else{
			System.out.println("Test arbol equilibrado incorrecto");
		}
		a = new ABB();
		for(int i = 62; i > 31; i--)
		{
			a.insertar(i);
		}
		a.reconstruirEquilibrado();
		a.insertar(30);
		if (!a.teDosFills()) {
			System.out.println("Test para arbol no equilibrado correcto");
		}else{
			System.out.println("Test arbol no equilibrado incorrecto");
		}
		a = new ABB();
		for(int i = 62; i > 31; i--)
		{
			a.insertar(i);
		}
		if(!a.teDosFills()){
			System.out.println("Test para arbol de una sola rama correcto");
		}else{
			System.out.println("Test para arbol de una sola rama  incorrecto");
		}
		for(int i = 0; i < 100; i++) {
			int num_nodos = (int) ((Math.random() * 100) / 100);
			for (int j = 0; j < num_nodos; j++) {
				a.insertar((int) Math.random());
			}
			a.reconstruirEquilibrado();
			if(a.teDosFills()){
				System.out.println("todo bien");
			}
		}
	}


}
