package eda.librerias.util;
import java.util.Random;

public class Ordenacio {
    // Selecció directa

    public static <T extends Comparable<T>> void seleccioDirecta(T v[]) {
	
	for (int j = 0; j < v.length-1; j++) {
	    int posmin = j; T valmin = v[j];
	    for (int i=j+1; i < v.length; i++)
		if (v[i].compareTo(valmin)<0){
		    valmin=v[i]; posmin=i;
		}
	    v[posmin]=v[j]; v[j]=valmin;
	}
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable <T>> void merge (T v[], int ini, int meitat, int fi){
	T[] aux = (T[]) new Comparable[fi-ini+1];
	
	int i=ini;
	int j=meitat+1;
	int k=0;

	while(i <= meitat && j <= fi){
	    if (v[i].compareTo(v[j]) < 0)
		aux[k++]=v[i++];
	    else
		aux[k++]=v[j++];
	}
	
	while(i <= meitat){
		aux[k++]=v[i++];
	}
	
	while(j <= fi){
	    aux[k++] = v[j++];
	}


	for (k = 0; k < aux.length; k++) {
	    v[ini+k]=aux[k];
	}

	
    }
    public static <T extends Comparable<T>> void mergeSort(T v[]){
	if (v == null) return;
	mergeSort(v, 0 , v.length-1);
    }

    private static <T extends Comparable<T>> void mergeSort(T v[], int ini, int fi) {
	if (ini < fi){
	    int meitat = (fi + ini)/2;
	    mergeSort(v, ini, meitat);
	    mergeSort(v, meitat+1, fi);
	    merge(v,ini,meitat,fi);
	}
    }

    public static <T extends Comparable<T>> void mergeSortRoin(T v[]){
	if (v == null) return;
	mergeSortRoin(v, 0 , v.length-1);
    }
    
    private static <T extends Comparable<T>> void mergeSortRoin(T v[], int ini, int fi) {
	if (ini < fi){
	    mergeSortRoin(v, ini, ini);
	    mergeSortRoin(v, ini+1, fi);
	    merge(v,ini,ini+1,fi);
	}
     }

    private static <T extends Comparable<T>> int  particio(T v[], int ini, int fi) {

	int i = ini-1;
	int f = fi+1;
	
	Random gen=new Random();
	int pos_pivot_aleat = gen.nextInt(fi-ini+1);
	T pivot = v[ini+pos_pivot_aleat];

	while(i < f){
	    do {
		i++;
	    } while (i <= fi && v[i].compareTo(pivot) < 0);

	    do {
		f--;
	    } while (f >= ini  && v[f].compareTo(pivot) > 0);

	    if (i < f){
		T aux = v[i];
		v[i] = v[f];
		v[f] = aux;
	    }
	}
	return f;

    }
    public static <T extends Comparable<T>> void quickSort(T v[]){
	if (v == null) return;
	quickSort(v, 0 , v.length-1);
    
    }
    private static <T extends Comparable<T>> void quickSort(T v[], int ini, int fi) {
	if (ini < fi){
	    int meitat = particio(v,ini,fi);
	    quickSort(v, ini, meitat);
	    quickSort(v, meitat+1, fi);
	}
    }
    public static <T extends Comparable<T>> T select(T v[], int k_essim){
	return select(v,0, v.length-1, k_essim);
    }

    private  static <T extends Comparable<T>> T select(T v[], int ini, int fi, int k_essim){
	if (ini == fi) return v[ini];
	else{
	    int meitat = particio(v,ini,fi);
	    if (k_essim <= meitat){
		return select(v,ini,meitat,k_essim);
	    } else {
		return select(v,meitat+1, fi, k_essim);
	    }
	}
    }
}


