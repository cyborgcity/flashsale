package com.sale.assignment;

import com.sale.assignment.config.impl.Config;
import com.sale.assignment.service.impl.Service;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Ravi on 10-10-2017.
 */

public class AppTest {

    Config config = null;

    @Before
    public void loadConfig(){
        try {
            config = Config.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAncestorConfig(){
        Assert.assertTrue(config.getAncestor().containsKey("Mens_wear"));
        Assert.assertTrue(config.getAncestor().containsKey("Womens_wear"));

        Assert.assertFalse(config.getAncestor().containsKey("Mens_wears"));
        Assert.assertFalse(config.getAncestor().containsKey("Womens_wear1"));

        Assert.assertEquals(30, config.getAncestor().get("Mens_wear"), 0);
        Assert.assertEquals(50, config.getAncestor().get("Womens_wear"), 0);

        Assert.assertNotEquals(50, config.getAncestor().get("Mens_wear"), 0);
        Assert.assertNotEquals(10, config.getAncestor().get("Womens_wear"), 0);
    }


    @Test
    public void testCategoryConfig(){
        Assert.assertTrue(config.getCategory().containsKey("Shirts"));
        Assert.assertTrue(config.getCategory().containsKey("Trousers"));
        Assert.assertTrue(config.getCategory().containsKey("Casuals"));
        Assert.assertTrue(config.getCategory().containsKey("Jeans"));
        Assert.assertTrue(config.getCategory().containsKey("Dresses"));
        Assert.assertTrue(config.getCategory().containsKey("Footwear"));

        Assert.assertFalse(config.getCategory().containsKey("Shirtss"));
        Assert.assertFalse(config.getCategory().containsKey("Trousers1"));
        Assert.assertFalse(config.getCategory().containsKey("Casuals2"));
        Assert.assertFalse(config.getCategory().containsKey("Jeans3"));
        Assert.assertFalse(config.getCategory().containsKey("Dresses5"));
        Assert.assertFalse(config.getCategory().containsKey("Footwear6"));

        Assert.assertEquals(30, config.getCategory().get("Shirts"), 0);
        Assert.assertEquals(30, config.getCategory().get("Trousers"), 0);
        Assert.assertEquals(30, config.getCategory().get("Casuals"), 0);
        Assert.assertEquals(40, config.getCategory().get("Jeans"), 0);
        Assert.assertEquals(50, config.getCategory().get("Dresses"), 0);
        Assert.assertEquals(60, config.getCategory().get("Footwear"), 0);

        Assert.assertNotEquals(60, config.getCategory().get("Shirts"), 0);
        Assert.assertNotEquals(50, config.getCategory().get("Trousers"), 0);
        Assert.assertNotEquals(40, config.getCategory().get("Casuals"), 0);
        Assert.assertNotEquals(30, config.getCategory().get("Jeans"), 0);
        Assert.assertNotEquals(20, config.getCategory().get("Dresses"), 0);
        Assert.assertNotEquals(10, config.getCategory().get("Footwear"), 0);

    }

    @Test
    public void testBrandConfig(){
        Assert.assertTrue(config.getBrand().containsKey("Wrangler"));
        Assert.assertTrue(config.getBrand().containsKey("Arrow"));
        Assert.assertTrue(config.getBrand().containsKey("Vero Moda"));
        Assert.assertTrue(config.getBrand().containsKey("UCB"));
        Assert.assertTrue(config.getBrand().containsKey("Adidas"));
        Assert.assertTrue(config.getBrand().containsKey("Provogue"));

        Assert.assertFalse(config.getBrand().containsKey("Wrangler1"));
        Assert.assertFalse(config.getBrand().containsKey("Arrow2"));
        Assert.assertFalse(config.getBrand().containsKey("Vero Moda3"));
        Assert.assertFalse(config.getBrand().containsKey("UCB4"));
        Assert.assertFalse(config.getBrand().containsKey("Adidas5"));
        Assert.assertFalse(config.getBrand().containsKey("Provogue6"));

        Assert.assertEquals(10, config.getBrand().get("Wrangler"), 0);
        Assert.assertEquals(20, config.getBrand().get("Arrow"), 0);
        Assert.assertEquals(60, config.getBrand().get("Vero Moda"), 0);
        Assert.assertEquals(0, config.getBrand().get("UCB"), 0);
        Assert.assertEquals(5, config.getBrand().get("Adidas"), 0);
        Assert.assertEquals(20, config.getBrand().get("Provogue"), 0);

        Assert.assertNotEquals(20, config.getBrand().get("Wrangler"), 0);
        Assert.assertNotEquals(30, config.getBrand().get("Arrow"), 0);
        Assert.assertNotEquals(40, config.getBrand().get("Vero Moda"), 0);
        Assert.assertNotEquals(10, config.getBrand().get("UCB"), 0);
        Assert.assertNotEquals(15, config.getBrand().get("Adidas"), 0);
        Assert.assertNotEquals(40, config.getBrand().get("Provogue"), 0);
    }
}
