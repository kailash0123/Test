package com.kailash;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * This class only deals with interger type value in one way(thus singlyLinkedlist).
 */
public class SinglyLinkedList implements Iterable {
    private NodeC first;
    private NodeC last;
    private int num;

    public SinglyLinkedList() {
        first = null;
        last = null;
        num = 0;
    }

    public void add(Integer item) {
        if (item == null) { throw new NullPointerException("The element you want to add should not be null."); }
        if (!isEmpty()) {
            NodeC prev = last;
            last = new NodeC(item, null);
            prev.setHeadPoint(last);
        }
        else {
            last = new NodeC(item, null);
            first = last;
        }
        num++;
    }

    public boolean remove(Integer item) {
        if (isEmpty()) { throw new IllegalStateException("List is empty so can't remove element from empty list"); }
        boolean result = false;
        NodeC prev = first;
        NodeC curr = first;
        while (curr.getHeadPoint() != null || curr == last) {
            if (curr.getData().equals(item)) {
                // remove the last remaining element
                if (num == 1) { first = null; last = null; }
                // remove first element
                else if (curr.equals(first)) { first = first.getHeadPoint(); }
                // remove last element
                else if (curr.equals(last)) { last = prev; last.setHeadPoint(null); }
                // remove element
                else { prev.setHeadPoint(curr.getHeadPoint()); }
                num--;
                result = true;
                break;
            }
            prev = curr;
            curr = prev.getHeadPoint();
        }
        return result;
    }

    /**
     * Remove all the element grater than the provided  size  value in targetV paramter
     * like we have 4,6,7 ,56,67 and we pass 4 as targetV arg value then 67 will be removed from the list
     * @param targetV
     * @return
     */
    public boolean removeTillTarget(int targetV) {
        if (isEmpty()) { throw new IllegalStateException("List is empty so can't remove element from empty list"); }
        if(num<targetV)
        {throw new IllegalStateException("List size should be equal or grater than than the target value.");}
        while(num!=targetV)
        {
            remove(this.last.getData());
            //num--;
        }

        return true;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num == 0;
    }

    public Iterator<Integer> iterator() { return new LinkedListIterator(); }

    private class LinkedListIterator implements Iterator {
        private NodeC current = first;

        public Integer next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
            Integer item = current.getData();
            current = current.getHeadPoint();
            return item;
        }

        public boolean hasNext() { return current != null; }

        public void remove() { throw new UnsupportedOperationException(); }
    }

    @Override public String toString() {
        StringBuilder s = new StringBuilder();
        for (Object item : this)
            s.append((Integer) item + " ");
        return s.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(16);
        list.add(26);
        list.remove(6);
        System.out.println(list.toString());
        list.removeTillTarget(4);
        System.out.println(">>>>"+list.toString());

    }
}
