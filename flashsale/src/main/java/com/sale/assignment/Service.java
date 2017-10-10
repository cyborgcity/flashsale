package com.sale.assignment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ravi on 01-10-2017.
 */
public class Service {

    private Map<String, Integer> discountTable = new HashMap<String, Integer>();

    private Config config = new Config();

    public void initializeConfig() {
        config.loadConfig();
    }

    public void calculateDiscount(String[] line){
        for(int i = 0; i < line.length; i++){
            String[] split = line[i].split(",");
            Integer brandDiscount = config.getBrand().get(split[1].trim()) != null ? config.getBrand().get(split[1].trim()) : 0;
            Integer categoryDiscount = config.getCategory().get(split[2].trim()) != null ? config.getCategory().get(split[2].trim()) : 0;
            Integer discount = brandDiscount > categoryDiscount ? brandDiscount : categoryDiscount;
            Integer price = Integer.parseInt(split[3].trim());
            Integer discountedPrice = price - (price * discount/100);
            discountTable.put(split[0].trim(), discountedPrice);
        }
    }

    public Integer getResult(String line){
        String[] split = line.split(",");
        Integer result = 0;
        for(int i = 0; i < split.length; i++){
            if(discountTable.containsKey(split[i].trim())){
                result += discountTable.get(split[i].trim());
            }
        }
        return result;
    }
}
