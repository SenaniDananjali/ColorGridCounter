package com.company;


public class GameManager {

    Integer gridRows = 3;
    Integer gridCols = 3;

    static Integer currentNodeLenth = 0;

    GameCreater gameCreater = new GameCreater();
    String[][] colorGrid = gameCreater.createGame(gridRows, gridCols);
    private Node maxLengthNode = new Node();
    static Integer maxNodeLenth = 0;

    public Node searchAdjacentColorNodes(Integer row, Integer col, Node currentNode) {

        if (row >= gridRows - 1 | col >= gridCols - 1) {
            return new Node();
        } else {
            String currentNodeColor = colorGrid[row][col];

            Node downNode = verticalSearch(row, col, currentNode);
            Node nextNode = horizontalSearch(row, col, currentNode);

            if (nextNode.color == downNode.color) {
                currentNode.color = currentNodeColor;
                currentNode.next = nextNode;
                currentNode.down = downNode;
                currentNodeLenth = currentNodeLenth + 2;
                searchAdjacentColorNodes(row + 1, col, currentNode);
                searchAdjacentColorNodes(row + 1, col, currentNode);
            } else if (nextNode.color == currentNodeColor) {
                currentNode.next = nextNode;
                searchAdjacentColorNodes(row, col + 1, currentNode);
                currentNodeLenth = currentNodeLenth + 1;
            } else if (downNode.color == currentNodeColor) {
                currentNode.down = downNode;
                searchAdjacentColorNodes(row + 1, col, currentNode);
                currentNodeLenth = currentNodeLenth + 1;
            } else {
                if (maxNodeLenth < currentNodeLenth) {
                    maxNodeLenth = currentNodeLenth;
                    maxLengthNode = currentNode;
                }
                Node newNext = new Node();
                Node newDown = new Node();
                searchAdjacentColorNodes(row, col + 1, newNext);
                searchAdjacentColorNodes(row + 1, col, newDown);
            }
        }
        return maxLengthNode;

    }

    public Node horizontalSearch(Integer row, Integer col, Node currentNode) {
        String nextNodeColor = colorGrid[row][col + 1];
        Node nextNode = new Node();

        nextNode.color = nextNodeColor;
        nextNode.x = row;
        nextNode.y = col + 1;
        currentNode.next = nextNode;

        return nextNode;

    }


    public Node verticalSearch(Integer row, Integer col, Node currentNode) {

        String downNodeColor = colorGrid[row + 1][col];

        Node downNode = new Node();
        downNode.color = downNodeColor;
        downNode.x = row + 1;
        downNode.y = col;

        return downNode;
    }
}


