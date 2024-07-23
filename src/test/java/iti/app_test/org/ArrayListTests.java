package iti.app_test.org;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArrayListTests {

    @Mock
    ArrayList<String> userList;

    @BeforeEach
    void setUp() {
        when(userList.size()).thenReturn(50);
    }

    @Test
    void testTotalUserFromDB() {
        assertEquals(50, userList.size());
        verify(userList).size();
    }

    @Test
    void testGettingSpecifUser() {
        when(userList.get(7)).thenReturn("Ali Alaa");
        assertEquals(50, userList.size());
        assertTrue(userList.get(7).contains("Ali Ahmed"));

        verify(userList).get(7);
    }
}
