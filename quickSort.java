import java.util.*;
public class quickSort {
    public static int partition(int a[],int low,int high)
    {
        int pivot=a[high];
        // calculate no of blank spaces
        int i=low-1; // not any number in the array
        for(int j=low;j<high;j++)
        {
            if(a[j]<pivot)
            {
                i++;
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        i++;
        int temp=a[i];
        a[i]=pivot;
        a[high]=temp;
        return i;
    }
    public static void quickSort(int a[],int low, int high)
    {
        if(low<high)
        {
            int pidx=partition(a,low ,high);
            quickSort(a, low, pidx-1);
            quickSort(a, pidx+1, high);
        }
    }
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter how many numbers you want to print:");
        int num=sc.nextInt();
        System.out.println("Enter numbers:");
        int a[]=new int[num];
        for(int i=0;i<num;i++)
        {
            a[i]=sc.nextInt();
        }
        for(int i=0;i<num;i++)
        {
            System.out.print(a[i]+" ");
        }
        int n=a.length;
        System.out.println();
        System.out.println("Sorted array:");
        quickSort(a, 0, n-1);
        // print
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
