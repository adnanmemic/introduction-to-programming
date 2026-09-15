public class Graph {

    int[][] adjacencyMatrix;
    String title;

    /**
     * Constructs a Graph with the given title and adjacency matrix.
     *
     * @param title           title of the graph
     * @param adjacencyMatrix adjacency matrix of the graph
     */
    public Graph(String title, int[][] adjacencyMatrix) {

        this.title = title;
        this.adjacencyMatrix = adjacencyMatrix;
        System.out.println("Title: " + title);
        System.out.println("Adjacency Matrix: " + adjacencyMatrix);
    }

    /**
     * Checks whether the graph is symmetric.
     *
     * @return true if the graph is symmetric, otherwise false
     */
    public boolean isSymmetric() {

        if (adjacencyMatrix == null)

            return false;

        for (int i = 0; i < adjacencyMatrix.length; i++) {

            for (int a = 0; a < adjacencyMatrix[i].length; a++) {

                if (adjacencyMatrix[i][a] != adjacencyMatrix[a][i]) {

                    return false;

                }
            }
        }

        return true;
    }

    /**
     * Turns all edges of the graph.
     */
    public void turnEdges() {

        int aktuell = 0; // ist eine Variable zum zwischenspeichern des vorherigen Wertes
        for (int i = 0; i < adjacencyMatrix.length; i++) {

            for (int a = i + 1; a < adjacencyMatrix[i].length; a++) { // a=i+1Damit nicht auf den ursprungswert geändert
                                                                      // wird

                aktuell = adjacencyMatrix[i][a];
                adjacencyMatrix[i][a] = adjacencyMatrix[a][i];
                adjacencyMatrix[a][i] = aktuell;
            }
        }
    }
}
