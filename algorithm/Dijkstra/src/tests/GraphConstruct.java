package tests;

import java.util.Set;
import java.util.HashSet;
import java.util.Collection;

import structure.Node;
import structure.DirectedEdge;
import structure.EdgeWeightedDigraph;

public class GraphConstruct {

  private Node A, B, C, D, E, F;

  private Set<Node> nodes;

  private Collection<DirectedEdge> edgesToConstruct;

  private EdgeWeightedDigraph graph;

  /**
   * construct the graph in directory res/g.png
   */
  public GraphConstruct() {
    edgesToConstruct = new HashSet<DirectedEdge>();

    A = new Node("A");
    B = new Node("B");
    C = new Node("C");
    D = new Node("D");
    E = new Node("E");
    F = new Node("F");

    nodes = new HashSet<Node>();
    nodes.add(A);
    nodes.add(B);
    nodes.add(C);
    nodes.add(D);
    nodes.add(E);
    nodes.add(F);

    edgesToConstruct.add(new DirectedEdge(A, B, 6));
    edgesToConstruct.add(new DirectedEdge(B, A, 6));

    edgesToConstruct.add(new DirectedEdge(A, C, 3));
    edgesToConstruct.add(new DirectedEdge(C, A, 3));

    edgesToConstruct.add(new DirectedEdge(C, B, 2));
    edgesToConstruct.add(new DirectedEdge(B, C, 2));

    edgesToConstruct.add(new DirectedEdge(D, B, 5));
    edgesToConstruct.add(new DirectedEdge(B, D, 5));

    edgesToConstruct.add(new DirectedEdge(C, D, 3));
    edgesToConstruct.add(new DirectedEdge(D, C, 3));

    edgesToConstruct.add(new DirectedEdge(C, E, 4));
    edgesToConstruct.add(new DirectedEdge(E, C, 4));

    edgesToConstruct.add(new DirectedEdge(E, D, 2));
    edgesToConstruct.add(new DirectedEdge(D, E, 2));

    edgesToConstruct.add(new DirectedEdge(F, D, 3));
    edgesToConstruct.add(new DirectedEdge(D, F, 3));

    edgesToConstruct.add(new DirectedEdge(F, E, 5));
    edgesToConstruct.add(new DirectedEdge(E, F, 5));

    graph = new EdgeWeightedDigraph(edgesToConstruct);
  }

  public Collection<DirectedEdge> edgesToConstruct() {
    return this.edgesToConstruct;
  }

  public EdgeWeightedDigraph graph() {
    return this.graph;
  }

  public Set<Node> nodes() {
    return this.nodes;
  }
}
