package com.dexlace.netty;

class Solution {
    public int jump(int[] nums) {
        // 这里需要统计两个覆盖范围，当前这一步的最大覆盖和下一步最大覆盖。
        int nextCover = 0;
        int curCover = 0;
        // 初始化为0
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // 遍历i只是为了拿到能跳的最大距离
            nextCover = Integer.max(i + nums[i], nextCover);
            // 而只有当i到达当前的覆盖距离下标时才真正算跳了一次
            // 保证当前跳的最远
            if (i == curCover) {
                // 已经到达可以到达集合终点，无需+1
                if (curCover >= nums.length - 1) {
                    break;
                } else {
                    // 只有当前覆盖距离不能到达 会去加一
                    res++;
                    curCover = nextCover;
                    // 验证此时是否能够到达 不用真的再去跑了
                    if (curCover >= nums.length - 1) {
                        break;
                    }
                }


            }
        }

     return res;
    }
}

