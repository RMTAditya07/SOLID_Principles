public class Main {
    public static void main(String[] args) {
        // Creating documents
        Document doc1 = new Document("Document 1: Important Report");
        Document doc2 = new Document("Document 2: Contract Agreement");

        // Using BasicPrinter (only prints but is forced to have other methods)
        IPrinter basicPrinter = new BasicPrinter();
        basicPrinter.print(doc1);
        try {
            basicPrinter.scan(doc1);  // This will throw an exception
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

        try {
            basicPrinter.fax(doc1);  // This will throw an exception
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

        // Using AdvancedPrinter (supports all operations)
        IPrinter AdvancedPrinter = new AdvancedPrinter();
        AdvancedPrinter.print(doc2);
        AdvancedPrinter.scan(doc2);
        AdvancedPrinter.fax(doc2);

        // Execution summary
        System.out.println("\n--- Execution Summary ---");

        // List printed documents
        System.out.println("Basic Printer - Printed Documents: ");
        BasicPrinter bp = (BasicPrinter) basicPrinter;
        bp.getPrintedDocuments().forEach(doc -> System.out.println(doc.getContent()));

        System.out.println("\nMulti-Function Printer - Printed and Faxed Documents: ");
        AdvancedPrinter mfp = (AdvancedPrinter) AdvancedPrinter;
        mfp.getPrintedDocuments().forEach(doc -> System.out.println("Printed: " + doc.getContent()));
        mfp.getFaxedDocuments().forEach(doc -> System.out.println("Faxed: " + doc.getContent()));
    }
}