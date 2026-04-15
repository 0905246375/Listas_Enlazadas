package umg.edu.gt.listasenlazadas.doubly;

/**
 * Implementacion basica de una lista doblemente enlazada.
 *
 * @param <T> tipo de dato almacenado
 */
public class DoublyLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int size;

    public void addFirst(T value) {
        DoublyNode<T> newNode = new DoublyNode<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        DoublyNode<T> newNode = new DoublyNode<>(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        }

        T value = head.getValue();
        head = head.getNext();
        if (head == null) {
            tail = null;
        } else {
            head.setPrevious(null);
        }
        size--;
        return value;
    }

    public T removeLast() {
        if (tail == null) {
            return null;
        }

        T value = tail.getValue();
        tail = tail.getPrevious();
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        size--;
        return value;
    }

    public boolean contains(T value) {
        DoublyNode<T> current = head;
        while (current != null) {
            if (isSameValue(current.getValue(), value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * RETO 1:
     * Cuenta cuantas veces aparece un valor en la lista.
     *
     * @param value valor a buscar
     * @return cantidad de ocurrencias
     */
    // Solucion del reto 1 
    public int countOccurrences(T value) {
        int count = 0;
        DoublyNode<T> current = head;

        while (current != null) {
            if (isSameValue(current.getValue(), value)) {
                count++;
            }
            current = current.getNext();
        }

        return count;
    }

    /**
     * RETO 2:
     * Limpia la lista nodo por nodo y retorna la cantidad removida.
     *
     * @return nodos eliminados
     */
    //Solucion reto 2 
    public int clean() {
        int removed = 0;
        DoublyNode<T> current = head;

        while (current != null) {
            DoublyNode<T> next = current.getNext();

            current.setNext(null);
            current.setPrevious(null);

            current = next;
            removed++;
        }

        head = null;
        tail = null;
        size = 0;

        return removed;
    }

    /**
     * RETO 3:
     * Invierte la lista in-place, actualizando enlaces next/previous.
     */
    //Solucion reto 3 
    public void reverseInPlace() {
        DoublyNode<T> current = head;
        DoublyNode<T> temp = null;

        while (current != null) {
            
            temp = current.getPrevious();
            current.setPrevious(current.getNext());
            current.setNext(temp);

            current = current.getPrevious(); 
        }

        temp = head;
        head = tail;
        tail = temp;
    }
    /**
     * RETO 4:
     * Elimina nodos duplicados conservando la primera ocurrencia.
     *
     * @return cantidad de nodos eliminados
     */
    //Solucion reto 4 
    public int removeDuplicates() {
        int removed = 0;
        DoublyNode<T> current = head;

        while (current != null) {
            DoublyNode<T> runner = current.getNext();

            while (runner != null) {
                DoublyNode<T> next = runner.getNext();

                if (isSameValue(current.getValue(), runner.getValue())) {
                   
                    if (runner.getPrevious() != null) {
                        runner.getPrevious().setNext(runner.getNext());
                    }

                    if (runner.getNext() != null) {
                        runner.getNext().setPrevious(runner.getPrevious());
                    }

                   
                    if (runner == tail) {
                        tail = runner.getPrevious();
                    }

                    size--;
                    removed++;
                }

                runner = next;
            }

            current = current.getNext();
        }

        return removed;
    }

    public String toForwardString() {
        StringBuilder builder = new StringBuilder("[");
        DoublyNode<T> current = head;
        while (current != null) {
            builder.append(current.getValue());
            if (current.getNext() != null) {
                builder.append(", ");
            }
            current = current.getNext();
        }
        builder.append("]");
        return builder.toString();
    }

    public String toBackwardString() {
        StringBuilder builder = new StringBuilder("[");
        DoublyNode<T> current = tail;
        while (current != null) {
            builder.append(current.getValue());
            if (current.getPrevious() != null) {
                builder.append(", ");
            }
            current = current.getPrevious();
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public String toString() {
        return toForwardString();
    }

    private boolean isSameValue(T left, T right) {
        return left == right || (left != null && left.equals(right));
    }
}
