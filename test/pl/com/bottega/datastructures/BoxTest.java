package pl.com.bottega.datastructures;

import datastructures.Box;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Created by bartek on 16.07.2017.
 */
public class BoxTest {
    //given
    private  Box nonEmptyBox = new Box("test");

    @Test
    public void canCreateNonEmptyBox(){
        assertFalse(nonEmptyBox.empty());
    }

    @Test
    public void canCreateEmptyBox(){
        //given
        Box box = new Box();

        //then
        assertTrue(box.empty());
    }

    @Test
    public void pullsElementFromTheBox(){
        //when
        String pulledElement = (String) nonEmptyBox.pull();

        //then
        assertEquals("test", pulledElement);
    }

    @Test
    public void boxIsEmptyAfterPull(){
        //when
        nonEmptyBox.pull();

        //then
        assertTrue(nonEmptyBox.empty());
    }

    @Test
    public void canInsertAndPullElement(){
        //given
        Box box = new Box();

        //when
        box.insert("test");
        String puledElement = (String) box.pull();

        //then
        assertEquals("test", puledElement);
    }

    @Test
    public void canHoldIntegers(){
        //given
        Box<Integer> integerBox = new Box<>();

        //when
        integerBox.insert(231);
        Integer pulledInteger = integerBox.pull();

        //then
        assertEquals(new Integer (231), pulledInteger);
    }

    /*
    @Test
    public void throwsWhenInsertingToNonEmptyBox(){
        //when
        try {
            nonEmptyBox.insert("something else");
            fail("Should throw exception");
        }
        catch(IllegalStateException ex){
            assertEquals("Box is not empty", ex.getMessage());
        }
    }
    */

    @Test
    public void throwsWhenInsertingToNonEmptyBox(){
        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                nonEmptyBox.insert("something else");
            }
        });
    }

    @Test
    public void throwswhenPullingFromEmptyBox(){
        assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new Box().pull();
            }
        });
    }


}
