package _03_DynDs.List;

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
      //
    }

    public boolean isEmpty() {
      return true;
      //
    }

    public boolean hasAccess() {
      return true;
      //
    }

    public void next() {
      //
    }

    public void toFirst() {
      //
    }

    public void toLast() {
      //
    }

    public ContentType getContent() {
      return null;
      //
    }

    public void setContent(ContentType pContent) {
      //
    }

    public void insert(ContentType pContent) {
      //
    }

    public void append(ContentType pContent) {
      //
    }

    public void concat(List<ContentType> pList) {
      //
    }

    public void remove() {
      //
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
