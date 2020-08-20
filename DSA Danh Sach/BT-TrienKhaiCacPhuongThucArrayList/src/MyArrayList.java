public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private int size = 0;
    Object[] elements= new Object[DEFAULT_CAPACITY];

    MyArrayList() {}

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.elements = new Object[capacity];
        } else if (capacity == 0) {
                this.elements=EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    capacity);
        }
    }

    public void add(int index, E e) {
        if(index==elements.length) {
            ensureCapacity(size);
        }
        if (size - index >= 0) System.arraycopy(elements, index, elements, index + 1, size - index);

        elements[index] = e;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException ("index " + index + " out of bounds");

        E e = (E) elements[index];

        if (size - 1 - index >= 0) System.arraycopy(elements, index + 1, elements, index, size - 1 - index);

        elements[elements.length - 1] = null;

        size--;
        return e;
    }

    public int size() {
        return size;
    }

    public E clone() {
        return (E) this;
    }

    public boolean contains(E e) {
        return  indexOf(e)>=0;
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(elements[i])) return i;
        return -1;
    }

    public boolean add(E e){
        if (size == elements.length) {
            ensureCapacity(size);
        }
        elements[size++] = e;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity >= elements.length) {
            E[] newElement = (E[]) new Object[size * 2 + 1];
            newElement = (E[]) clone();
            elements = newElement;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException ("index " + index + " out of bounds");

        return (E) elements[index];
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(elements[i]);
            if (i < size - 1) result.append(", ");
        }

        return result.toString() + "]";
    }

}
