/**
 * PdfDocument - Concrete implementation for PDF documents.
 */
public class PdfDocument implements Document {

    private final String fileName;

    public PdfDocument(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void open() {
        System.out.println("[PdfDocument]  Opening: " + fileName + ".pdf");
    }

    @Override
    public void save() {
        System.out.println("[PdfDocument]  Saving: " + fileName + ".pdf");
    }

    @Override
    public void close() {
        System.out.println("[PdfDocument]  Closing: " + fileName + ".pdf");
    }

    @Override
    public String getDocumentType() {
        return "Portable Document Format (.pdf)";
    }
}