/**
 * WordDocument - Concrete implementation for Word documents.
 */
public class WordDocument implements Document {

    private final String fileName;

    public WordDocument(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void open() {
        System.out.println("[WordDocument] Opening: " + fileName + ".docx");
    }

    @Override
    public void save() {
        System.out.println("[WordDocument] Saving: " + fileName + ".docx");
    }

    @Override
    public void close() {
        System.out.println("[WordDocument] Closing: " + fileName + ".docx");
    }

    @Override
    public String getDocumentType() {
        return "Microsoft Word Document (.docx)";
    }
}