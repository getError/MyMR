package cn.geterror.mm;


import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return val+"->"+next;
    }
}

class SortedQueue{
    List<ListNode> data = new ArrayList<>();

    public void add(ListNode i){
        if(i==null){
            return;
        }
        if(data.isEmpty()){
            data.add(i);
            return;
        }
        data.add(i);
        int index = data.size()-1;
        while (index!=0){
            if(data.get(index/2).val>data.get(index).val){
                ListNode t = data.get(index/2);
                data.set(index,t);
                data.set(index/2,i);

                index/=2;
            }else {
                break;
            }
        }
    }

    public ListNode pop(){
        if(data.isEmpty()){
            return null;
        }
        ListNode res = data.get(0);
        data.set(0,data.get(data.size()-1));
        int index = 0;
        while (index*2+2<=data.size()){
            int left = index*2+1;
            int right = index*2+2;
            ListNode cur = data.get(index);
            if(index*2+1==data.size()-1){
                if(cur.val<data.get(left).val) {
                    data.set(index, data.get(left));
                }
                index = index*2+1;
                break;
            }
            if(cur.val<=data.get(left).val&&cur.val<=data.get(right).val){
                index = left;
            }else if (data.get(left).val<data.get(right).val&&data.get(left).val<=cur.val){
                data.set(index,data.get(left));
                data.set(left,cur);
                index = left;
            }else {
                data.set(index,data.get(right));
                data.set(right,cur);
                index = right;
            }
        }
        data.remove(data.size()-1);
        return res;
    }


}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1){
            return;
        }

        int j = nums.length-1;
        int i = j-1;
        while (i>0&&nums[i]>=nums[j]){
            i--;
            j--;
        }
        if(!(i==0&&nums[i]>=nums[j])) {
            j = nums.length - 1;
            while (nums[i] >= nums[j]) {
                j--;
            }
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }else {
            i = -1;
        }

        Arrays.sort(nums,i+1,nums.length);
    }
}
public class Test {
    public static void main(String[] args) {
        val solution = new Solution();
        int[] nums = {1,5,1};
//        Arrays.sort(nums);
        solution.nextPermutation(nums);
        System.out.println(Arrays.asList(nums));
    }

}