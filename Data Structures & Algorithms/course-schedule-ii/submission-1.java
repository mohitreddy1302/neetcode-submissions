
class Solution {
    static class Edge {
        int src, dest;
        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: build the graph
        ArrayList<Edge>[] graph = buildGraph(numCourses, prerequisites);

        // Step 2: if there is a cycle, no valid order exists
        if (hasCycle(graph, numCourses)) {
            return new int[0];
        }

        // Step 3: put the courses on a stack in topological order
        Stack<Integer> s = topSort(graph, numCourses);

        // Step 4: pop the stack into an array
        return stackToArray(s, numCourses);
    }

    // Step 1: create the adjacency list, with edge b -> a for each [a, b]
    static ArrayList<Edge>[] buildGraph(int numCourses, int[][] prerequisites) {
        ArrayList<Edge>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites) {
            graph[p[1]].add(new Edge(p[1], p[0]));
        }
        return graph;
    }

    // Step 2: cycle check
    static boolean hasCycle(ArrayList<Edge>[] graph, int V) {
        boolean[] vis = new boolean[V];
        boolean[] onPath = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i] && cycleUtil(graph, i, vis, onPath)) {
                return true;
            }
        }
        return false;
    }

    static boolean cycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] onPath) {
        vis[curr] = true;
        onPath[curr] = true;

        for (Edge e : graph[curr]) {
            // Neighbour is still on the current path: cycle
            if (onPath[e.dest]) return true;
            if (!vis[e.dest] && cycleUtil(graph, e.dest, vis, onPath)) return true;
        }

        onPath[curr] = false;
        return false;
    }

    // Step 3: topological sort
    static Stack<Integer> topSort(ArrayList<Edge>[] graph, int V) {
        boolean[] vis = new boolean[V];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }
        return s;
    }

    static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;

        // Finish all courses that curr leads to first
        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }

        // Then curr goes on top of them
        s.push(curr);
    }

    // Step 4: pop the stack into an array
    static int[] stackToArray(Stack<Integer> s, int n) {
        int[] order = new int[n];
        int idx = 0;
        while (!s.isEmpty()) {
            order[idx++] = s.pop();
        }
        return order;
    }
}