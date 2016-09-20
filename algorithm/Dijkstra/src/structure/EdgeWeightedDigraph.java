package structure;

import java.lang.System;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class EdgeWeightedDigraph {

  private Map<Node, Set<DirectedEdge>> adj;

  public EdgeWeightedDigraph(Collection<DirectedEdge> edges) {
    adj = new HashMap<Node, Set<DirectedEdge>>();
    for (DirectedEdge e : edges) {
      addEdge(e);
    }
  }

  /**
   * the vertext count
   */
  public int V() {
    return adj.size();
  }

  /**
   * edge count
   */
  public int E() {
    int result = 0;
    for (Set s : adj.values()) {
      result += s.size();
    }
    return result;
  }

  public void addEdge(DirectedEdge edge) {
    Node from = edge.from();
    addVertex(from);
    Node to = edge.to();
    addVertex(to);

    adj.get(from).add(edge);
  }

  public void addVertex(Node v) {
    if (!adj.containsKey(v)) {
      adj.put(v, new HashSet<DirectedEdge>());
    }
  }

  public Set<DirectedEdge> adj(Node v) {
    return new HashSet<DirectedEdge>(adj.get(v));
  }

  public Set<DirectedEdge> edges() {
    Set<DirectedEdge> edges = new HashSet<DirectedEdge>();
    for (Set<DirectedEdge> vSet : adj.values()) {
      for (DirectedEdge e : vSet) {
        edges.add(e);
      }
    }
    return edges;
  }

  public Set<Node> nodes() {
    return adj.keySet();
  }
}
