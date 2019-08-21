package IncomeApp;

public class Main {

  public static void main(String[] args) {
    String[] tasks = {"a", "b", "c"};
    Graph graph = new Graph(tasks);
    graph.addEdge("b", "a");
    graph.addEdge("c", "b");
     graph.addEdge("c", "a");
    if (!graph.isCyclic()) {
      graph.findDependencyOrder();
    } else {
      System.out.println("Error - this is a cyclic dependency");
    }
  }
}
