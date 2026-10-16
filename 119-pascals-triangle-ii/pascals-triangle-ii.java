class Solution {
    public List<Integer> getRow(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> fst= new ArrayList<>();
        fst.add(1);
        res.add(fst);
        if(n==0){
            return res.get(0);
        }
        for(int i=1;i<=n;i++){
            List<Integer> prev= res.get(i-1);
            List<Integer> sub= new ArrayList<>();
           sub.add(1);
           for(int j=0;j<i-1;j++){
             sub.add(prev.get(j)+prev.get(j+1));
           } 
           sub.add(1);
           res.add(sub);
        }
        return res.get(n);
    }
}