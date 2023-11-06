import java.util.*;
// recusive
class fibonacci{
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        // non - recursive
        System.out.println("Enter number:");
        int number=sc.nextInt();
        int a=0;
        int b=1;
        int c;
         System.out.print(a+" "+b+" ");
        for(int i=2;i<number;i++)
        {
            c=a+b;
            System.out.print(c+" ");
            a=b;
            b=c;
        }
    }
}