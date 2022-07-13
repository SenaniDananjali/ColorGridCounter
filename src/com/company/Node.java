package com.company;

public class Node {
    Integer x;
    Integer y;
    String color;
    Node next;
    Node down;
    Node prev;
    Node head, tail = null;


    public Node(Integer x, Integer y, String color, Node prev, Node next, Node down) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.next = next;
        this.down = down;
        this.prev = prev;
    }

    public Node() {

    }

    public void addNode(Integer x, Integer y, String color, Node prev, Node next, Node down) {
        Node newNode = new Node(x, y, color, prev, next, down);
        //if this is the first Node
        if (head.equals(tail.equals(null))) {
            head = tail = newNode;
            tail.next = null;
            tail.down = null;
            head.prev = null;
            head.down = null;
        } else {
            tail = newNode;
            newNode = new Node();
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public boolean checkNode(Node headRef, Integer x, Integer y) {
        boolean result = false;
        if (headRef.nodeCount(headRef,0) == 1) {
            result = false;
        } else {
            if ((headRef.x == x && headRef.y == y)) {
                result = true;

            } else {
                if (headRef.next != null) {
                    if (headRef.next.x == x && headRef.next.y == y) {
                        result = true;

                    } else {
                        result = checkNode(headRef.next, headRef.next.x, headRef.next.y);
                    }

                }
                if (headRef.down != null) {
                    if (headRef.down.x == x && headRef.down.y == y) {
                        result = true;

                    } else {
                        result = checkNode(headRef.down, headRef.down.x, headRef.down.y);
                    }
                }
            }
        }

        return result;
    }

    public Integer nodeCount(Node headNode, Integer count) {
        if (headNode == null) {
        } else {
            if (headNode.prev != null) {
                headNode=headNode.prev;
                count++;
                count=nodeCount(headNode, count);
            }

        }

        return count;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", color='" + color + '\'' +
                ", next=" + next +
                ", down=" + down +
                ", prev=" + prev +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
