package _03_DynDsLin.List.mitGUIundErw;

public class List <ContentType> {
    //in protected geändert wegen ListErw - Zugriff erforderlich
    protected class ListNode {
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
            return next;
        }

        public void setNextNode(ListNode pNext) {
            next = pNext;
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
        if (hasAccess()) current = current.getNextNode();
    }

    public void toFirst() {
        if (!isEmpty()) current = first;
    }

    public void toLast() {
        if (!isEmpty()) current = last;
    }

    public ContentType getContent() {
        if (hasAccess()) return current.getContentObject(); else return null;
    }

    public void setContent(ContentType pContent) {
        if (pContent != null && hasAccess()) current.setContentObject(pContent);
    }

    public void insert(ContentType pContent) {
        if (pContent != null) {
            if (hasAccess()) {
                ListNode newNode = new ListNode(pContent);
                if (current != first) {
                   ListNode previous = getPrevious(current);
                   newNode.setNextNode(previous.getNextNode());
                   previous.setNextNode(newNode);
                } else {
                    newNode.setNextNode(first);
                    first = newNode;
                }
            } else {
                if (isEmpty()) {
                    ListNode newNode = new ListNode(pContent);
                    first = newNode;
                    last = newNode;
                }
            }
        }
    }

    public void append(ContentType pContent) {
        if (pContent != null) {
            if (isEmpty()) {
                insert(pContent);
            }
            else {
                ListNode newNode = new ListNode(pContent);
                last.setNextNode(newNode);
                last = newNode;
            }
        }
    }

    public void concat(List<ContentType> pList) {
        if (pList != this && pList != null && !pList.isEmpty()) {
            if (isEmpty()) {
                first = pList.first;
                last = pList.last;
            } else {
                last.setNextNode(pList.first);
                last = pList.last;
            }
            //pList wird gelöscht (nicht in Dokumentation gefordert)
            pList.first = null;
            pList.last = null;
            pList.current = null;
        }
    }

    public void remove() {
        if (hasAccess() && !isEmpty()) {
            if (current == first) {
                first = first.getNextNode();
            } else {
               ListNode previous = getPrevious(current);
               if (current == last) last = previous;
               previous.setNextNode(current.getNextNode());
            }
            ListNode temp = current.getNextNode();
            //Element wird gelöscht (nicht in Dokumentation gefordert)
            current.setContentObject(null);
            current.setNextNode(null);
            current = temp;
            if (isEmpty()) last = null;
        }
    }

    //Zusatz-Methode - nicht in Dokumentation enthalten,
    //aber sehr hilfreich für andere Methoden!
    //geändert in protected wegen GUI!
    protected ListNode getPrevious(ListNode pNode) {
        if (pNode != null && pNode != first && !isEmpty()) {
            ListNode temp = first;
            while (temp != null && temp.getNextNode() != pNode) temp = temp.getNextNode();
            return temp;
        } else {
            return null;
        }
    }
}
