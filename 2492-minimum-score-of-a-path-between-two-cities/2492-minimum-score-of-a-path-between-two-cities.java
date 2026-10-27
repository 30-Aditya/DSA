class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            graph[u].add(new int[]{v, wt});
            graph[v].add(new int[]{u, wt});
        }

        boolean[] visited = new boolean[n + 1];

        return dfs(1, graph, visited, Integer.MAX_VALUE);
    }

    private int dfs(int node, List<int[]>[] graph,
                    boolean[] visited, int score) {

        visited[node] = true;

        for (int[] edge : graph[node]) {
            int next = edge[0];
            int wt = edge[1];

            score = Math.min(score, wt);

            if (!visited[next]) {
                score = dfs(next, graph, visited, score);
            }
        }

        return score;
    }
}