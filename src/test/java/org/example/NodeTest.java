package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    private Node test = new Node("Корень");

    @Test
    void creating(){
        assertEquals(test.name, "Корень");
        assertTrue(test.children.isEmpty());
    }

    @Test
    void sons_creating(){
        assertDoesNotThrow(() ->
                test.Add("Сынуля"));
        assertNotNull(test.get(0));
    }

    @Test
    void name_search(){
        test.Add("Сынуля");
        assertNotNull(test.get("Сынуля"));
        assertEquals(test.get("Сынуля"), test.get(0));
    }

    @Test
    void delete_by(){
        test.Add("Сынуля");
        test.del(0);
        assertFalse(test.children.contains(new Node("Сынуля")));
        test.Add("Сынуля");
        test.del("Сынуля");
        assertFalse(test.children.contains(new Node("Сынуля")));
    }

    @Test
    void delete_all(){
        test.Add("Сынуля");
        test.Add("Дочурка");
        test.del_all();
        assertTrue(test.children.isEmpty());
    }

    @Test
    void changing_name(){
        test.set_name("Корней");
        assertEquals(test.name, "Корней");
    }
}
