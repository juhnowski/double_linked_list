package com.company;

public class NeighborIterator {

    Neighbor current;
    Neighbor previous;

    DoubleEndedLinkedList list;

    public NeighborIterator(DoubleEndedLinkedList list){
        this.list = list;
        current = list.firstLink;
        previous = list.lastLink;
    }

    public boolean hasNext(){
        return  current.next != null;
    }

    public Neighbor next() {
        if(hasNext()){
            previous = current;
            current = current.next;
            return current;
        }

        return null;
    }

    public void remove() {
        if(previous == null){
            list.firstLink = current.next;
        } else {
            previous.next = current.next;

            if(current.next == null){
                current = list.firstLink;
                previous = null;
            } else {
                current = current.next;
            }
        }
    }
}
