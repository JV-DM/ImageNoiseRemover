package eda.librerias.estructurasDeDatos.deDispersion;
import eda.librerias.estructurasDeDatos.modelos.Map;
import eda.librerias.estructurasDeDatos.modelos.LlistaAmbPI;
import eda.librerias.estructurasDeDatos.lineales.LEGLlistaAmbPI;

@SuppressWarnings("unchecked")
public class TaulaHash<C,V> implements Map<C,V> {
    //atributs
    protected EntradaHash<C,V> [] taula;
    protected int numElem;
    //metodes
    public TaulaHash(int nCubetes){
	taula = new EntradaHash[nCubetes];
	numElem = 0;
    }

      // insereix/actualitza la entrada (c,v) torna
    // valor anterior o null si no estava
    public V inserir(C c, V v){
	int pos = fHash(c);
	    
	EntradaHash<C,V> aux = taula[pos];
	while (aux != null && !c.equals(aux.clau)){
	    aux = aux.seg;
	}

	V aTornar = null;
	if (aux != null){
	    aTornar = aux.valor;
	    aux.valor = v;
	} else {//no estava
	    taula[pos] = new EntradaHash<C,V>(c,v,taula[pos]);
	    numElem++;
	}
       
	return aTornar;
    }
    // elimina entrada con clau c, torna su
    // valor associat, o null si no existeix
    public V eliminar(C c){
	int pos = fHash(c);
	EntradaHash<C,V> aux = taula[pos];
	EntradaHash<C,V> aux_ant = null;
	while (aux!=null && !c.equals(aux.clau)){
	    aux_ant = aux;
	    aux = aux.seg;
	}

	V aTornar = null;
	if (aux != null) {// trobat
	    numElem--;
	    aTornar = aux.valor;
	    if (aux_ant == null) {//esborrem el primer element
		taula[pos] = aux.seg;
	    } else{
		aux_ant.seg = aux.seg;
	    }
	}
	return aTornar;
	
    }
    // torna el valor associat a la clau c
    // o null si no existia eixa entrada    
    public V recuperar(C c){
	int pos = fHash(c);
	EntradaHash<C,V> aux = taula[pos];
	while(aux != null && !c.equals(aux.clau)){
	    aux = aux.seg;
	}

	if (aux != null)
	    return aux.valor;
	else
	    return null;
    }
    
    public boolean esBuida(){
	return numElem == 0;
    }
    public int talla(){
	return numElem;
    }

    public int fHash(C clau){
	int hash_valor = clau.hashCode();

	if (hash_valor < 0) hash_valor *= -1;
	
	return hash_valor % taula.length;
    }
    // torna una ListaConPI que conte totes les claus
    public  LlistaAmbPI<C> claus(){

	LlistaAmbPI<C> llista = new LEGLlistaAmbPI<C>();
	
	for (int c = 0; c < taula.length; c++) {
	    EntradaHash<C,V> aux = taula[c];
	    while(aux != null){
		llista.inserir(aux.clau);
		aux = aux.seg;
	    }
	}

	return llista;
    }

    public double factorCarrega(){
	return (1.0*numElem)/taula.length;
    }

    public double desviacioTipica(){
	double mitjana = factorCarrega();
	double sumaQuadrats=0;
	for (int c = 0; c < taula.length; c++) {
	    int cont = 0;
	    EntradaHash<C,V> aux = taula[c];
	    while (aux != null) {
		cont++;
		aux = aux.seg;
	    }

	    sumaQuadrats += (mitjana - cont)* (mitjana - cont);
	}
	sumaQuadrats = sumaQuadrats / taula.length;

	return Math.sqrt(sumaQuadrats);
    }

    public String histograma(){
	int [] histo = new int [10];
	
	for (int c = 0; c < taula.length; c++) {
	    int cont = 0;
	    EntradaHash<C,V> aux = taula[c];	    
	    while(aux != null){
		cont++;
		aux = aux.seg;
	    }
	    if (cont > 9) cont = 9;
	    histo[cont]++;
	}

	String res = "";
	for (int i = 0; i < histo.length; i++) {
	    res += i + " " + histo[i] + "\n";
	}
	return res;
    }

}
