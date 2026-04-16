import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
        int leftWrongIndex = -1;
        int rightWrongIndex = -1;
        int sLength = s.length();
        for(int i=0; i < sLength/2; i++) {
            if(s.charAt(i) != s.charAt(sLength - 1 - i)) {
                leftWrongIndex = i;
                rightWrongIndex = sLength -1 -i;
                break;
            }
        }
        if(leftWrongIndex == -1 && rightWrongIndex == -1) {
            return -1;
        }

        if (checkPalindrome(s.substring(leftWrongIndex + 1, rightWrongIndex + 1))) {
            return leftWrongIndex;
        } else if (checkPalindrome(s.substring(leftWrongIndex, rightWrongIndex))) {
            return rightWrongIndex;
        }

        return -1;
    }

    public static boolean checkPalindrome(String s) {
        int sLength = s.length();
        for(int i=0; i< s.length() /2 ;i ++) {
            if(s.charAt(i) != s.charAt(sLength - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.palindromeIndex(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
