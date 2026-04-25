class Solution {
    static int UNVISITED = 0, VISITING = 1, VISITED = 2;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Create adjacency list for graph
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> status = new HashMap<>();    

        for(int i=0; i<numCourses; i++) {
            adj.put(i, new ArrayList<>());
            status.put(i, UNVISITED);
        }

        for (int i=0; i< prerequisites.length; i++) {
            List<Integer> list = adj.get(prerequisites[i][0]);
            list.add(prerequisites[i][1]);
            adj.put(prerequisites[i][0], list);
            status.put(prerequisites[i][0], UNVISITED);
        }
        // System.out.println(status);

        
        for(Integer crs : adj.keySet()) {
            if (!dfs(crs, adj, status))
                return false;
        }
        return true;
    }

    boolean dfs(int crs, Map<Integer, List<Integer>> adj, Map<Integer, Integer> status) {
        // System.out.println("Status = " + status);
        if (status.get(crs) == VISITED) {
            return true;
        }
        if(status.get(crs) == VISITING) {
            return false;
        }
        status.put(crs, VISITING);
        for (int child : adj.get(crs)) {
            if (!dfs(child, adj, status)) {
                return false;
            }
        }
        status.put(crs, VISITED);
        return true;
    }
}

/**
1->2->3
   ->5
**/
