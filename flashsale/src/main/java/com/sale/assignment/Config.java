package com.sale.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Ravi on 01-10-2017.
 */
public class Config {

    private Map<String, Integer> ancestor = new HashMap<String, Integer>();
    private Map<String, Integer> category = new HashMap<String, Integer>();
    private Map<String, Integer> brand = new HashMap<String, Integer>();

    public void loadConfig(){
        this.loadAncestor();
        this.loadCategory();
        this.loadBrand();
    }

    private void loadAncestor(){
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("data/ancestorData.csv");
        try {
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine().trim();
                String[] split = line.split(",");
                ancestor.put(split[0].trim(), Integer.parseInt(split[1].trim()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCategory(){
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("data/categoryData.csv");
        try {
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine().trim();
                String[] split = line.split(",");
                int discount = 0;
                if(!ancestor.isEmpty() && ancestor.containsKey(split[1].trim())){
                    if (ancestor.get(split[1].trim()) > Integer.parseInt(split[2].trim())){
                        discount = ancestor.get(split[1]);
                    }else {
                        discount = Integer.parseInt(split[2]);
                    }
                }
                category.put(split[0].trim(), discount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBrand(){
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("data/brandData.csv");
        try {
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine().trim();
                String[] split = line.split(",");
                brand.put(split[0].trim(), Integer.parseInt(split[1].trim()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getAncestor() {
        return ancestor;
    }

    public Map<String, Integer> getCategory() {
        return category;
    }

    public Map<String, Integer> getBrand() {
        return brand;
    }

}
