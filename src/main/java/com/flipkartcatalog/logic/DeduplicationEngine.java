package com.flipkartcatalog.logic;

import com.flipkartcatalog.model.Product;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class DeduplicationEngine {

    public static List<Product> removeDuplicates(List<Product> originalList) {
        Set<Product> uniqueProducts = new LinkedHashSet<>(originalList);  // removes duplicates using equals & hashCode
        return new ArrayList<>(uniqueProducts); // return as List
    }
}
