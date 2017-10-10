package com.sale.assignment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Ravi on 10-10-2017.
 */
public class AppServiceTest {

    Service service = null;

    @Before
    public void loadConfig(){
        service =  new Service();
    }

    @Test
    public void testCalculateDiscount(){
        String[] data = getDiscountData();
        try {
            service.calculateDiscount(data);
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        Map<String, Integer> discountTable = service.getDiscountTable();

        Assert.assertEquals(560, discountTable.get("1"), 0);
        Assert.assertEquals(560, discountTable.get("2"), 0);
        Assert.assertEquals(720, discountTable.get("3"), 0);
        Assert.assertEquals(1320, discountTable.get("4"), 0);
        Assert.assertEquals(1050, discountTable.get("5"), 0);

        Assert.assertNotEquals(1560, discountTable.get("1"), 0);
        Assert.assertNotEquals(5610, discountTable.get("2"), 0);
        Assert.assertNotEquals(7230, discountTable.get("3"), 0);
        Assert.assertNotEquals(132, discountTable.get("4"), 0);
        Assert.assertNotEquals(105, discountTable.get("5"), 0);

    }

    @Test
    public void testGetResult(){

    }

    private String[] getDiscountData(){
        String[] data = {"1, Arrow,Shirts,800","2, Vero Moda,Dresses,1400", "3, Provogue,Footwear,1800", "4, Wrangler,Jeans,2200", "5, UCB,Shirts,1500"};
        return data;
    }
}
