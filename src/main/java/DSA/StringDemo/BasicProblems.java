package DSA.StringDemo;

public class BasicProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1= "abCdEf";
		System.out.println(toogleString(s1));
		System.out.println("q=test\"><script>alert(\"hello\")</script>".replaceAll("(?i)<script.*?>.*?</script.*?>", ""));
		System.out.println(sortString("rupalisahu"));
        System.out.println(reverseString(s1));
        
        System.out.println(reverse("hello please wake me up"));
	}
private static String reverse(String st) {
		// TODO Auto-generated method stub
		String[] str=st.trim().split(" ");
		StringBuffer sb= new StringBuffer();
		
		for(int i=str.length-1;i>=0;i--) {
			if(i==0) {
				sb.append(str[i]);
				break;
			}
			sb.append(str[i]+" ");
			
		}
		return sb.toString();
	}
private static String reverseString(String s) {
		// TODO Auto-generated method stub
	    String s1= new String();
	    char[] ch =s.toCharArray();
	    int i=0,j=ch.length-1;
	    while(i<=j) {
	    	char t=ch[i];
	    	ch[i]=ch[j];
	    	ch[j]=t;
	    	i++;
	    	j--;
	    }
		return new String(ch);
	}
//given a string which contains only lowercase characters sort the string
	private static String sortString(String s) {
		// TODO Auto-generated method stub
		int[] ch= new int[26];
		String s1= new String();
		for(int i=0;i<s.length();i++) {
			ch[s.charAt(i)-'a']++;
		}
		for(int i=0;i<26;i++) {
			for(int j=0;j<ch[i];j++) {
				s1+=(char)('a'+i);
			}
		}
		return s1;
	}

	private static String toogleString(String s1) {
		// TODO Auto-generated method stub
		String res="";
		for(int i=0;i<s1.length();i++) {
			res=res+(char) (s1.charAt(i) ^(1<<5));
			
		}
		return res;
	}
	
	

}
