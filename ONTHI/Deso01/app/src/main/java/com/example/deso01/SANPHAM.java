package com.example.deso01;

public class SANPHAM {
    private String ma, ten;
    private double dongia;
    public SANPHAM(String ma, String ten, double dongia) {
        this.ma = ma;
        this.ten = ten;
        this.dongia = dongia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    @Override
    public String toString() {
        return ten;
    }
}
