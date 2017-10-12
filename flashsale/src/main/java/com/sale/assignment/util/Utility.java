package com.sale.assignment.util;

import com.sale.assignment.config.impl.Config;

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

    public static  boolean validateInput(Config config, String[] split){
        return config.getBrand().containsKey(split[1].trim()) && config.getCategory().containsKey(split[2].trim());
    }
}
