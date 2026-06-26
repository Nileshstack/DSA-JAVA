class Solution {
    public boolean isHappy(int n) {
       Set <Integer> set = new HashSet<>();
       while(true){
        int sq=square(n);
        if(sq==1){
            return true;
        }
        if(set.contains(sq)){
            return false;
        }
            set.add(sq);
            n=sq;
       }
      // return true; 
    }
    public int square(int m){
        int sum=0;
        while(m>0){
           int r=m%10;
            sum+=r*r;
            m=m/10;
        }
        return sum;
    }
}