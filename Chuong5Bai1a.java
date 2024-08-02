public class Chuong5Bai1a {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public Chuong5Bai1a(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int from, int to) {
        adjacencyMatrix[from][to] = 1;
    }

    public void printMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Chuong5Bai1a g = new Chuong5Bai1a(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 5);
        g.addEdge(4, 1);
        g.addEdge(4, 3);
        g.addEdge(5, 2);
        g.addEdge(5, 4);
        
        g.printMatrix();
    }
}
