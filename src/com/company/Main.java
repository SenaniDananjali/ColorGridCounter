package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

     GameManager gameManager=new GameManager();
     Node newNode=new Node();
    gameManager.searchAdjacentColorNodes(0,0,newNode);


        System.out.println(gameManager.searchAdjacentColorNodes(0,0,newNode));
    }
}
