package withISP;

public class Main {
    public static void main(String[] args) {
        // Creating documents
        Document doc1 = new Document("Document 1: Important Report");
        Document doc2 = new Document("Document 2: Contract Agreement");

        // Using BasicPrinter (only prints)
        IPrinter basicPrinter = new BasicPrinter();
        basicPrinter.print(doc1);

        // Using MultiFunctionPrinter (prints, scans, and faxes)
        AdvancedPrinter multiFunctionPrinter = new AdvancedPrinter();
        multiFunctionPrinter.print(doc2);

        // Scanning a document using MultiFunctionPrinter
        Document scannedDoc = multiFunctionPrinter.scan();
        multiFunctionPrinter.fax(scannedDoc);

        // More realistic outputs
        System.out.println("\n--- Execution Summary ---");

        // List printed documents
        System.out.println("Basic Printer - Printed Documents: ");
        BasicPrinter bp = (BasicPrinter) basicPrinter;
        bp.getPrintedDocuments().forEach(doc -> System.out.println(doc.getContent()));

        System.out.println("\nMulti-Function Printer - Printed and Faxed Documents: ");
        multiFunctionPrinter.getPrintedDocuments().forEach(doc -> System.out.println("Printed: " + doc.getContent()));
        multiFunctionPrinter.getFaxedDocuments().forEach(doc -> System.out.println("Faxed: " + doc.getContent()));
    }
}