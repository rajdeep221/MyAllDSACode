package StackAndQueue.ImportQuestion;

public class CircularTour {

    public int tour(int petrol[], int distace[]) {
        int start = 0;
        int reqFuel = 0;
        int extraFuel = 0;

        for (int i = 0; i < petrol.length; i++) {
            extraFuel += petrol[i] - distace[i];

            if (extraFuel < 0) {
                reqFuel += extraFuel;
                extraFuel = 0;
                start = i + 1;
            }
        }

        return (reqFuel + extraFuel >= 0) ? start : -1;
    }
}
