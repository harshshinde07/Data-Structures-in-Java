package graphs;

import java.util.LinkedList;

/**
 * Graph using Adjacency Matrix
 *
 * Functions to implement -
 *
 * BFS
 * DFS
 * Minimum Spanning Tree - Prim's OR Kruskal's
 * Single Source Shortest Path - Dijkstra's
 * Detect Cycle in Directed Graph
 * Detect Cycle in Undirected Graph
 * All Pair Shortest Path - Floyd-Warshall
 * Bellman Ford for -ve Weights
 *
 * Travelling Salesperson Problem*
 * Graph Coloring*
 *
 **/

public class Graph {
    int vertices;
    int [][]mat;

    Graph(int val) {
        vertices = val;
        mat = new int[val+1][val+1];
    }

    public void addEdge(int src, int dest) {
        mat[src][dest] = 1;
        /**
         * for undirected graph add node from dest to src
         */
//        mat[dest][src] = 1;
    }

    public void BFS(int v) {
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.add(v);

        while(queue.size() != 0) {
            int s = queue.poll();
            System.out.print(s + " ");

            for(int i = 0; i < vertices; i++) {
                if(mat[s][i] == 1) {
                    if(!visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }
    }

    public void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for(int i = 0; i < vertices; i++) {
            if(mat[v][i] == 1) {
                if(!visited[i])
                    DFSUtil(i, visited);
            }
        }

    }

    public void DFS(int v) {
        boolean[] visited = new boolean[vertices];
        DFSUtil(v, visited);
    }

    public int getMinKey(int[] key, boolean[] included) {
        int min = Integer.MAX_VALUE, index = -1;

        for (int v = 0; v < vertices; v++)
            if (!included[v] && key[v] < min) {
                min = key[v];
                index = v;
            }
        return index;
    }

    public void printMST(int[] parent) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertices; i++)
            System.out.println(parent[i] + " - " + i + "\t" + mat[i][parent[i]]);
    }

    public void primsMST() {
        /*
         * Array to store constructed MST
         */
        int[] parent = new int[vertices];
        /*
         * Key values used to pick minimum weight edge from a cut
         */
        int[] key = new int[vertices];
        /*
         * Array to keep a track of nodes included in MST
         */
        boolean[] included = new boolean[vertices];
        for(int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            included[i] = false;
        }

        key[0] = 1;
        parent[0] = -1;
        for(int i = 0; i < vertices - 1; i++) {
            int u = getMinKey(key, included);
            included[u] = true;

            for(int v = 0; v < vertices; v++) {
                /*
                 * mat[u][v] is non zero only for adjacent vertices of m
                 * included[v] is false for vertices not yet included in MST
                 * Update the key only if mat[u][v] is smaller than key[v]
                 */
                if (mat[u][v] != 0 && !included[v] && mat[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = mat[u][v];
                }
            }
        }
        printMST(parent);
    }
}
