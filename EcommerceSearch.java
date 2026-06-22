import java.util.Arrays;
import java.util.Comparator;

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("Product[id=%s, name=%s, category=%s]", productId, productName, category);
    }
}

class SearchService {
    public static int linearSearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equals(targetName)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] sortedProducts, String targetName) {
        int lo = 0, hi = sortedProducts.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = sortedProducts[mid].getProductName().compareTo(targetName);
            if (cmp == 0) return mid;
            else if (cmp < 0) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}

public class EcommerceSearch {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P101", "Wireless Mouse", "Accessories"),
            new Product("P102", "Mechanical Keyboard", "Accessories"),
            new Product("P103", "USB-C Hub", "Accessories"),
            new Product("P104", "Webcam", "Electronics"),
            new Product("P105", "Monitor Stand", "Furniture")
        };

        System.out.println("--- Linear Search (unsorted array) ---");
        System.out.println("Found 'USB-C Hub' at index: " + SearchService.linearSearch(products, "USB-C Hub"));
        System.out.println("Search for 'Nonexistent Item': index " + SearchService.linearSearch(products, "Nonexistent Item"));

        System.out.println("\n--- Preparing sorted array for Binary Search ---");
        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts, Comparator.comparing(Product::getProductName));
        for (Product p : sortedProducts) System.out.println(p);

        System.out.println("\n--- Binary Search (sorted array) ---");
        System.out.println("Found 'Webcam' at sorted index: " + SearchService.binarySearch(sortedProducts, "Webcam"));
        System.out.println("Search for 'Nonexistent Item': index " + SearchService.binarySearch(sortedProducts, "Nonexistent Item"));
    }
}