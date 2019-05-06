package eda.librerias.estructurasDeDatos.deDispersion;
class EntradaHash<C, V> {
    C clau;
    V valor;
    EntradaHash<C, V> seg;
    public EntradaHash(C clau, V valor,
		       EntradaHash<C, V> seg) {
	this.clau = clau;
	this.valor = valor;
	this.seg = seg;
    }
}
