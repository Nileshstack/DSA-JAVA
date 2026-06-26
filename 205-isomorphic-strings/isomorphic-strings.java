class Solution {
    public boolean isIsomorphic(String s, String t) {
      Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(!map.containsKey(ch1)){
                if(!map.containsValue(ch2)){
                    map.put(ch1,ch2);
                }else{
                    return false;
                }
            }else{
                char exist= map.get(ch1);
                if(exist!=ch2){
                    return false;
                }
            }
        }
         return true;
    }
}