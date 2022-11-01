package _01_Wiederholung_EF.Meins;

public class List<ContentType> {
    private class ListNode {
        private ContentType contentObject;
        private ListNode next;

        private ListNode(ContentType pContent) {
            contentObject = pContent;
            next = null;
        }

        public ContentType getContentObject() {
            return contentObject;
        }

        public void setContentObject(ContentType pContent) {
            contentObject = pContent;
        }

        public ListNode getNextNode() {
            return this.next;
        }

        public void setNextNode(ListNode pNext) {
            this.next = pNext;
        }
    }

    ListNode first;
    ListNode last;
    ListNode current;

    public List() {
        first = null;
        last = null;
        current = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean hasAccess() {
        return current != null;
    }

    public void next() {
        if (this.hasAccess()) {
            current = current.getNextNode();
        }
    }

    public void toFirst() {
        if (!isEmpty()) {
            current = first;
        }
    }

    public void toLast() {
        if (!isEmpty()) {
            current = last;
        }
    }

    public ContentType getContent() {
        if (this.hasAccess()) {
            return current.getContentObject();
        } else {
            return null;
        }
    }

    public void setContent(ContentType pContent) {
        if (pContent != null && this.hasAccess()) {
            current.setContentObject(pContent);
        }
    }

    public void insert(ContentType pContent) {
        if (pContent != null) {
            if (this.hasAccess()) {
                ListNode newNode = new ListNode(pContent);
                if (current != first) {
                   ListNode previous = this.getPrevious(current);
                   newNode.setNextNode(previous.getNextNode());
                   previous.setNextNode(newNode);
                } else {
                    newNode.setNextNode(first);
                    first = newNode;
                }
            } else {
                if (this.isEmpty()) {
                    ListNode newNode = new ListNode(pContent);
                    first = newNode;
                    last = newNode;
                }
            }
        }
    }

    public void append(ContentType pContent) {
        if (pContent != null) {
            if (this.isEmpty()) {
                this.insert(pContent);
            } else {
                ListNode newNode = new ListNode(pContent);
                last.setNextNode(newNode);
                last = newNode;
            }
        }
    }

    public void concat(List<ContentType> pList) {
        if (pList != this && pList != null && !pList.isEmpty()) {
            if (this.isEmpty()) {
                this.first = pList.first;
                this.last = pList.last;
            } else {
                this.last.setNextNode(pList.first);
                this.last = pList.last;
            }
            pList.first = null;
            pList.last = null;
            pList.current = null;
        }
    }

    public void remove() {
        if (this.hasAccess() && !this.isEmpty()) {
            if (current == first) {
                first = first.getNextNode();
            } else {
               ListNode previous = this.getPrevious(current);
                if (current == last) {
                    last = previous;
                }
                previous.setNextNode(current.getNextNode());
            }
            ListNode temp = current.getNextNode();
            current.setContentObject(null);
            current.setNextNode(null);
            current = temp;
            if (this.isEmpty()) {
                last = null;
            }
        }
    }

    //Zusatz-Methode - nicht in Dokumentation enthalten,
    //aber sehr hilfreich für andere Methoden
    private ListNode getPrevious(ListNode pNode) {
        if (pNode != null && pNode != first && !this.isEmpty()) {
            ListNode temp = first;
            while (temp != null && temp.getNextNode() != pNode) {
                temp = temp.getNextNode();
            }
            return temp;
        } else {
            return null;
        }
    }
}