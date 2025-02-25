package io.github.jorelali.utils;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SimpleGraph<T> {
	
	private Map<T, TreeSet<T>> nodes = new TreeMap<>();
	
	public void addNode(T value) {
		nodes.put(value, new TreeSet<>());
	}
	
	public void connect(T node, T other) {
		nodes.get(node).add(other);
	}
	
	public void connectBothWays(T node, T other) {
		connect(node, other);
		connect(other, node);
	}
	
	public Set<T> getConnectedNodes(T node) {
		return nodes.get(node);
	}
	
	public boolean isConnectedTo(T node, T other) {
		return nodes.containsKey(node) && nodes.get(node).contains(other);
	}
	
	public Set<T> getNodes() {
		return nodes.keySet();
	}
	
	public String getPrettyPrint() {
		StringBuilder builder = new StringBuilder("{\n");
		for (T node : nodes.keySet()) {
			builder.append("  " + node + ": " + getConnectedNodes(node) + "\n");
		}
		builder.append("}");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nodes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleGraph other = (SimpleGraph) obj;
		return Objects.equals(nodes, other.nodes);
	}

	@Override
	public String toString() {
		return "Graph [" + nodes + "]";
	}
	
}
