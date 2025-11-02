# Flipkart Catalog Deduplication and Enrichment Engine  

A **Java Maven–based data engineering project** designed to enhance the quality and usability of large-scale e-commerce product data.  
The system automatically removes duplicate listings, fills missing categories, and exports clean, structured data—making it ready for analytics and reporting pipelines.

---

## Project Overview  

E-commerce platforms like Flipkart manage millions of product listings that often contain duplicates or missing details.  
This project automates **data cleaning, deduplication, and enrichment** to ensure accuracy, completeness, and consistency.

**Core Operations:**
1. **Deduplication :** Detects and removes duplicate products using overridden `equals()` and `hashCode()` methods.  
2. **Enrichment :** Fills missing category values via a **rule-based mapping** (e.g., mapping brands → categories).  
3. **Export :** Writes the refined dataset into a new CSV for seamless downstream use.

---

## Key Features  

- Automated duplicate detection using `HashSet`-based logic  
- Brand-based enrichment for missing categories  
- Reliable CSV parsing & writing using **OpenCSV**  
- Unit testing with **JUnit 5**  
- Modular + Scalable + Maven-driven architecture  

---

## Tech Stack  

| Component | Technology Used |
|------------|-----------------|
| Language | Java |
| Framework | Apache Maven |
| Libraries | OpenCSV, JUnit 5 |
| IDE / Tools | VS Code, Git, GitHub |
| Concepts | OOP, Collections, File Handling, Testing |

---

## Folder Structure  

The project is organized as follows 👇  

- FlipkartCatalogDeduplication/
- ┣ src/
- ┃ ┣ main/java/com/flipkartcatalog/
- ┃ ┃ ┣ io/
- ┃ ┃ ┃ ┣ ProductReader.java
- ┃ ┃ ┃ ┗ ProductWriter.java
- ┃ ┃ ┣ logic/
- ┃ ┃ ┃ ┣ DeduplicationEngine.java
- ┃ ┃ ┃ ┗ EnrichmentEngine.java
- ┃ ┃ ┣ model/
- ┃ ┃ ┃ ┗ Product.java
- ┃ ┃ ┗ MainApp.java
- ┃ ┗ resources/
- ┃ ┃ ┣ flipkart_com-ecommerce_sample.csv
- ┃ ┃ ┗ output.csv
- ┣ test/java/com/flipkartcatalog/logic/
- ┃ ┣ DeduplicationEngineTest.java
- ┃ ┗ EnrichmentEngineTest.java
- ┣ pom.xml
- ┗ README.md


---

## Concepts & Implementation  

| Concept | File(s) | Description |
|----------|----------|-------------|
| **Encapsulation & OOP** | `Product.java` | Private fields with getters / setters for data protection |
| **Collections (HashSet, List)** | `DeduplicationEngine.java` | Fast duplicate removal and product grouping |
| **Static Utility Methods** | `ProductReader`, `DeduplicationEngine`, `EnrichmentEngine` | Independent reusable logic blocks |
| **File Handling** | `ProductReader`, `ProductWriter` | Read & write CSV files via OpenCSV |
| **Unit Testing** | `JUnit 5` | Validates correctness and reliability |
| **Maven Build Mgmt** | `pom.xml` | Dependency + plugin configuration |

---

## Results  

| Metric | Before | After |
|---------|---------|--------|
| Total Products | 14 000 + | ~7 000 – 9 000 |
| Missing Categories | 1 000 + | 0 |
| Duplicates | High | Eliminated ✅ |

**Outcome :** Cleaner + Complete + Consistent dataset — ready for analytics and catalog maintenance.

---

## How to Run  

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/FlipkartCatalogDeduplication.git
   cd FlipkartCatalogDeduplication
