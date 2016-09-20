package tests;

import structure.Node;
import structure.DirectedEdge;
import org.junit.Test;
import org.junit.Before;

import java.util.Set;
import java.util.HashSet;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class DirectedEdgeTest {

  private DirectedEdge e1, e2;

  @Before
  public void setUp() {
    Node A = new Node("A");
    Node B = new Node("B");
    e1 = new DirectedEdge(A, B, 4);
    e2 = new DirectedEdge(A, B, 4);
  }

  @Test
  public void referenceEqualsTest() {
    assertFalse(e1 == e2);
  }

  @Test
  public void equalsTest() {
    assertTrue(e1.equals(e2));
  }

  @Test
  public void hashCodeTest() {
    assertEquals(e1.hashCode(), e2.hashCode());
  }

  @Test
  public void collectionTest() {
    Set<DirectedEdge> set = new HashSet<DirectedEdge>();
    set.add(e1);
    assertTrue(set.contains(e2));
  }
}
