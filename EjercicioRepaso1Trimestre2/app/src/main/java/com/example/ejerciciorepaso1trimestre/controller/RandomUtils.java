package com.example.ejerciciorepaso1trimestre.controller;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import
public class RandomUtils {
    private static Random r = new Random();
    public static int randomInt(int range){
        return (r.nextInt(range));
    }
    public static int randomIndex(Objects[]array){
        return randomInt(array.length);
    }

    public static <Arrays> Objects randomElement(Objects[] array){
        return(array[randomIndex(array)]);
    }
    public static float randomFloat(int n){
        return (float)Math.random()*n;
    }
}
