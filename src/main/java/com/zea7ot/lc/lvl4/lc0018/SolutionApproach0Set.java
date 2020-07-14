/**
 * https://leetcode.com/problems/4sum/
 * 
 * Time Complexity:     O(N ^ 3) + O(N * lg(N))
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl4.lc0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0Set {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // sanity check
        if(nums == null || nums.length < 4) return new ArrayList<List<Integer>>();

        final int N = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        
        for(int i = 0; i < N - 3; i++){
            for(int j = i + 1; j < N - 2; j++){
                int lo = j + 1, hi = N - 1;
                while(lo < hi){
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if(target == sum){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        lo++;
                        hi--;
                    }else if(sum < target) lo++;
                    else hi--;
                }
            }
        }
    
        return new ArrayList<List<Integer>>(ans);
    }
}