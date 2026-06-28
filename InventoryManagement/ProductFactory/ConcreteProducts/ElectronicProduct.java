package ProductFactory.ConcreteProducts;

import CommonEnum.ProductCategory;
import ProductFactory.Product;

public class ElectronicProduct extends Product {
    private String brand;
    private int warrantyPeriod;

    public ElectronicProduct(int id,String name,double price,int quantity,int threshold){
        super();
        setId(id);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setProductCategory(ProductCategory.ELECTRONICS);
        setThreshold(threshold);

    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
}
