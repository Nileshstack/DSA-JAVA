class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n==0) return result;
        List<Integer> first = new ArrayList<>();
        first.add(1);//for first top list
        result.add(first);//add this in final list
        if(n==1) return result;//edge case is n==1
        for(int i=1;i<n;i++){
            List<Integer> pre = result.get(i-1);
            List<Integer> row = new ArrayList<>();
            row.add(1);//add 1 at first 
            for(int j=0;j<i-1;j++){
                row.add(pre.get(j)+pre.get(j+1)); //add mid ele with i + i-1 form prev list; 
            }
            row.add(1); //add 1 at last
            result.add(row);
        }
        return result;
    }
}