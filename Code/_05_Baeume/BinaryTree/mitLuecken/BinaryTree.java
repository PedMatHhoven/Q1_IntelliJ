package _05_Baeume.BinaryTree.mitLuecken;

//offizielle Abiturklasse (im 1. Teil - weiter unten ergänzt durch nützliche Methoden!)
public class BinaryTree <ContentType> {
  //innere Klasse (Wurzelknoten)
  private class BTNode {
    private ContentType content;
    private BinaryTree <ContentType> left, right;

    public BTNode(ContentType pContent) {
      content = pContent;
      left = new BinaryTree <>();
      right = new BinaryTree <>();
    }
  }
  //Ende innere Klasse

  private BTNode node; //ein Baum besteht aus einer Wurzel (mit Teilbäumen - s.o.)

  public BinaryTree() { //Konstruktor 1
    node = null;
  }

  public BinaryTree(ContentType pContent) { //Konstruktor 2
    if (pContent != null) node = new BTNode(pContent); else node = null;
  }

  public BinaryTree(ContentType pContent, BinaryTree <ContentType> pLeftTree, BinaryTree <ContentType> pRightTree) { //Konstruktor 3
    if (pContent != null) {
      node = new BTNode(pContent);
      if (pLeftTree != null) node.left = pLeftTree; else node.left = new BinaryTree <>();
      if (pRightTree != null) node.right = pRightTree; else node.right = new BinaryTree <>();
    } else node = null;
  }

  public boolean isEmpty() {
    return node == null;
  }

  public void setContent(ContentType pContent) {
    //
  }

  public ContentType getContent() {
    return null;
  }

  public void setLeftTree(BinaryTree <ContentType> pTree) {
    if (!isEmpty() && pTree != null) node.left = pTree;
  }

  public void setRightTree(BinaryTree <ContentType> pTree) {
    //
  }

  public BinaryTree <ContentType> getLeftTree() {
    return null; //für das Zeichnen vonnöten!
  }

  public BinaryTree<ContentType> getRightTree() {
    return null; //für das Zeichnen vonnöten!
  }
  //Ende offizielle Abiturklasse

  //sinnvolle Erweiterungen (für jeden Binärbaum!)
  public String inorder() {
    return "";
  }

  public String preorder() {
    return "";
  }

  public String postorder() {
    return "";
  }

 /*public String levelorderMitQueue() {
  //unten eine Version ohne Queue (rekursiv mit 2 Methoden)
  //untere ist kürzer, speichert aber durch Rekursion auch Zwischenwerte auf Stack!
  //diese hier ist evtl. etwas intuitiver/ leichter nachzuvollziehen!
    String s;
    Queue <BinaryTree <ContentType>> q = new Queue <>();
    s = "";
    q.enqueue(this);
    while (!q.isEmpty()) {
      BinaryTree <ContentType> tree = q.front();
      s = s + tree.getContent() + " ";
      if (!tree.getLeftTree().isEmpty()) {
        q.enqueue(tree.getLeftTree());
      }
      if (!tree.getRightTree().isEmpty()) {
        q.enqueue(tree.getRightTree());
      }
      q.dequeue();
    }
    return s;
  } */

  public String levelorder(){
    String s = "";
    for (int i=1; i<=height(); i++) s = s + giveLevel(i);
    return s;
  }

  private String giveLevel(int level) {
    if (isEmpty()) return "";
    else if (level == 1) return getContent() + " ";
    else return getLeftTree().giveLevel(level - 1) + getRightTree().giveLevel(level - 1);
  }

  public int number() {
    return 0;
  }

  public int height() {
    return 0;
  }
}