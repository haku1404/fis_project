package com.example;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SinhVien {
    private String mssv;
    private String ten;

    private Set<Diem> monDaHoc = new HashSet<Diem>();

    public SinhVien(String mssv, String ten) {
        this.mssv = mssv;
        this.ten = ten;
    }

    public boolean themDiem(Diem diemMoi) {
        return this.monDaHoc.add(diemMoi);
    }

    //TODO Cau 1
    public double tinhDiemTrungBinh() {
        //Giong nhu cach tinh hien tai cua truong

        //...

        //double average = monDaHoc.stream().mapToInt(Diem::getDiem).average().getAsDouble();
        double totalGra = monDaHoc.stream().mapToInt((Diem::tongDiem)).sum();
        double totalTin = monDaHoc.stream().mapToInt((Diem::tongTin)).sum();

        double averageGra = totalGra/totalTin;
        return averageGra;
    }


    //TODO Cau 2
    public String bangDiem() {
    /*
     MSSV : 0203044
     Ten  : Nguyen Van A
     Danh Sach Diem
     STT  Ten Mon             Diem       So Tin Chi
     1    Cau Truc Du Lieu 1  8          3
     2    Cau Truc Du Lieu 2  8          3
     Diem Trung Binh   8.0
    */
        //...
        //StringBuilder
        StringBuilder str = new StringBuilder();


        return null;
    }


    //TODO Cau 3
    public String xepLoai() {
    /*
    Quy tac xep loai nhu sau
        DiemTB < 5 -> YEU
        DiemTB >= 5 va DiemTB < 6 -> TB
        DiemTB >= 6 va DiemTB < 7 -> TB-KHA
        DiemTB >= 7 va DiemTB < 8 -> KHA
        DiemTB >= 8 -> GIOI
    */

        //...
        return null;
    }
}
