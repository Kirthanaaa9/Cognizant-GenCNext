package com.ecommerce.search;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Phone", "Electronics"),
            new Product(3, "Shoes", "Fashion"),
            new Product(4, "Watch", "Accessories")
        };

        Product foundLinear = SearchUtils.linearSearch(products, "Phone");
        System.out.println("Linear Search: " + (foundLinear != null ? foundLinear : "Not found"));

        Product foundBinary = SearchUtils.binarySearch(products, "Phone");
        System.out.println("Binary Search: " + (foundBinary != null ? foundBinary : "Not found"));
    }
}
