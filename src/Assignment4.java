import java.util.*;

public class Task3_GraphSearch {

    public static void main(String[] args) {
        // Construct the Graph utilizing an Adjacency List
        Map<String, List<String>> adjList = new LinkedHashMap<>();
        adjList.put("A", Arrays.asList("C", "B", "D"));
        adjList.put("B", Arrays.asList("A", "C", "E", "G"));
        adjList.put("C", Arrays.asList("A", "B", "D"));
        adjList.put("D", Arrays.asList("C", "A"));
        adjList.put("E", Arrays.asList("G", "F", "B"));
        adjList.put("F", Arrays.asList("G", "E"));
        adjList.put("G", Arrays.asList("F", "B"));

        System.out.println("DFS Visitation Order: ");
        Set<String> dfsVisited = new LinkedHashSet<>();
        dfs(adjList, "A", dfsVisited);
        System.out.println(String.join(", ", dfsVisited));

        System.out.println("\nBFS Visitation Order: ");
        bfs(adjList, "A");
    }

    // Depth-First Search Algorithm
    public static void dfs(Map<String, List<String>> adjList, String current, Set<String> visited) {
        visited.add(current);
        for (String neighbor : adjList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfs(adjList, neighbor, visited);
            }
        }
    }

    // Breadth-First Search Algorithm
    public static void bfs(Map<String, List<String>> adjList, String start) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println(String.join(", ", visited));
    }
}