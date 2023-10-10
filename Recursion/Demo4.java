package Recursion;

public class Demo4 {

    static int stepsCount(int n, int steps){
        if(n == 0){
            return steps;
        }
        if(n%2 == 0){
            return stepsCount(n/2, ++steps);
        }
        return stepsCount(n-1, ++steps);
    }
    public static void main(String[] args) {
        System.out.println(stepsCount(122, 0));
    }
}
