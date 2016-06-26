public class Solution {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        int count = 0;
        Queue<Integer> noRequest = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] item:prerequisites) {
            degree[item[0]]++;
            graph[item[1]].add(item[0]);
        }



        for (int item = 0; item < numCourses; item++) {
            // System.out.println(item+"'s degree "+degree[item]);
            if (degree[item] == 0) {
                // System.out.println(item+" has no request");
                count++;
                noRequest.add(item);
            }
        }

        while (noRequest.size() != 0) {
            int curCourse = noRequest.poll();
            // System.out.println("check course "+curCourse);
            for (int i = 0; i < graph[curCourse].size(); i++) {
                int nextOne = graph[curCourse].get(i);
                // System.out.println("next one "+nextOne + " "+degree[nextOne]);
                degree[nextOne]--;
                if (degree[nextOne] == 0) {
                    // System.out.println(nextOne+"become no request");
                    count++;
                    noRequest.add(nextOne);
                }
            }
        }


        if (count >= numCourses) {
            return true;
        } else {
            return false;
        }
    }
}
