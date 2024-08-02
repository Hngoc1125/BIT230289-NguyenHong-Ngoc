import java.util.LinkedList;

public class Chuong5Bai1b {
    private LinkedList<Integer>[] adjacencyList;
    private int numVertices;

    public Chuong5Bai1b(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int from, int to) {
        adjacencyList[from].add(to);
    }

    public void printAdjacencyList() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print((i + 1) + " → [");
            for (int j = 0; j < adjacencyList[i].size(); j++) {
                System.out.print(adjacencyList[i].get(j) + 1);
                if (j < adjacencyList[i].size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Chuong5Bai1b g = new Chuong5Bai1b(6);
        g.addEdge(2 - 1, 1 - 1);
        g.addEdge(2 - 1, 4 - 1);
        g.addEdge(3 - 1, 2 - 1);
        g.addEdge(3 - 1, 6 - 1);
        g.addEdge(4 - 1, 3 - 1);
        g.addEdge(4 - 1, 5 - 1);
        g.addEdge(4 - 1, 6 - 1);
        g.addEdge(5 - 1, 1 - 1);
        g.addEdge(6 - 1, 1 - 1);
        g.addEdge(6 - 1, 2 - 1);
        g.addEdge(6 - 1, 5 - 1);
        
        g.printAdjacencyList();
    }
}
