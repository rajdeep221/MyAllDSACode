package String;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameVII {
    public boolean canReach(String s, int minJump, int maxJump) {
        int idx = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        int maxReach = 0;

        while (!queue.isEmpty()) {
            idx = queue.remove();

            if (idx == s.length() - 1) {
                return true;
            }

            for (int i = Math.max(minJump + idx, maxReach); i <= Math.min(idx + maxJump, s.length() - 1); i++) {
                if (s.charAt(i) == '0') {
                    queue.add(i);
                }
            }

            maxReach = Math.min(idx + maxJump + 1, s.length() - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        JumpGameVII ob = new JumpGameVII();
        System.out.println(ob.canReach("0000000000", 2, 5));
    }
}
