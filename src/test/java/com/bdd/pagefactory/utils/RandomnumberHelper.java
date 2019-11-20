package com.bdd.pagefactory.utils;

import java.util.Random;

public class RandomnumberHelper {
    public int randomNumberGenerator(int size){
        return new Random().nextInt(size -1);
    }

}
