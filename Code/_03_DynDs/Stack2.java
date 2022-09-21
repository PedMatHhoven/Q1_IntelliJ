package _03_DynDs;
//alle Kommentare aus "Stack" wurden entfernt
public class Stack2 <ContentType> {
  private class StackNode {
    private ContentType content = null;
    private StackNode nextNode = null; 
    
    public StackNode(ContentType pContent) {
      content = pContent;
      nextNode = null; 
    }
    
    public void setNext(StackNode pNext) {
      nextNode = pNext; 
    }                         
    
    public StackNode getNext() {
      return nextNode;
    }
    
    public ContentType getContent() {
      return content;
    }
  }
  
  private StackNode head;
  
  public Stack2 () {
    head = null; 
  }
  
  public boolean isEmpty() {
    return (head == null);  
  }      
    
  public void push(ContentType pContent) {
    if (pContent != null) {
      StackNode node = new StackNode(pContent);
      node.setNext(head);
      head = node;
    } 
  }
  
  public void pop() {
    if (!isEmpty()) {
      head  = head.getNext();
    } 
  } 
  
  public ContentType top() {
    if (!isEmpty()) {
      return head.getContent();
    } else {
      return null;
    } 
  }

}
