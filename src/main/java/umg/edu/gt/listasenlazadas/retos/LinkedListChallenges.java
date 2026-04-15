package umg.edu.gt.listasenlazadas.retos;

import umg.edu.gt.listasenlazadas.simple.SinglyLinkedList;

/**
 * Laboratorio de retos para obligar a extender el codigo base de las estructuras.
 */
public final class LinkedListChallenges {

    private LinkedListChallenges() {
    }

    public static void run() {
        System.out.println("=== RETOS DE IMPLEMENTACION ===");
        challenge1CountOccurrences();
        challenge2Clean();
        challenge3ReverseInPlace();
        challenge4RemoveDuplicates();
        System.out.println();
    }

    private static void challenge1CountOccurrences() {
        SinglyLinkedList<String> eventos = new SinglyLinkedList<>();
        eventos.addLast("LOGIN");
        eventos.addLast("CLICK");
        eventos.addLast("LOGIN");
        eventos.addLast("SCROLL");
        eventos.addLast("LOGIN");

        System.out.println("Reto 1 - Analitica de eventos (lista simple)");
        System.out.println("Eventos: " + eventos);

        int totalLogins = eventos.countOccurrences("LOGIN");
        printCheck("countOccurrences(LOGIN)", 3, totalLogins);

        System.out.println();
    }

    private static void challenge2Clean() {
        SinglyLinkedList<Integer> numeros = new SinglyLinkedList<>();
        numeros.addLast(10);
        numeros.addLast(20);
        numeros.addLast(30);
        numeros.addLast(40);

        System.out.println("Reto 2 - Limpieza total de lista");
        System.out.println("Antes de clean: " + numeros + " size=" + numeros.size());

        int eliminados = numeros.clean();

        printCheck("clean() nodos eliminados", 4, eliminados);
        printCheck("size despues de clean", 0, numeros.size());
        printCheck("isEmpty despues de clean", true, numeros.isEmpty());
        printCheck("toString despues de clean", "[]", numeros.toString());

        System.out.println();
    }

    private static void challenge3ReverseInPlace() {
        SinglyLinkedList<Integer> lista = new SinglyLinkedList<>();
        lista.addLast(2);
        lista.addLast(4);
        lista.addLast(5);
        lista.addLast(6);

        System.out.println("Reto 3 - Inversion in-place");
        System.out.println("Antes: " + lista);

        lista.reverseInPlace();

        System.out.println("Despues: " + lista);

        printCheck("reverseInPlace contenido", "[6, 5, 4, 2]", lista.toString());
        printCheck("size se mantiene", 4, lista.size());

        System.out.println();
    }

    private static void challenge4RemoveDuplicates() {
        SinglyLinkedList<String> codigos = new SinglyLinkedList<>();
        codigos.addLast("A");
        codigos.addLast("B");
        codigos.addLast("A");
        codigos.addLast("C");
        codigos.addLast("B");
        codigos.addLast("D");
        codigos.addLast("D");

        System.out.println("Reto 4 - Eliminacion de duplicados");
        System.out.println("Antes: " + codigos);

        int eliminados = codigos.removeDuplicates();

        System.out.println("Despues: " + codigos);

        printCheck("removeDuplicates eliminados", 3, eliminados);
        printCheck("contenido sin duplicados", "[A, B, C, D]", codigos.toString());
        printCheck("size final", 4, codigos.size());

        System.out.println();
    }

    private static void printCheck(String testName, Object expected, Object actual) {
        boolean ok = isSame(expected, actual);
        String status = ok ? "OK" : "FALLO";
        System.out.println("  [" + status + "] " + testName
                + " -> esperado=" + expected + ", obtenido=" + actual);
    }

    private static boolean isSame(Object left, Object right) {
        return left == right || (left != null && left.equals(right));
    }
}