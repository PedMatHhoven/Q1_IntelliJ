package _03_DynDs.Queue.mitAnwendung;

public class AP_Queue<ContentType> {
    private class QueueNode {
        private ContentType content = null;
        private QueueNode nextNode = null;

        public QueueNode(ContentType pContent) {
            content = pContent;
            nextNode = null;
        }

        public void setNext(QueueNode pNext) {
            nextNode = pNext;
        }

        public QueueNode getNext() {
            return nextNode;
        }

        public ContentType getContent() {
            return content;
        }
    }

    private QueueNode head;
    private QueueNode tail;

    public AP_Queue() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(ContentType pContent) {
        if (pContent != null) {
            QueueNode newNode = new QueueNode(pContent);
            if (this.isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
        }
    }

    public void dequeue() {
        if (!this.isEmpty()) {
            head = head.getNext();
            if (this.isEmpty()) {
                head = null;
                tail = null;
            }
        }
    }

    //zusätzliche Funktion mit Beugung der Queue-Regeln für Anwendung
    public void frontEnqueue(ContentType pContent){
        QueueNode newNode = new QueueNode(pContent);
        if (this.isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public ContentType front() {
        if (this.isEmpty()) {
            return null;
        } else {
            return head.getContent();
        }
    }
}