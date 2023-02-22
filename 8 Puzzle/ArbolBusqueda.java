package puzzle8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArbolBusqueda {
    
    Nodo raiz;
    String objetivo;
    
    public ArbolBusqueda(Nodo raiz, String objetivo)
    {
        this.raiz = raiz;
        this.objetivo = objetivo;
    }
    
    //Busqueda por Anchura
    public void busquedaPorAnchura()
    {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Queue<Nodo> estadosPorVisitar = new LinkedList();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                   //("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                
                }
            }
            nodoActual = estadosPorVisitar.poll();  
             
            //OPCION 1
            String cadena = nodoActual.getEstado();

			System.out.println(cadena.substring(0, 3));
			System.out.println(cadena.substring(3, 6));
			System.out.println(cadena.substring(6, 9));
			System.out.println("------");

            //OPCION 2
            /*Nodo n = Nodo(estadoInicial);
            a.imprimeSolucion(raiz, nodoActual);
            */
          //  System.out.println(nodoActual.getEstado());
        }
      
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.getEstado());
    }


    public void Imprimir(){
         String cadena = nodoActual.getEstado();

			System.out.println(cadena.substring(0, 3));
			System.out.println(cadena.substring(3, 6));
			System.out.println(cadena.substring(6, 9));
			System.out.println("------");
    }
    //************************BUSQUEDA X PROFUNDIDAD******* */
     //Busqueda por Anchura
     public void busquedaPorProfundidad()
     {
         Nodo nodoActual = raiz;
         Collection<String> estadosVisitados = new ArrayList();
         Stack<Nodo> estadosPorVisitar = new Stack<Nodo>();
         while(!nodoActual.getEstado().equals(objetivo))
         {
             estadosVisitados.add(nodoActual.getEstado());
             //Generar a los Nodos Hijos
             Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
             for (String hijo : hijos) {
                 if(!estadosVisitados.contains(hijo))
                 {
                    //("---Metiendo nuevo Nodo");
                     //Crear nuevo Nodo.
                     Nodo nHijo = new Nodo(hijo);
                     nHijo.setPadre(nodoActual);
                     estadosPorVisitar.add(nHijo);
                 
                 }
             }
             nodoActual = estadosPorVisitar.pop();  
              
             //OPCION 1
             String cadena = nodoActual.getEstado();
 
             System.out.println(cadena.substring(0, 3));
             System.out.println(cadena.substring(3, 6));
             System.out.println(cadena.substring(6, 9));
             System.out.println("------");
             
             //OPCION 2
             /*Nodo n = Nodo(estadoInicial);
             a.imprimeSolucion(raiz, nodoActual);
             */
           //  System.out.println(nodoActual.getEstado());
         }
       
         System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
         System.out.println(nodoActual.getEstado());
     }
    
}
