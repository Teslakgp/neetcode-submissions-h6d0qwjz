class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            int course = pair[0];
            int prereq = pair[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while(!q.isEmpty()){
            int current = q.poll();
            result[index++] = current;

            for(int neighbour : adj.get(current)){
                indegree[neighbour] --;

                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }

        return (index == numCourses)? result : new int[0];
    }
}
