/**
 * Document - Base interface for all document types.
 * Every document must support open, save, and close operations.
 */
public interface Document {
    void open();
    void save();
    void close();
    String getDocumentType();
}