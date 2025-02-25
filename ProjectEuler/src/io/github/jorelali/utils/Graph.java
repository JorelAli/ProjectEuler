package io.github.jorelali.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Graph<T> {

	public class Node {
		
		T value;
		
		public Node(T value) {
			this.value = value;
		}
		
		public T getValue() {
			return this.value;
		}
		
		public boolean isConnected(Node other) {
			return edges.containsKey(this) && edges.get(this).equals(other);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Objects.hash(value);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			return Objects.equals(value, other.value);
		}

		private Graph getEnclosingInstance() {
			return Graph.this;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
		
	}
	
	public Set<Node> nodes = new HashSet<>();
	public Map<Node, Node> edges = new HashMap<>();
	
	public Node makeNode(T value) {
		Node node = new Node(value);
		nodes.add(node);
		return node;
	}
	
	public void connect(Node node, Node other) {
		edges.put(node, other);
	}

	@Override
	public int hashCode() {
		return Objects.hash(edges, nodes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Graph other = (Graph) obj;
		return Objects.equals(edges, other.edges) && Objects.equals(nodes, other.nodes);
	}

	@Override
	public String toString() {
		return "Graph [nodes=" + nodes + ", edges=" + edges + "]";
	}
	
}
