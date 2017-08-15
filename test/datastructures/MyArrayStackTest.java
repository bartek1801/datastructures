package datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by bartek on 29.07.2017.
 */
class MyArrayStackTest {
    @Test
    void canPushAndPopElement() {
        MyStack<Long> s = new MyArrayStack<>();

        s.push(11L);
        s.push(22L);
        long l1 = s.pop();
        s.push(33L);
        long t2 = s.pop();
        long t3 = s.pop();


        assertEquals(22L, l1);
        assertEquals(33, t2);
        assertEquals(11, t3);
        assertNull(s.pop());
    }


}