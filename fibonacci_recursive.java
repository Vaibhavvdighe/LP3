import java.util.*;

    class fibonacci_recursive{
        static int a=0,b=1,c;
        static void Fib(int count)
        {
            if(count>0){
                c=a+b;
                a=b;
                b=c;
                System.out.print(" "+c);
                Fib(count-1);
            }
        }
    
            public static void main(String[] args){
                Scanner sc=new Scanner(System.in);
        System.out.println("Enter number: ");
        int count=sc.nextInt();
        System.out.print(a+" "+b);
        Fib(count-2);
}
    }

