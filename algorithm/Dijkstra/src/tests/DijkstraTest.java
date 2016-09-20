package tests;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.lang.System;
import java.util.List;
import java.util.LinkedList;

import dijkstra.Dijkstra;
import structure.Node;
import structure.DirectedEdge;

import java.lang.System;

public class DijkstraTest {

  private Dijkstra dijkstra;

  private GraphConstruct gs;

  @Before
  public void setUp() {
    gs = new GraphConstruct();
    dijkstra = new Dijkstra(gs.graph(), new Node("A"));
  }

  @Test
  public void distToTest() {
    assertEquals(5, dijkstra.distTo(new Node("B")));
    assertEquals(3, dijkstra.distTo(new Node("C")));
    assertEquals(6, dijkstra.distTo(new Node("D")));
    assertEquals(7, dijkstra.distTo(new Node("E")));
    assertEquals(9, dijkstra.distTo(new Node("F")));
  }

  @Test
  public void pathToTest() {
    List<DirectedEdge> pathToF = dijkstra.pathTo(new Node("F"));
    List<DirectedEdge>actualPathToF = new LinkedList<DirectedEdge>();
    actualPathToF.add(new DirectedEdge(new Node("A"), new Node("C")));
    actualPathToF.add(new DirectedEdge(new Node("C"), new Node("D")));
    actualPathToF.add(new DirectedEdge(new Node("D"), new Node("F")));

    assertEquals(pathToF, actualPathToF);
  }

  @Test
  public void hasPathToTest() {
    for (Node node : gs.nodes()) {
      assertTrue(dijkstra.hasPathTo(node));
    }
    assertFalse(dijkstra.hasPathTo(new Node("AA")));
  }
}
