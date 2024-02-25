import java.io.*;
import java.util.*;

public class GraphRelations {
    private int n; // number of vertices
    private boolean[][] adjMatrix; // adjacency matrix

    public GraphRelations(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        n = Integer.parseInt(reader.readLine());
        adjMatrix = new boolean[n][n];
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            String[] edge = reader.readLine().split(" ");
            int v = Integer.parseInt(edge[0]) - 1;
            int u = Integer.parseInt(edge[1]) - 1;
            adjMatrix[v][u] = true;
        }
        reader.close();
    }

    public boolean isReflexive() {
        for (int i = 0; i < n; i++) {
            if (!adjMatrix[i][i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isAntisymmetric() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] && adjMatrix[j][i] && i != j) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        GraphRelations gr = new GraphRelations("src/graph.txt");
        System.out.println("Is reflexive: " + gr.isReflexive());
        System.out.println("Is antisymmetric: " + gr.isAntisymmetric());
    }
}
