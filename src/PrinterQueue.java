import java.util.LinkedList;
import java.util.Queue;

public class PrinterQueue {

    private Queue<Document> queue;

    public PrinterQueue() {
        this.queue = new LinkedList<>();
    }

    public void addDocument(Document document) {
        queue.add(document);
    }

    public void removeDocument(Document document) {
        queue.remove(document);
    }

    public void printDocument() {
        if (!queue.isEmpty()) {
            Document doc = queue.poll();
            System.out.println("Printing document: " + doc.name);
        } else {
            System.out.println("Printer queue is empty.");
        }
    }

    public int getQueueSize() {
        return queue.size();
    }

    public Queue<Document> getQueue() {
        return queue;
    }
}
