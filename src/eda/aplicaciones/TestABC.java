package eda.aplicaciones;
import  eda.librerias.estructurasDeDatos.jerarquicos.ABB;
import java.util.Random;

public class TestABC {
    public static void main(String[] args) {
	ABB<Integer> arbre = new ABB();
	Random gen = new Random();
	
	for (int i = 0; i < 11; i++) {
	    arbre.insertar(i);
	    //arbre.inserir(gen.nextInt(1000));
	}
	for (int i = -1; i > -11; i--) {
	    arbre.insertar(i);
	    //arbre.inserir(gen.nextInt(1000));
	}
	//System.out.println(arbre.enRang(50,-75));
	arbre.eliminar(0);
	ABB<Integer> a = new ABB<>();
	a.insertar(1);

	System.out.println(a.teDosFills());
	a.reconstruirEquilibrado();
	System.out.println(a.teDosFills());
    }

}