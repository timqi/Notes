package tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Set;
import java.util.HashSet;
import java.util.Collection;

import structure.Node;
import structure.DirectedEdge;
import structure.EdgeWeightedDigraph;

public class EdgeWeightedDigraphTest {

  private Collection<DirectedEdge> edgesToConstruct;

  private EdgeWeightedDigraph graph;

  private GraphConstruct gs;

  @Before
  public void setUp() {
    gs = new GraphConstruct();
    this.edgesToConstruct = gs.edgesToConstruct();
    this.graph = gs.graph();
  }

  @Test
  public void constructTest() {
    assertEquals(6, graph.V());
    assertEquals(9*2, graph.E());
    assertEquals(edgesToConstruct, graph.edges());

    Node D = new Node("D");
    Node B = new Node("B");
    Node C = new Node("C");
    Node E = new Node("E");
    Node F = new Node("F");
    Set<DirectedEdge> edgesFromD = new HashSet<DirectedEdge>();
    edgesFromD.add(new DirectedEdge(D, B, 5));
    edgesFromD.add(new DirectedEdge(D, C, 3));
    edgesFromD.add(new DirectedEdge(D, E, 2));
    edgesFromD.add(new DirectedEdge(D, F, 3));

    assertEquals(edgesFromD, graph.adj(D));

    Set<Node> nodes = new HashSet<Node>();
    nodes.add(B);
    nodes.add(C);
    nodes.add(D);
    nodes.add(E);
    nodes.add(F);
    nodes.add(new Node("A"));

    assertEquals(nodes, graph.nodes());
  }

}
