package StackAndQueue.ImportQuestion;

import java.util.*;

public class AsteroidCollision {

    public int[] asteroidCollision(int asteroids[]) {
        int arr[] = new int[asteroids.length];
        int idx = -1;
        int i = 0;

        while (i < asteroids.length) {

            if (asteroids[i] >= 0 || (idx == -1) || (arr[idx] < 0)) {
                idx++;
                arr[idx] = asteroids[i];
                i++;
            } else {
                int coun = Math.abs(asteroids[i]);

                if (arr[idx] < coun) {
                    idx--;
                } else if (arr[idx] == coun) {
                    idx--;
                    i++;
                } else {
                    i++;
                }
            }
        }

        return Arrays.copyOfRange(arr, 0, idx + 1);
    }

}
