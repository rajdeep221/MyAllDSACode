package Recursion;

import java.util.*;

public class FordFulkerson { // Create the class
    private int[][] resGra;
    private boolean[] visited;
    private int[] parent;
    private int[][] graph;
    private int S, T;

    public FordFulkerson(int n) { // Declare the size of the graph
        graph = new int[n + 2][n + 2];
        visited = new boolean[n + 2];
        parent = new int[n + 2];
        resGra = new int[n + 2][n + 2];
        S = 0;
        T = n;
    }

    public void createGraph(int a[], int b[], int p[][], int n) { // Create the graph
        for (int i = 0; i < n; i++) {
            if (a[i] > b[i]) {
                addEdge(S, i + 1, a[i]);
            } else {
                addEdge(i + 1, n, b[i]);
            }

            if (i > 0) {
                addEdge(i + 1, i, p[i][i - 1]);
            }

            if (i < n - 1) {
                addEdge(i + 1, i + 2, p[i][i + 1]);
            }
        }
    }

    public void addEdge(int src, int dst, int cost) { // Add edges to the graph
        graph[src][dst] = cost;
    }

    public void fordFulkerson() { // Perform Ford-Fulkerson Algorithm
        fordFulkerson(graph, S, T);
    }

    private void fordFulkerson(int[][] graph, int src, int sink) {
        int ver = graph.length;
        resGra = new int[ver][ver];
        for (int i = 0; i < ver; i++) {
            for (int j = 0; j < ver; j++) {
                resGra[i][j] = graph[i][j];
            }
        }

        visited = new boolean[ver];
        parent = new int[ver];

        while (bfs(src, sink)) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = sink; v != src; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, resGra[u][v]);
            }

            for (int v = sink; v != src; v = parent[v]) {
                int u = parent[v];
                resGra[u][v] -= pathFlow;
                resGra[v][u] += pathFlow;
            }
        }
    }

    private boolean bfs(int src, int sink) { // Perform bfs for the Ford-Fulkerson Algorithm
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;
        parent[src] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < visited.length; v++) {
                if (!visited[v] && resGra[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[sink];
    }

    public ArrayList<Integer> getNodeConnectedToSource() { // Find Nodes that are connected to the source
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < visited.length - 1; i++) {
            if (visited[i]) {
                list.add(i - 1);
            }
        }
        return list;
    }

    public ArrayList<Integer> getNodeConnectedToSink() { // Find Nodes that are connected to the sink
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < visited.length - 1; i++) {
            if (!visited[i]) {
                list.add(i - 1);
            }
        }

        return list;
    }

    public static void main(String[] args) {

        FordFulkerson ob = new FordFulkerson(4);
        int a[] = { 1, 3, 3, 1 }; // Likelihood of i to become foreground
        int b[] = { 3, 1, 1, 3 }; // Likelihood of i to become background
        int p[][] = { // Panalty for the neightbouring nodes
                { 0, 0, 0, 0 },
                { 2, 0, 0, 0 },
                { 0, 2, 0, 2 },
                { 0, 0, 0, 0 }
        };
        ob.createGraph(a, b, p, 4);
        ob.fordFulkerson();

        ArrayList<Integer> foreGround = ob.getNodeConnectedToSource();
        ArrayList<Integer> backGround = ob.getNodeConnectedToSink();

        System.out.println("The forground pixels are " + foreGround.toString());
        System.out.println("The background pixels are " + backGround.toString());
    }
}
