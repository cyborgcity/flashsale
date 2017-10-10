package com.sale.assignment;

import java.io.InputStream;

/**
 * Created by Ravi on 01-10-2017.
 */
public class Utility {

    public InputStream getFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("input/input.csv");
        return inputStream;
    }
}
