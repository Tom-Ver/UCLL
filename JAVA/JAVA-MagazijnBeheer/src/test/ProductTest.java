package test;
import exceptions.HighStockException;
import exceptions.LowStockException;
import org.junit.*;
import static org.junit.Assert.*;
import products.Product;
import stockmovements.DescriptionIn;
import stockmovements.StockIn;
import stockmovements.StockMovement;

public class ProductTest {

    private Product product;
    private StockMovement stockMovement;

    @Before
    public void setUp(){
        product = new Product(20,5,2, 10, 5);
    }

    @Test
    public void test_product_addInitStock_and_actualStock() throws Exception{
        stockMovement = new StockIn(6, DescriptionIn.INIT);
        product.addStockmovement(stockMovement);
        assertEquals(6, product.actualStock());
    }

    @Test
    public void test_set_addStockMovement_inValid_HighValue() throws Exception{
            stockMovement = new StockIn(12, DescriptionIn.LEVERING);
            product.addStockmovement(stockMovement);
    }
    @Test
    public void test_set_addStockMovement_inValid_LowValue() throws Exception{
        stockMovement = new StockIn(1, DescriptionIn.LEVERING);
        product.addStockmovement(stockMovement);
    }
}
