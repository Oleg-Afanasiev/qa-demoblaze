package com.academy.project.model;

import java.util.Objects;

public class Laptop {
    private String name;
    private int price;

    public Laptop(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop)) return false;
        Laptop laptop = (Laptop) o;
        return price == laptop.price && Objects.equals(name, laptop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
