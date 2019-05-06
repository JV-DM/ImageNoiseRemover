package eda.librerias.estructurasDeDatos.lineales;
import  eda.librerias.estructurasDeDatos.modelos.Cua;

public class ArrayCua<E> implements Cua<E> {
    //atributs
    protected E elArray[];    
    protected static final int CAPACITAT_PER_DEFECTE = 3;
    protected int finalC, principiC, talla;

    @SuppressWarnings("unchecked")
    public ArrayCua(){
	elArray = (E[]) new Object[CAPACITAT_PER_DEFECTE];    
	finalC=-1;

	principiC=0;
	talla=0;
    }
    
    @SuppressWarnings("unchecked")
    protected void duplicarArrayCircular(){
	E [] aux = (E[]) new Object[elArray.length * 2];

	//System.out.println("talla nova "+ aux.length);

	for (int i = 0; i < talla; i++) 
	    aux[i] = elArray[(i+principiC) % elArray.length];

	principiC=0;
	finalC=talla-1;
	
	elArray = aux;
	
    }
    protected int incrementar(int index){
	index++;
	return index % elArray.length;
    }
    
    public void encuar(E e){
	if (talla >= elArray.length)
	    duplicarArrayCircular();
	    
	finalC = incrementar(finalC);	    
	elArray[finalC] = e;		
	talla++;
	    
    }
    

    public E desencuar(){
	if (talla <= 0) //esta buida
	    return null;
	
	E aux= elArray[principiC];
	principiC=incrementar(principiC);
	talla--;
	return aux;
	
    }
    public E primer(){
	if (talla <= 0) return null;
	return elArray[principiC];
    }

    public boolean esBuida(){
	return talla == 0;
    }
    public String toString(){
	String aTornar="";
	for (int i = 0; i < talla; i++) {
	    aTornar += elArray[(i+principiC) % elArray.length] + "\n";	    
	}
	return aTornar;
    }
}
