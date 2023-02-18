import javax.swing.JOptionPane;

public class Main
{
    
    public static void main(String[] args) {
        
       int opcion =0 , elemento=0;
       String nombre;
       arbolBinario arbolPrueba = new arbolBinario();
       do{
           try {
               opcion=Integer.parseInt(JOptionPane.showInputDialog(null,"1-.AGREGAR NODO \n"
               +"2-.BUSCAR UN NODO \n"
               +"3-.IMPRIMIR ARBOL(POST ORDEN)"));
               switch(opcion){
                   case 1:
                       elemento = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero del Nodo"));
                        nombre = (JOptionPane.showInputDialog(null,"Ingresa el nombre del Nodo"));
                        arbolPrueba.agregarNodo(elemento,nombre);
                       
                       break;
                       case 2:
                           if(!arbolPrueba.estaVacio()){
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero del Nodo a buscar"));
                         
                         
                          if(arbolPrueba.buscaNodo(elemento)==null)
                             System.out.println("El Nodo no se encuentra en el arbolPrueba");
                           }else{
                               System.out.println("Nodo Encontrado "+ arbolPrueba.buscaNodo(elemento) );
                           }
                           break;
                           case 3:
                               if(!arbolPrueba.estaVacio()){
                                   arbolPrueba.postOrden(arbolPrueba.raiz);
                               }else{
                                   System.out.println("El arbol esta vacio");
                               }
                           
                           break;
                           case 4:
                               break;
               }
           } catch(Exception e) {
               System.out.print("ERROR"+ e.getMessage());
           }
       }while(opcion !=4);
       
    }
}