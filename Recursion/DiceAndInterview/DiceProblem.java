package Recursion.DiceAndInterview;

import java.util.ArrayList;

public class DiceProblem {

    static void dice(String p, int target) {
        if (target == 0) {
            System.out.print(p + ", ");
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    static ArrayList<String> diceReturn(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 1; i <= 6 && i <= target; i++) {
            ans.addAll(diceReturn(p + i, target - i));
        }
        return ans;
    }

    static void diceFace(String p, int target, int face) {
        if (target == 0) {
            System.out.print(p + ", ");
            return;
        }

        for (int i = 1; i <= face && i <= target; i++) {
            diceFace(p + i, target - i, face);
        }
    }

    public static void main(String[] args) {
        dice("", 4);
        System.out.println();
        System.out.println(diceReturn("", 4));
        diceFace("", 3, 7);
    }
}
