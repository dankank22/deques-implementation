package deques;

/**
 * @see Deque
 */
public class LinkedDeque<T> extends AbstractDeque<T> {
    private int size;
    // IMPORTANT: Do not rename these fields or change their visibility.
    // We access these during grading to test your code.
    Node<T> front;
    Node<T> back;
    // Feel free to add any additional fields you may need, though.

    public LinkedDeque() {
        this.front = new Node<>(null, null, null);
        this.back = new Node<>(null, front, null);
        front.next = back;
        size = 0;
    }

    public void addFirst(T item) {
        Node newNode = new Node<>(item, front, front.next);
        front.next.prev = newNode;
        front.next = newNode;
        size++;
    }

    public void addLast(T item) {
        size += 1;
        Node newNode = new Node<>(item, back.prev, back);
        back.prev.next = newNode;
        back.prev = newNode;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T itemData = front.next.value;
        size -= 1;
        front.next.next.prev = front;
        //front.next.prev
        front.next = front.next.next;
        return itemData;

    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T itemData = back.prev.value;
        back.prev.prev.next = back;
        back.prev = back.prev.prev;

        size -= 1;
        return itemData;

    }

    public T get(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return null;
        }
        Node<T> temp;
        int count;
        if (index < size / 2) {
            temp = front.next;
            count = 0;
            while (temp != back && count < index) {
                temp = temp.next;
                count++;
            }
        } else {
            temp = back.prev;
            count = size - 1;
            while (temp != front && count > index) {
                temp = temp.prev;
                count--;
            }
        }
        return temp.value;
    }

    public int size() {
        return size;
    }
}
