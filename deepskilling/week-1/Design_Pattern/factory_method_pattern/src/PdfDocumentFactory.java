/**
 * PdfDocumentFactory - Concrete factory for PDF documents.
 */
public class PdfDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument(String fileName) {
        System.out.println("[Factory] Creating PDF Document...");
        return new PdfDocument(fileName);
    }
}