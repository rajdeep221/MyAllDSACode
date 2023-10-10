package Recursion;

public class Demo3 {

    static int countZeros(int n, int count, int args){
        if(n == 0 && args != 0){
            return count;
        }
        else if(n == 0 && args == 0 ){
            return 1;
        }
        int rem = n%10;
        if(rem == 0){
            return countZeros(n/10, ++count, args + 1);
        }
        return countZeros(n/10, count, args + 1);
    }
    
    public static void main(String[] args) {
        System.out.println(countZeros(1050401400, 0, 0));
    }
}
