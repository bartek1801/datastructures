package datastructures;

import oracle.jrockit.jfr.StringConstantPool;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bartek on 20.07.2017.
 */
class MyLinkedListTest {
    @Test
    public void canAddAndGetElement() {
        MyList<String> l = new MyLinkedList<>();

        l.add("one");
        l.add("two");
        l.add("three");
        String elem = l.get(2);


        //assertEquals("two", elem);
        assertEquals("two", elem);

    }

    @Test
    public void canReadLenthOfLinkedList(){
        MyList<String> l = new MyLinkedList<>();

        l.add("one");
        l.add("two");
        l.add("sri");

        int len = l.length();

        assertEquals(3, len);
    }

    @Test
    void canRemoveElementNumberI() {
        MyList<String> l = new MyLinkedList<>();

        l.add("test element1");
        l.add("test element2");
        l.add("test element3");
        l.remove(1);
        int len = l.length();
        String test = l.get(1);

        assertEquals(2, len);
        assertEquals("test element2", test);
        assertEquals("test element2", l.first());
    }

    @Test
    void canRemoveElementE(){
        MyList<String> l = new MyLinkedList<>();

        l.add("first");
        l.add("test element");
        l.add("test element2");
        l.add("test element3");
        //l.remove("test element");
        l.remove("first");

        String elem = l.get(1);

        //assertEquals("test element2", elem);
        assertEquals("test element", elem);
        assertEquals(3,l.length());
    }

    @Test
    void canGetFirstElement(){
        MyList<Integer> l = new MyLinkedList<>();

        l.add(11);
        l.add(22);
        l.add(33);
        int firstEl = l.first();

        assertEquals(11, firstEl);
    }

    @Test
    void canGetLastElement(){
        MyList<Integer> l = new MyLinkedList<>();

        l.add(123);
        l.add(321);

        int lastEl = l.last();

        assertEquals(321,lastEl);
    }

    @Test
    void canClearAllLinkedList(){
        MyList<Integer> l = new MyLinkedList<>();

        l.add(123);
        l.add(124);
        l.add(125);

        l.clear();

        //assertEquals(0, l.length());
        assertNull(l.first());
    }

    @Test
    public void canCheckContainsElement(){
        MyList<String> l = new MyLinkedList<>();

        l.add("first");
        l.add("second");
        l.add("third");
        l.add("123");

        assertTrue(l.contains("third"));
        assertFalse(l.contains("dupa"));
    }

    @Test
    public void canGetIndexOfElement(){
        MyList<String> l = new MyLinkedList<>();

        l.add("one");
        l.add("two");
        l.add("three");
        l.add("four");
        int index = l.indexOf("three");

        assertEquals(3,index);
    }

    @Test
    public void methodToStringWorks(){
        MyList<String> l = new MyLinkedList<>();

        l.add("ala");
        l.add("ma");
        l.add("kota");
        l.add("i");
        l.add("psa");
        String test = l.toString();

        assertEquals("[ala, ma, kota, i, psa]", test);
    }

    @Test
    public void canAddNullElement(){
        MyList<String> l =  new MyLinkedList<>();

        l.add(null);
        l.add(null);
        l.add(null);

        assertNull(l.first());
        assertNull(l.get(2));
    }

    @Test
    public void shouldIterateOverList() {
        MyList<String> l = new MyLinkedList<>();
        l.add("one");
        l.add("two");
        l.add("three");

        for (String s : l) {
            System.out.println(s);
        }
    }

}