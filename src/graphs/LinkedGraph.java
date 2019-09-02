package graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Graph using Adjacency List
 */

public class LinkedGraph {
    int vertices;
    LinkedList<Integer>[] adj;

    LinkedGraph(int v) {
        vertices = v;
        adj = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adj[src].add(dest);
    }

    public void BFS(int v) {
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.add(v);

        while(queue.size() != 0) {
            int s = queue.poll();
            System.out.print(s + " ");

            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public void DFSUtil(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");

        for (int n : adj[s]) {
            if (!visited[n]) {
                DFSUtil(s, visited);
            }
        }
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[vertices];
        DFSUtil(v, visited);
    }
}
