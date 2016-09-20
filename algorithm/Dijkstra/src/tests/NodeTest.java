package tests;

import structure.Node;
import org.junit.Test;
import org.junit.Before;

import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class NodeTest {

  private Node n1, n2;

  @Before
  public void setUp() {
    n1 = new Node("Node");
    n2 = new Node("Node");
  }

  @Test
  public void referenceEqualsTest() {
    assertFalse(n1 == n2);
  }

  @Test
  public void equalsTest() {
    assertTrue(n1.equals(n2));
  }

  @Test
  public void hashCodeTest() {
    assertEquals(n1.hashCode(), n2.hashCode());
  }

  @Test
  public void collectionTest() {
    Map<Node, Object> map = new HashMap<Node, Object>();
    map.put(n1, null);
    assertTrue(map.containsKey(n2));
  }

}
