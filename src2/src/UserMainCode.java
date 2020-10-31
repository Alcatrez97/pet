/******************************************************************************

 Welcome to GDB Online.
 GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
 C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
 Code, Compile, Run and Debug online from anywhere in world.

 *******************************************************************************/
public class UserMainCode
{

    public int arrangments(int input1){
        try{return countDer(input1);}
        catch (  UnsupportedOperationException("arrangments(int input1)"));

    }
    static int countDer(int n)
    {

        if (n == 1) return 0;
        if (n == 2) return 1;


        return (n - 1) * (countDer(n - 1) +
                countDer(n - 2));
    }
}
