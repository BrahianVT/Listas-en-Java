//Implementacion de una lista ordenada
public class ListaOrdenada{
	class Nodo{
		int info;
		Nodo sig;
	}
	private Nodo raiz;
	public ListaOrdenada(){ raiz = null;}
	void insertar(int x){
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		if(raiz == null){
			raiz = nuevo;
			
		} else{
			if(x < raiz.info){
				nuevo.sig = raiz;
				raiz = nuevo;
			}
			else{
				Nodo aux = raiz;
				Nodo atras = raiz;
				while(x >= aux.info && aux.sig != null){
					atras = aux;
					aux = aux.sig;
				}
				if(x >= aux.info)
					aux.sig = nuevo;
				else{
					nuevo.sig = aux;
					atras.sig = nuevo;
				}
			}
		}
	}
	public void imprimir(){
		Nodo reco = raiz;
        while (reco != null) {
            System.out.print (reco.info + "-");
            reco = reco.sig;
        }
        System.out.println();
	}
	public static void main(String[] args) {
        ListaOrdenada lo=new ListaOrdenada();
        lo.insertar(10);
        lo.insertar(5);
        lo.insertar(7);
        lo.insertar(50);
        lo.imprimir();
    }
}