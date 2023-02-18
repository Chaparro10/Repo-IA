
public class arbolBinario{
    NodoArbol raiz;
    
    public arbolBinario(){
        raiz =null;
    }
    //PARA SABER SI ESTA Vacioc
    public boolean estaVacio(){
        return raiz==null;
    }
    //METODO PARA BUSCAR NODO EN arbolBinari
    public NodoArbol buscaNodo(int dato){
        NodoArbol auxiliar=raiz;
        while(auxiliar.dato!=dato){
            if(dato<auxiliar.dato){
                auxiliar=auxiliar.hijoIzq;
            }else{
                auxiliar=auxiliar.hijoDer;
            }
            if(auxiliar==null){
                return null;
                
            }
        }
        return auxiliar;
    }
    
    //RECORRER ARBOL POST ORDEN
    public void postOrden(NodoArbol r){
        if(r != null){
            postOrden(r.hijoIzq);
            postOrden(r.hijoDer);
            System.out.println(r.dato + ", ");
            
        }
    }
    
    //agregar nodos al arbolBinario
    public void agregarNodo(int dato , String nombre){
        NodoArbol nuevo = new NodoArbol(dato,nombre);
        if(raiz==null){
            raiz=nuevo;
        }else{
            NodoArbol auxiliar =raiz;
            NodoArbol padre;
            while(true){
                padre=auxiliar;
                if(dato<auxiliar.dato){
                    auxiliar=auxiliar.hijoIzq;
                    if(auxiliar==null){
                        padre.hijoIzq=nuevo;
                        return;
                    }
                }else{
                    auxiliar=auxiliar.hijoDer;
                    if(auxiliar==null){
                        padre.hijoDer=nuevo;
                        return;
                    }
                }
            }
            
        }
    }
}
 //TERMINA CLASE
