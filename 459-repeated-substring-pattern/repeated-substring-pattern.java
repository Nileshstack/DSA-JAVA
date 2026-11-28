class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for(int i=1;i<=l/2;i++){
            if(l%i==0){
                int times = l/i;
                StringBuilder sb = new StringBuilder("");
                String rep = s.substring(0,i); 
                while(times>0){
                    sb.append(rep);
                    times--;
                }
                if(sb.toString().equals(s)){
                    return true;
                }
            }
           
        }
         return false;
    }
}