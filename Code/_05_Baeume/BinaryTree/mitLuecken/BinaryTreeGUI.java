package _05_Baeume.BinaryTree.mitLuecken;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class BinaryTreeGUI extends Frame {
  // Anfang Attribute
  private Button btTerm = new Button();
  private Button btSuch = new Button();
  private Button btSuch1 = new Button();
  private Button btInorder = new Button();
  private Button btPreorder = new Button();
  private Button btPostorder = new Button();
  private Button btLevelorder = new Button();
  private TextField tfInorder = new TextField();
  private TextField tfPreorder = new TextField();
  private TextField tfPostorder = new TextField();
  private TextField tfLevelorder = new TextField();
  private Button btInfix = new Button();
  private TextField tfInfix = new TextField();
  private Button btErgebnis = new Button();
  private Button btAnzahl = new Button();
  private Button btHoehe = new Button();
  private Button btInfixBaum = new Button();
  private Button btPostfixBaum = new Button();
  private Button btPraefixBaum = new Button();
  private TextField tfInfixBaum = new TextField();
  private TextField tfPraefixBaum = new TextField();
  private TextField tfPostfixBaum = new TextField();
  private TextField tfErgebnis = new TextField();
  private TextField tfAnzahl = new TextField();
  private TextField tfHoehe = new TextField();
  private MyPanel cp = new MyPanel();
  private BinaryTree Baum = new BinaryTree();
  private BinaryTree Baum1, Baum2, Baum3;
  private String Term;
  // Ende Attribute
  
  public BinaryTreeGUI(String title) { 
    // Frame-Initialisierung
    super(title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 835; 
    int frameHeight = 529;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(true);
    add(cp);
    // Anfang Komponenten
    btTerm.setBounds(120, 8, 123, 25);
    btTerm.setLabel("Bsp-Termbaum");
    btTerm.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btTerm_ActionPerformed(evt);
      }
    });
    btTerm.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(btTerm);
    btSuch.setBounds(592, 8, 123, 25);
    btSuch.setLabel("Bsp-Suchbaum");
    btSuch.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btSuch_ActionPerformed(evt);
      }
    });
    btSuch.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(btSuch);
    btInorder.setBounds(16, 328, 99, 25);
    btInorder.setLabel("inorder");
    btInorder.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btInorder_ActionPerformed(evt);
      }
    });
    btInorder.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(btInorder);
    btPreorder.setBounds(16, 392, 99, 25);
    btPreorder.setLabel("preorder");
    btPreorder.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btPreorder_ActionPerformed(evt);
      }
    });
    btPreorder.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(btPreorder);
    btPostorder.setBounds(16, 424, 99, 25);
    btPostorder.setLabel("postorder");
    btPostorder.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btPostorder_ActionPerformed(evt);
      }
    });
    btPostorder.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(btPostorder);
    btLevelorder.setBounds(16, 456, 99, 25);
    btLevelorder.setLabel("levelorder");
    btLevelorder.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btLevelorder_ActionPerformed(evt);
      }
    });
    btLevelorder.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(btLevelorder);
    tfInorder.setBounds(128, 328, 278, 28);
    tfInorder.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(tfInorder);
    tfPreorder.setBounds(128, 392, 278, 28);
    tfPreorder.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(tfPreorder);
    tfPostorder.setBounds(128, 424, 278, 28);
    tfPostorder.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(tfPostorder);
    tfLevelorder.setBounds(128, 456, 278, 28);
    tfLevelorder.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(tfLevelorder);
    btInfix.setBounds(16, 360, 99, 25);
    btInfix.setLabel("infix");
    btInfix.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btInfix_ActionPerformed(evt);
      }
    });
    btInfix.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(btInfix);
    tfInfix.setBounds(128, 360, 278, 28);
    tfInfix.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(tfInfix);
    btErgebnis.setBounds(416, 360, 99, 25);
    btErgebnis.setLabel("Ergebnis");
    btErgebnis.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btErgebnis_ActionPerformed(evt);
      }
    });
    btErgebnis.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(btErgebnis);
    btAnzahl.setBounds(416, 328, 99, 25);
    btAnzahl.setLabel("Anzahl");
    btAnzahl.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btAnzahl_ActionPerformed(evt);
      }
    });
    btAnzahl.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(btAnzahl);
    btHoehe.setBounds(616, 328, 59, 25);
    btHoehe.setLabel("Höhe");
    btHoehe.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btHoehe_ActionPerformed(evt);
      }
    });
    btHoehe.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(btHoehe);
    btInfixBaum.setBounds(416, 392, 99, 25);
    btInfixBaum.setLabel("Infix-Baum");
    btInfixBaum.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btInfixBaum_ActionPerformed(evt);
      }
    });
    btInfixBaum.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(btInfixBaum);
    btPostfixBaum.setBounds(416, 456, 99, 25);
    btPostfixBaum.setLabel("Postfix-Baum");
    btPostfixBaum.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btPostfixBaum_ActionPerformed(evt);
      }
    });
    btPostfixBaum.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(btPostfixBaum);
    btPraefixBaum.setBounds(416, 424, 99, 25);
    btPraefixBaum.setLabel("Präfix-Baum");
    btPraefixBaum.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btPraefixBaum_ActionPerformed(evt);
      }
    });
    btPraefixBaum.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(btPraefixBaum);
    tfInfixBaum.setBounds(528, 392, 278, 28);
    tfInfixBaum.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(tfInfixBaum);
    tfPraefixBaum.setBounds(528, 424, 278, 28);
    tfPraefixBaum.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(tfPraefixBaum);
    tfPostfixBaum.setBounds(528, 456, 278, 28);
    tfPostfixBaum.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(tfPostfixBaum);
    tfErgebnis.setBounds(528, 360, 54, 28);
    tfErgebnis.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(tfErgebnis);
    tfAnzahl.setBounds(528, 328, 54, 28);
    tfAnzahl.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(tfAnzahl);
    tfHoehe.setBounds(624, 360, 46, 28);
    tfHoehe.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(tfHoehe);
    btSuch1.setBounds(592, 40, 123, 25);
    btSuch1.setLabel("Zufallssuchbaum");
    btSuch1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btSuch1_ActionPerformed(evt);
      }
    });
    btSuch1.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(btSuch1);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public BinaryTreeGUI
  
  // Anfang Methoden
  public void btTerm_ActionPerformed(ActionEvent evt) {
    /*Baum1 = new Termbaum(new String("5"));
    Baum2 = new Termbaum(new String("11"));
    Baum2 = new Termbaum(new String("*"), Baum1, Baum2);
    Baum1 = new Termbaum(new String("18"));
    Baum3 = new Termbaum(new String("12"));
    Baum3 = new Termbaum(new String("/"), Baum1, Baum3);
    Baum = new Termbaum(new String("-"), Baum2, Baum3);
    Baum1 = new Termbaum(new String("4"));
    Baum2 = new Termbaum(new String("7"));
    Baum2 = new Termbaum(new String("+"), Baum1, Baum2);
    Baum = new Termbaum(new String("*"), Baum, Baum2);
    cp.repaint();*/
  } 
  
  public void btSuch_ActionPerformed(ActionEvent evt) {
    Baum1 = new BinaryTree(3);
    Baum2 = new BinaryTree(8);
    Baum2 = new BinaryTree(9, Baum2, new BinaryTree());
    Baum3 = new BinaryTree(13);
    Baum3 = new BinaryTree(12, Baum2, Baum3);
    Baum = new BinaryTree(7, Baum1, Baum3);
    Baum1 = new BinaryTree(22);
    Baum2 = new BinaryTree(25);
    Baum3 = new BinaryTree(23, Baum1, Baum2);
    Baum1 = new BinaryTree(31);
    Baum2 = new BinaryTree(41, Baum1, new BinaryTree());
    Baum3 = new BinaryTree(27, Baum3, Baum2);
    Baum = new BinaryTree(15, Baum, Baum3);
    cp.repaint();
  } 
  
  public void btSuch1_ActionPerformed(ActionEvent evt) {
    int[] a = new int[10];
    for (int i=0; i<=9 ; i++) {
      Random rand = new Random();
      a[i] = rand.nextInt(7)+7*i;
    }
    Baum1 = new BinaryTree(a[0]);
    Baum2 = new BinaryTree(a[2]);
    Baum = new BinaryTree(a[1], Baum1, Baum2);
    Baum1 = new BinaryTree(a[4]);
    Baum2 = new BinaryTree();
    Baum1 = new BinaryTree(a[5], Baum1, Baum2);
    Baum2 = new BinaryTree(a[7]);
    Baum3 = new BinaryTree(a[9]);
    Baum3 = new BinaryTree(a[8], Baum2, Baum3);
    Baum3 = new BinaryTree(a[6], Baum1, Baum3);
    Baum = new BinaryTree(a[3], Baum, Baum3);
    cp.repaint();
  }
  
  public void btInorder_ActionPerformed(ActionEvent evt) {
    tfInorder.setText(Baum.inorder());
  } 
  
  public void btPreorder_ActionPerformed(ActionEvent evt) {
    tfPreorder.setText(Baum.preorder());
  } 
  
  public void btPostorder_ActionPerformed(ActionEvent evt) {
    tfPostorder.setText(Baum.postorder());
  } 
  
  public void btLevelorder_ActionPerformed(ActionEvent evt) {
    tfLevelorder.setText(Baum.levelorder());
  } 
  
  public void btInfix_ActionPerformed(ActionEvent evt) {
    //if (Baum instanceof Termbaum) tfInfix.setText(((Termbaum) Baum).infix()); else tfInfix.setText("nur Termbäume!");
  } 
  
  public void btErgebnis_ActionPerformed(ActionEvent evt) {
    //if (Baum instanceof Termbaum) tfErgebnis.setText("" + Math.round(100.0*((Termbaum) Baum).Ergebnis())/100.0);
    //else tfErgebnis.setText("nur TB");
  } 
  
  public void btAnzahl_ActionPerformed(ActionEvent evt) {
    tfAnzahl.setText("" + Baum.number());
  } 
  
  public void btHoehe_ActionPerformed(ActionEvent evt) {
    tfHoehe.setText("" + Baum.height());
  } 
  
  public BinaryTree InfixZuTermbaum() {
    return null;
  }
 
  public void btInfixBaum_ActionPerformed(ActionEvent evt) {
    /*Term = tfInfixBaum.getText();
    Baum = InfixZuTermbaum();
    cp.repaint();*/
  }
 
  public BinaryTree PostfixZuTermbaum() {
    return null;
  }
  
  public void btPostfixBaum_ActionPerformed(ActionEvent evt) {
    /*Term = tfPostfixBaum.getText();
    Baum = PostfixZuTermbaum();
    cp.repaint();*/
  } 
  
  public BinaryTree PraefixZuTermbaum() {
    return null;
  }

  public void btPraefixBaum_ActionPerformed(ActionEvent evt) {
    //Term ist global deklariert, weil in java kein call-by-reference möglich,
    //aber Term muss sich bei jedem rekursiven Aufruf obiger Methode 
    //PraefixZuTermbaum mit verändern!
    /*Term = tfPraefixBaum.getText();
    Baum = PraefixZuTermbaum();
    cp.repaint();*/
  } 
  
  public static void main(String[] args) {
    new BinaryTreeGUI("BinaryTreeGUI");
  } 
  
  class MyPanel extends Panel {
    public MyPanel(){
      super(null);
    }
    
    public void paint (Graphics g){
      displayTree(g, Baum, 417, 65, 160, 55, 15);
    }
    
    private void displayTree(Graphics g, BinaryTree pTree, int x, int y, int hGap, int vGap, int radius) {
      if (!pTree.isEmpty()) {
        g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        g.drawString("" + pTree.getContent(), x - 6, y + 4);
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
    
    private void Child(Graphics g, char child, int x1, int y1, int x2, int y2, int vGap, int radius) { 
      double d = Math.sqrt(vGap * vGap + (x2 - x1) * (x2 - x1));
      int x11, x21, y11, y21;
      if (child == 'l')  {
        x11 = (int)(x1 + radius * (x2 - x1) / d);
        x21 = (int)(x2 - radius * (x2 - x1) / d);
      }
      else  {
        x11 = (int)(x1 - radius * (x1 - x2) / d);
        x21 = (int)(x2 + radius * (x1 - x2) / d);
      }
      y11 = (int)(y1 - radius * vGap / d);
      y21 = (int)(y2 + radius * vGap / d);            
      g.drawLine(x11, y11, x21, y21);
    }
  } 
  // Ende Methoden
}
