import java.util.ArrayList;
import java.util.List;

class BasicPrinter implements IPrinter {
    private List<Document> printedDocuments = new ArrayList<>();

    @Override
    public void print(Document document) {
        printedDocuments.add(document);
        System.out.println("Printing document: " + document.getContent());
    }

    @Override
    public void scan(Document document) {
        // This printer cannot scan, but it is forced to implement this method
        throw new UnsupportedOperationException("BasicPrinter does not support scanning.");
    }

    @Override
    public void fax(Document document) {
        // This printer cannot fax, but it is forced to implement this method
        throw new UnsupportedOperationException("BasicPrinter does not support faxing.");
    }

    public List<Document> getPrintedDocuments() {
        return printedDocuments;
    }
}