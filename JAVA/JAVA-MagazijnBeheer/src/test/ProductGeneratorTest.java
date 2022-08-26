package test;

import exceptions.HighStockException;
import exceptions.LowStockException;
import generators.ProductGenerator;
import org.junit.Before;
import org.junit.Test;
import products.Product;

public class ProductGeneratorTest {
    ProductGenerator productGenerator;
    @Before
    public void setUp(){
        productGenerator = new ProductGenerator();
    }
    @Test
    public void test_generateProducts_values_valid() throws HighStockException, LowStockException {
        Product product = productGenerator.generateProducts(10, 80);
    }
}
