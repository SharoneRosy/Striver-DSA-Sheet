class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(0, nums.length - 1, nums);
        return nums;
    }
    private void mergeSort(int left, int right, int nums[]){
        if(left >= right)return;
        int mid = left + (right - left) / 2;
        // System.out.println("left: " + left + " right: " + right + " mid: "+ mid);
        mergeSort(left, mid, nums);
        mergeSort(mid+1, right, nums);
        merge(left, mid, right, nums);
    }
    private void merge(int left, int mid, int right, int nums[]){
        List<Integer> sortedList = new ArrayList<>();
        int indx1 = left, indx2 = mid + 1;
        while(indx1 < mid + 1 && indx2 < right + 1){
            if(nums[indx1] <= nums[indx2]){
                sortedList.add(nums[indx1++]);
            }else{
                sortedList.add(nums[indx2++]);
            }
        }
        while(indx1 < mid + 1){
            sortedList.add(nums[indx1++]);
        }
        while(indx2 < right + 1){
            sortedList.add(nums[indx2++]);
        }
        int indx = left;
        for(var num : sortedList){
            nums[indx++] = num;
        }
    }
}