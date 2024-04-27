import java.util.Scanner;

public class PrinterQueueDriver {
    public static void main(String[] args) {
        PrinterQueue printerQueue = new PrinterQueue();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nPrinter Queue Menu:");
            System.out.println("1. Add a document to the queue");
            System.out.println("2. Remove a document from the queue");
            System.out.println("3. Print document at the front of the queue");
            System.out.println("4. Display queue size");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addDocument(printerQueue, scanner);
                case 2 -> removeDocument(printerQueue, scanner);
                case 3 -> printerQueue.printDocument();
                case 4 -> System.out.println("Queue size: " + printerQueue.getQueueSize());
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);
        scanner.close();
    }

    private static void addDocument(PrinterQueue printerQueue, Scanner scanner) {
        System.out.print("Enter document name: ");
        String name = scanner.next();
        scanner.nextLine();
        int pages = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter number of pages: ");
            if (scanner.hasNextInt()) {
                pages = scanner.nextInt();
                scanner.nextLine();
                if (pages > 0) {
                    validInput = true;
                    } else {
                    System.out.println("Invalid input. Number of pages must be greater than 0.");
                 }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }

        Document document = new Document(name, pages);
        printerQueue.addDocument(document);
    }

    private static void removeDocument(PrinterQueue printerQueue, Scanner scanner) {
        System.out.print("Enter document name to remove: ");
        String docName = scanner.next();
        scanner.nextLine();
        for (Document doc : printerQueue.getQueue()) {
            if (doc.name.equals(docName)) {
                printerQueue.removeDocument(doc);
                System.out.println("Document removed successfully.");
                return;
            }
        }
        System.out.println("Document not found in the queue.");
    }

}
