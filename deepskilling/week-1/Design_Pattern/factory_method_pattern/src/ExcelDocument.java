/**
 * ExcelDocument - Concrete implementation for Excel documents.
 */
public class ExcelDocument implements Document {

    private final String fileName;

    public ExcelDocument(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void open() {
        System.out.println("[ExcelDocument] Opening: " + fileName + ".xlsx");
    }

    @Override
    public void save() {
        System.out.println("[ExcelDocument] Saving: " + fileName + ".xlsx");
    }

    @Override
    public void close() {
        System.out.println("[ExcelDocument] Closing: " + fileName + ".xlsx");
    }

    @Override
    public String getDocumentType() {
        return "Microsoft Excel Spreadsheet (.xlsx)";
    }
}