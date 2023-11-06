
import java.util.*;
 
class Binomial {
 
    // Returns value of Binomial
    // Coefficient C(n, k)
    static int binomialCoeff(int n, int k)
    {
 
        // Base Cases
        if (k > n)
            return 0;
        if (k == 0 || k == n)
            return 1;
            //These lines handle two more base cases. If 'k' is either 0 or equal to 'n', the binomial coefficient is 1. This is because C(n, 0) and C(n, n) are always 1.
 
        // Recur
        return binomialCoeff(n - 1, k - 1)
            + binomialCoeff(n - 1, k);
            //These lines define the recursive part of the function. If none of the base cases are met, the function uses the recursive formula C(n, k) = C(n-1, k-1) + C(n-1, k) to calculate the binomial coefficient.
    }
 
    /* Driver program to test above function */
    public static void main(String[] args)
    {
        int n = 5, k = 2;
        System.out.printf("Value of C(%d, %d) is %d ", n, k,
                          binomialCoeff(n, k));
    }
}
