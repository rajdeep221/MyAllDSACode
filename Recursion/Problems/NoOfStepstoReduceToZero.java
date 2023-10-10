package Recursion.Problems;

public class NoOfStepstoReduceToZero {

    public int numberOfSteps(int num) {

        if (num == 0) {
            return 0;
        }

        if (num % 2 != 0) {
            return 1 + numberOfSteps(num - 1);
        } else {
            return 1 + numberOfSteps(num / 2);
        }
    }

    public static void main(String[] args) {
        NoOfStepstoReduceToZero ob = new NoOfStepstoReduceToZero();
        System.out.println(ob.numberOfSteps(14));
    }
}
