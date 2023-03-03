package _05_Baeume.BinarySearchTreeMitExtras;

public interface ComparableContent <ContentType> {
  public boolean isGreater(ContentType pContent);
  public boolean isEqual(ContentType pContent);
  public boolean isLess(ContentType pContent);
}
