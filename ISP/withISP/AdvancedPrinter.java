package withISP;

import java.util.ArrayList;
import java.util.List;


class AdvancedPrinter implements IPrinter, IScanner, IFax {
    private List<Document> printedDocuments = new ArrayList<>();
    private List<Document> faxedDocuments = new ArrayList<>();

    @Override
    public void print(Document document) {
        printedDocuments.add(document);
        System.out.println("Printing document: " + document.getContent());
    }

    @Override
    public Document scan() {
        Document scannedDocument = new Document("Scanned Document Content");
        System.out.println("Scanning document: " + scannedDocument.getContent());
        return scannedDocument;
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