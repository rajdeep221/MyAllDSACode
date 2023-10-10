package IGT;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class CreationGraph {
    private class Edge {
        private int src;
        private int des;
        private int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.wt = w;
        }
    }

    private ArrayList<Edge> graph[];
    private int V;

    public CreationGraph(int V) {
        this.V = V;
        graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    // Creating a graph

    public void createGraph(int u, int v, int w) {
        graph[u].add(new Edge(u, v, w));
    }

    public void printNeighbout(int s) {
        for (int i = 0; i < graph[s].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.des + ", " + e.wt);
        }
    }

    // Dijkstra's Algorithm -> It is a greedy algorithm O(E + E log V)
    // Limitation :- Not work for negative weight

    private static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int n, int d) {
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist; // To sort in ascending order according to distance
            // return p2.dist - this.dist; To sort in descending order according to distance
        }
    }

    public void dijkstra(int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[V];

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.des;
                    if (dist[u] + e.wt < dist[v]) {
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.println("distace of " + i + " from " + src + " is " + dist[i]);
        }
    }

    // Bellman Ford Algorithm O(E.V)
    // Limitation :- Not work for Negative Weight Cycle

    public void bellManFord(int src) {
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int k = 0; k < V - 1; k++) { // O(V)
            // O(E)
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.des;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {
                        dist[v] = dist[u] + e.wt;
                    }
                }
            }
        }

        // To check negative weight cycle

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                int u = e.src;
                int v = e.des;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {
                    System.out.println("Negative wt cycle");
                    return;
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    // Minimum Spanning Tree (MST) :- It is for undirected, connected and weighted
    // graph
    // Prim's Algorithm

    private class Pair1 implements Comparable<Pair1> {
        int node;
        int cost;

        public Pair1(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair1 p2) {
            return this.cost - p2.cost; // ascending order
        }
    }

    public void primsAlgo() {
        PriorityQueue<Pair1> pq = new PriorityQueue<>(); // non-mst
        boolean vis[] = new boolean[V]; // mst
        pq.add(new Pair1(0, 0));

        int mstCost = 0;

        while (!pq.isEmpty()) {
            Pair1 curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                System.out.print(curr.node);
                mstCost += curr.cost;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if (!vis[e.des]) {
                        pq.add(new Pair1(e.des, e.wt));
                    }
                }
            }
        }

        System.out.println("\nmin cost of mst = " + mstCost);
    }

}