package DSA.Agoogle;


import java.util.*;

/*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.*/


/*[a.b.c, v.k.f, a.b, k.f, a.b.c.d, v.k]
[10,     15,    40,  20    5.      15]

if any string is substring (starting from index 0) of any other string present in our list then.. the value of that string is discarded
give sum of all the values which wont get discarded

string will always be a single carater with singe dot (.)
aaaa.dd
a.d


15 +20 + 5*/
public class test {
    public static void main(String[] args) {




    }

    /*public  boolean isCoursesPossible(int numCourses,int[][] prerequisites){

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0 ;i<prerequisites.length;i++){
            adjList.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] course :prerequisites){
            adjList.get(course[0]).add(course[1]);
            inDegree[course[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i =0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        int completedCourse =0;
        while (!queue.isEmpty()){
            int x = queue.poll();
            for(int n : adjList.get(x)){
                inDegree[n]--;
                if(inDegree[n]==0){
                    queue.offer(n);
                }
            }
        }
        return completedCourse==numCourses;
    }*/

    class  TrieNode{

        boolean isEnd = false;
        Map<Character,TrieNode> childrens = new HashMap<>();
        int value =0;
    }
    public void  insert(String character,int value){


    }
    public  int findValue(String[] strings,int[] values){
        int sum =0;
        for(int i =0;i<strings.length;i++){

        }

        return 0;
    }

}
