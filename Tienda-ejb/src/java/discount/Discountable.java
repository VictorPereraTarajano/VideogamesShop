package discount;

import entities.Product;
import interfaces.IShoppingCart;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import loader.DiscountLoader;

public abstract class Discountable {
    
    public double getDiscount(Product product, int amount) {
        ArrayList<Discount> discounts = loadDiscounts(product.getID());
        double price = product.getPricePerUnit();
        for (Discount discount : discounts) {
            price -= discount.apply(product, amount);
        }
        return price;
    }
    
    public double getDiscount (HashMap<Product, Integer> map) {
        ArrayList<Discount> discounts = loadDiscounts(-1);
        double price = 0;
        for (Entry<Product,Integer> entry : map.entrySet()) {
            price += entry.getKey().getPricePerUnit()*entry.getValue();
            price -= getDiscount(entry.getKey(), entry.getValue());
        }
        for (Discount discount : discounts) {
            
        }
        return price;
    }
    
    private ArrayList<Discount> loadDiscounts (int ID) {
        return new DiscountLoader().load(ID);
    }
    
}
