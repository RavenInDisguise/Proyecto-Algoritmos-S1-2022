/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuerzabruta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author monic
 */
public class FuerzaBruta {

    /**
     *
     */
    static int maxSum = 100;
    static int arrSize = 51;

    // variable to store
    // states of dp
    static int[][] dp = new int[arrSize][maxSum];
    static boolean[][] visit = new boolean[arrSize][maxSum];
    static ArrayList<Integer> currentSubset = new ArrayList<>();
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
    	
    // To find the number of subsets with sum equal to 0
    // Since S can be negative, we will maxSum
    // to it to make it positive
    static int SubsetCnt(int i, int s, int arr[], int n){
            // Base cases
       
            if (i == n){
                    if (s == 0){
                            return 1;
                    }
                    else{
                            ArrayList<Integer> currentSubset = new ArrayList<>();
                            return 0;
                    }
            }

            // Returns the value if a state is already solved
            if (visit[i][s + arrSize])
            {
                    return dp[i][s + arrSize];
            }

            // If the state is not visited, then continue
            visit[i][s + arrSize] = true;

            // Recurrence relation
            currentSubset.add(arr[i]);
            dp[i][s + arrSize] = SubsetCnt(i + 1, s + arr[i], arr, n)
                            + SubsetCnt(i + 1, s, arr, n);
            
            if(s==0 && !currentSubset.isEmpty()){
                allSubsets.add(currentSubset);
                ArrayList<Integer> currentSubset = new ArrayList<>();
                //System.out.print(sum + " ");
            }
            // Returning the value
            return dp[i][s + arrSize];
}
    /* This code contributed by PrinciRaj1992 */

 /* Driver program to test above function */
    public static void main(String args[]){
        int arr[] = new int[] { -1, 1, -2, -3, 5 };
        int n = arr.length;
 
        isSubsetSumZero(arr, n);
        
        //System.out.println(allSubsets.toString());
        
        int arr2[] = {2, 2, 2, -4, -4};
	int n2= arr.length;
	//System.out.println(SubsetCnt(0, 0, arr2, n2));
        System.out.println(allSubsets.toString());
    }
}
   
