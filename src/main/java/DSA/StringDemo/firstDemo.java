package DSA.StringDemo;

import java.util.ArrayList;
import java.util.Arrays;

public class firstDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int s =10;
        //literal methods
        String a  ="rupali";
        String b = "rupali" ;
        // a and b are reference variable pointing  "kunal " in a heap
        // all the similar values of strings are not recreated in a pool.
        System.out.println(a ==b);
        System.out.println();
        //pointing two different objects
        String ab = new String("rupali");
        String bc = new String("rupali");
        //using assignment we are comparing hashcodes not coontents
        System.out.println(ab ==bc);
        System.out.println(ab.compareTo(bc));
        System.out.println(ab.equals(bc));
        //indexing
        System.out.println(bc.charAt(0));
        
        ///function overloading -- came function name but different parameter
        //out  object of printstream class
        System.out.println(56);
        System.out.println("rupali");
        System.out.println(new int[] {2,3,4,5,6});
        System.out.println(Arrays.toString(new int[] {2,3,4,5,6}));
        String name =null;
        System.out.println(name);
        //String methods
        String str = "hello how are you";
        System.out.println(str.contains("how")); 
        String s1= str.substring(5);
        System.out.println(s1);
        String s2 = str.substring(2,5);
        System.out.println(s2);
        String s3 = str.replace('h', 'm');
        char[] c = str.toCharArray();
        for(char ch:c) {
        	System.out.print(ch);
        }
        String[] sk = str.split(str) ;
        for(String ch:sk) {
        	System.out.print(ch);
        }
        System.out.println(s1.isEmpty());
        firstDemo has = new firstDemo();
        has.pretyPrinting();
        pretyPrinting();
        Operators();
        StringsObjects();
	}
	 static void pretyPrinting() {
		float c =453.1274f;
		System.out.printf("formatted num  is %.3f", c);
		float a = 453.1274f;
        System.out.printf("Formatted number is %.2f", a);

//      System.out.printf("Pie: %.3f", Math.PI);

      System.out.printf("Hello my name is %s and I am %s", "Kunal", "Cool");
      System.out.println();
	}
	 static void Operators() {
		 System.out.println('a'+'b');
		 System.out.println("a"+"b");
		 System.out.println((char)('a'+1));
		 System.out.println("a"+1);
		 System.out.println("kunal" + new ArrayList<>());
		 System.out.println("kunal"+ new Integer(56));
		 String str = new ArrayList<>() + " " + new Integer(56);
		 
		 System.out.println(str);
		 String name  ="rupali sahu";
		 System.out.println(Arrays.toString(name.toCharArray()));
		 System.out.println(name.toLowerCase());
		 System.out.println(name);
		 System.out.println(name.indexOf(0));
		 System.out.println("      kunal   ".strip());
		 System.out.println(Arrays.toString(name.split( "  ") ));
		 isPalindrome();
	 }

	 
	 static void StringsObjects() {
		 String strs= new String("hello");
		 strs.concat("world");
		 System.out.println(strs);
		 StringBuffer sb = new StringBuffer("hello");
		 sb.append("world");
		 System.out.println(sb + "hey");
		 StringBuilder sb1  = new StringBuilder("Core");
		 sb1.append("Java");
		 sb1.append("jki");
		 System.out.println(sb1 );
	 }
	 
	 
	 static void isPalindrome() {
		 String str1 = "abcdcba";
		 int n = str1.length() -1;
		 int i =0;
		 while( i<=n ) {
			 
			 if (str1.charAt(i)!= (str1.charAt(n))){
				 System.out.println("not a palindrome");
			 }
			 else {
				 i++;
				 n--;
			 }
			 
		 }
		 System.out.println("palindrome");
	 }
	 static boolean isPalin(String str) {
		 
		 int n = str.length() -1;
		 int i =0;
		 for( int j =0 ;j <=n/2;j++ ) {
			 char start =str.charAt(i);
			 if (str.charAt(i)!= (str.charAt(n))){
				 System.out.println("not a palindrome");
				 return true;
			 }
			 else {
				 i++;
				 n--;
			 }
			 
		 }
		 System.out.println("palindrome");
		return false;
	 }
}




