import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Node[] visited = new Node[101];
        Arrays.fill(visited, null);
        Node clone = new Node(node.val);
        dfs(node, visited, clone);
        return clone;
    }

    public void dfs(Node node, Node[] visited, Node clone) {
        visited[clone.val] = clone;
        for (Node neighbor : node.neighbors) {
            if (visited[neighbor.val] == null) {
                Node newN = new Node(neighbor.val);
                clone.neighbors.add(newN);
                dfs(neighbor, visited, newN);
            } else {
                clone.neighbors.add(visited[neighbor.val]);
            }
        }
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}