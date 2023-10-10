package Recursion;
//reverse a number
public class Demo1{

    static int r = 0;
    static void reverANumber(int n){
       if(n > 0){
            int rem = n%10;
            r = r*10 + rem;
            reverANumber(n/10);
       }
    }

    static int reverANumber1(int n, int digits){
        if(n%10 == n){
            return n;
        }
        int rem = n%10;
        return rem *(int)Math.pow(10, digits - 1)+ reverANumber1(n/10, digits-1);
    }

    public static void main(String[] args) {
        int n = 1124;
        reverANumber(n);
        System.out.println(Demo1.r);
        //This will calculate the no digits in the 'n'.
        int digits = (int) Math.log10(n) + 1;

        System.out.println(reverANumber1(n, digits));
        
    }
}