package DSA.graph.cycleDetection.topo;

import java.util.ArrayList;
import java.util.List;

//https://takeuforward.org/data-structure/alien-dictionary-topological-sort-g-26/
public class AlienDictionary {
    public static void main(String[] args) {

        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        String res = findOrder(N,K,dict);
        System.out.println(res);

    }

    private static String findOrder(int n, int k, String[] dict) {


        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0;i<k;i++)adjList.add(new ArrayList<>());
        for(int i =0;i<dict.length-1;i++){
            String w1 = dict[i],w2=dict[i+1];
            int len= Math.min(w1.length(),w1.length());
            int j=0;
            while (j<len){
                if (w1.charAt(j)!=w2.charAt(j)){
                    adjList.get(w1.charAt(j)-'a').add(w2.charAt(j)-'a');
                    break;
                }
                j++;
            }
        }
        List<Integer> sorted = TopoSort.topoWithKahnsApproach(k,adjList);
        if(sorted.size()!=k)return "";
        StringBuilder builder= new StringBuilder();
        for (int c :sorted)builder.append((char) (c+'a'));
       return builder.toString();
       /* List<List<Integer>> adjList= new ArrayList<>();

        for (int i = 0; i < k; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i =0;i<n-1;i++){
            String dic1= dict[i],dict2=dict[i+1];
            int j =0,len= Math.min(dic1.length(),dict2.length());
            while (j<len){
                if(dic1.charAt(j)!=dict2.charAt(j)){
                    adjList.get(dic1.charAt(j)-'a').add(dict2.charAt(j)-'a');
                    break;
                }
                j++;
            }
        }
        List<Integer> orderedList= TopoSort.topoWithKahnsApproach(k,adjList);
        String ans="";
        for(Integer i :orderedList){
            ans=ans+(char)(i+(int)'a');
        }
        return ans;*/
    }

//    Time Complexity: O(N*len)+O(K+E), where N is the number of words in the dictionary, ‘len’ is the length up to the index where the first inequality occurs, K = no. of nodes, and E = no. of edges.
//
//    Space Complexity: O(K) + O(K)+O(K)+O(K) ~ O(4K), O(K) for the indegree array, and O(K) for the queue data structure used in BFS(where K = no.of nodes), O(K) for the answer array and O(K) for the adjacency list used in the algorithm.
//
}
