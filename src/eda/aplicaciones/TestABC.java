package eda.aplicaciones;
import  eda.librerias.estructurasDeDatos.jerarquicos.ABC;
import java.util.Random;

public class TestABC {
    public static void main(String[] args) {
	ABC<Integer> arbre = new ABC();
	Random gen = new Random();
	
	for (int i = 0; i < 11; i++) {
	    arbre.inserir(i);
	    //arbre.inserir(gen.nextInt(1000));
	}
	for (int i = -1; i > -11; i--) {
	    arbre.inserir(i);
	    //arbre.inserir(gen.nextInt(1000));
	}
	System.out.println(arbre.inOrdre());

	//System.out.println(arbre.enRang(50,-75));
	arbre.esborrar(0);
	System.out.println(arbre.inOrdre());
	ABC<Integer> a = new ABC<>();
	a.inserir(1);
	a.inserir(2);
	a.inserir(3);
	a.inserir(4);
	a.inserir(0);
	System.out.println(arbre.teDosFills());
    }

}