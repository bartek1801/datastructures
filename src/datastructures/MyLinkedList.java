package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by bartek on 16.07.2017.
 */
public class MyLinkedList<E> implements MyList<E> {

    private Link<E> first, last;
    private int length;

    @Override
    public void add(E e) {
        Link<E> newLink = new Link<>();
        newLink.element = e;
        if (first == null) {
            first = newLink;
            last = newLink;
        } else {
            last.next = newLink;
            last = newLink;
        }
        length++;
    }

    @Override
    public void remove(E e) {
       /* int i = indexOf(e);
        if (i > 0)
            remove(i);*/

//        Link<E> tmpPrevious = first;
//        Link<E> tmp = tmpPrevious.next;
        /*if (first.equals(e)) {
            first = first.next; //TODO jak przerwać metodę w tyhm miejscu
        }else {
            while (tmpPrevious != null) {
                if (tmp.element.equals(e)) {
                    tmpPrevious.next = tmp.next;
                    break;
                }
                tmpPrevious = tmpPrevious.next;
            }
        }*/
        Link l = first;
        Link prev = null;
        while (l != null){
            if (l.contains(e)){
               remove(l, prev);
            }
            prev = l;
            l = l.next;
        }

    }

    private void remove(Link l, Link prev) {

        if (prev != null && l.next != null){
            prev.next = l.next;
        }
        else if (prev == null && l.next == null){
            first = null;
            last = null;
        }
        else if(prev == null && l.next != null){
            first = l.next;
        }
        else {
            prev.next = null;
            last = prev;
        }
        length--;
        return;

    }


    @Override
    public int length() {
       /* Link<E> tmp = first;
        int counter = 0;
        while (tmp != null) {
            counter++;
            tmp = tmp.next;
        }
        return counter;*/
       return length;
    }

    @Override
    public void remove(int i) {
      /*  Link<E> tmpNext = first.next;
        Link<E> tmp = first;
        int counter = 1;
        if (i == 1) {
            first = first.next;
        } else {
            while (tmpNext != null) {
                if (counter == i) {
                    tmp.next = tmpNext.next;
                    break;
                }
                counter++;
            }
        }*/
      if (i >= 0 && i < length){
          Link l = first;
          Link prev = null;
          int k = 0;
          while (k < i){
              prev = l;
              l = prev.next;
              k++;
          }
          remove(l, prev);
      }
      else
          throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public E first() {
        return first.element;
    }

    @Override
    public E last() {
        return last.element;
    }

    @Override
    public E get(int i) {
        Link<E> tmp = first;
        int counter = 1;

        while (counter != i) {
            tmp = tmp.next;
            counter++;
        }
        return tmp.element;
    }

    @Override
    public boolean contains(E element) {
        Link<E> tmp = first;
        while (!(tmp.element.equals(element))) {
            tmp = tmp.next;
            if (tmp == null)
                return false;
        }
        return true;
    }

    @Override
    public int indexOf(E element) {
        Link<E> tmp = first;
        int counter = 1;
        while (!(tmp.element.equals(element))) {
            tmp = tmp.next;
            counter++;
            if (tmp == null)
                return -1;
        }
        return counter;
    }

    @Override
    public void clear() {
        while (first != null)
            first = first.next;
    }

    public String toString() {
        Link<E> tmp = first;
        StringBuilder concatenate = new StringBuilder("[");
        while (tmp.next != null) {
            concatenate.append(tmp.element).append(", ");
            tmp = tmp.next;
        }
        //concatenate.append(tmp.element).append("]");
        return concatenate.append(tmp.element).append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Link<E> currentLink = first;

            @Override
            public boolean hasNext() {
                return currentLink != null;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                E tmpElement = currentLink.element;
                currentLink = currentLink.next;
                return tmpElement;
            }
        };
    }

    private class Link<E> {

        private E element;
        private Link<E> next;

        /*public Link(E element) {
            this.element = element;
        }*/



        public boolean contains(E other){
            return (element == null && other == null) || element.equals(other);
        }
    }



}
