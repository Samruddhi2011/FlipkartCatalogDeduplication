package com.flipkartcatalog.logic;

import com.flipkartcatalog.model.Product;
import java.util.*;

public class EnrichmentEngine {

    private static final Map<String, String> dynamicMappings = new HashMap<>();

    // Method to ask user for mappings
    public static void initializeMappingsFromUser() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter number of brand-category mappings to add:");
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline

            for (int i = 0; i < n; i++) {
                System.out.print("Enter brand keyword: ");
                String brand = scanner.nextLine().toLowerCase();

                System.out.print("Enter category: ");
                String category = scanner.nextLine();

                dynamicMappings.put(brand, category);
            }
        }
    }

    public static List<Product> enrich(List<Product> products) {
        for (Product p : products) {
            if (p.getProductCategory() == null || p.getProductCategory().isBlank()) {
                String category = inferCategory(p.getBrand());
                p.setProductCategory(category);
            }
        }
        return products;
    }

    private static String inferCategory(String brand) {
        String b = brand.toLowerCase();

        // Java 17 switch expression
        return switch (b) {
            case "nike", "levis" -> "Apparel";
            case "samsung", "apple", "mi" -> "Electronics";
            case "bata", "puma" -> "Footwear";
            default -> dynamicMappings.entrySet().stream()
                    .filter(e -> b.contains(e.getKey()))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElse("Others");
        };
    }
}
