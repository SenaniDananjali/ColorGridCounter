package com.company;


public class GameManager extends Node {

    Integer count = 0;
    Integer currentNodeLength = 0;
    Integer maxNodeLength = 0;
    Node longestNodeHead = new Node();

    private Node maxLengthNode = new Node();


    public Node getAdjacentColorNodes(Node currentNode, Node headNode, String[][] colorGrid) {
        Integer gridRows = colorGrid.length;
        Integer gridCols = colorGrid[0].length;
        if (currentNode.color == null | headNode.color == null) {
            currentNode.color = colorGrid[currentNode.x][currentNode.y];
            headNode.color = colorGrid[headNode.x][headNode.y];
        }

        //check whether next node is same in color
        //if next node applicable

        Integer nextX = currentNode.x;
        Integer nextY = currentNode.y + 1;
        if (nextX < gridRows && nextY < gridCols) {
            //create next node
            Node nextNode = new Node(nextX, nextY, null, currentNode, null, null);
            if (currentNode.color == colorGrid[nextX][nextY]) {
                //check whether the node added prior to the tree
                if (!checkNode(currentNode, nextX, nextY)) {
                    nextNode.color = currentNode.color;
                    nextNode.prev = currentNode;
                    getAdjacentColorNodes(nextNode, currentNode, colorGrid);
                }

            } else {
                nextNode = null;
                nextNode.prev = currentNode;
                nextNode.color = colorGrid[nextX][nextY];
                Node newNode = new Node(nextX, nextY, null, null, null, null);


                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Thread id " + Thread.currentThread());
                        getAdjacentColorNodes(newNode, newNode, colorGrid);
                    }
                });
                t1.setPriority(Thread.NORM_PRIORITY);
                t1.start();

            }

        }
        //check down Node applicable
        Integer downX = currentNode.x + 1;
        Integer downY = currentNode.y;
        if (downX < gridRows && downY < gridCols) {
            //create down Node

            Node downNode = new Node(downX, downY, null, currentNode, null, null);
            if (currentNode.color == colorGrid[downX][downY]) {

                if (!checkNode(currentNode, downX, downY)) {
                    downNode.color = currentNode.color;
                    downNode.prev = currentNode;
                    getAdjacentColorNodes(downNode, currentNode, colorGrid);
                }
            } else {
                downNode = null;
                downNode.prev = currentNode;
                downNode.color = colorGrid[downX][downY];
                Node newNode = new Node(downX, downY, null, null, null, null);
                Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Thread id " + Thread.currentThread());
                        getAdjacentColorNodes(newNode, newNode, colorGrid);
                    }
                });
                t2.setPriority(Thread.MIN_PRIORITY);
                t2.start();

            }
        }

        //check for dead end of the tree

        this.count = nodeCount(currentNode, count);
        // update max count, max head node
        if (count >= maxNodeLength) {
            maxNodeLength = count;
            count=0;
            longestNodeHead = currentNode;

        }

        return longestNodeHead;
    }
}

