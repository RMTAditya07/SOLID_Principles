import java.util.ArrayList;
import java.util.List;

public class ProductCatalogService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProducts() {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - Rs." + product.getPrice());
        }
    }

    public Product getProduct(int index) {
        if (index < 1 || index > products.size()) {
            return null;
        }
        return products.get(index - 1);
    }
}
