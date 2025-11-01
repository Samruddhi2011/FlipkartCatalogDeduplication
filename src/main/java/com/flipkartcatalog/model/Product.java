package com.flipkartcatalog.model;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String uniqId;
    private String crawlTimestamp;
    private String productUrl;
    private String productName;
    private String productCategory;
    private String pid;
    private double retailPrice;
    private double discountedPrice;
    private String image;
    private String isFKAdvantageProduct;
    private String description;
    private double productRating;
    private double overallRating;
    private String brand;
    private String productSpecifications;

    private static List<String> deduplicationFields = new ArrayList<>(List.of("productName", "brand", "productCategory"));

    public static void setDeduplicationFields(List<String> fields) {
        deduplicationFields = fields != null ? fields : deduplicationFields;
    }

    public Product() {}

    public Product(String uniqId, String crawlTimestamp, String productUrl, String productName, String productCategory,
                   String pid, double retailPrice, double discountedPrice, String image, String isFKAdvantageProduct,
                   String description, double productRating, double overallRating, String brand, String productSpecifications) {
        this.uniqId = uniqId;
        this.crawlTimestamp = crawlTimestamp;
        this.productUrl = productUrl;
        this.productName = productName;
        this.productCategory = productCategory;
        this.pid = pid;
        this.retailPrice = retailPrice;
        this.discountedPrice = discountedPrice;
        this.image = image;
        this.isFKAdvantageProduct = isFKAdvantageProduct;
        this.description = description;
        this.productRating = productRating;
        this.overallRating = overallRating;
        this.brand = brand;
        this.productSpecifications = productSpecifications;
    }

    private Object getFieldValueByName(String field) {
        switch (field.trim()) {
            case "uniqId": return uniqId;
            case "crawlTimestamp": return crawlTimestamp;
            case "productUrl": return productUrl;
            case "productName": return productName;
            case "productCategory": return productCategory;
            case "pid": return pid;
            case "retailPrice": return retailPrice;
            case "discountedPrice": return discountedPrice;
            case "image": return image;
            case "isFKAdvantageProduct": return isFKAdvantageProduct;
            case "description": return description;
            case "productRating": return productRating;
            case "overallRating": return overallRating;
            case "brand": return brand;
            case "productSpecifications": return productSpecifications;
            default: return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        for (String field : deduplicationFields) {
            Object thisVal = getFieldValueByName(field);
            Object otherVal = product.getFieldValueByName(field);

            if (thisVal == null || otherVal == null || !thisVal.toString().equalsIgnoreCase(otherVal.toString())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        for (String field : deduplicationFields) {
            Object value = getFieldValueByName(field);
            result = 31 * result + (value == null ? 0 : value.toString().toLowerCase().hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        return uniqId + ", " + crawlTimestamp + ", " + productUrl + ", " + productName + ", " + productCategory + ", " +
                pid + ", " + retailPrice + ", " + discountedPrice + ", " + image + ", " + isFKAdvantageProduct + ", " +
                description + ", " + productRating + ", " + overallRating + ", " + brand + ", " + productSpecifications;
    }

    // Getters and Setters

    public String getUniqId() { return uniqId; }
    public void setUniqId(String uniqId) { this.uniqId = uniqId; }

    public String getCrawlTimestamp() { return crawlTimestamp; }
    public void setCrawlTimestamp(String crawlTimestamp) { this.crawlTimestamp = crawlTimestamp; }

    public String getProductUrl() { return productUrl; }
    public void setProductUrl(String productUrl) { this.productUrl = productUrl; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getProductCategory() { return productCategory; }
    public void setProductCategory(String productCategory) { this.productCategory = productCategory; }

    public String getPid() { return pid; }
    public void setPid(String pid) { this.pid = pid; }

    public double getRetailPrice() { return retailPrice; }
    public void setRetailPrice(double retailPrice) { this.retailPrice = retailPrice; }

    public double getDiscountedPrice() { return discountedPrice; }
    public void setDiscountedPrice(double discountedPrice) { this.discountedPrice = discountedPrice; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getIsFKAdvantageProduct() { return isFKAdvantageProduct; }
    public void setIsFKAdvantageProduct(String isFKAdvantageProduct) { this.isFKAdvantageProduct = isFKAdvantageProduct; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getProductRating() { return productRating; }
    public void setProductRating(double productRating) { this.productRating = productRating; }

    public double getOverallRating() { return overallRating; }
    public void setOverallRating(double overallRating) { this.overallRating = overallRating; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getProductSpecifications() { return productSpecifications; }
    public void setProductSpecifications(String productSpecifications) { this.productSpecifications = productSpecifications; }

    // ✅ ADD THIS STATIC METHOD BELOW TO FIX THE ERROR
    public static Product fromCSVLine(String[] line) {
        if (line.length < 15) {
            return null; // Skip malformed rows
        }

        Product p = new Product();
        p.setUniqId(line[0]);
        p.setCrawlTimestamp(line[1]);
        p.setProductUrl(line[2]);
        p.setProductName(line[3]);
        p.setProductCategory(line[4]);
        p.setPid(line[5]);

        try { p.setRetailPrice(Double.parseDouble(line[6])); } catch (NumberFormatException e) { p.setRetailPrice(0.0); }
        try { p.setDiscountedPrice(Double.parseDouble(line[7])); } catch (NumberFormatException e) { p.setDiscountedPrice(0.0); }

        p.setImage(line[8]);
        p.setIsFKAdvantageProduct(line[9]);
        p.setDescription(line[10]);

        try { p.setProductRating(Double.parseDouble(line[11])); } catch (NumberFormatException e) { p.setProductRating(0.0); }
        try { p.setOverallRating(Double.parseDouble(line[12])); } catch (NumberFormatException e) { p.setOverallRating(0.0); }

        p.setBrand(line[13]);
        p.setProductSpecifications(line[14]);

        return p;
    }
}
