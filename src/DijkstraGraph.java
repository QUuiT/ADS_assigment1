import java.util.*;

public class DijkstraGraph {

    static class Edge {
        String city;
        int distance;

        Edge(String city, int distance) {
            this.city = city;
            this.distance = distance;
        }
    }

    static class NodeDistance {
        String city;
        int distance;

        NodeDistance(String city, int distance) {
            this.city = city;
            this.distance = distance;
        }
    }

    private Map<String, List<Edge>> graph = new HashMap<>();

    public void createGraph() {
        graph.put("Glasgow", new ArrayList<>());
        graph.put("Stirling", new ArrayList<>());
        graph.put("Perth", new ArrayList<>());
        graph.put("Edinburgh", new ArrayList<>());
        graph.put("Dundee", new ArrayList<>());

        addRoad("Glasgow", "Stirling", 50);
        addRoad("Glasgow", "Edinburgh", 70);
        addRoad("Stirling", "Perth", 40);
        addRoad("Stirling", "Edinburgh", 50);
        addRoad("Perth", "Edinburgh", 100);
        addRoad("Perth", "Dundee", 60);
    }

    private void addRoad(String city1, String city2, int distance) {
        graph.get(city1).add(new Edge(city2, distance));
        graph.get(city2).add(new Edge(city1, distance));
    }

    public void dijkstra(String startCity, String targetCity) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previousCity = new HashMap<>();

        for (String city : graph.keySet()) {
            distances.put(city, Integer.MAX_VALUE);
            previousCity.put(city, null);
        }

        distances.put(startCity, 0);

        PriorityQueue<NodeDistance> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(node -> node.distance)
        );

        priorityQueue.add(new NodeDistance(startCity, 0));

        while (!priorityQueue.isEmpty()) {
            NodeDistance current = priorityQueue.poll();
            String currentCity = current.city;

            if (current.distance > distances.get(currentCity)) {
                continue;
            }

            for (Edge edge : graph.get(currentCity)) {
                String neighborCity = edge.city;
                int newDistance = distances.get(currentCity) + edge.distance;

                if (newDistance < distances.get(neighborCity)) {
                    distances.put(neighborCity, newDistance);
                    previousCity.put(neighborCity, currentCity);
                    priorityQueue.add(new NodeDistance(neighborCity, newDistance));
                }
            }
        }

        printShortestPath(startCity, targetCity, distances, previousCity);
    }

    private void printShortestPath(
            String startCity,
            String targetCity,
            Map<String, Integer> distances,
            Map<String, String> previousCity
    ) {
        List<String> path = new ArrayList<>();

        String currentCity = targetCity;

        while (currentCity != null) {
            path.add(currentCity);
            currentCity = previousCity.get(currentCity);
        }

        Collections.reverse(path);

        System.out.println("Shortest path from " + startCity + " to " + targetCity + ":");

        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));

            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
        System.out.println("Shortest distance: " + distances.get(targetCity));
    }
}