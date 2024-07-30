package com.example.design5;

public class Item {
    private int number;
    private String hoTen;
    private int sdt;
    private int color;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Item(int number, String hoTen, int sdt, int color) {
        this.number = number;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.color = color;
    }
}
