import java.util.ArrayList;
import java.util.List;

class AdvancedPrinter implements IPrinter {
    private List<Document> printedDocuments = new ArrayList<>();
    private List<Document> faxedDocuments = new ArrayList<>();

    @Override
    public void print(Document document) {
        printedDocuments.add(document);
        System.out.println("Printing document: " + document.getContent());
    }

    @Override
    public void scan(Document document) {
        System.out.println("Scanning document: " + document.getContent());
    }

    @Override
    public void fax(Document document) {
        faxedDocuments.add(document);
        System.out.println("Faxing document: " + document.getContent());
    }

    public List<Document> getPrintedDocuments() {
        return printedDocuments;
    }

    public List<Document> getFaxedDocuments() {
        return faxedDocuments;
    }
}