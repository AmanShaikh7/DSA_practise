class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    public int[] mergeSort(int nums[],int lo,int hi){
        if(lo==hi){
            int base[] = new int[1];
            base[0] = nums[lo];
            return base;
        }
        int mid = (lo+hi)/2;
        int fsh[] = mergeSort(nums,lo,mid);
        int ssh[] = mergeSort(nums,mid+1,hi);
        int fsa[] = mergeTwoSortedArrays(fsh,ssh);
        return fsa;
    }

    public int[] mergeTwoSortedArrays(int[] fsh, int[] ssh){
        int[] ans = new int [fsh.length+ssh.length];
        int po = 0;
        int pt = 0;
        int k = 0;
        while(po < fsh.length && pt < ssh.length){
            if(fsh[po] <= ssh[pt]){
                ans[k] = fsh[po];
                po++;
                k++;
            }else{
                ans[k] = ssh[pt];
                pt++;
                k++;
            }
        }
        while(po < fsh.length){
            ans[k] = fsh[po];
            po++;
            k++;
        }
        while(pt < ssh.length){
            ans[k] = ssh[pt];
            pt++;
            k++;
        }

        return ans;
    }
}