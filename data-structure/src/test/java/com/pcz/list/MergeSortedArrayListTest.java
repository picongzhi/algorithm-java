package com.pcz.list;

import static org.junit.Assert.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MergeSortedArrayListTest {
    @Test
    public void mergeTest() {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            listA.add(i * 2);
            listB.add(i * 2 + 1);
        }

        List<Integer> listC = MergeSortedArrayList.merge(listA, listB);
        log.info("listA: {}", listA);
        log.info("listB: {}", listB);
        log.info("listC: {}", listC);

        listA = null;
        listC = MergeSortedArrayList.merge(listA, listB);
        assertNull(listC);
    }
}
