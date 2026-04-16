import java.lang.*;
import java.util.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); 

        while (t-- > 0) {
            String s = sc.nextLine();
            if(isLapindrome(s)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            } 
        }
        sc.close();
    }

    private static boolean isLapindrome(String s) {
        int n = s.length();
        int mid = n / 2;

        int[] left = new int[26];
        int[] right = new int[26];
        
        for (int i = 0; i < mid; i++) {
            left[s.charAt(i) - 'a']++;
        }

        int start = (n % 2 == 0) ? mid : mid + 1;
        for (int i = start; i < n; i++) {
            right[s.charAt(i) - 'a']++;
        }

        return Arrays.equals(left, right);

	}
}
