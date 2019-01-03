package com.company;

public class Neighbor {
    public String name;
    public int number;

    public Neighbor next;
    public Neighbor previos;

    public Neighbor(String homeOwnerName, int houseNumber){
        this.name = homeOwnerName;
        this.number = houseNumber;
    }

    public void print(){
        System.out.println("№"+number+" "+name);
    }

    public String toString(){
        return name;
    }
}
