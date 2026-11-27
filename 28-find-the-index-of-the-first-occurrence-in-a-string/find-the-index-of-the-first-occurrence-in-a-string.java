class Solution {
    public int strStr(String h, String n) {
        int l = n.length();
        int indx=-1;
        for(int i=0;i<=h.length()-l;i++){
            String st =  h.substring(i,i+l);
            if(st.equals(n)){
                indx=i;
                break;
            }
        }
        return indx;
    }
}