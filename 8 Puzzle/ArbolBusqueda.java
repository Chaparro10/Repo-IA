package puzzle8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Stack;

import javax.naming.spi.DirStateFactory.Result;

public class ArbolBusqueda {

    Nodo raiz;
    String objetivo;

    public ArbolBusqueda(Nodo raiz, String objetivo) {

        this.raiz = raiz;
        this.objetivo = objetivo;
    }

    // Busqueda por Anchura
    public void busquedaPorAnchura() {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Queue<Nodo> estadosPorVisitar = new LinkedList<>();
        while (!nodoActual.getEstado().equals(objetivo)) {
            estadosVisitados.add(nodoActual.getEstado());
            // Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos(); // <-- Cada Equipo tiene que ingeniarselas para crear
                                                                 // este metodo!
            for (String hijo : hijos) {
                if (!estadosVisitados.contains(hijo)) {
                    // ("---Metiendo nuevo Nodo");
                    // Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);

                }
            }
            nodoActual = estadosPorVisitar.poll();

            // OPCION 1
            String cadena = nodoActual.getEstado();

            System.out.println(cadena.substring(0, 3));
            System.out.println(cadena.substring(3, 6));
            System.out.println(cadena.substring(6, 9));
            System.out.println("------");

            // OPCION 2
            /*
             * Nodo n = Nodo(estadoInicial);
             * a.imprimeSolucion(raiz, nodoActual);
             */
            // System.out.println(nodoActual.getEstado());
        }

        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.getEstado());
    }

    /* HEURISTICA1-.SUMA DE POSICIONES INCORRECTAS */
    private int heuristica1(String estado, String objetivo2) {
        int resultado = 0;
        for (int x = 0; x < estado.length(); x++) {
            if (estado.charAt(x) != objetivo2.charAt(x)) // MIENTRAS QUE EL ESTADO SEA DISTINTO AL OBJETIVO INCRMENTA
                                                         // CONTADOR
                resultado++;

        }
        return resultado;

    }

    /* HEURISTICA 2 SUMA DE DIFERIENCIAS POR POSICION */
    private int heuristica2(String estado, String objetivo3) {
        int result = 0;
        int numero1, numero2;
        for (int i = 0; i < estado.length(); i++) {
            numero1 = Character.getNumericValue(estado.charAt(i));
            if (estado.charAt(i) == ' ')
                numero1 = 0;// SI ENCUENTRA ESPACIO ES UN CERO
            numero2 = Character.getNumericValue(objetivo3.charAt(i));
            if (objetivo3.charAt(i) == ' ')
                numero2 = 0;

            result = result + Math.abs(numero1 - numero2);
        }

        return result;

    }

    /* HEURISTICA 3-. /*SUMA LA DISTANCIA DE MANHATAM DE CADA NUM A SU OBJETIVO */
    private int heuristica3(String estado, String Objetivo4) {
        int distancia = 0;
        for (int i = 0; i < estado.length(); i++) {
            if (estado.charAt(i) != ' ') {

                int x2 = objetivo.indexOf(estado.charAt(i) % 3);
                int y2 = objetivo.indexOf(estado.charAt(i) / 3);
                distancia += Math.abs(x2 - y2);
            }
        }

        return distancia;
    }

    /*----************************************************************************------ */
    public void busquedaPorAnchuraconHeuristica1() {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        PriorityQueue<Nodo> estadosPorVisitar = new PriorityQueue<Nodo>();
        while (!nodoActual.getEstado().equals(objetivo)) {
            estadosVisitados.add(nodoActual.getEstado());
            // Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos(); // <-- Cada Equipo tiene que ingeniarselas para crear
                                                                 // este metodo!
            for (String hijo : hijos) {
                if (!estadosVisitados.contains(hijo)) {
                    // ("---Metiendo nuevo Nodo");
                    // Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.costo = heuristica3(nHijo.getEstado(), objetivo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);

                }
            }
            nodoActual = estadosPorVisitar.poll();

            // OPCION 1
            String cadena = nodoActual.getEstado();

            System.out.println(cadena.substring(0, 3));
            System.out.println(cadena.substring(3, 6));
            System.out.println(cadena.substring(6, 9));
            System.out.println("------");
        }

        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.getEstado());
    }

    // ************************BUSQUEDA X PROFUNDIDAD******* */
    // Busqueda por Anchura
    public void busquedaPorProfundidad() {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Stack<Nodo> estadosPorVisitar = new Stack<Nodo>();
        while (!nodoActual.getEstado().equals(objetivo)) {
            estadosVisitados.add(nodoActual.getEstado());
            // Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos(); // <-- Cada Equipo tiene que ingeniarselas para crear
                                                                 // este metodo!
            for (String hijo : hijos) {
                if (!estadosVisitados.contains(hijo)) {
                    // ("---Metiendo nuevo Nodo");
                    // Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);

                }
            }
            nodoActual = estadosPorVisitar.pop();

            // OPCION 1
            String cadena = nodoActual.getEstado();

            System.out.println(cadena.substring(0, 3));
            System.out.println(cadena.substring(3, 6));
            System.out.println(cadena.substring(6, 9));
            System.out.println("------");

            // OPCION 2
            /*
             * Nodo n = Nodo(estadoInicial);
             * a.imprimeSolucion(raiz, nodoActual);
             */
            // System.out.println(nodoActual.getEstado());
        }

        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.getEstado());
    }

}
