import org.junit.Test;

import java.util.Queue;

import static org.junit.Assert.*;

public class PrinterQueueTest {

    @Test
    public void testAddDocument() {
        PrinterQueue printerQueue = new PrinterQueue();
        Document doc1 = new Document("Document1", 5);
        Document doc2 = new Document("Document2", 10);

        printerQueue.addDocument(doc1);
        printerQueue.addDocument(doc2);

        assertEquals(2, printerQueue.getQueueSize());
    }

    @Test
    public void testRemoveDocument() {
        PrinterQueue printerQueue = new PrinterQueue();
        Document doc1 = new Document("Document1", 5);
        Document doc2 = new Document("Document2", 10);

        printerQueue.addDocument(doc1);
        printerQueue.addDocument(doc2);
        printerQueue.removeDocument(doc1);

        assertEquals(1, printerQueue.getQueueSize());
    }

    @Test
    public void testPrintDocument() {
        PrinterQueue printerQueue = new PrinterQueue();
        Document doc1 = new Document("Document1", 5);
        Document doc2 = new Document("Document2", 10);

        printerQueue.addDocument(doc1);
        printerQueue.addDocument(doc2);

        assertEquals(2, printerQueue.getQueueSize());

        printerQueue.printDocument();

        assertEquals(1, printerQueue.getQueueSize());
    }

    @Test
    public void testPrintDocumentEmptyQueue() {
        PrinterQueue printerQueue = new PrinterQueue();

        assertEquals(0, printerQueue.getQueueSize());

        printerQueue.printDocument();

        assertEquals(0, printerQueue.getQueueSize());
    }

    @Test
    public void testGetQueueSize() {
        PrinterQueue printerQueue = new PrinterQueue();
        Document doc1 = new Document("Document1", 5);
        Document doc2 = new Document("Document2", 10);

        printerQueue.addDocument(doc1);
        printerQueue.addDocument(doc2);

        assertEquals(2, printerQueue.getQueueSize());
    }

    @Test
    public void testGetQueue() {
        PrinterQueue printerQueue = new PrinterQueue();
        Document doc1 = new Document("Document1", 5);
        Document doc2 = new Document("Document2", 10);

        printerQueue.addDocument(doc1);
        printerQueue.addDocument(doc2);

        Queue<Document> queue = printerQueue.getQueue();

        assertNotNull(queue);
        assertEquals(2, queue.size());
        assertTrue(queue.contains(doc1));
        assertTrue(queue.contains(doc2));
    }
}
