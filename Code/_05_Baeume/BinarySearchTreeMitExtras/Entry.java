package _05_Baeume.BinarySearchTreeMitExtras;

public class Entry implements ComparableContent <Entry> {
  private int wert;
  
  public Entry (int Zahl) {
    wert = Zahl;
  }

  public int getWert() {
    return wert;
  }
  
  public boolean isLess(Entry pContent) {
    return (getWert() < pContent.getWert());
  }
  
  public boolean isEqual(Entry pContent) {
    return (getWert() == pContent.getWert());
  }
  
  public boolean isGreater(Entry pContent) {
   return (getWert() > pContent.getWert());
  }
}