package _05_Baeume.BinaryTree.mitLuecken;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import java.util.Random;

public class Controller {
    @FXML private Canvas myCanvas;
    @FXML private TextField tfInorder;
    @FXML private TextField tfInfix;
    @FXML private TextField tfPreorder;
    @FXML private TextField tfPostorder;
    @FXML private TextField tfLevelorder;
    @FXML private TextField tfAnzahl;
    @FXML private TextField tfHoehe;
    @FXML private TextField tfErgebnis;
    @FXML private TextField tfInfixBaum;
    @FXML private TextField tfPraefixBaum;
    @FXML private TextField tfPostfixBaum;
    private BinaryTree Baum = new BinaryTree();
    private BinaryTree Baum1, Baum2;
    private String Term;

    public void btTerm_onClick() {
      Baum1 = new Termbaum("*", new Termbaum("5"), new Termbaum("11"));
      Baum2 = new Termbaum("/", new Termbaum("18"), new Termbaum("12"));
      Baum = new Termbaum("-", Baum1, Baum2);
      Baum1 = new Termbaum("+", new Termbaum("4"), new Termbaum("7"));
      Baum = new Termbaum("*", Baum, Baum1);
      paint(myCanvas.getGraphicsContext2D());
    }

    public void btBsp_onClick() {
      Baum = new BinaryTree(9, new BinaryTree(8), new BinaryTree());
      Baum = new BinaryTree(12, Baum, new BinaryTree(13));
      Baum = new BinaryTree(7, new BinaryTree(3), Baum);
      Baum1 = new BinaryTree(23, new BinaryTree(22), new BinaryTree(25));
      Baum2 = new BinaryTree(41, new BinaryTree(31), new BinaryTree());
      Baum1 = new BinaryTree(27, Baum1, Baum2);
      Baum = new BinaryTree(15, Baum, Baum1);
      paint(myCanvas.getGraphicsContext2D());
    }

    public void btZufall_onClick() {
      int[] a = new int[10];
      for (int i=0; i<=9 ; i++) {
          Random rand = new Random();
          a[i] = rand.nextInt(7)+7*i;
      }
      Baum = new BinaryTree(a[1], new BinaryTree(a[0]), new BinaryTree(a[2]));
      Baum1 = new BinaryTree(a[5], new BinaryTree(a[4]), new BinaryTree());
      Baum2 = new BinaryTree(a[8], new BinaryTree(a[7]), new BinaryTree(a[9]));
      Baum2 = new BinaryTree(a[6], Baum1, Baum2);
      Baum = new BinaryTree(a[3], Baum, Baum2);
      paint(myCanvas.getGraphicsContext2D());
    }

    public void btInorder_onClick() {
      tfInorder.setText(Baum.inorder());
    }

    public void btInfix_onClick() {
      if (Baum instanceof Termbaum) tfInfix.setText(((Termbaum) Baum).infix());
      else tfInfix.setText("nur Termbäume!");
    }

    public void btPreorder_onClick() {
      tfPreorder.setText(Baum.preorder());
    }

    public void btPostorder_onClick() {
      tfPostorder.setText(Baum.postorder());
    }

    public void btLevelorder_onClick() {
      tfLevelorder.setText(Baum.levelorder());
    }

    public void btAnzahl_onClick() {
      tfAnzahl.setText("" + Baum.number());
    }

    public void btHoehe_onClick() {
      tfHoehe.setText("" + Baum.height());
    }

    public void btErgebnis_onClick() {
      if (Baum instanceof Termbaum) tfErgebnis.setText("" + Math.round(100.0*((Termbaum) Baum).Ergebnis())/100.0);
      else tfErgebnis.setText("nur TB");
    }

    public Termbaum InfixZuTermbaum() {
    //vielleicht mal mit Parameter Term im Prozedurkopf kurz probieren!?
      int i,j,k,l,m,n;
      String t;
      Termbaum b;
      if (Term.charAt(0) == '(') {
        b = new Termbaum("");
        Term = Term.substring(1);
        b.setLeftTree(InfixZuTermbaum());
        b.setContent(Term.substring(0,1));
        Term = Term.substring(1);
        b.setRightTree(InfixZuTermbaum());
        Term = Term.substring(1);
      }
      else {
        i = 100;
        j = Term.indexOf('+'); if ((j > 0) && (j < i)) i = j;
        k = Term.indexOf('-'); if ((k > 0) && (k < i)) i = k;
        l = Term.indexOf('*'); if ((l > 0) && (l < i)) i = l;
        m = Term.indexOf('/'); if ((m > 0) && (m < i)) i = m;
        n = Term.indexOf(')'); if ((n > 0) && (n < i)) i = n;
        t = Term.substring(0,i);
        Term = Term.substring(i);
        b = new Termbaum(t);
      }
      return b;
    }

