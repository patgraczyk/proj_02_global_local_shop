import models.*;
import org.junit.Before;
import org.junit.Test;


import static junit.framework.TestCase.assertEquals;
import static models.GroupType.FRUITS;
import static models.GroupType.TUBERS;
import static models.TagType.ORGANIC;

public class BasketTest {
    private Customer customer_1;
    private Basket basket_1;
    private Product product;
    private Product product2;
    private Farm farm1;

    @Before
    public void before(){
        Shop shop = new Shop("new shop");
        customer_1 = new Customer("Ricardo", "Edinburgh", shop);
        basket_1 = new Basket(customer_1);
        farm1 = new Farm("Animal Farms", "McDonnald", "FarmRoad 7", FuelConversionFactorType.ELECTRIC);
        product = new Product("potatoes", TUBERS, ORGANIC,0.5, farm1, shop );
        product2 = new Product("strawberries", FRUITS, ORGANIC,1.5, farm1, shop );


    }


    @Test
    public void startsEmpty(){
        assertEquals(0, basket_1.getProductsInBasket().size());
    }

    @Test
    public void hasCustomer(){
        assertEquals("Ricardo", basket_1.getCustomer().getCustomerName());
    }

    @Test
    public void isEmpty(){
        assertEquals(0, basket_1.getProductsInBasket().size());
    }

    @Test
    public void canAddProducts(){
        basket_1.addToBasket(product);
        assertEquals(1, basket_1.getProductsInBasket().size());
    }

    @Test
    public void canAddMultipleProducts(){
        basket_1.addToBasket(product);
        basket_1.addToBasket(product2);
        assertEquals(2,basket_1.getProductsInBasket().size());
    }

    @Test
    public void canCalculateFootprintOfBasket(){
        basket_1.addToBasket(product);
        basket_1.addToBasket(product2);
        assertEquals(0.009134, basket_1.emissionsOfProductsInBasket(),0);
    }

    @Test
    public void canCalculateFootprintOfBasket1product() {
        basket_1.addToBasket(product2);
        assertEquals(0.006850500000000001, basket_1.emissionsOfProductsInBasket(), 0);
    }

    @Test
    public void canCalculateFoodMilesOfBasket(){
        basket_1.addToBasket(product);
        basket_1.addToBasket(product2);
        assertEquals(0.49000000000000005, basket_1.foodMilesEmissionsOfProductsInBasket(),0);
    }

    @Test
    public void canCalculateFoodMilesOfBasket1product(){
        basket_1.addToBasket(product);
        assertEquals(0.24500000000000002, basket_1.foodMilesEmissionsOfProductsInBasket(),0);
    }

}
