/**
 * FactoryMethodTest — Demonstrates the Factory Method Pattern.
 *
 * Key point: The client (this class) never uses 'new WordDocument()'
 * directly. It always goes through the factory — fully decoupled.
 */
public class FactoryMethodTest {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("   Factory Method Pattern - Document MS  ");
        System.out.println("==========================================");

        // Each factory handles its own document type
        DocumentFactory wordFactory  = new WordDocumentFactory();
        DocumentFactory pdfFactory   = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // ── Test 1: Word Document ──────────────────────────────────────
        System.out.println("\n>> Test 1: Word Document");
        wordFactory.processDocument("ProjectReport");

        // ── Test 2: PDF Document ───────────────────────────────────────
        System.out.println("\n>> Test 2: PDF Document");
        pdfFactory.processDocument("CompanyBrochure");

        // ── Test 3: Excel Document ─────────────────────────────────────
        System.out.println("\n>> Test 3: Excel Document");
        excelFactory.processDocument("SalesData_Q1");

        // ── Test 4: Polymorphism — same interface, different factories ──
        System.out.println("\n\n>> Test 4: Polymorphic Factory Usage");
        System.out.println("   (Same processDocument() call, different factories)");

        DocumentFactory[] factories   = { wordFactory, pdfFactory, excelFactory };
        String[]          fileNames   = { "Resume", "Invoice", "Budget" };

        for (int i = 0; i < factories.length; i++) {
            factories[i].processDocument(fileNames[i]);
        }

        System.out.println("\n==========================================");
        System.out.println("  All document types created successfully!");
        System.out.println("==========================================");
    }
}