package datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bartek on 16.07.2017.
 */
class MyArrayListTest {

    @Test
    public void canAddAndRemoveElements(){
        MyList<String> l = new MyArrayList<>();
        //MyList<String> l = new MyLinkedList<>();

        l.add("one");
        l.add("two");
        l.add("three");
        l.add("four");
        l.remove("three");
        String four = l.get(2);

        assertEquals("four", four);
    }

    @Test
    public void canGetElement(){
        MyList<String> l = new MyArrayList<>();

        l.add("first");
        l.add("second");
        l.add("third");
        l.add("forth");

        String element = l.get(1);

        assertEquals("second", element);
    }

    @Test
    public void canGetFirstElement(){
        MyList<String> l = new MyArrayList<>();

        l.add("first element");
        l.add("random element");
        l.add("random element");
        l.add("random element");
        l.add("random element");
        l.add("last element");
        String firstEl = l.first();
        //String lastEl = l.last();

        assertEquals("first element", firstEl);
        //assertEquals("last element", lastEl);
    }

    @Test
    public void canGetLastElement(){
        MyList<Integer> t = new MyArrayList<>();

        t.add(11);
        t.add(22);
        t.add(33);
        int lastEl = t.last();

        assertEquals(33, lastEl);
    }

    @Test
    public void canGetListLength(){
        MyList<String> l = new MyArrayList<>();

        l.add("element");
        l.add("element");
        l.add("element");
        l.add("element");
        int listLength = l.length();

        assertEquals(4, listLength);
    }

    @Test
    void canClearAllArrayList(){
        MyList<Integer> l = new MyArrayList<>();

        l.add(1);
        l.add(11);
        l.add(111);
        l.clear();


        assertNull(l.get(0));
        assertNull(l.get(1));
        assertNull(l.get(2));

    }

    @Test
    public void canRemoveElementNumberI(){
        MyList<String> l = new MyArrayList<>();

        l.add("1234");
        l.add("test element");
        l.add("test element2");
        l.add("test element3");
        l.remove(1);
        String test = l.get(1);

        assertEquals("test element2", test );
    }

    @Test
    public void canGetIndexOfElement(){
        MyList<String> l = new MyArrayList<>();

        l.add("one");
        l.add("two");
        l.add("three");
        l.add("four");
        int index = l.indexOf("three");

        assertEquals(2,index);
    }

    @Test
    public void canCheckContainsElement(){
        MyList<Integer> l = new MyArrayList<>();

        l.add(123);
        l.add(456);
        l.add(789);
        l.add(0);

        assertTrue(l.contains(0));
        assertFalse(l.contains(4321));
    }

    @Test
    public void methodToStringWorks(){
        MyList<String> l = new MyArrayList<>();
        l.add("ala");
        l.add("ma");
        l.add("psa");
        l.add("i");
        l.add("kota");
        String test = l.toString();// zwraca napis: "[ala, ma, psa]"

        assertEquals("[ala, ma, psa, i, kota]", test);
    }

    @Test
    public void canAddNullElement(){
        MyList<String> l = new MyArrayList<>();

        l.add(null);
        l.add(null);
        l.add(null);

        assertNull(l.first());
        assertNull(l.get(1));
    }

    @Test
    public void shouldIterateOverList(){
        MyList<String> l = new MyArrayList<>();
        l.add("one");
        l.add("two");
        l.add("three");

        for (String s : l){
            System.out.println(s);
        }
    }

}