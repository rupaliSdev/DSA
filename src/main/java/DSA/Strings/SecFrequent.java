package DSA.Strings;

import java.util.HashMap;

public class SecFrequent {
    String secFrequent(String arr[], int N) {
        // your code here
        HashMap<String,Integer> map = new HashMap<>();
        int max=0,smax=0;
        for(String a :arr){
            map.put(a,map.getOrDefault(a,0)+1);
            if(max<map.get(a)) max = map.get(a);
            else if (smax<map.get(a)) smax = map.get(a);
        }

        for(String s :map.keySet()){
            if(map.get(s)== smax) return s;
        }
        return "";
    }
}
