package umg.edu.gt.listasenlazadas;

import umg.edu.gt.listasenlazadas.applications.TaskBacklogApp;
import umg.edu.gt.listasenlazadas.retos.LinkedListChallenges;
import umg.edu.gt.listasenlazadas.simple.SimpleListExample;
import umg.edu.gt.listasenlazadas.simple.SinglyLinkedList;


/**
 * Punto de entrada del proyecto.
 * Ejecuta ejemplos base y aplicaciones practicas.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== DEMOS ESTRUCTURAS ENLAZADAS ===");
        System.out.println();

        SimpleListExample.run();

        System.out.println();
        System.out.println("=== APLICACIONES REALES ===");
        TaskBacklogApp.run();
       
       
        LinkedListChallenges.run();
        
        System.out.println("\n=== RESULTADOS AGREGADOS ===");
        
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        
        System.out.println("Lista original: " + list);
     
        System.out.println("Eliminados: " + list.clean());
        System.out.println("Lista después de clean: " + list);

     
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        System.out.println("Lista nueva: " + list);

        
        list.reverseInPlace();
        System.out.println("Lista invertida: " + list);
        
        
     
        SinglyLinkedList<String> list2 = new SinglyLinkedList<>();

        list2.addLast("A");
        list2.addLast("B");
        list2.addLast("A");
        list2.addLast("C");
        list2.addLast("B");
        list2.addLast("D");

        System.out.println("Lista con duplicados: " + list2);

        int eliminados = list2.removeDuplicates();

        System.out.println("Duplicados eliminados: " + eliminados);
        System.out.println("Lista sin duplicados: " + list2);
    }
}
