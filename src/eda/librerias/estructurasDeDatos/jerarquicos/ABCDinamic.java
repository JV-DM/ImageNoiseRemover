package eda.librerias.estructurasDeDatos.jerarquicos;
import eda.librerias.estructurasDeDatos.modelos.*;

public class ABCDinamic<E extends Comparable<E>>
        implements ArbreBinariDeCerca<E> {
    protected NodeABC<E> arrel;
    protected int talla;

    public ABCDinamic() {
        arrel = null;
        talla = 0;
    }

    public boolean cercar_it(E e){
        NodeABC<E> r = arrel;

        if (e.equals(r.valor())) return true;

        while (r != null && !e.equals(r.valor()) ) {
            if (e.compareTo(r.valor())< 0){
                r = r.esq;
            } else{
                r = r.dre;
            }
        }
        if (r == null) return false;
        return true;

        // return (r != null);
    }
    public boolean cercar(E e){
        return cercar(e,arrel);
    }

    private boolean cercar(E e,NodeABC<E> r ){
        if (r == null) return false;

        if (e.equals(r.valor())) return true;
        if (e.compareTo(r.valor())< 0){
            return cercar(e,r.esq);
        }else {
            return cercar(e,r.dre);
        }
    }

    public void inserir(E e){
        NodeABC<E> r = arrel;
        NodeABC<E> ant = null;

        while (r != null && !e.equals(r.valor()) ) {
            ant = r;
            if (e.compareTo(r.valor())< 0){
                r = r.esq;
            } else{
                r = r.dre;
            }
        }
        if (r == null){
            // si l'arbre esta buit
            if (arrel == null){ // if (ant == null)
                arrel = new NodeABC<E>(e);
            } else {
                //decidir si el posem a la dreta o a l'esquerra
                if (e.compareTo(ant.valor())< 0){
                    ant.esq = new NodeABC<E>(e);
                } else {
                    ant.dre = new NodeABC<E>(e);
                }
            }
        }


    }

    public boolean esBuit(){return false;}

    private String preOrdre(NodeABC<E> r){
        if (r == null) return "";

        String res = "";
        res += r.valor() + "\n";
        res += preOrdre(r.esq);
        res += preOrdre(r.dre);

        return res;
    }
    public String preOrdre(){
        return preOrdre(arrel);
    }

    private  String inOrdre(NodeABC<E> r){
        if (r == null) return "";
        return inOrdre(r.esq) + r.valor() + "\n" + inOrdre(r.dre);

    }
    public String inOrdre(){return inOrdre(arrel);}
    public String postOrdre(){return "";}

    public E max(){
        NodeABC<E> r = arrel;
        if (arrel == null) return null;

        while (r.dre != null){
            r = r.dre;
        }
        return r.valor();
    }


    public E min(){
        NodeABC<E> r = arrel;
        if (arrel == null) return null;

        while (r.esq != null){
            r = r.esq;
        }
        return r.valor();
    }

    private E successor (E e, NodeABC<E> r){

        if (r == null)
            return null;

        if (e.compareTo(r.valor())<0 ){
            E suc = successor(e, r.esq);
            if (suc == null){ // l'arbre esq no te successor de e
                return r.valor();
            } else {
                return suc;
            }
        }else {
            return successor(e, r.dre);
        }
    }
    public E successor(E e){
        return successor(e, arrel);
    }

    private int numNodes(NodeABC<E> r){

        if (r == null) return 0;

        int n_nod_esq = numNodes(r.esq);
        int n_nod_dret = numNodes(r.dre);
        return n_nod_esq + 1 + n_nod_dret;
    }
    public int numNodes(){
        return numNodes(arrel);
    }

    private int numFulles(NodeABC<E> r){
        if (r == null) return 0;
        if (r.esq == null && r.dre == null) return 1;
        return numFulles(r.esq) + numFulles(r.dre);

    }

    public int numFulles(){
        return numFulles(arrel);
    }

    private int altura(NodeABC<E> r){
        if (r == null) return -1;
        int alt_esq = altura(r.esq);
        int alt_dret = altura(r.dre);

        if (alt_esq > alt_dret) return alt_esq +1;
        else return alt_dret+1;
    }

    public int altura(){
        return altura(arrel);
    }

    private void espill(NodeABC<E> r){

        if (r != null){

            espill(r.esq);
            espill(r.dre);

            NodeABC<E> aux = r.esq;
            r.esq = r.dre;
            r.dre = aux;
        }
    }
    public void espill(){
        espill(arrel);
    }

    private void imprimirAProf(NodeABC<E> r, int prof){

        if (r == null) return; // no hi ha feina que fer

        if (prof == 0){
            System.out.println(r.valor());
        } else {
            imprimirAProf(r.esq, prof -1);
            imprimirAProf(r.dre, prof -1);
        }
    }
    public void imprimirAProf(int prof){
        imprimirAProf(arrel,prof);
    }

    private String imprimirEnRang(NodeABC<E> r, E min, E max){

        if (r == null) return "";
        String res = "";

        //	System.out.println(r.valor()+" "+min+" "+max);

        if (r.valor().compareTo(min) >= 0 && r.valor().compareTo(max)<=0){
            res += r.valor()+" ";
        }

        if (min.compareTo(r.valor()) < 0){
            res += imprimirEnRang(r.esq,min,max);
        }
        if (max.compareTo(r.valor()) > 0){
            res += imprimirEnRang(r.dre,min,max);
        }

        return res;
    }
    public String imprimirEnRang( E min, E max){
        return imprimirEnRang(arrel,min,max);
    }

    public E eliminarMin(){
        if (arrel == null){
            return null;
        }
        return eliminarMin(arrel, null);
    }

    public E eliminarMin(NodeABC<E> aux, NodeABC<E> ant){

        while (aux.esq != null){
            ant = aux;
            aux = aux.esq;
        }

        E aTornar = aux.valor();
        if (ant == null){  // ó aux == arrel, esborrem l'arrel
            arrel = arrel.dre;
        } else {
            ant.esq = aux.dre;
        }

        return aTornar;
    }

    public void esborrar(E e){
        NodeABC<E> aux = arrel;
        NodeABC<E> ant = null;

        while (aux != null && e.equals(aux.valor())== false){
            ant = aux;
            if(e.compareTo(aux.valor()) < 0)
                aux = aux.esq;
            else
                aux = aux.dre;
        }

        if ( aux == null )  // l'element a esborrar no està
            return;


        //té dos fill
        if (aux.esq != null && aux.dre !=null){
            aux.setValor(eliminarMin(aux.dre, aux));
        } else if (aux.esq != null){ // té fill esq
            // if (aux.valor().compareTo(ant.valor() < 0)
            if (e.compareTo(ant.valor()) < 0){ // aux està a l'esquerre de ant
                ant.esq = aux.esq;
            }else
                ant.dre = aux.esq;
        } else if (aux.dre != null){ // té fill dret
            if (e.compareTo(ant.valor()) < 0){ // aux està a l'esquerre de ant
                ant.esq = aux.dre;
            }else
                ant.dre = aux.dre;
        } else {// es una fulla
            if (e.compareTo(ant.valor()) < 0){ // aux està a l'esquerre de ant
                ant.esq = null;
            }else
                ant.dre = null;

        }
    }
}