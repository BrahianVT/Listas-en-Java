//Implementacion de una lista generica

 class ListaGenerica{
	class Nodo{
		int info;
		Nodo sig;
	}
	Nodo raiz;
	ListaGenerica(){ raiz = null; }
	void insertar (int pos , int x){
		if(pos <= cantidad() + 1){
			Nodo nuevo = new Nodo();
			nuevo.info = x;
			if (pos ==1){
				nuevo.sig = raiz;
				raiz = nuevo;
			}else{
				if (pos == cantidad() + 1){
					Nodo aux = raiz;
					while(aux.sig != null){
						aux = aux.sig;
					}
					aux.sig = nuevo;
					nuevo.sig = null;
				}else{
					Nodo aux = raiz;
					for(int i = 1; i <= pos - 2; i++ )
						aux = aux.sig;
					Nodo siguiente = aux.sig;
					aux.sig = nuevo;
					nuevo.sig = siguiente;
				}
				
			}
		}
	}
	public int eliminar(int pos){
		if (pos <= cantidad()){
			int informacion;
			if(pos ==1){
				informacion = raiz.info;
				raiz = raiz.sig;
			}else{
				Nodo aux;
				aux = raiz;
				for(int i = 1; i <= pos - 2; i++)
					aux = aux.sig;
				Nodo prox = aux.sig;
				aux.sig = prox.sig;
				informacion = prox.info;
			}
			return informacion;
		}else{
			return Integer.MAX_VALUE;
		}
	}
	public void intercambiar (int pos1, int pos2){
		if(pos1 <= cantidad() && pos2 <= cantidad()){
			Nodo aux1 = raiz;
			for(int i = 1; i < pos1; i++)
				aux1 = aux1.sig;
			Nodo aux2 = raiz;
			for(int i = 1; i < pos2; i++)
				aux2 = aux2.sig;
			int aux = aux1.info;
			aux1.info = aux2.info;
			aux2.info = aux;
		}
	}
	public int mayor(){
		if(!vacia()){
		Nodo aux = raiz;
		int mayor = aux.info;
		while(aux.sig != null){
			if(aux.info > mayor){
				mayor = aux.info;
			}
			aux = aux.sig;
		}
		return mayor;
		}else{
		return Integer.MAX_VALUE;
		}
	}
	public int posMayor(){
		if(!vacia()){
			int mayor = raiz.info;
			int i = 1;
			int may = i;
			Nodo aux = raiz;
			while(aux.sig != null){
				if(aux.info > mayor){
					mayor = aux.info;
					may = i;
					}
				aux = aux.sig;
				i++;
			}
			return i;
		}
		else{
			return Integer.MAX_VALUE;
		}
	}
	public int cantidad(){
		Nodo aux = raiz;
		int i = 0;
		while(aux != null){
			aux = aux.sig;
			i++;
		}
		return i;
		
	}
	public boolean ordenada_asc(){
		if(cantidad() > 1){
			Nodo aux1 = raiz;
			Nodo aux2 = raiz.sig;
			while(aux2 != null){
				if(aux2.info < aux1.info)
			 	   return false;
				aux1 = aux1.sig;
				aux2 = aux2.sig;
			}
		}
		return true;
	}
	public boolean existe (int x){
		Nodo aux = raiz;
		while(aux != null){
				if(x == aux.info){
					return true;
				}
				aux = aux.sig;
		}
		return false;
	}
	public boolean vacia(){
		if(raiz == null)
			return true;
		else
		return false;
 	}
	public void imprimir(){
		Nodo aux = raiz;
		while(aux!= null){
			System.out.print(aux.info +" - ");
			aux = aux.sig;
		}
	System.out.println();
	}
	public static void main (String[] args){
		ListaGenerica lista = new ListaGenerica();
		lista.insertar(1,10);
		lista.insertar(2,20);
		lista.insertar(3,30);
		//lista.insertar(2,15);
		//lista.insertar(1,115);
		lista.imprimir();
		System.out.println ("Luego de Borrar el primero que es:" + lista.eliminar(2));
		lista.imprimir();
		/*System.out.println ("Luego de Intercambiar el primero con el tercero");
        lista.intercambiar (1, 3);
		lista.imprimir();
		if(lista.existe(10))
		System.out.println("existe el numero 10");
		else
		System.out.println("no existe el numero 10");
		System.out.println("la posicion del mayor es: " +lista.posMayor());
		if (lista.ordenada_asc())
            System.out.println("La lista esta ordenada de menor a mayor");
        else
            System.out.println("La lista no está ordenada de menor a mayor");
		*/
	}
} 