/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dsa;

/**
 *
 * @author AORUS
 */
public class Recursion {

    void recursionMain() {
        //        summation(1, 5, 0);
        //System.out.println(factorial(3));
        //        fibonacciSequence(0, 1, 5);
        //        System.out.println(xSquare(2, 4));
        //        towerOfHanoi(2, "S", "H", "D");
        //        printReverseString("abc", "abc".length() - 1);
        //        findLastAndFirstOccurance("abbaba", 0, 'a', -1, -1);
//        System.out.println(isSorted(new int[]{1, 3, 4, 5}, new int[]{1, 3, 4, 5}.length - 1));
//        System.out.println(xMoveLast("Hxexlccx", 'x', 1));
        removeDuplicate("abbccda", 0, "");
    }

    void summation(int i, int n, int sum) {
        if (i == n) {
            sum += i;
            System.out.println(sum);
            return;
        }
        summation(i + 1, n, sum += i);
    }

    int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return (n * factorial(n -= 1));
    }

    void printFib(int a, int b, int n) {
        if (n == 0) {
            return;
        }
        int c = a + b;
        System.out.println(c);
        printFib(b, c, n -= 1);
    }

    void fibonacciSequence(int a, int b, int n) {
        System.out.println(a);
        System.out.println(b);

        printFib(a, b, n);
    }

    int xSquare(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (n % 2 == 0) {
            return xSquare(x, n / 2) * xSquare(x, n / 2);
        } else {
            return xSquare(x, n / 2) * xSquare(x, n / 2) * x;
        }
    }

    void towerOfHanoi(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println("transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        towerOfHanoi(n - 1, src, dest, helper);
        System.out.println("transfer disk " + n + " from " + src + " to " + dest);
        towerOfHanoi(n - 1, helper, src, dest);
    }

    void printReverseString(String str, int indx) {
        if (indx == 0) {
            System.out.print(str.charAt(indx));
            return;
        }
        System.out.print(str.charAt(indx));
        printReverseString(str, indx - 1);
    }

    void findLastAndFirstOccurance(String str, int indx, char c, int first, int last) {
        if (indx == str.length()) {
            System.out.println(first + " " + last);
            return;
        }
        if (str.charAt(indx) == c) {
            if ((first == -1)) {
                first = indx;
            } else {
                last = indx;
            }
        }
        findLastAndFirstOccurance(str, indx + 1, c, first, last);
    }

    boolean isSorted(int[] arr, int indx) {
        if (indx == 0) {
            return true;
        }
        if (arr[indx - 1] >= arr[indx]) {
            return false;
        } else {
            return isSorted(arr, indx - 1);

        }
    }

    String xMoveLast(String str, char cha, int indx) {
        if (indx == str.length() - 1) {
            return str;
        }
        if (str.charAt(indx) == cha) {
            str += str.charAt(indx);
            str = str.replaceFirst(String.valueOf(str.charAt(indx)), "");
        }
        return xMoveLast(str, cha, indx + 1);
    }

    void removeDuplicate(String str, int indx, String result) {
        boolean[] map = new boolean[26];
        System.out.println(map);
        if (indx == str.length()) {
            System.out.println(result);
            return;
        }
        char ch = str.charAt(indx);
        if (map[ch - 'a'] == true) {
            System.out.println("true");
            removeDuplicate(str, indx + 1, result);
        } else {
            result += ch;
            map[ch - 'a'] = true;
            removeDuplicate(str, indx + 1, result);
        }

    }
}
