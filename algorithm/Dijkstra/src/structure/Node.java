package structure;

public class Node implements Cloneable {

  private String m;

  public Node(String m) {
    this.m = m;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Node))
      return false;

    return m.equals(o.toString());
  }

  @Override
  public int hashCode() {
    return m.hashCode();
  }

  @Override
  public String toString() {
    return m;
  }
}
