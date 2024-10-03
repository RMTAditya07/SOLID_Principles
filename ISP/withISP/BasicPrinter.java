package withISP;

import java.util.ArrayList;
import java.util.List;


class BasicPrinter implements IPrinter {
    private List<Document> printedDocuments = new ArrayList<>();

    @Override
    public void print(Document document) {
        printedDocuments.add(document);
        System.out.println("Printing document: " + document.getContent());
    }

    public List<Document> getPrintedDocuments() {
        return printedDocuments;
    }
}