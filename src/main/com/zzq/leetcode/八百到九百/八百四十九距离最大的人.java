package main.com.zzq.leetcode.八百到九百;

public class 八百四十九距离最大的人 {
    public int maxDistToClosest(int[] seats) {
        int result = 0;
        int curLength = 0;
        int index = 0;
        boolean flag = true;
        while (index < seats.length) {
            if (seats[index] == 0) {
                curLength++;
            } else {
                flag = false;
                curLength = 0;
            }
            index++;
            if (flag || index == seats.length) {
                result = Math.max(result, curLength);
            } else {
                result = Math.max(result, (curLength + 1) / 2);
            }
        }
        return result;
    }
}
