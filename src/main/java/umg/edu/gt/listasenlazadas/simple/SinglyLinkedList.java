package umg.edu.gt.listasenlazadas.simple;

/**
 * Implementacion basica de una lista simplemente enlazada.
 *
 * @param <T> tipo de dato almacenado
 */
public class SinglyLinkedList<T> {
    private SimpleNode<T> head;
    private SimpleNode<T> tail;
    private int size;

    public void addFirst(T value) {
        SimpleNode<T> newNode = new SimpleNode<>(value);
        newNode.setNext(head);
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        SimpleNode<T> newNode = new SimpleNode<>(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
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
        }
        size--;
        return value;
    }

    public boolean remove(T value) {
        if (head == null) {
            return false;
        }

        if (isSameValue(head.getValue(), value)) {
            removeFirst();
            return true;
        }

        SimpleNode<T> previous = head;
        SimpleNode<T> current = head.getNext();

        while (current != null) {
            if (isSameValue(current.getValue(), value)) {
                previous.setNext(current.getNext());
                if (current == tail) {
                    tail = previous;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    public boolean contains(T value) {
        SimpleNode<T> current = head;
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

    public int countOccurrences(T value) {
        int count = 0;
        SimpleNode<T> current = head;
        while (current != null) {
            if (isSameValue(current.getValue(), value)) {
                count++;
            }
            current = current.getNext();
        }
        return count;
    }

    public int clean() {
        int removed = 0;
        SimpleNode<T> current = head;

        while (current != null) {
            SimpleNode<T> next = current.getNext();
            current.setNext(null);
            current = next;
            removed++;
        }

        head = null;
        tail = null;
        size = 0;
        return removed;
    }

    public void reverseInPlace() {
        if (head == null || head.getNext() == null) {
            return;
        }

        SimpleNode<T> previous = null;
        SimpleNode<T> current = head;
        tail = head;

        while (current != null) {
            SimpleNode<T> next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        head = previous;
    }

    public int removeDuplicates() {
        int removed = 0;
        SimpleNode<T> current = head;

        while (current != null) {
            SimpleNode<T> runnerPrevious = current;
            SimpleNode<T> runner = current.getNext();

            while (runner != null) {
                if (isSameValue(current.getValue(), runner.getValue())) {
                    runnerPrevious.setNext(runner.getNext());
                    if (runner == tail) {
                        tail = runnerPrevious;
                    }
                    size--;
                    removed++;
                    runner = runnerPrevious.getNext();
                } else {
                    runnerPrevious = runner;
                    runner = runner.getNext();
                }
            }

            current = current.getNext();
        }

        return removed;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        SimpleNode<T> current = head;
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

    private boolean isSameValue(T left, T right) {
        return left == right || (left != null && left.equals(right));
    }
}