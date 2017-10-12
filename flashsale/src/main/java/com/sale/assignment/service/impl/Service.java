package com.sale.assignment.service.impl;

import com.sale.assignment.util.Utility;
import com.sale.assignment.exception.WrongInputException;
import com.sale.assignment.config.impl.Config;
import com.sale.assignment.service.IService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ravi on 01-10-2017.
 */
public class Service implements IService{

    private Map<String, Integer> discountTable = new HashMap<String, Integer>();

    private Config config = Config.getInstance();

    public Service() throws Exception {
    }

    public void calculateDiscount(String[] line) throws WrongInputException {
        for(int i = 0; i < line.length; i++){
            String[] split = line[i].split(",");
            if (!Utility.validateInput(config, split)){
                throw new WrongInputException("Wrong Input Data. Please check Brand and Category.");
            }
            Integer brandDiscount = config.getBrand().get(split[1].trim()) != null ? config.getBrand().get(split[1].trim()) : 0;
            Integer categoryDiscount = config.getCategory().get(split[2].trim()) != null ? config.getCategory().get(split[2].trim()) : 0;
            Integer discount = brandDiscount > categoryDiscount ? brandDiscount : categoryDiscount;
            Integer price = Integer.parseInt(split[3].trim());
            Integer discountedPrice = price - (price * discount/100);
            discountTable.put(split[0].trim(), discountedPrice);
        }
    }

    public Integer getResult(String line) throws WrongInputException {
        String[] split = line.split(",");
        Integer result = 0;
        for(int i = 0; i < split.length; i++){
            if(discountTable.containsKey(split[i].trim())){
                result += discountTable.get(split[i].trim());
            }else {
                throw new WrongInputException("Wrong Item " + split[i] + ". Please pass correct Item number to be billed.");
            }
        }
        return result;
    }

    public Map<String, Integer> getDiscountTable() {
        return discountTable;
    }

}
