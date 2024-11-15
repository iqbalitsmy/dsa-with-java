/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dsa;

/**
 *
 * @author AORUS
 */
public class ArrayPart {

    void callFun() {
        int arr[] = {5, 6, 7, 8, 9, 10, 64, 85, 474};
//        System.out.println(binnarySearch(arr, 10));
//        int[] rev = reverseArray(arr);
//        for (int i = 0; i < rev.length; i++) {
//            System.out.println(rev[i]);
//        }
        pairInAnArray(arr);
    }

//    time complexity = 
    int binnarySearch(int arr[], int n) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] > n) {
                end = mid - 1;
            } else if (arr[mid] < n) {
                start = mid + 1;
            }
        }
        return -1;
    }

    int[] reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }

    void pairInAnArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                System.out.println("pair of" + arr[i] + " : (" + arr[i] + "," + arr[j] + ")");
            }
        }
    }
    void printSubarray(){
        
    }
}
