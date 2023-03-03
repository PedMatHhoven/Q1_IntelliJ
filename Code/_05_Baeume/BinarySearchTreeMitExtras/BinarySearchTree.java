package _05_Baeume.BinarySearchTreeMitExtras;

public class BinarySearchTree <ContentType extends ComparableContent <ContentType>> {
//aus offizieller Abitur-Vorgabe - allerdings Quelltext ein wenig verändert: "this" gelöscht, teils
//unnötige Klammern entfernt, teils Attributen- durch Methodenaufrufe ersetzt, "remove"
//ohne Hilfsmethoden, ...! außerdem im unteren Teil weitere nützliche Methoden ergänzt!

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
      if (isEmpty()) node = new BSTNode <>(pContent);
      else if (pContent.isLess(getContent())) getLeftTree().insert(pContent);
      else if(pContent.isGreater(getContent())) getRightTree().insert(pContent);
    }
  }
  
  public ContentType search(ContentType pContent) {
    if (isEmpty() || pContent == null) return null;
    else if (pContent.isLess(getContent())) return getLeftTree().search(pContent);
    else if (pContent.isGreater(getContent())) return getRightTree().search(pContent);
    else return pContent;
  }
  
  public void remove(ContentType pContent) { 
    if (!isEmpty() && pContent != null ) {
      if (pContent.isLess(getContent())) {
        getLeftTree().remove(pContent);
      } else if (pContent.isGreater(getContent())) {
        getRightTree().remove(pContent);
      } else { //gefunden
        if (getLeftTree().isEmpty()) {
          if (getRightTree().isEmpty()) { //kein Nachfolger
            node = null; 
          } else { //nur rechts Nachfolger
            node = getRightTree().node; 
          }
        } else if (getRightTree().isEmpty()) { //nur links Nachfolger
          node = getLeftTree().node;
        } else { //links und rechts Nachfolger - suche den nächstgrößten!
          BinarySearchTree <ContentType> tree = getRightTree();
          while (!tree.getLeftTree().isEmpty()) tree = tree.getLeftTree();
          ContentType hilfe = tree.getContent();
          remove(hilfe); //Methode wird rekursiv aufgerufen - sorgt für Nachrücken des Restbaumes
          node.content = hilfe;
        }   
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

  //weitere nützliche Methoden (siehe teils auch BinaryTree)
  public void inorder(Queue <ContentType> queue) { //zur Abwechslung mal mit Queue implementiert!
    if (!isEmpty()) {
      getLeftTree().inorder(queue); queue.enqueue(getContent()); getRightTree().inorder(queue);
    }
  }

  public void preorder(Queue <ContentType> queue) {
    if (!isEmpty()) {
      queue.enqueue(getContent()); getLeftTree().preorder(queue); getRightTree().preorder(queue);
    }
  }
  
  public void postorder(Queue <ContentType> queue) {
     if (!isEmpty()) {
       getLeftTree().postorder(queue); getRightTree().postorder(queue); queue.enqueue(getContent());
     }
  }
  
  public void levelorder(Queue <ContentType> queue) {
    for (int i=1; i<=height(); i++) giveLevel(i, queue);
  }
  
  public void giveLevel(int level, Queue <ContentType> queue) {
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
  
  public ContentType minimum() {
    if (isEmpty()) return null;
    else if (getLeftTree().isEmpty()) return getContent();
    else return getLeftTree().minimum();
  }
  
  public ContentType maximum() {
    if (isEmpty()) return null;
    else if (getRightTree().isEmpty()) return getContent();
    else return getRightTree().maximum();
  }
}