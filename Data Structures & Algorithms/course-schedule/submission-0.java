
class Solution {
    static class Edge {
        int src, dest;
        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // graph[b] holds the edges b -> a (take b before a)
        ArrayList<Edge>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites) {
            graph[p[1]].add(new Edge(p[1], p[0]));
        }

        // If there is a cycle, we cannot finish all courses
        return !isCycle(graph, numCourses);
    }

    // vis: nodes visited so far (in any DFS)
    // stack: nodes on the current DFS path
    public static boolean isCycle(ArrayList<Edge>[] graph, int V) {
        boolean[] vis = new boolean[V];
        boolean[] stack = new boolean[V];

        // Start a DFS from every unvisited course, so disconnected parts are covered
        for (int i = 0; i < V; i++) {
            if (!vis[i] && isCycleUtil(graph, i, vis, stack)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // The neighbour is still on the current path: we looped back, so there is a cycle
            if (stack[e.dest]) {
                return true;
            }

            // Otherwise explore the neighbour if it is new
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        // Leaving curr: it is no longer on the current path
        stack[curr] = false;
        return false;
    }
}