    public void btInfixBaum_onClick() {
      Term = tfInfixBaum.getText();
      Baum = InfixZuTermbaum();
      paint(myCanvas.getGraphicsContext2D());
    }

    public Termbaum PraefixZuTermbaum() {
      int i;
      String t, h;
      Termbaum b;
      i = Term.indexOf(" ");
      t = Term.substring(0,i);
      Term = Term.substring(i+1);
      h = t.substring(0,1);
      b = new Termbaum("");
      if (h.equals("+") || h.equals("-") || h.equals("*") || h.equals("/")) {
        b.setLeftTree(PraefixZuTermbaum());
        b.setRightTree(PraefixZuTermbaum());
        b.setContent(t);
      }
      else {
        b.setContent(t);
      }
      return b;
    }

    public void btPraefixBaum_onClick() {
      //Term ist global deklariert, weil in java kein call-by-reference möglich,
      //aber Term muss sich bei jedem rekursiven Aufruf obiger Methode
      //PraefixZuTermbaum mit verändern!
      Term = tfPraefixBaum.getText();
      Baum = PraefixZuTermbaum();
      paint(myCanvas.getGraphicsContext2D());
    }

    public Termbaum PostfixZuTermbaum() {
      int i, j;
      String t,h;
      Termbaum b = new Termbaum();
      Termbaum[] hilfe = new Termbaum[10];
      j = 0;
      while (Term.indexOf(" ") != -1) {
        i = Term.indexOf(" ");
        t = Term.substring(0,i);
        Term = Term.substring(i+1);
        h = t.substring(0,1);
        if (h.equals("+") || h.equals("-") || h.equals("*") || h.equals("/")) {
          b = new Termbaum(t);
          b.setLeftTree(hilfe[j-2]);
          b.setRightTree(hilfe[j-1]);
          hilfe[j-2] = b;
          j--;
        }
        else {
          b = new Termbaum(t);
          hilfe[j] = b;
          j++;
        }
      }
      return b;
    }

    public void btPostfixBaum_onClick() {
      Term = tfPostfixBaum.getText();
      Baum = PostfixZuTermbaum();
      paint(myCanvas.getGraphicsContext2D());
    }

    public void paint (GraphicsContext g) {
      g.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
      displayTree(g, Baum, 417, 65, 160, 55, 15);
    }

    private void displayTree(GraphicsContext g, BinaryTree pTree, int x, int y, int hGap, int vGap, int radius) {
      if (!pTree.isEmpty()) {
          g.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
          g.fillText("" + pTree.getContent(), x - 6, y + 4);
          if (!pTree.getLeftTree().isEmpty()) {
            Child(g, 'l', x - hGap, y + vGap, x, y, vGap, radius);
            displayTree(g, pTree.getLeftTree(), x - hGap, y + vGap, hGap / 2, vGap, radius);
          }
          if (!pTree.getRightTree().isEmpty()) {
            Child(g, 'r', x + hGap, y + vGap, x, y, vGap, radius);
            displayTree(g, pTree.getRightTree(), x + hGap, y + vGap, hGap / 2, vGap, radius);
          }
      }
    }

    private void Child(GraphicsContext g, char child, int x1, int y1, int x2, int y2, int vGap, int radius) {
      double d = Math.sqrt(vGap * vGap + (x2 - x1) * (x2 - x1));
      int x11, x21, y11, y21;
      if (child == 'l')  {
        x11 = (int)(x1 + radius * (x2 - x1) / d);
        x21 = (int)(x2 - radius * (x2 - x1) / d);
      }
      else {
        x11 = (int)(x1 - radius * (x1 - x2) / d);
        x21 = (int)(x2 + radius * (x1 - x2) / d);
      }
      y11 = (int)(y1 - radius * vGap / d);
      y21 = (int)(y2 + radius * vGap / d);
      g.strokeLine(x11, y11, x21, y21);
    }
}