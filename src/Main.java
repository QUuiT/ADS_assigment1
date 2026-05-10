import java.util.Arrays;
import java.util.*;

public class Main {
    static Map<Character, List<Character>> graph = new HashMap<>();
    public static void main(String[] args) {
        // Task 1
        // DFS visit order:
        // A -> C -> B -> E -> G -> F -> D
        //          A
        //          |
        //          C
        //         / \
        //        B   D
        //       /
        //      E
        //     /
        //    G
        //   /
        //  F
        //
        // DFS algorithm starts from A,
        // and it will go through C into the depth until it reaches a node.
        // Then when F has no unvisited neighbors, DFS backtracks to C,
        // because C still has unvisited neighbor it will visit D.

        // Task 2
        // BFS visit order:
        // A -> C -> B -> D -> E -> G -> F
        //          A
        //       /  |  \
        //      C   B   D
        //         / \
        //        E   G
        //        |
        //        F
        //
        // BFS algorithm starts from A.
        // First, it visits all neighbors of A in the given order:
        // A: C, B, D
        // So C, B, and D are added to the queue.
        // Then BFS checks C.
        // C has neighbors A, B, and D, but all of them are already visited.
        // Then BFS checks B.
        // B has unvisited neighbors E and G, so BFS visits E and G.
        // Then BFS checks D.
        // D has neighbors C and A, but both are already visited.
        // Then BFS checks E.
        // E has neighbors G, F, and B.
        // G and B are already visited, so BFS visits F.
        // After that, G and F have no new unvisited neighbors.

        // Task 3
        // Graph from Task 1
//        createGraph();
//        boolean[] visited = new boolean[7];
//
//        System.out.print("DFS output: ");
//        dfs('A', visited);
//
//        System.out.println();
//
//        System.out.print("BFS output: ");
//        bfs('A');
        // Implementation of methods are below outside the main


        // Task 4
        // Edinburgh -> Stirling -> Perth -> Dundee
        // 50 + 40 + 60 = 150 is the shortest distance from Edinburgh to Dundee
        // Therefore, the shortest path is:
        // Edinburgh -> Stirling -> Perth -> Dundee

        // Task 5
        DijkstraGraph roadNetwork = new DijkstraGraph();

        roadNetwork.createGraph();
        roadNetwork.dijkstra("Edinburgh", "Dundee");
    }

    public static void createGraph() {
        graph.put('A', Arrays.asList('C', 'B', 'D'));
        graph.put('B', Arrays.asList('A', 'C', 'E', 'G'));
        graph.put('C', Arrays.asList('A', 'B', 'D'));
        graph.put('D', Arrays.asList('C', 'A'));
        graph.put('E', Arrays.asList('G', 'F', 'B'));
        graph.put('F', Arrays.asList('G', 'E'));
        graph.put('G', Arrays.asList('F', 'B'));
    }

    public static void dfs(char currentNode, boolean[] visited) {
        int currentIndex = currentNode - 'A';

        visited[currentIndex] = true;
        System.out.print(currentNode + " ");

        for (char neighbor : graph.get(currentNode)) {
            int neighborIndex = neighbor - 'A';

            if (!visited[neighborIndex]) {
                dfs(neighbor, visited);
            }
        }
    }

    public static void bfs(char startNode) {
        boolean[] visited = new boolean[7];
        Queue<Character> queue = new LinkedList<>();

        int startIndex = startNode - 'A';

        visited[startIndex] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            char currentNode = queue.poll();
            System.out.print(currentNode + " ");

            for (char neighbor : graph.get(currentNode)) {
                int neighborIndex = neighbor - 'A';

                if (!visited[neighborIndex]) {
                    visited[neighborIndex] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

}