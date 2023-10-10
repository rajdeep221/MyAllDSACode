package String;

import java.util.Arrays;

public class NextGreaterElementIII {

    public int nextGreaterElement(int n) {
        String st = String.valueOf(n);
        int l = st.length();
        int arr[] = new int[l];

        for (int i = 0; i < l; i++) {
            arr[i] = st.charAt(i) - '0';
        }

        int idx = -1;
        for (int i = l - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                idx = i - 1;
                break;
            }
        }

        if (idx == -1)
            return -1;

        for (int i = l - 1; i > idx; i--) {
            if (arr[i] > arr[idx]) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                break;
            }
        }

        int j = idx + 1;
        int r = l - 1;

        while (j < r) {
            int temp = arr[j];
            arr[j++] = arr[r];
            arr[r--] = temp;
        }

        long res = 0;
        for (int i = 0; i < l; i++) {
            res = res * 10 + arr[i];
        }

        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }

    public static void main(String[] args) {
        NextGreaterElementIII ob = new NextGreaterElementIII();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(ob.nextGreaterElement(230241));
    }
}
