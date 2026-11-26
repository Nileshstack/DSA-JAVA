class Solution {
    public boolean closeStrings(String w1, String w2) {
      int[] freq1 = new int[26];
      int [] freq2 = new int[26];
      for(int i=0;i<w1.length();i++){
        freq1[w1.charAt(i)-97]++;
      }
      for(int i=0;i<w2.length();i++){
        freq2[w2.charAt(i)-97]++;
      } 
      for(int i=0;i<26;i++){
        if((freq1[i]==0 && freq2[i]!=0) || (freq1[i]!=0 && freq2[i]==0)) return false;
      }
      Arrays.sort(freq1);
      Arrays.sort(freq2);
      if(!Arrays.equals(freq1,freq2)) return false;
      return true;
    }
}