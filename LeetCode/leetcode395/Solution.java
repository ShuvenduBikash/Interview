package leetcode395;

import java.util.ArrayList;

public class Solution {

    public int longestSubstring(String s, int k) {
        if(s==null||s.length()==0||s.length()<k) return 0;
        if(k<=1) return s.length();
        int n=s.length();
        int[] count=new int[26];
        int max=0;
        for(int i=0;i<n;i++){
            count[s.charAt(i)-'a']++;
        }
        ArrayList<Integer> pos=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(count[s.charAt(i)-'a']<k) pos.add(i);
        }
        if(pos.size()==0) return n;
        pos.add(0,-1);
        pos.add(n);
        for(int i=1;i<pos.size();i++){
            int start=pos.get(i-1)+1;
            int end=pos.get(i);
            max=Math.max(max,longestSubstring(s.substring(start,end),k));
        }
        return max;
    }
}