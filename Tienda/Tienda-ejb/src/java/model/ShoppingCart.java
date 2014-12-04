/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;

@Stateful
@LocalBean
public class ShoppingCart implements IShoppingCart {

    public ArrayList<Product> cart = new ArrayList<>();
    public double total = 0;
    public Date date;

    public ArrayList<Product> getCart() {
        return cart;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void setDate (Date date) {
        this.date = date;
    }
    
    public Date getDate () {
        return this.date;
    }

}
