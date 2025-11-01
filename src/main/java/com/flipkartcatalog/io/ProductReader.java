package com.flipkartcatalog.io;

import com.flipkartcatalog.model.Product;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductReader {

    public static List<Product> readProductsFromCSV(String filePath) {
        List<Product> products = new ArrayList<>();

        try {
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(',')
                    .withQuoteChar('"')
                    .withEscapeChar('\\')
                    .withIgnoreQuotations(false)
                    .build();

            CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                    .withCSVParser(parser)
                    .build();

            String[] line;
            boolean isFirstLine = true;

            while ((line = reader.readNext()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // skip header
                    continue;
                }

                try {
                    Product product = Product.fromCSVLine(line);
                    if (product != null) {
                        products.add(product);
                    }
                } catch (Exception e) {
                    System.err.println("Skipping malformed row due to error: " + e.getMessage());
                }
            }

        } catch (IOException | CsvValidationException e) {
            System.err.println("Failed to read the CSV file: " + e.getMessage());
        }

        return products;
    }
}
