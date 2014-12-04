/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author usuario
 */
@Stateless
@LocalBean
public class Catalog implements ICatalog {

    public ArrayList<Product> listProduct = new ArrayList<>();
    
    public ArrayList<Product> loadProducts(String filename) {
        BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(filename)));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(";");
                listProduct.add(new Product(splitLine[0], Integer.parseInt(splitLine[1]), splitLine[2], splitLine[3], Float.parseFloat(splitLine[4])));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return listProduct;
    }

    @Override
    public ArrayList<Product> getCatalog() {
        return listProduct;
    }
}
