import model.Product;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product(3128874119L, "Banana",  LocalDate.of(2023,1,24), 124, 0.55);
        products[1] = new Product(2927458265L, "Apple", LocalDate.of(2022,12,9), 18, 1.09);
        products[2] = new Product(9189927460L, "Carrot", LocalDate.of(2023, 3, 31), 89, 2.99);

        Arrays.sort(products, Comparator.comparing(Product::getUnitPrice).reversed());
        printProduct(products);
    }

    public static void printProduct(Product[] products){
        System.out.println("Printed in JSON format\n[");
        for(Product p: products){
            System.out.printf(" {\"productId\": %d, \"name\": \"%s\", \"dateSupplied\": \"%s\", \"quantityInStock\": %d, \"unitPrice\": %.2f},\n",
                    p.getProductId(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice());
        }
        System.out.println("]");

        System.out.println("\nPrinted in XML format");
        System.out.println("<?xml version=\"1.0\"?>");
        System.out.println("<products>");
        for (Product p : products) {
            System.out.printf("  <product productId=\"%d\" name=\"%s\" dateSupplied=\"%s\" quantityInStock=\"%d\" unitPrice=\"%.2f\" />\n",
                    p.getProductId(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice());
        }
        System.out.println("</products>\n");

        System.out.println("\nPrinted in CSV format");
        System.out.println("productId,name,dateSupplied,quantityInStock,unitPrice");
        for (Product p : products) {
            System.out.printf("%d,%s,%s,%d,%.2f\n",
                    p.getProductId(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice());
        }
    }
}

