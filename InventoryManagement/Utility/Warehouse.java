package Utility;

import ProductFactory.Product;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private int id;
    private String name;
    private String location;
    private Map<Integer, Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public Warehouse(int id, String name, String location)
    {
        this.id =id;
        this.name =name;
        this.location =location;
        this.products = new HashMap<>();
    }

    public void addProduct(Product product,int quantity)
    {
        int productId = product.getId();
        if(products.containsKey(productId)){
            Product existingProduct = products.get(productId);
            existingProduct.setQuantity(existingProduct.getQuantity()+quantity);
            products.put(productId,existingProduct);
        }
        else {
            products.put(productId,product);
        }

        System.out.println(quantity + " more " + product.getName() + " added to "+ name
        + ". New quantiy is :"+ products.get(productId).getQuantity());
    }

    public boolean removeProduct(int id, int quantity) {
        if (products.containsKey(id)) {
            Product product = products.get(id);
            int currentQuantity = product.getQuantity();
            if (currentQuantity >= quantity) {
                // Sufficient inventory to remove
                product.setQuantity(currentQuantity - quantity);
                System.out.println(quantity + " units of " + product.getName()
                        + " (id: " + id + ") removed from " + name
                        + ". Remaining quantity: " + product.getQuantity());
                // If quantity becomes zero, consider removing the product entirely
                if (product.getQuantity() == 0) {
                    // Remove products with zero quantity
                    products.remove(id);
                    System.out.println("Product " + product.getName()
                            + " removed from inventory as quantity is now zero.");
                }
                return true;
            } else {
                System.out.println("Error: Insufficient inventory. Requested: "
                        + quantity + ", Available: " + currentQuantity);
                return false;
            }
        } else {
            System.out.println(
                    "Error: Product with id " + id + " not found in " + name);
            return false;
        }
    }
}
