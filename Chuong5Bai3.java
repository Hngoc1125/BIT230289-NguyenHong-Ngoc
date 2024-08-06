import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Chuong5Bai3 {
    int V, E;
    Edge[] edge;

    Chuong5Bai3(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge(0, 0, 0);
    }

    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void Union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    void KruskalMST() {
        Edge result[] = new Edge[V];
        int e = 0;
        for (int i = 0; i < V; ++i)
            result[i] = new Edge(0, 0, 0);

        Arrays.sort(edge);

        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        for (int i = 0; i < E; ++i) {
            Edge next_edge = edge[i];
            int x = find(parent, next_edge.src);
            int y = find(parent, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                Union(parent, x, y);
            }
        }

        System.out.println("Các cạnh trong cây khung nhỏ nhất:");
        for (int i = 0; i < e; ++i)
            System.out.println((result[i].src + 1) + " -- " + (result[i].dest + 1) + " == " + result[i].weight);
    }

    public static void main(String[] args) {
        int V = 7;
        int E = 10;
        Chuong5Bai3 graph = new Chuong5Bai3(V, E);

        graph.edge[0] = new Edge(0, 1, 16);  // 1-2
        graph.edge[1] = new Edge(1, 2, 5);   // 2-3
        graph.edge[2] = new Edge(2, 3, 10);  // 3-4
        graph.edge[3] = new Edge(2, 4, 6);   // 3-5
        graph.edge[4] = new Edge(0, 5, 19);  // 1-6
        graph.edge[5] = new Edge(1, 5, 21);  // 2-6
        graph.edge[6] = new Edge(3, 5, 14);  // 4-6
        graph.edge[7] = new Edge(4, 5, 18);  // 5-6
        graph.edge[8] = new Edge(4, 6, 11);  // 5-7
        graph.edge[9] = new Edge(5, 6, 33);  // 6-7

        graph.KruskalMST();
    }
}
