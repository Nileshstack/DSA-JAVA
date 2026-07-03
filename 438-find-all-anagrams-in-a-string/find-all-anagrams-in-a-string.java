class Solution {
    public List<Integer> findAnagrams(String s, String p) {
      int pcount[]=new int[26];  
      int scount[]=new int[26]; 
      List<Integer> ans = new ArrayList<>();
      int n= p.length();
      for(int i=0;i<n;i++){
        char ch = p.charAt(i);
        pcount[ch-'a']++;
      }
      //sliding window for scount[]
      for(int i=0;i<s.length();i++){
        scount[s.charAt(i)-'a']++;
        if(i>=p.length()){
            scount[s.charAt(i-p.length())-'a']--;
        }
        if(Arrays.equals(pcount,scount)){
            ans.add(i-p.length()+1);
        }
      }
      return ans;
    }
}