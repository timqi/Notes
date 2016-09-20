package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  NodeTest.class,
  DirectedEdgeTest.class,
  EdgeWeightedDigraphTest.class,
  DijkstraTest.class
})
public class AllTests {
}
