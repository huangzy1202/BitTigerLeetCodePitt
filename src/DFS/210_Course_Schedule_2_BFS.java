public class Solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        int count = 0;
        int[] ans = new int[numCourses];
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> noRequest = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] item:prerequisites) {
            degree[item[0]]++;
            graph[item[1]].add(item[0]);
        }



        for (int item = 0; item < numCourses; item++) {
            if (degree[item] == 0) {
                result.add(item);
                count++;
                noRequest.add(item);
            }
        }

        while (noRequest.size() != 0) {
            int curCourse = noRequest.poll();
            for (int i = 0; i < graph[curCourse].size(); i++) {
                int nextOne = graph[curCourse].get(i);
                degree[nextOne]--;
                if (degree[nextOne] == 0) {
                    result.add(nextOne);
                    count++;
                    noRequest.add(nextOne);
                }
            }
        }


        if (count >= numCourses) {
            int index = 0;
            for (int item:result) {
                ans[index] = item;
                index++;
            }
            return ans;
        } else {
            return new int[0];
        }
    }
}
