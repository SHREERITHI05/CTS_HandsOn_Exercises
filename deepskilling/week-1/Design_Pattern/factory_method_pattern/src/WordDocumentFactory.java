/**
 * WordDocumentFactory - Concrete factory for Word documents.
 */
public class WordDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument(String fileName) {
        System.out.println("[Factory] Creating Word Document...");
        return new WordDocument(fileName);
    }
}