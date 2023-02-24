package _05_Baeume.BinarySearchTreeMitLuecken;

public class BinarySearchTree <ContentType extends ComparableContent <ContentType>> {
//aus offizieller Abitur-Vorgabe - allerdings Quelltext ein wenig verändert: "this" gelöscht, teils
//unnötige Klammern entfernt, teils Attributen- durch Methodenaufrufe ersetzt, "remove" ohne Hilfsmethoden, ...!
//außerdem im unteren Teil weitere nützliche Methoden ergänzt!

  //innere Klasse (Wurzelknoten)
  private class BSTNode <CT extends ComparableContent <CT>> {
    private CT content;
    private BinarySearchTree <CT> left, right;

    public BSTNode(CT pContent) {
      content = pContent;    
      left = new BinarySearchTree<>();
      right = new BinarySearchTree<>();
    }
  }
  //Ende innere Klasse

  private BSTNode <ContentType> node;

  public BinarySearchTree() {
    node = null;
  }

  public boolean isEmpty() {
    return node == null;
  }
  
  public void insert(ContentType pContent) {
    if (pContent != null) {
      //
    }
  }
  
  public ContentType search(ContentType pContent) {
    if (isEmpty() || pContent == null) return null;
    return null;
    //
  }
  
  public void remove(ContentType pContent) { 
    if (!isEmpty() && pContent != null ) {
      if (pContent.isLess(getContent())) {
        getLeftTree().remove(pContent);
      } else if (pContent.isGreater(getContent())) {
        getRightTree().remove(pContent);
      } else { //gefunden
        //4 Fälle - kein Nachfolger, ...
      }
    }
  }

  public ContentType getContent() {
    if (isEmpty()) return null; else return node.content;
  }

  public BinarySearchTree <ContentType> getLeftTree() {
    if (isEmpty()) return null; else return node.left;
  }

  public BinarySearchTree <ContentType> getRightTree() {
    if (isEmpty()) return null; else return node.right;
  }
  //Ende offizielle (angepasste) Abiturklasse

  // weitere nützliche Methoden (siehe teils auch BinaryTree)
  //zur Abwechslung alle Traversierungsalgorithmen mit Queue formuliert!
  public void inorder(Queue <ContentType> queue) {
    if (!isEmpty()) { getLeftTree().inorder(queue); queue.enqueue(getContent()); getRightTree().inorder(queue); }
  }

 public void preorder(Queue <ContentType> queue) {
    if (!isEmpty()) { queue.enqueue(getContent()); getLeftTree().preorder(queue); getRightTree().preorder(queue); }
  }
  
  public void postorder(Queue <ContentType> queue) {
     if (!isEmpty()) { getLeftTree().postorder(queue); getRightTree().postorder(queue); queue.enqueue(getContent()); }
  }
  
  public void levelorder(Queue <ContentType> queue) {
    for (int i=1; i<=height(); i++) giveLevel(i, queue);
  }
  
  public void giveLevel(int level, Queue<ContentType> queue) {
    if (!isEmpty()) {
      if (level == 1) queue.enqueue(getContent());
      else { getLeftTree().giveLevel(level-1, queue); getRightTree().giveLevel(level-1, queue); }
    }
  }

  public int number() {
    if (isEmpty()) return 0; else return getLeftTree().number() + 1 + getRightTree().number();
  }
  
  public int height() {
    if (isEmpty()) return 0;  
    else if (getLeftTree().height() > getRightTree().height()) return getLeftTree().height() + 1;
    else return getRightTree().height() + 1;
  }
  
  public ContentType getMinimum() {
    if (isEmpty()) return null;
    return null;
    //
  }
  
  public ContentType getMaximum() {
    if (isEmpty()) return null;
    return null;
    //
  }
}
