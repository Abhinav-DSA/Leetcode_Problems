class Solution {
    public int findMiddleIndex(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int ls=0;
            int rs=0;
            for(int j=0;j<i;j++){
                ls=ls+nums[j];
            }
            for(int j=i+1;j<n;j++){
                rs=rs+nums[j];
            }
            if(ls==rs){
                return i;
            }

        }
        return -1;
    }
}
 