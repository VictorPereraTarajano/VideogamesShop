package entities;

import interfaces.ICatalog;
import interfaces.IShoppingCart;
import discount.cartdiscount.CartDiscount;
import discount.Discount;
import loader.DiscountLoader;
import discount.productdiscount.ProductDiscount;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import loader.ProductLoader;

@Stateless
public class Catalog implements ICatalog {

    public ArrayList<Product> listProduct = new ArrayList<>();
    
    @PostConstruct
    public void init () {
        new ProductLoader().load(listProduct);
        new DiscountLoader().load(listProduct);
        applyProductDiscounts();
    }

    @Override
    public ArrayList<Product> getCatalog() {
        return listProduct;
    }

    @Override
    public void applyProductDiscounts() {
        for (Product product : listProduct) {
            try {
                Discount discount = product.getDiscount();
                if (discount != null)   ((ProductDiscount) discount).apply(product);
            } catch (ClassCastException ex) {
                product.setPrice(product.getPricePerUnit());
            }
        }
    }

    @Override
    public void applyCartDiscounts(IShoppingCart cart) {
        for (Product product : cart.getCart().keySet()) {
            try {
                Discount discount = product.getDiscount();
                if (discount != null)   {
                    ((CartDiscount) discount).apply(cart, product);
                }
            } catch (ClassCastException ex) {
            }
        }
    }
  
}
