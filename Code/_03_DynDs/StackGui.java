package _03_DynDs;

import java.awt.*;
import java.awt.event.*;

public class StackGui extends Frame {
  // Anfang Attribute
  private Button btStack = new Button();
  private Button btisEmpty = new Button();
  private Button btpush = new Button();
  private Button btpop = new Button();
  private Button bttop = new Button();
  private Button btKopie = new Button();
  private List list1 = new List();
  private TextField tFisEmpty = new TextField();
  private TextField tFpush = new TextField();
  private TextField tFtop = new TextField();
  private Stack s;
  private TextField tFKlammern = new TextField();
  private TextField tFKopie = new TextField();
  // Ende Attribute
  
  public StackGui(String title) { 
    // Frame-Initialisierung
    super(title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 261; 
    int frameHeight = 449;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Panel cp = new Panel(null);
    add(cp);
    
    // Anfang Komponenten
    btStack.setBounds(24, 24, 75, 25);
    btStack.setLabel("Stack");
    btStack.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btStack_ActionPerformed(evt);
      }
    });
    cp.add(btStack);
    
    btisEmpty.setBounds(24, 72, 75, 25);
    btisEmpty.setLabel("isEmpty");
    btisEmpty.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btisEmpty_ActionPerformed(evt);
      }
    });
    btisEmpty.setEnabled(false);
    cp.add(btisEmpty);
    
    btpush.setBounds(24, 120, 75, 25);
    btpush.setLabel("push");
    btpush.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btpush_ActionPerformed(evt);
      }
    });
    btpush.setEnabled(false);
    cp.add(btpush);
    
    btpop.setBounds(24, 168, 75, 25);
    btpop.setLabel("pop");
    btpop.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btpop_ActionPerformed(evt);
      }
    });
    btpop.setEnabled(false);
    cp.add(btpop);
    
    bttop.setBounds(24, 216, 75, 25);
    bttop.setLabel("top");
    bttop.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bttop_ActionPerformed(evt);
      }
    });
    bttop.setEnabled(false);
    cp.add(bttop);

    list1.setBounds(120, 280, 78, 108);
    cp.add(list1);
    
    tFisEmpty.setBounds(120, 72, 78, 20);
    cp.add(tFisEmpty);
    
    tFpush.setBounds(120, 120, 78, 20);
    cp.add(tFpush);
    
    tFtop.setBounds(120, 216, 78, 20);
    cp.add(tFtop);

    // Ende Komponenten
    setVisible(true);
  } // end of public StackGui
  
  // Anfang Methoden
  public void btStack_ActionPerformed(ActionEvent evt) {                                                       
    s = new Stack <String> (); 
    gibAus();
    btisEmpty.setEnabled(true);
    btpush.setEnabled(true);
    btpop.setEnabled(true);
    bttop.setEnabled(true);
    btKopie.setEnabled(true);
  }
  
  public void btisEmpty_ActionPerformed(ActionEvent evt) {
    if (s.isEmpty()) tFisEmpty.setText("ja - leer!"); else tFisEmpty.setText("nicht leer!");
  } 
  
  public void btpush_ActionPerformed(ActionEvent evt) {
    s.push(tFpush.getText());
    gibAus();
  }
  
  public void btpop_ActionPerformed(ActionEvent evt) {
    s.pop(); 
    gibAus();
  } 
  
  public void bttop_ActionPerformed(ActionEvent evt) {
    tFtop.setText("" + s.top());
  }

  public void btKopie_ActionPerformed(ActionEvent evt) {
    tFKopie.setText(tFKlammern.getText());
  } 
  
  public void gibAus() {
    //Ausgabe �ber Hilfsstack
    Stack s2 = new Stack <String> ();
    list1.removeAll();
    while (!s.isEmpty()){
      //vorderstes Element ausgeben + zwischenspeichern + l�schen
      list1.add("" + s.top());
      s2.push(s.top());
      s.pop();
    }
    //btStack rekonstruieren (und Hilfsstack leeren)
    while (!s2.isEmpty()){
      s.push(s2.top());
      s2.pop();
    } 
  }
  // Ende Methoden
  
  public static void main(String[] args) {
    new StackGui("StackGui");
  }
} // end of class StackGui
