package com.practise;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

  public static int findMaxLength(int[] nums) {
    Map<Integer, Integer> seen = new HashMap<>();
    int total = 0;
    int length = 0;
    seen.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) total = total - 1;
      else total = total + 1;
      if (seen.containsKey(total)) {
        length = Math.max(length, i - seen.get(total));
      } else seen.put(total, i);
    }
    return length;
        }
  public static int findMaxLengthResolve(int[] nums){
    Map<Integer, Integer> map = new HashMap<>();
    int maxLength = 0;
    int total= 0;
    map.put(0, -1);
    for(int i=0; i<nums.length; i++){
      if(nums[i]==0){
        total+=-1;
      }else total+=1;
      if(map.containsKey(total)){
        maxLength=Math.max(i-map.get(total), maxLength);
      }else map.put(total, i);
    }
    return maxLength;
  }
}
