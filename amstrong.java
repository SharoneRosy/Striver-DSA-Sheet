package Patterns;

import java.util.*;
class amstrong{
static boolean ArmstrongNumber(int n)
{
    int originalno = n;
    int count = 0;
    int temp = n;
    while (temp != 0)
    {
        count++;
        temp = temp / 10;
    }
    int sumofpower = 0;
    while (n != 0)
    {
        int digit = n % 10;
        sumofpower += Math.pow(digit,count);
        n /= 10;
    }
    if(sumofpower == originalno)return true;
    else return false;
}
public static void main(String args[])
{

    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    if (ArmstrongNumber(n)==true)
      System.out.print("true");
    else System.out.print("false");

}
}

    

