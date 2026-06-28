package ProductFactory.ConcreteProducts;

import CommonEnum.ProductCategory;
import ProductFactory.Product;

import java.util.Date;

public class GroceryProduct extends Product {
    private Date expiryDate;
    private boolean refridgerate;

    public GroceryProduct(int id,String name,double price,int quantity,int threshold){
        super();
        setId(id);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setProductCategory(ProductCategory.GROCERY);
        setThreshold(threshold);

    }

    public boolean isRefridgerate() {
        return refridgerate;
    }

    public void setRefridgerate(boolean refridgerate) {
        this.refridgerate = refridgerate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
