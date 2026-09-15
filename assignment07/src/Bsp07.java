public class Bsp07 {

    public static void main(String[] args) {

        // ------------------------Part1-------------------------------
        // create Graph Method
        System.out.println(createGraph(8));

        // addEdge Graph
        System.out.println(addEdge(createGraph(8), 0, 1));

        // isComplete Method
        System.out.println(isComplete(createGraph(8)));

        // missingEdges Method
        System.out.println(missingEdges(createGraph(8)));

        // maxDegree Method
        System.out.println(maxDegree(createGraph(8)));

        // isPath Method
        System.out.println(isPath(createGraph(8), new int[] { 1, 2 }));

        // ------------------------Part2-------------------------------

        // directNeighbors Method
        System.out.println(directNeighbors(createGraph(8), 5));
    }

    ////// PART 1
    /**
     * Creates an empty graph with the given order.
     *
     * @param order number of nodes
     * @return adjacency matrix of a graph with order nodes, or null if
     *         order is > 9 or <= 0.
     */
    public static int[][] createGraph(int order) {

        if (order < 1 || order >= 10)
            return null;

        int zeile = order;
        int spalte = order;

        int[][] leererGraph = new int[zeile][spalte];

        for (int i = 0; i < leererGraph.length; i++) {

            for (int a = 0; a < leererGraph[i].length; a++) {

                leererGraph[i][a] = 0;
            }
        }

        return leererGraph;
    }

    /**
     * Adds an edge to the graph.
     *
     * @param graph adjacency matrix of the graph
     * @param src   source node
     * @param dst   destination node
     * @return true if the edge was added or was already present, false if
     *         the edge could not be added (e.g., because src or dst are invalid,
     *         or src is equal to dst, or the graph is null).
     */
    public static boolean addEdge(int[][] graph, int src, int dst) {

        if (graph == null || dst == src || dst >= graph.length || dst < 0 || src < 0 || src >= graph.length)

            return false;

        graph[src][dst] = 1;
        return true;

    }

    /**
     * Returns true if, and only if, the graph is complete.
     *
     * @param graph adjacency matrix of the graph
     * @return true if the graph is complete, false otherwise
     */
    public static boolean isComplete(int[][] graph) {

        if (graph == null)

            return false;

        for (int i = 0; i < graph.length; i++) {

            for (int a = 0; a < graph[i].length; a++) {

                if (i != a) {

                    if (graph[i][a] != 1)

                        return false;

                }
            }
        }

        return true;
    }

    /**
     * Returns the number of missing edges in the graph.
     *
     * @param graph adjacency matrix of the graph
     * @return number of missing edges, or -1 if graph is null
     */
    public static int missingEdges(int[][] graph) {

        if (graph == null)

            return -1;

        int missing = 0;
        for (int i = 0; i < graph.length; i++) {

            for (int a = 0; a < graph[i].length; a++) {

                if (i != a) {

                    if (graph[i][a] != 1)

                        missing++;

                }
            }
        }

        return missing;
    }

    /**
     * Returns the maximum degree of the graph.
     *
     * @param graph adjacency matrix of the graph
     * @return maximum degree of the graph, or -1 if graph is null
     */
    public static int maxDegree(int[][] graph) {

        if (graph == null)

            return -1;

        int maxDeg = 0, absolutDeg = 0;
        for (int i = 0; i < graph.length; i++) {

            maxDeg = 0;
            for (int a = 0; a < graph[i].length; a++) {

                if (i != a) {

                    if (graph[i][a] == 1)

                        maxDeg++;

                }
            }
            if (maxDeg > absolutDeg) {

                absolutDeg = maxDeg;

            }
        }

        return absolutDeg;
    }

    /**
     * Returns true if, and only if, the path is present in the graph.
     *
     * @param graph adjacency matrix of the graph
     * @param path  array of nodes
     * @return true if the path exists, false otherwise
     */
    public static boolean isPath(int[][] graph, int[] path) {

        if (graph == null)

            return false;

        for (int i = 0; i < graph.length; i++) {

            for (int a = 0; a < graph[i].length; a++) {

                if (i != a) {

                    for (int b = 0; b < path.length; b++)

                        if (b + 1 < path.length && graph[path[b]][path[b + 1]] != 1) // Verbindung zwischen path[b] für
                                                                                     // Wert1 und path[b+1] für Wert2
                                                                                     // path[b] --> Zeile, path[b+1] -->
                                                                                     // Spalte
                            return false;

                }
            }
        }

        return true;
    }

    ////// PART 2
    /**
     * Returns the direct neighbors of a node, in ascending order.
     *
     * The direct neighbors of a node are all nodes that are directly
     * reachable from that node.
     *
     * @param graph adjacency matrix of the graph
     * @param node  node for which the direct neighbors are to be returned
     * @return array of nodes that are directly reachable from the given node,
     *         or null if the node is invalid
     */
    public static int[] directNeighbors(int[][] graph, int node) {

        if (graph == null || node < 0 || node >= graph.length)

            return null;

        // Anzahl der nachbarn ermitteln
        int anzahlNachbarn = 0, zahl = 0;
        for (int i = 0; i < graph[node].length; i++) {

            if (graph[node][i] == 1) {

                anzahlNachbarn++;
            }
        }

        // die ermittelte Anzahl der Nachbarn ist die Länge des zurückliefernden arrays
        int[] nachbarn = new int[anzahlNachbarn];
        for (int a = 0; a < graph[node].length; a++) {

            if (graph[node][a] == 1) {

                nachbarn[zahl] = a;
                zahl++;
            }
        }

        return nachbarn;
    }
}
