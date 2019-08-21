package IncomeApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Graph {

	private Map<String, List<String>> adjecency = null;

	private String[] tasks = null;

	public Graph(String[] tasks) {
		this.tasks = tasks;
		adjecency = new HashMap<String, List<String>>();
		
		for (int i = 0; i < tasks.length; i++)
			adjecency.put(tasks[i], new ArrayList<String>());
	}

	public void addEdge(String source, String dest) {
		adjecency.get(source).add(dest);
	}

	public boolean isCyclic() {

		Set<String> visited = new HashSet<String>();
		Set<String> recStack = new HashSet<String>();

		for (int i = 0; i < tasks.length; i++)
			if (isCyclicUtil(tasks[i], visited, recStack))
				return true;

		return false;
	}

	private boolean isCyclicUtil(String task, Set<String> visited, Set<String> recStack) {

		if (recStack.contains(task))
			return true;

		if (visited.contains(task))
			return false;

		visited.add(task);
		recStack.add(task);

		List<String> children = adjecency.get(task);

		for (String child : children)
			if (isCyclicUtil(child, visited, recStack))
				return true;

		recStack.remove(task);
		return false;
	}

	public List<String> findDependencyOrder() {
		Stack<String> stack = new Stack<String>();

		Set<String> visited = new HashSet<String>();

		for (int i = 0; i < tasks.length; i++)
			if (!visited.contains(tasks[i]))
				findDependencyOrderUtil(tasks[i], visited, stack);

		List<String> finalList = new ArrayList<String>();
		while (stack.empty() == false)
			finalList.add(stack.pop());
		return finalList;
	}

	private void findDependencyOrderUtil(String v, Set<String> visited, Stack<String> stack) {
		visited.add(v);
		String i;

		Iterator<String> it = adjecency.get(v).iterator();
		while (it.hasNext()) {
			i = it.next();
			if (!visited.contains(i))
				findDependencyOrderUtil(i, visited, stack);
		}

		stack.push(v);
	}

}
