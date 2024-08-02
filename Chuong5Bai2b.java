import java.util.*;

public class Chuong5Bai2b {
    private Map<Character, List<Character>> graph;
    private Set<Character> visited;

    public Chuong5Bai2b() {
        graph = new HashMap<>();
        visited = new HashSet<>();
    }

    public void addEdge(char u, char v) {
        graph.computeIfAbsent(u, k -> new LinkedList<>()).add(v);
        graph.computeIfAbsent(v, k -> new LinkedList<>()).add(u);
    }

    public boolean dfs(char current, char target) {
        if (current == target) {
            System.out.print(current + " ");
            return true;
        }
        
        visited.add(current);
        System.out.print(current + " → ");
        
        for (char neighbor : graph.getOrDefault(current, new LinkedList<>())) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, target)) {
                    return true;
                }
                System.out.print(current + " → ");
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Chuong5Bai2b graph = new Chuong5Bai2b();
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'S');
        graph.addEdge('S', 'C');
        graph.addEdge('C', 'D');
        graph.addEdge('C', 'E');
        graph.addEdge('C', 'F');
        graph.addEdge('F', 'G');
        graph.addEdge('G', 'H');
        
        System.out.println("DFS từ A để tìm H:");
        if (graph.dfs('A', 'H')) {
            System.out.println("Tìm thấy");
        } else {
            System.out.println("Không tìm thấy");
        }
    }
}
