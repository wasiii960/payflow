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
}
