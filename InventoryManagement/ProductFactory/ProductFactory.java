package ProductFactory;

import CommonEnum.ProductCategory;
import ProductFactory.ConcreteProducts.ElectronicProduct;
import ProductFactory.ConcreteProducts.GroceryProduct;

public class ProductFactory {

    public Product createProduct(int id,String name,double price, int quantity,ProductCategory productCategory,int threshold)
    {
        return switch (productCategory) {
            case ELECTRONICS -> new ElectronicProduct(id, name, price, quantity, threshold);
            case GROCERY -> new GroceryProduct(id, name, price, quantity, threshold);
            default -> throw new IllegalArgumentException(
                    "Unsupported product category:" + productCategory
            );
        };
    }
}
