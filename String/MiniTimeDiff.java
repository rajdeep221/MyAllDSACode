package String;

import java.util.Arrays;
import java.util.List;

public class MiniTimeDiff {

    public int findMinDifference(List<String> timePoints) {
        int times[] = new int[timePoints.size()];
        String arr[] = new String[2];

        for (int i = 0; i < times.length; i++) {
            arr = timePoints.get(i).split(":");
            times[i] = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
        }

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < times.length; i++) {
            min = Math.min(times[i] - times[i - 1], min);
        }

        int timeWrap = Math.abs(times[times.length - 1] - times[0] - 1440);

        return Math.min(min, timeWrap);
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("25"));
    }
}
