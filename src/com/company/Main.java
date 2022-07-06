package com.company;

public class Main {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        Node newNode = new Node();
        Node maxAdjacentNode=gameManager.searchAdjacentColorNodes(0, 0, newNode);
        System.out.println("Largest Block of Joining nodes: "+maxAdjacentNode.toString());
    }
}
