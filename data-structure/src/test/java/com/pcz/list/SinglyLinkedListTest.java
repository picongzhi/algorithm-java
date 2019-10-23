package com.pcz.list;

import static org.junit.Assert.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SinglyLinkedListTest {
    @Test
    public void insertTest() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.insert(1);
        assertEquals(1, singlyLinkedList.get(0));
        singlyLinkedList.insert(2);
        assertEquals(2, singlyLinkedList.get(1));
        singlyLinkedList.insert(3);
        assertEquals(3, singlyLinkedList.get(2));

        log.info("[list] = {}", singlyLinkedList);
    }

    @Test
    public void insertHeadTest() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.insertHead(1);
        assertEquals(1, singlyLinkedList.get(0));
        singlyLinkedList.insertHead(2);
        assertEquals(2, singlyLinkedList.get(0));
        singlyLinkedList.insertHead(3);
        assertEquals(3, singlyLinkedList.get(0));

        log.info("[list] = {}", singlyLinkedList);
    }

    @Test
    public void insertNthTest() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insert(1);
        singlyLinkedList.insert(2);
        singlyLinkedList.insert(3);

        log.info("[list] = {}", singlyLinkedList);
        singlyLinkedList.insertNth(4, 1);
        assertEquals(4, singlyLinkedList.get(1));
        assertEquals(4, singlyLinkedList.size());
        log.info("[list] = {}", singlyLinkedList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertNthExceptionTest() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertNth(-1, 1);
    }

    @Test
    public void deleteTest() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insert(1);
        singlyLinkedList.insert(2);
        singlyLinkedList.insert(3);
        log.info("[list] = {}", singlyLinkedList);

        assertEquals(3, singlyLinkedList.get(singlyLinkedList.size() - 1));
        singlyLinkedList.delete();
        assertEquals(2, singlyLinkedList.get(singlyLinkedList.size() - 1));
        singlyLinkedList.delete();
        assertEquals(1, singlyLinkedList.get(singlyLinkedList.size() - 1));
        singlyLinkedList.delete();

        assertTrue(singlyLinkedList.isEmpty());
        log.info("[list] = {}", singlyLinkedList);
    }

    @Test
    public void deleteHeadTest() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insert(1);
        singlyLinkedList.insert(2);
        singlyLinkedList.insert(3);
        log.info("[list] = {}", singlyLinkedList);

        assertEquals(1, singlyLinkedList.get(0));
        singlyLinkedList.deleteHead();
        assertEquals(2, singlyLinkedList.get(0));
        singlyLinkedList.deleteHead();
        assertEquals(3, singlyLinkedList.get(0));
        singlyLinkedList.deleteHead();

        assertTrue(singlyLinkedList.isEmpty());
        log.info("[list] = {}", singlyLinkedList);
    }

    @Test
    public void deleteNthTest() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insert(1);
        singlyLinkedList.insert(2);
        singlyLinkedList.insert(3);
        log.info("[list] = {}", singlyLinkedList);

        singlyLinkedList.deleteNth(1);
        assertEquals(2, singlyLinkedList.size());
        log.info("[list] = {}", singlyLinkedList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteNthExceptionTest() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insert(1);
        singlyLinkedList.insert(2);
        singlyLinkedList.insert(3);
        log.info("[list] = {}", singlyLinkedList);
        singlyLinkedList.deleteNth(singlyLinkedList.size());
    }

    @Test
    public void sizeTest() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        assertEquals(0, singlyLinkedList.size());

        singlyLinkedList.insert(1);
        singlyLinkedList.insert(2);
        singlyLinkedList.insert(3);
        assertEquals(3, singlyLinkedList.size());
        log.info("[list] = {}", singlyLinkedList);
    }

    @Test
    public void isEmptyTest() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        assertTrue(singlyLinkedList.isEmpty());

        singlyLinkedList.insert(1);
        singlyLinkedList.insert(2);
        singlyLinkedList.insert(3);
        assertFalse(singlyLinkedList.isEmpty());
        log.info("[list] = {}", singlyLinkedList);
    }
}
