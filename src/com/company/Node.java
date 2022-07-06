package com.company;

public class Node {
    Integer x;
    Integer y;
    String color;
    Node next;
    Node down;

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", color='" + color + '\'' +
                ", next=" + next +
                ", down=" + down +
                '}';
    }
}
