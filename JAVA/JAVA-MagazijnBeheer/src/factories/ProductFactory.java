package factories;

import products.Product;

public class ProductFactory {

    //Create new product without stock
    public Product newProduct(int critic, int low, int normal, int high, int weight){
        Product product = new Product(high, low, critic, normal,weight);
        return product;
    }

}
