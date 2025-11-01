package com.flipkartcatalog.io;

import com.flipkartcatalog.model.Product;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProductWriter {

    public static void writeProductsToCSV(List<Product> products, String outputPath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputPath))) {
            // Write CSV header
            String[] header = {
                "uniq_id", "crawl_timestamp", "product_url", "product_name", "product_category",
                "pid", "retail_price", "discounted_price", "image", "is_FK_Advantage_product",
                "description", "product_rating", "overall_rating", "brand", "product_specifications"
            };
            writer.writeNext(header);

            // Write product data
            for (Product p : products) {
                String[] row = {
                    p.getUniqId(),
                    p.getCrawlTimestamp(),
                    p.getProductUrl(),
                    p.getProductName(),
                    p.getProductCategory(),
                    p.getPid(),
                    String.valueOf(p.getRetailPrice()),
                    String.valueOf(p.getDiscountedPrice()),
                    p.getImage(),
                    p.getIsFKAdvantageProduct(),
                    p.getDescription(),
                    String.valueOf(p.getProductRating()),
                    String.valueOf(p.getOverallRating()),
                    p.getBrand(),
                    p.getProductSpecifications()
                };
                writer.writeNext(row);
            }

        } catch (IOException e) {
            System.err.println("Error writing to CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
