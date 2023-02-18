public class NodoArbol{
    int dato;
    String nombre;
    NodoArbol hijoIzq ,hijoDer;
    
    public NodoArbol(int dato,String nombre){
        this.dato=dato;
        this.nombre=nombre;
        this.hijoIzq=null;
        this.hijoDer=null;
        
    }
    public String toString(){
        return nombre +"Su Dato es "+dato;
    }
}
