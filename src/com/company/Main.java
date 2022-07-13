package com.company;

public class Main {

    public static void main(String[] args) {
        GameCreater gameCreater = new GameCreater();
        String[][] colorGrid = gameCreater.createGame(10, 10);
        // String[][] colorGrid={{"ff9ef99e","ff9ef99e","ff9ef99e"},{"ff9ef99e","ff9ef99e","ff9ef99e"}};
        Node nullNode = null;
        Node newNode = new Node(0, 0, colorGrid[0][0], nullNode, nullNode, nullNode);

        GameManager gameManager = new GameManager();
        Node maxAdjacentNode = gameManager.getAdjacentColorNodes(newNode, newNode, colorGrid);
        System.out.println("Largest Block of Joining nodes: " + maxAdjacentNode.toString());


    }
}
