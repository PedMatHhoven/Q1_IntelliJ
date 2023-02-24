package _05_Baeume.BinarySearchTreeMitLuecken;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;

import java.util.Random;

public class Controller {
    @FXML private Canvas myCanvas;
    @FXML private TextField tfInorder;
    @FXML private TextField tfPreorder;
    @FXML private TextField tfPostorder;
    @FXML private TextField tfLevelorder;
    @FXML private TextField tfBuildTree;
    @FXML private TextField tfInsert;
    @FXML private TextField tfSearch;
    @FXML private TextField tfSearchAusgabe;
    @FXML private TextField tfRemove;
    @FXML private TextField tfNumber;
    @FXML private TextField tfHeight;
    @FXML private TextField tfMinimum;
    @FXML private TextField tfMaximum;
    private BinarySearchTree<Entry> Baum = new BinarySearchTree();
    private Queue<Entry> queue = new Queue();

    public void btBsp_onClick() {
      Baum = new BinarySearchTree();
      int[] Zahlen = {10, 5, 15, 2, 7, 13, 17, 8, 9, 6, 4, 14, 16, 1, 22, 11, 12};
      for (int i = 0; i < Zahlen.length; i++)  Baum.insert(new Entry(Zahlen[i]));
      paint(myCanvas.getGraphicsContext2D());
    }

    public void btZufall_onClick() {
      Baum = new BinarySearchTree();
      int[] Zahlen = new int[11]; Random rand = new Random();
      for (int i = 0; i < 11; i++) Zahlen[i] = rand.nextInt(7) + 7*i;
      int[] pos = {5, 2, 7, 0, 3, 6, 9, 1, 4, 8, 10};
      for (int i = 0; i < 11; i++) Baum.insert(new Entry(Zahlen[pos[i]]));
      paint(myCanvas.getGraphicsContext2D());
    }

    public void btInorder_onClick() {
      queue = new Queue(); Baum.inorder(queue); tfInorder.setText(AusgabeQueue());
    }

    public void btPreorder_onClick() {
      queue = new Queue(); Baum.preorder(queue); tfPreorder.setText(AusgabeQueue());
    }

    public void btPostorder_onClick() {
      queue = new Queue(); Baum.postorder(queue); tfPostorder.setText(AusgabeQueue());
    }

    public void btLevelorder_onClick() {
      queue = new Queue(); Baum.levelorder(queue); tfLevelorder.setText(AusgabeQueue());
    }

    public String AusgabeQueue() {
      String s = "";
      while (!queue.isEmpty()) { s = s + queue.front().getWert() + " "; queue.dequeue(); }
      return s;
    }

    public void btInsert_onClick() {
      Baum.insert(new Entry(Integer.parseInt(tfInsert.getText())));
      paint(myCanvas.getGraphicsContext2D());
    }

    public void btSearch_onClick() {
      Entry hilfe = new Entry(Integer.parseInt(tfSearch.getText()));
      if (Baum.search(hilfe) == null) tfSearchAusgabe.setText("nicht vorhanden!");
      else tfSearchAusgabe.setText("vorhanden!");
    }

    public void btRemove_onClick() {
      Baum.remove(new Entry(Integer.parseInt(tfRemove.getText())));
      paint(myCanvas.getGraphicsContext2D());
    }

    public void btNumber_onClick() {
      tfNumber.setText("" + Baum.number());
    }

    public void btHeight_onClick() {
      tfHeight.setText("" + Baum.height());
    }

    public void btMinimum_onClick() {
      if (Baum.getMinimum() != null) tfMinimum.setText("" + Baum.getMinimum().getWert());
    }

    public void btMaximum_onClick() {
      if (Baum.getMaximum() != null) tfMaximum.setText("" + Baum.getMaximum().getWert());
    }

    public void btBuildTree_onClick() {
      String[] s = tfBuildTree.getText().split(" ", 0); //aufsplitten an " ", Teile in String-array
      int laenge = s.length;
      int[] Reihe = new int[laenge];
      for (int i  = 0; i < laenge; i++) Reihe[i] = Integer.parseInt(s[i]); //umgewandelt zu Integer-array
      Reihe = bubblesort(Reihe); //sortierte Liste, damit Baum maximal ausgeglichen
      Baum = new BinarySearchTree();
      FuegeEin(Reihe, 0, laenge - 1);
      paint(myCanvas.getGraphicsContext2D());
    }

    public int[] bubblesort(int[] toSort) {
      int temp;
      for(int i = 1; i < toSort.length; i++)
          for(int j = 0; j < toSort.length - i; j++)
              if(toSort[j] > toSort[j+1]) { temp = toSort[j]; toSort[j]=toSort[j+1]; toSort[j+1]=temp; }
      return toSort;
    }

    public void FuegeEin(int[] Feld, int l, int r) {
      //
    }

    public void paint (GraphicsContext g) {
      g.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
      displayTree(g, Baum, 417, 65, 160, 55, 15);
    }

    private void displayTree(GraphicsContext g, BinarySearchTree<Entry> pTree, int x, int y, int hGap, int vGap, int radius) {
      if (!pTree.isEmpty()) {
          g.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
          g.fillText("" + pTree.getContent().getWert(), x - 6, y + 4);
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