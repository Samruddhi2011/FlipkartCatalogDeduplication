package com.flipkartcatalog;

import com.flipkartcatalog.model.Product;
import com.flipkartcatalog.io.ProductReader;
import com.flipkartcatalog.io.ProductWriter;
import com.flipkartcatalog.logic.DeduplicationEngine;
import com.flipkartcatalog.logic.EnrichmentEngine;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        String inputPath = "src/main/resources/flipkart_com-ecommerce_sample.csv";
        String outputPath = "src/main/resources/output.csv";

        try (Scanner scanner = new Scanner(System.in)) {
            // Ask user for deduplication fields
            System.out.println("Enter deduplication fields (comma-separated, e.g., productName,brand,productCategory): ");
            String fieldsInput = scanner.nextLine();

            List<String> deduplicationFields = Arrays.stream(fieldsInput.split(","))
                                                     .map(String::trim)
                                                     .toList();

            Product.setDeduplicationFields(deduplicationFields);
            System.out.println("Deduplication will use fields: " + deduplicationFields);

            List<Product> allProducts = ProductReader.readProductsFromCSV(inputPath);
            System.out.println("Total products before deduplication: " + allProducts.size());

            List<Product> deduplicated = DeduplicationEngine.removeDuplicates(allProducts);
            System.out.println("Total products after deduplication: " + deduplicated.size());

            deduplicated = EnrichmentEngine.enrich(deduplicated);
            System.out.println("Enrichment done.");

            ProductWriter.writeProductsToCSV(deduplicated, outputPath);
            System.out.println("Output written to: " + outputPath);

            //if (!deduplicated.isEmpty()) {
            //    System.out.println("Sample product after deduplication & enrichment:\n" + deduplicated.get(0));
            //}
        } catch (Exception e) {
            System.err.println("An error occurred during processing: " + e.getMessage());
        }
    }
}
