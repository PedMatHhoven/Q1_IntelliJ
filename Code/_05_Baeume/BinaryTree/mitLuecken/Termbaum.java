package _05_Baeume.BinaryTree.mitLuecken;

public class Termbaum extends BinaryTree <String> {
  public Termbaum() {
    super();
  }

  public Termbaum(String pContent) {
   super(pContent);
  }

  public Termbaum(String pContent, BinaryTree <String> pLeftTree, BinaryTree <String> pRightTree) {
    super(pContent, pLeftTree, pRightTree);
  }
  
  public String infix() {
    if (!isEmpty()) {
      if (getContent().equals("+") || getContent().equals("-") || getContent().equals("*") || getContent().equals("/")) {
        return "(" + ((Termbaum) getLeftTree()).infix()
        + getContent()
        + ((Termbaum) getRightTree()).infix() + ")";
      } 
      else return "" + getContent();  
    } 
    else return ""; 
  }
  
  public double Ergebnis() {
    if (getContent().equals("+")) 
    return ((Termbaum) getLeftTree()).Ergebnis() + ((Termbaum) getRightTree()).Ergebnis();
    else if (getContent().equals("-"))
    return ((Termbaum) getLeftTree()).Ergebnis() - ((Termbaum) getRightTree()).Ergebnis();
    else if (getContent().equals("*")) 
    return ((Termbaum) getLeftTree()).Ergebnis() * ((Termbaum) getRightTree()).Ergebnis();
    else if (getContent().equals("/"))
    return ((Termbaum) getLeftTree()).Ergebnis() / ((Termbaum) getRightTree()).Ergebnis();
    else return Double.parseDouble(getContent());
  }
}
