package com.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MonHocTest {

    @Test
    void testEquals(){
        MonHoc monHoc1 = new MonHoc("CTDL", 3, 1);
        MonHoc monHoc2 = new MonHoc("CTDL", 3, 1);

        assertTrue(monHoc1.equals(monHoc2));
        MonHoc monHoc3 = new MonHoc("Cau truc du lieu", 3, 1);
        assertFalse(monHoc1.equals(monHoc3));
    }

    @Test
    void getTen() {
        MonHoc monHoc = new MonHoc("CTDL", 3, 1);
        assertEquals("CTDL", monHoc.getTen());
        assertNotEquals("Cau truc du lieu", monHoc.getTen());

        monHoc = new MonHoc(null,3, 1);
        assertNull(monHoc.getTen());
    }

    @Test
    void getTcLT() {
    }

    @Test
    void getTcTH() {
    }

    @Test
        void testWithCollection(){
        List<MonHoc> danhsachMonHoc = new ArrayList<>();

        MonHoc monHoc1 = new MonHoc("CTDL", 3, 1);
        MonHoc monHoc2 = new MonHoc("OOP", 2, 1);
        danhsachMonHoc.add(monHoc1);
        danhsachMonHoc.add(monHoc2);

        MonHoc monHoc3 = new MonHoc("CTDl", 3, 1);
//        assertEquals(0, danhsachMonHoc.indexOf(monHoc1));
//        assertEquals(0, danhsachMonHoc.indexOf(monHoc3));

        Collections.sort(danhsachMonHoc);
        System.out.println(danhsachMonHoc);

        Collections.sort(danhsachMonHoc, new Comparator<MonHoc>() {
            @Override
            public int compare(MonHoc o1, MonHoc o2) {
                if(o1.getTcLT() > o2.getTcLT()){
                    return 1;
                }else if(o1.getTcLT() < o2.getTcLT()){
                    return -1;
                }else
                return 0;
            }
        });



    }

    @Test
    void testWithSet(){
        Set<MonHoc> setMonHoc = new HashSet<>();
        MonHoc monHoc1 = new MonHoc("CTDL", 3, 1);
        MonHoc monHoc2 = new MonHoc("OOP", 2, 1);

        setMonHoc.add(monHoc1);
        setMonHoc.add(monHoc2);

         MonHoc monHoc3 = new MonHoc("CTDL", 3, 1);
        setMonHoc.add(monHoc3);

        assertEquals(2, setMonHoc.size());

    }

}