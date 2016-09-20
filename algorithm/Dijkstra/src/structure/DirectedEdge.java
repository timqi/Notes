package structure;

public class DirectedEdge {

  private int mWeight;

  private Node mNodeFrom;

  private Node mNodeTo;

  public DirectedEdge(Node from, Node to) {
    this(from, to, 0);
  }

  public DirectedEdge(Node from, Node to, int weight) {
    this.mNodeFrom = from;
    this.mNodeTo = to;
    this.mWeight = weight;
  }

  public int weight() {
    return mWeight;
  }

  public Node from() {
    return mNodeFrom;
  }

  public Node to() {
    return mNodeTo;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof DirectedEdge))
      return false;

    DirectedEdge e = (DirectedEdge) o;
    return (
        mNodeFrom.equals(e.from()) &&
        mNodeTo.equals(e.to())
      );
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + mNodeFrom.hashCode();
    result = 31 * result + mNodeTo.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return mNodeFrom.toString() + "→" + mNodeTo.toString();
  }

}
