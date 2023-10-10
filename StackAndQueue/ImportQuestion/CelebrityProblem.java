package StackAndQueue.ImportQuestion;

public class CelebrityProblem {

    int celebrity(int M[][], int n) {
        int cel = -1, count = 0;

        for (int j = 0; j < n; j++) {
            count = 0;
            for (int i = 0; i < n; i++) {

                if (M[j][i] == 1) {
                    break;
                }

                if (M[i][j] == 1) {
                    count++;
                }
            }

            if (count == (n - 1)) {
                cel = j;
                break;
            }
        }

        return cel;
    }
}
