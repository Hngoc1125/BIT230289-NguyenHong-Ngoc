import java.util.*;

public class Chuong5Bai2a {
    private Map<Character, List<Character>> graph;

    public Chuong5Bai2a() {
        graph = new HashMap<>();
    }

    public void addEdge(char u, char v) {
        graph.computeIfAbsent(u, k -> new LinkedList<>()).add(v);
        graph.computeIfAbsent(v, k -> new LinkedList<>()).add(u);
    }

    public void bfs(char start, char target) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        Map<Character, Character> parent = new HashMap<>();
        
        queue.add(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            char current = queue.poll();
            
            if (current == target) {
                printPath(start, target, parent);
                return;
            }
            
            for (char neighbor : graph.getOrDefault(current, new LinkedList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                }
            }
        }
    }
    
    private void printPath(char start, char target, Map<Character, Character> parent) {
        List<Character> path = new ArrayList<>();
        for (char at = target; at != start; at = parent.get(at)) {
            path.add(at);
        }
        path.add(start);
        Collections.reverse(path);
        
        for (char node : path) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Chuong5Bai2a graph = new Chuong5Bai2a();
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'S');
        graph.addEdge('S', 'C');
        graph.addEdge('C', 'D');
        graph.addEdge('C', 'E');
        graph.addEdge('C', 'F');
        graph.addEdge('F', 'G');
        graph.addEdge('G', 'H');
        
        System.out.println("BFS từ A để tìm H:");
        graph.bfs('A', 'H');
    }
}
