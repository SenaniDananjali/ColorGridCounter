package com.company;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class GameCreater {


    public String[][]  createGame(Integer row, Integer col) {

        String[][] colorGrid = new String[row][col];
        Arrays.setAll(colorGrid, x -> {
            Arrays.setAll(colorGrid[x], y -> randomColor());
            return colorGrid[x];
        });
        return colorGrid;
    }

    public String randomColor(){
        Color color = new Color((int) (Math.random() * 0x1000000));
     // System.out.println(Integer.toHexString(color.getRGB()));
        return Integer.toHexString(color.getRGB());
    }

}
