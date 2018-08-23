package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {

    private int id;
    private String customerName;
    private String customerAddress;
    private Map<String, String> environmetnInfo;
    private List<Product> basket;


    public Customer(String customerName, String customerAddress) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.environmetnInfo = new HashMap<String, String>();
        this.basket = new ArrayList<Product>();
    }

//GETTERS & SETTERS


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Map<String, String> getEnvironmetnInfo() {
        return environmetnInfo;
    }

    public void setEnvironmetnInfo(Map<String, String> environmetnInfo) {
        this.environmetnInfo = environmetnInfo;
    }

    public List<Product> getBasket() {
        return basket;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }

    //OTHER METHODS
    public void addToBasket(Product product){
        this.basket.add(product);
    }

    public void removeFromBasket(Product product){
        this.basket.remove(product);
    }

    public void addEnvironmentalInfo(String key, String value){
        this.environmetnInfo.put(key, value);
    }

    public void removeFromEnvironemtnalInfo(String key){
        this.environmetnInfo.remove(key);
    }


}