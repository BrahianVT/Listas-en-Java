//Implementacion de lista circular
class ListaCircular{
	class Nodo{
		int info;
		Nodo ant,sig;
	}
	private Nodo raiz;
	ListaCircular(){
		raiz = null;
	}
	void insertarPrimero (int x){
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		if(raiz == null){
			raiz = nuevo;
			nuevo.sig = raiz;
			nuevo.ant = raiz;
		}else{
			Nodo ultimo = raiz.ant;
			nuevo.sig = raiz;
			nuevo.ant = ultimo;
			raiz.ant = nuevo;
			ultimo.sig = nuevo;
			raiz = nuevo;
		}
	}
	void insertarUltimo(int x){
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		if(raiz == null){
			nuevo.sig = nuevo;
			nuevo.ant = nuevo;
			raiz = nuevo;
		}
		else{
			Nodo ultimo = raiz.ant;
			nuevo.sig = raiz;
			nuevo.ant = ultimo;
			raiz.ant = nuevo;
			ultimo.sig = nuevo;
		}
	}
	boolean vacia(){
		if(raiz == null)
			return true;
		else
			return false;
	}
	int cantidad(){
		int cant = 0;
		if(!vacia()){
		Nodo aux = raiz;
		do{
			cant++;
			aux = aux.sig;
		}while(aux != raiz);
		}
		return cant;
	}
	 void imprimir(){
	 if(!vacia()){
		Nodo aux = raiz;
		do{
			System.out.print(aux.info +"-");
			aux = aux.sig;
		}while(aux != raiz);
		System.out.println();
		}
	 }
	 void borrarPorPos(int pos){
		if (pos <= cantidad()){
			if(pos ==1){
				if(cantidad() == 1)
				raiz = null;
			    else{
				Nodo ultimo = raiz.ant;
				raiz = raiz.sig;
				ultimo.sig = raiz;
				raiz.ant = ultimo;
			    }
			}else{
				Nodo aux = raiz;
				for(int i = 1; i <= pos-1; i++)
					aux = aux.sig;
				Nodo anterior = aux.ant;
				aux = aux.sig;
				anterior.sig = aux;
				aux.ant = anterior; 
			}
		}
	 }
	 public static void main(String [] args){
		 ListaCircular lc=new ListaCircular();
        lc.insertarPrimero(100);
        lc.insertarPrimero(45);
        lc.insertarPrimero(12);
        lc.insertarPrimero(4);
        System.out.println("Luego de insertar 4 nodos al principio");
        lc.imprimir();
        lc.insertarUltimo(250);
        lc.insertarUltimo(7);
        System.out.println("Luego de insertar 2 nodos al final");
        lc.imprimir();
        System.out.println("Cantidad de nodos:"+lc.cantidad());
        System.out.println("Luego de borrar el de la primer posicion:");
        lc.borrarPorPos(1);
        lc.imprimir();
        System.out.println("Luego de borrar el de la cuarta posicion:");
        lc.borrarPorPos(4);
        lc.imprimir();  
	 }
}

