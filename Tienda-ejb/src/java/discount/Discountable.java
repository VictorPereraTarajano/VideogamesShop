package discount;

import entities.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import loader.DiscountLoader;

public abstract class Discountable {
    
    public double getDiscount(Product product, int amount, boolean applyIVA) {
        double price=product.getPricePerUnit()*amount;
        for (Discount discount : loadDiscounts(product.getID())) 
            price -= discount.apply(product, amount);
        if (applyIVA) price = Discount.applyIVA(price);
        if (price < 0) price = 0;
        product.setPrice(price);
        return price;
    }
    
    public double getDiscount (HashMap<Product, Integer> map) {
        double price = 0;      
        for (Entry<Product,Integer> entry : map.entrySet()) 
           price += getDiscount(entry.getKey(), entry.getValue(), false);

        for (Discount discount : loadDiscounts(-1)) 
            price -= discount.apply(price);
        if (price < 0) price = 0;
        return Discount.applyIVA(price);
    }
    
    private ArrayList<Discount> loadDiscounts (int ID) {
        return new DiscountLoader().load(ID);
    }
    
}
