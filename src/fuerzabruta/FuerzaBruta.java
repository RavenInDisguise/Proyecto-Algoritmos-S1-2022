/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuerzabruta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author monic
 */
public class FuerzaBruta {

    /**
     *
     */
    public static ArrayList<List> allSubsets = new ArrayList<List>();
    static void isSubsetSumZero(int arr[], int n){
        ArrayList<Integer> currentSubset = new ArrayList<>();
        // There are total 2^n subsets
        int total = 1 << n;
 
        // Consider all numbers from 0 to 2^n - 1
        for (int i = 0; i < total; i++) {
            int sum = 0;
            currentSubset = new ArrayList<>();
            
            // Consider binary representation of
            // current i to decide which elements
            // to pick.
            for (int j = 0; j < n; j++){
                if ((i & (1 << j)) != 0){
                    currentSubset.add(arr[j]);
                    sum += arr[j];
                }
            }
 
            // Print sum of picked elements.
            if(sum==0 && !currentSubset.isEmpty()){
                allSubsets.add(currentSubset);
                //System.out.print(sum + " ");
            }
        }
    }

 /* Driver program to test above function */
    public static void main(String args[]){
        int arr[] = new int[] { -1, 1, -2, -3, 5 };
        int n = arr.length;
 
        isSubsetSumZero(arr, n);
        System.out.println(allSubsets.toString());
        
        
    }
}
   
