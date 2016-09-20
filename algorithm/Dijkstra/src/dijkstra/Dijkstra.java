package dijkstra;

import structure.Node;
import structure.DirectedEdge;
import structure.EdgeWeightedDigraph;

import java.lang.Integer;
import java.lang.Iterable;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class Dijkstra {

  private Map<Node, Integer> dist;

  private Map<Node, DirectedEdge> prev;

  public Dijkstra(EdgeWeightedDigraph g, Node srcNode) {

    dist = new HashMap<Node, Integer>();
    prev = new HashMap<Node, DirectedEdge>();
    for (Node node : g.nodes()) {
      if (node.equals(srcNode)) {
        dist.put(node, 0);
      } else {
        dist.put(node, Integer.MAX_VALUE);
      }
      prev.put(node, null);
    }

    Set<Node> mappedNodes = new HashSet<Node>();
    Set<Node> unmappedNodes = new HashSet<Node>(g.nodes());

    while (!unmappedNodes.isEmpty()) {
      Node mapping = null; int minDist = Integer.MAX_VALUE;
      for (Node unode : unmappedNodes) {
        int d = dist.get(unode);
        if (d < minDist) {
          minDist = d;
          mapping = unode;
        }
      }
      unmappedNodes.remove(mapping);
      int distToMapping = dist.get(mapping);
      for (DirectedEdge edge : g.adj(mapping)) {
        Node edgeTo = edge.to();
        if (distToMapping + edge.weight() < dist.get(edgeTo)) {
          dist.put(edgeTo, distToMapping + edge.weight());
          prev.put(edgeTo, edge);
        }
      }
    }
  }

  public int distTo(Node dstNode) {
    return dist.get(dstNode);
  }

  public boolean hasPathTo(Node dstNode) {
    if (!dist.containsKey(dstNode)) return false;
    return dist.get(dstNode) < Integer.MAX_VALUE;
  }

  public List<DirectedEdge> pathTo(Node dstNode) {
    List<DirectedEdge> result = new LinkedList<DirectedEdge>();
    DirectedEdge edge;
    while ( (edge = prev.get(dstNode)) != null) {
      result.add(0, edge);
      dstNode = edge.from();
    }
    return result;
  }
}
