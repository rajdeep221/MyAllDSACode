package IGT;

import java.util.*;

public class Graph {
    private class Edge {
        private int src;
        private int des;

        public Edge(int s, int d) {
            this.src = s;
            this.des = d;
        }
    }

    ArrayList<Edge> graph[];
    int V;

    public Graph(int V) {
        this.V = V;
        graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void createGraph(int i, int u, int v) {
        graph[i].add(new Edge(u, v));
    }

    public void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V];
        q.add(s);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }
    }

    // bfs for disconnected graph

    public void disconnectedGraph() {
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                bfs(i, vis);
            }
        }
    }

    public void bfs(int s, boolean vis[]) {

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }
    }

    // dfs

    public void dfs(boolean vis[], int curr) { // O(V+E)
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.des]) {
                dfs(vis, e.des);
            }
        }
    }

    // All paths from source to target

    public void printAllPath(boolean vis[], int curr, String path, int tar) { // O(V^V)
        if (curr == tar) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.des]) {
                vis[curr] = true;
                printAllPath(vis, e.des, path + e.des, tar);
                vis[curr] = false;
            }
        }
    }

    // Print neighbour

    public void printNeighbout(int s) {
        for (int i = 0; i < graph[s].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.des + ", ");
        }
    }

    // Cycle detection in undirected graph

    public boolean isCycleUndirected(boolean vis[], int curr, int par) { // O(E + V)
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.des] && e.des != par) {
                return true;
            } else if (!vis[e.des]) {
                if (isCycleUndirected(vis, e.des, curr)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Cycle detection in directed graph

    public boolean isCycleDirected(boolean vis[], int curr, boolean rec[]) { // O(E + V)
        vis[curr] = true;
        rec[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (rec[e.des]) {
                return true;
            } else if (!vis[e.des]) {
                if (isCycleDirected(vis, e.des, rec)) {
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }

    public boolean checkCycleInGraph() {
        boolean vis[] = new boolean[V];
        boolean rec[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                boolean check = isCycleDirected(vis, i, rec);
                if (check) {
                    return check;
                }
            }
        }
        return false;
    }

    // Topological sorting O(V + E)

    public void topSortUtil(int curr, boolean vis[], Stack<Integer> stack) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.des]) {
                topSortUtil(e.des, vis, stack);
            }

        }

        stack.push(curr);
    }

    public void topSort() {
        boolean vis[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSortUtil(i, vis, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    // Strongly Connected Component in Directed graph
    // Kosaraju's Algorithm O(V + E)

    public void kosarajuAlgo() {
        // step 1 - O(V+E)
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            topSort1(i, vis, s);
        }

        // step 2 - O(V+E)
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); i++) {
                Edge e = graph[i].get(j);
                // e.src(i) -> e.dest(i)
                transpose[e.des].add(new Edge(e.des, e.src));
            }
        }

        // step 3 - O(V+E)
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                dfs1(transpose, curr, vis);
                System.out.println();
            }
        }

    }

    public void topSort1(int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.des]) {
                topSort1(curr, vis, s);
            }
        }

        s.push(curr);
    }

    public void dfs1(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.des]) {
                dfs1(graph, e.des, vis);
            }
        }
    }

    // Bridge in a Graphs using Tarjan's Algorithm - O (V + E)
    // Bridge : - It is an edge whose deletion will increase the no. of component

    public void getBridge() {
        int dt[] = new int[V]; // discovery time array
        int low[] = new int[V]; // lowest discovery time array
        int time = 0;
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs2(i, vis, dt, low, time, -1);
            }
        }
    }

    public void dfs2(int curr, boolean vis[], int dt[], int low[], int time, int par) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.des == par) {
                continue;
            } else if (!vis[e.des]) {
                dfs2(e.des, vis, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[e.des]);
                if (dt[curr] < low[e.des]) {
                    System.out.println("bridge is : " + curr + "---" + e.des);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[e.des]);
            }
        }
    }

    // -> Find Articulation Point using Tarjan's Algorithm
    // -> Articulatio Point : - It is a node whose deletion will increase the no. of
    // components
    // -> Articulatin point is used to find the Vulnerability(weekness) in any
    // newtork system.
    // -> Another approach to find Articulatino point is Naive Algorithm. Here we
    // delete any node one at a time and then check whether the no. of components
    // are incresed or not. Here T(n) = O(V * (V+E))
    // -> There three types of neighbour of a node : -
    // i) Parent : - Here the curr node is traverse from the Parent node. For ex:-
    // if we travel a -> b then a is parent of b
    // ii) Ancestor : - Here the neighbour is already visited but that node is not
    // the parent of the current node
    // iii) Child : - Here the neithboure is unvisited. Means the curr node can
    // traverse to the next node which is unvisited.

    public void getAP() { // O(V + E)
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs3(i, -1, dt, low, vis, time, ap);
            }
        }
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.println("AP :- " + i);
            }
        }
    }

    public void dfs3(int curr, int par, int dt[], int low[], boolean vis[], int time, boolean ap[]) {

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.des;

            if (par == neigh) {
                continue;
            } else if (vis[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                dfs3(neigh, curr, dt, low, vis, time, ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (dt[curr] <= low[neigh] && par != -1) {
                    ap[curr] = true;
                }
                children++;
            }
        }

        if (par == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    public int noOfPahts(int src, int des) {
        boolean visited[] = new boolean[V];
        return noOfPaths(src, des, visited);
    }

    private int noOfPaths(int src, int des, boolean visited[]) {
        if (src == des) {
            return 1;
        }

        visited[src] = true;
        int count = 0;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!visited[e.des]) {
                count += noOfPaths(e.des, des, visited);
            }
        }

        visited[src] = false;
        return count;
    }

}