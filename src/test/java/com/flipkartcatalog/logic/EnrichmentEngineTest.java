package com.flipkartcatalog.logic;

import com.flipkartcatalog.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EnrichmentEngineTest {

    @Test
    public void testEnrichmentOutputPrint() {
        Product p1 = new Product("id1", "...", "...", "Boots", "", "...", 2095, 999,
                "...", "...", "...", 0.0, 0.0, "Catwalk", "...");

        Product p2 = new Product("id2", "...", "...", "Watch", "", "...", 1099, 399,
                "...", "...", "...", 5.0, 5.0, "Samsung", "...");

        Product p3 = new Product("id3", "...", "...", "Shoes", "", "...", 1999, 1499,
                "...", "...", "...", 4.5, 4.7, "Nike", "...");

        List<Product> input = new ArrayList<>();
        input.add(p1);
        input.add(p2);
        input.add(p3);

        List<Product> enriched = EnrichmentEngine.enrich(input);

        System.out.println("After Enrichment:");
        for (Product p : enriched) {
            System.out.println(p.getBrand() + " → " + p.getProductCategory());
        }
    }
}
