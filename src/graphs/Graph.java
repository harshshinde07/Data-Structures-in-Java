package graphs;

/**
 * Functions to implement -
 *
 *
 **/

public class Graph {
    int vertices;
    int [][]mat;

    Graph(int val) {
        vertices = val;
        mat = new int[val+1][val+1];
    }

    public void addEdges(int src, int dest) {
        mat[src][dest] = 1;
        /**
         * for undirected graph add node from dest to src
         */
        mat[dest][src] = 1;
    }

    public static void main(String []args) {

    }
}
