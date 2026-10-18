class Solution {
    public int nthUglyNumber(int n) {
        int arr[]= new int[n+1];
        int i2 =1;
        int i3=1;
        int i5=1;
        arr[1]=1;
        for(int i=2;i<=n;i++){
            int i2u= arr[i2]*2;
            int i3u= arr[i3]*3;
            int i5u = arr[i5]*5;

            int minUgluNo = Math.min(Math.min(i2u,i3u),i5u);
            arr[i]= minUgluNo;
            if(minUgluNo==i2u)  i2++;
            if(minUgluNo==i3u) i3++;
            if(minUgluNo==i5u) i5++;
        }
        return arr[n];
    }
}