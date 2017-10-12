package com.sale.assignment.service;

import com.sale.assignment.exception.WrongInputException;

import java.util.Map;

/**
 * Created by Ravi on 12-10-2017.
 */
public interface IService {

    void calculateDiscount(String[] line) throws WrongInputException;

    Integer getResult(String line) throws WrongInputException;

    public Map<String, Integer> getDiscountTable();

}
