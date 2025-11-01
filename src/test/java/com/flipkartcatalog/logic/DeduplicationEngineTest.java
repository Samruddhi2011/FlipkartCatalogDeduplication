package com.flipkartcatalog.logic;

import com.flipkartcatalog.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DeduplicationEngineTest {

    // Base duplicate test – two same product names
    @Test
    public void testBasicDuplicateRemoval() {
        Product p1 = new Product("1", "...", "...", "Phone", "Electronics", "...", 15000, 13000, "...", "...", "...", 4.2, 4.6, "Samsung", "...");
        Product p2 = new Product("2", "...", "...", "Phone", "Electronics", "...", 15500, 12900, "...", "...", "...", 4.1, 4.5, "Samsung", "...");

        List<Product> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);

        List<Product> result = DeduplicationEngine.removeDuplicates(list);
        System.out.println("Expected Size: 1 | Got: " + result.size());
    }

    // Keep distinct products
    @Test
    public void testKeepsDistinctProducts() {
        Product p1 = new Product("3", "...", "...", "TV", "Electronics", "...", 30000, 28000, "...", "...", "...", 4.0, 4.4, "Sony", "...");
        Product p2 = new Product("4", "...", "...", "Shoes", "Footwear", "...", 3000, 2500, "...", "...", "...", 3.8, 4.2, "Nike", "...");

        List<Product> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);

        List<Product> result = DeduplicationEngine.removeDuplicates(list);
        System.out.println("Expected Size: 2 | Got: " + result.size());
    }

    // Duplicates with slight name change (to test if strict)
    @Test
    public void testSimilarNameNotDuplicate() {
        Product p1 = new Product("5", "...", "...", "Samsung Phone", "Electronics", "...", 15000, 14000, "...", "...", "...", 4.2, 4.6, "Samsung", "...");
        Product p2 = new Product("6", "...", "...", "Samsung Smartphone", "Electronics", "...", 15000, 14000, "...", "...", "...", 4.2, 4.6, "Samsung", "...");

        List<Product> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);

        List<Product> result = DeduplicationEngine.removeDuplicates(list);
        System.out.println("Expected Size: 2 | Got: " + result.size());
    }

    // Case-insensitive match
    @Test
    public void testCaseInsensitiveDuplicate() {
        Product p1 = new Product("7", "...", "...", "Shoes", "Footwear", "...", 2000, 1800, "...", "...", "...", 4.0, 4.3, "Puma", "...");
        Product p2 = new Product("8", "...", "...", "shoes", "Footwear", "...", 2000, 1800, "...", "...", "...", 4.0, 4.3, "Puma", "...");

        List<Product> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);

        List<Product> result = DeduplicationEngine.removeDuplicates(list);
        System.out.println("Expected Size: 1 | Got: " + result.size());
    }
}
