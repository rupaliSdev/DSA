package DSA.Agoogle;

import java.util.*;

class NewBieFaciliator {


    /*Asked in Google full stack screening round: Suppose we have a social network consisting of people and their friends. We call a person a “newbie” if they have exactly one friend. We call a person a “facilitator” if all, except possibly one, of its friends are newbies. A facilitator must have at least one newbie friend. Write an algorithm to find all “facilitators” in a social network. Wasnt able to tell which data structure to use but the interviewer was helpful gave me a example data structure and asked me write the algorithm for finding the facilitators based on that.*/
    public List<Integer> findFacilitators(Map<Integer, List<Integer>> graph) {

        Map<Integer, Integer> degree = new HashMap<>();

        // Step 1: Compute degree
        for (int node : graph.keySet()) {
            degree.put(node, graph.get(node).size());
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: Check facilitator condition
        for (int node : graph.keySet()) {

            List<Integer> neighbors = graph.get(node);

            int newbieCount = 0;

            for (int nei : neighbors) {
                if (degree.get(nei) == 1) {
                    newbieCount++;
                }
            }

            int total = neighbors.size();

            if (newbieCount >= 1 && (total - newbieCount) <= 1) {
                result.add(node);
            }
        }

        return result;
    }
}