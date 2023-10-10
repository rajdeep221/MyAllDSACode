package StackAndQueue.ImportQuestion;

public class TaskScheduler {

    public int leastInterval(char task[], int n) {
        int max = 0, countMax = 0;
        int arr[] = new int[26];

        for (char ch : task) {
            arr[ch - 'A']++;

            if (max == arr[ch - 'A']) {
                countMax++;
            }

            if (max < arr[ch - 'A']) {
                max = arr[ch - 'A'];
                countMax = 1;
            }
        }

        int partCount = max - 1;
        int partLength = n - (countMax - 1);
        int emptySpace = partCount * partLength;

        int remEle = task.length - (max * countMax);

        int idle = Math.max(0, emptySpace - remEle);

        return task.length + idle;
    }
}
