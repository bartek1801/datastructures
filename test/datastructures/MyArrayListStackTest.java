package datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by bartek on 27.07.2017.
 */
class MyArrayListStackTest {
    @Test
    void canPushAndPopElement() {
        MyStack<Integer> s = new MyArrayListStack<>();

        s.push(123);
        s.push(444);
        int t1 = s.pop();
        s.push(998);
        int t2 = s.pop();
        int t3 = s.pop();

        assertEquals(444, t1);
        assertEquals(998, t2);
        assertEquals(123, t3);
        assertNull(s.pop());
    }


}