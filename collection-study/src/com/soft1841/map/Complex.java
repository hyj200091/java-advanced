package com.soft1841.map;

public class Complex {
    private  Integer id ;
    private  String name;
    private  String origin;
    private Double price;

    public Complex() {
    }

    public Complex(Integer id, String name, String origin, Double price) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                '}';
    }
}
