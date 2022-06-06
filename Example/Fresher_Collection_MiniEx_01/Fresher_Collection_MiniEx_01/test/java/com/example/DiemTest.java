package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiemTest {

    @Test
    void testEquals() {
        MonHoc monHoc1 = new MonHoc("CTDL", 3, 1);
        MonHoc monHoc2 = new MonHoc("OOP", 3, 1);

        Diem diem1 = new Diem(monHoc1, 7);
        Diem diem2 = new Diem(monHoc2, 8);
      //  assertTrue(diem1.equals(diem2));
        assertFalse(diem1.equals(diem2));



    }

    @Test
    void testMon(){

    }

    @Test
    void getDiem() {
        MonHoc monHoc1 = new MonHoc("CTDL", 3, 1);
        Diem diem1 = new Diem(monHoc1, 8);
        assertEquals(8, diem1.getDiem());
        assertNotEquals(1, diem1.getDiem());

    }
}