package com.company;

public class DoubleEndedLinkedList {

    public Neighbor firstLink;
    public Neighbor lastLink;

    public void insertInFirstPosition(String name, int number){
        Neighbor item = new Neighbor(name,number);
        if(isEmpty()){
            lastLink = item;
        } else {
            firstLink.previos = item;
        }
        item.next = firstLink;
        firstLink = item;
    }

    public void insertInLastPosition(String name, int number){
        Neighbor item = new Neighbor(name,number);
        if(isEmpty()){
            firstLink = item;
        } else {
            lastLink.next = item;
            item.previos = lastLink;
        }

        lastLink = item;
    }

    public boolean isEmpty(){
        return (firstLink == null);
    }

    public void print() {
        Neighbor link = firstLink;
        while (link!=null){
            link.print();
            link = link.next;
        }
    }

    public boolean insertAfterKey(String name, int number, int key){
        Neighbor item = new Neighbor(name, number);
        Neighbor current = firstLink;

        while (current.number != key){
            current = current.next;

            if(current == null){
                return false;
            }
        }

        if(current == lastLink){
            item.next = null;
            lastLink = item;
        } else {
            item.next = current.next;
            current.next.previos = item;
        }
        item.previos = current;
        current.next = item;
        return  true;
    }

    public void insertInOrder(String name, int number){
        Neighbor item = new Neighbor(name, number);

        Neighbor previous = null;
        Neighbor current = firstLink;

        while ((current != null) && (number > current.number)){
            previous = current;
            current = current.next;
        }

        if(previous ==null){
            firstLink = item;
        } else {
            previous.next = item;
        }

        item.next = current;
    }

    public static void main(String[] args) {
	    DoubleEndedLinkedList list = new DoubleEndedLinkedList();

	    list.insertInOrder("Ilya", 1);
        list.insertInOrder("Vladimir", 2);
        list.insertInOrder("Nikolay", 12);

        list.insertInOrder("Ann",20);
        list.insertInOrder("Cat",21);

        list.insertInOrder("Mary",3);
        list.print();
        System.out.println("-----------------------");
        NeighborIterator iterator = new NeighborIterator(list);
        iterator.next();
        iterator.remove();
        list.print();
    }
}
