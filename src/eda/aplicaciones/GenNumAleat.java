package eda.aplicaciones;
import java.util.Random;

public class GenNumAleat {
    public static void main(String[] args) {
	Random gen = new Random();

	if (args.length < 2){
	    System.err.println("Us: java: GenNumAleat quantitat rang");
	    System.exit(-1);
	}
	
	int quantitat = Integer.parseInt(args[0]);
	int rang = Integer.parseInt(args[1]);

	System.out.println(quantitat);

	for (int i = 0; i < quantitat; i++) {	    
	    int num = gen.nextInt(rang);	    
	    System.out.println(num);
	}
	
    }

}
