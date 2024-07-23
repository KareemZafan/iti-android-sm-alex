package iti.app_test.org;

import iti.app.org.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTests {
    private MyStack myStack;

    @BeforeEach
    void beforeEach() {
        myStack = new MyStack();
    }

    @Test
    void testPushElementsToStack() {
        myStack.push(1)
                .push(2)
                .push(3)
                .push(4);

        assertEquals(4, myStack.getSize());
        assertEquals(List.of(1, 2, 3, 4), myStack.getCurrentStack());
        assertEquals(4, myStack.getPeek());

    }

    @Test
    void testPopElementsFromStack() {

        assertEquals(0, myStack.getSize());
        IllegalStateException ex = assertThrowsExactly(IllegalStateException.class,
                () -> myStack.pop());
        assertTrue(ex.getMessage().contains("empty stack!"));
        myStack.push(1)
                .push(2)
                .push(3)
                .push(4);

        myStack.pop().pop().pop();

        assertEquals(1, myStack.getPeek());
        assertEquals(1, myStack.getPeek());
        assertEquals(List.of(1), myStack.getCurrentStack());

    }
}
