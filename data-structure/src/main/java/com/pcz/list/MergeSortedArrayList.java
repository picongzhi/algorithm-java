package com.pcz.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author picongzhi
 */
public class MergeSortedArrayList {
    public static List<Integer> merge(List<Integer> listA, List<Integer> listB) {
        if (listA == null || listB == null) {
            return null;
        }

        List<Integer> listC = new ArrayList<>();
        int indexA = 0;
        int indexB = 0;
        while (indexA < listA.size() && indexB < listB.size()) {
            listC.add(listA.get(indexA) <= listB.get(indexB) ?
                    listA.get(indexA++) : listB.get(indexB++));
        }

        while (indexA < listA.size()) {
            listC.add(listA.get(indexA++));
        }

        while (indexB < listB.size()) {
            listC.add(listB.get(indexB++));
        }

        return listC;
    }
}
