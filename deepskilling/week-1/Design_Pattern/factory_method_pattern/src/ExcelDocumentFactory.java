/**
 * ExcelDocumentFactory - Concrete factory for Excel documents.
 */
public class ExcelDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument(String fileName) {
        System.out.println("[Factory] Creating Excel Document...");
        return new ExcelDocument(fileName);
    }
}