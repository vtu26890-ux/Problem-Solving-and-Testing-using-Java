class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int size= s.length();
        String a  = s.substring(1, size) + s.substring(0, size - 1);
        return a.contains(s);
    }
}