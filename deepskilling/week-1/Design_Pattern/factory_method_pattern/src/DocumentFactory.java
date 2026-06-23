/**
 * DocumentFactory - Abstract factory defining the Factory Method.
 * Subclasses decide which Document type to instantiate.
 */
public abstract class DocumentFactory {

    // Factory Method — must be implemented by each concrete factory
    public abstract Document createDocument(String fileName);

    /**
     * Full document workflow: create → open → save → close
     * This is the template that all factories share.
     */
    public void processDocument(String fileName) {
        System.out.println("\n----------------------------------------");
        Document doc = createDocument(fileName);
        System.out.println("  Type : " + doc.getDocumentType());
        doc.open();
        doc.save();
        doc.close();
        System.out.println("----------------------------------------");
    }
}