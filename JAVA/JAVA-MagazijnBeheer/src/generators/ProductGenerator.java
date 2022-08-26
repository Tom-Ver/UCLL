package generators;

import exceptions.HighStockException;
import exceptions.InitialStockException;
import exceptions.LowStockException;
import factories.ProductFactory;
import factories.StockFactory;
import products.Product;
import stockmovements.Description;
import stockmovements.DescriptionIn;
import stockmovements.DescriptionOut;
import stockmovements.StockMovement;

import javax.sound.midi.Soundbank;
import java.util.Iterator;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class ProductGenerator {

    ProductFactory productFactory = new ProductFactory();
    StockFactory stockFactory = new StockFactory();
    Random random = new Random();
    SortedSet inventory = new TreeSet();


    //genereren van opgegegeven aantal producten met initiële stock en genereren van opgegeven aantal stockmovements
    public void addingProducts(int quantityP, int quantityM) throws InitialStockException, HighStockException, LowStockException {
        // excepties moeten hier gecatched worden
        for(int i=0; i< quantityP; i++){
            Product p = generateProducts(50,80);
            for (int j=0;j<quantityM-1;j++){
                boolean inout = random.nextBoolean();
                Description desc;
                int q;
                if(inout){
                    desc = DescriptionIn.getRandomDescriptionIn();
                    q=20;
                }
                    else{ desc = DescriptionOut.getRandomDescriptionOut();
                        q=5;
                    }
                StockMovement s = stockFactory.getStockmovement(inout,q,desc) ;
                p.addStockmovement(s);
            }

            inventory.add(p);

        }
    }

    //Stock genereren met normale stock als initiele stock. Lowstock en highStock aangegeven door user
    public Product generateProducts(int lowStock, int highStock) throws HighStockException, LowStockException {


        //if (lowStock < 2 || lowStock > highStock){throw new ProductGenException}
        int weight = random.nextInt(10);
        int normalStock = random.nextInt((highStock-lowStock) + 1) + lowStock;
        int criticStock = lowStock - (lowStock / 2);
        Product product = productFactory.newProduct(criticStock, lowStock, normalStock, highStock, weight);
        StockMovement stockMovement = stockFactory.addInitStock(normalStock);
        product.addStockmovement(stockMovement);
        return product;
    }

    // hier moet nog een methode om alles af te printen
    public void printstockmovements(){
        Iterator inventoryIteraror = inventory.iterator();
        int i=1;
            while (inventoryIteraror.hasNext())
            {
                System.out.println("Product " + i + ":");
                Product p = (Product) inventoryIteraror.next();
                p.printStockmovements();
            i++;
        }
    };


}
