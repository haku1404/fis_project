package com.example;

public class MonHoc implements Comparable<MonHoc> {
    private String ten;
    private int tcLT;
    private int tcTH;

    public MonHoc(String ten, int tcLT, int tcTH) {
        this.ten = ten;
        this.tcLT = tcLT;
        this.tcTH = tcTH;
    }

//    public boolean equals(Object that) {
//        //Hai mon duoc goi la bang nhau neu cung ten mon
//        if (that instanceof MonHoc) {
//            return ((MonHoc) that).ten.equals(this.ten);
//        }
//        return false;
//    }

    public String getTen() {
        return ten;
    }

    public int getTcLT() {
        return tcLT;
    }

    public int getTcTH() {
        return tcTH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonHoc monHoc = (MonHoc) o;

        if (tcLT != monHoc.tcLT) return false;
        if (tcTH != monHoc.tcTH) return false;
        return ten != null ? ten.equals(monHoc.ten) : monHoc.ten == null;
    }

    @Override
    public int hashCode() {
        int result = ten != null ? ten.hashCode() : 0;
        result = 31 * result + tcLT;
        result = 31 * result + tcTH;
        return result;
    }

    @Override
    public int compareTo(MonHoc that) {
        if(this.ten.compareTo(that.ten) > 0){
            return 1;
        }else if(this.ten.compareTo(that.ten) < 0){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "ten='" + ten + '\'' +
                ", tcLT=" + tcLT +
                ", tcTH=" + tcTH +
                '}';
    }
}
