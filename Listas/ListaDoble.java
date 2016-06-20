//Implementacion de lista doblemente enlazada
public class ListaDoble{
	class Nodo{
		int info;
		Nodo ant,sig;
	}
	Nodo raiz;
	public ListaDoble(){
		raiz = null;
	}
	void insertar(int pos , int x){
		if(pos <= cantidad() + 1){
			Nodo nuevo = new Nodo();
			nuevo.info = x;
			if(pos == 1){
				nuevo.sig = raiz;
				if(raiz != null)
					raiz.ant = nuevo;
			raiz = nuevo;
			}
				else{
					if(pos == cantidad() +1){
						Nodo aux = raiz;
						while(aux.sig != null){
							aux = aux.sig;
						}
						aux.sig = nuevo;
						nuevo.ant = aux;
						nuevo.sig = null;
					}
					else{
						Nodo aux = raiz;
						for(int i = 1; i <= pos-2; i++){
							aux = aux.sig;
						}
						Nodo siguiente = aux.sig;
						aux.sig = nuevo;
						nuevo.ant = aux;
						nuevo.sig = siguiente;
						siguiente.ant = nuevo;
					}
				}
			
		}
	}
	public void borrar (int pos){
		if(pos <= cantidad()){
			if(pos ==1){
				raiz = raiz.sig;
				raiz.ant = null;
			}else{
				Nodo aux = raiz;
				for(int i = 1; i <= pos-2; i++)
					aux = aux.sig;
				Nodo prox = aux.sig;
				prox = prox.sig;
				aux.sig = prox;
				if(prox != null)
					prox.ant = aux;
			}
		}
	}
	void intercambiar(int pos1 , int pos2){
		if(pos1 <= cantidad() && pos2 <= cantidad()){
			Nodo aux = raiz;
			for(int i = 1; i < pos1; i++)
				aux = aux.sig;
			Nodo aux2 = raiz;
			for(int i = 1; i < pos2; i++)
				aux2 = aux2.sig;
			int aux3 = aux.info;
			aux.info = aux2.info;
			aux2.info =aux3; 
		}
	}
	public int buscar (int x){
		Nodo aux = raiz;
		int i = 1;
		int pos = i;
		while(aux != null){
			if(x == aux.info){
				pos = i;
			}
		aux = aux.sig;
		i++;
		}
		return pos;
	}
	public int cantidad (){
        int cant = 0;
        Nodo reco = raiz;
        while (reco != null) {
            reco = reco.sig;
            cant++;
        }
        return cant;
    }
	public boolean existe(int x) {
        Nodo reco=raiz;
        while (reco!=null) {
            if (reco.info==x)
                return true;
            reco=reco.sig;
        }
        return false;
    }
	public boolean vacia ()
    {
        if (raiz == null)
            return true;
        else
            return false;
    }
    
    public void imprimir ()
    {
        Nodo reco = raiz;
        while (reco != null) {
            System.out.print (reco.info + "-");
            reco = reco.sig;
        }
        System.out.println();
    }
	public static void main(String[] ar) {
        ListaDoble lg = new ListaDoble();
        lg.insertar (1, 10);
        lg.insertar (2, 20);
        lg.insertar (3, 30);
        lg.insertar (3, 15);
        lg.insertar (4, 115);
        lg.imprimir ();
		System.out.println ("Luego de Borrar el primero");
        lg.borrar(1);
		lg.imprimir ();
		System.out.println ("Luego de Intercambiar el primero con el tercero");
        lg.intercambiar (1, 3);
		lg.imprimir();
		if (lg.existe(115)) {
			int pos = lg.buscar(115);
            System.out.println("Se encuentra el dato en la lista en posicion: " + pos);
		}else
            System.out.println("No se encuentra el dato en la lista");
	}
}