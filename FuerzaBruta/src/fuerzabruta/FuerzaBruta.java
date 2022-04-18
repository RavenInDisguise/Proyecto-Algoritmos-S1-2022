/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuerzabruta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
/**
 *
 * @author Mónica Alfaro, Ignacio Brenes
 */
public class FuerzaBruta {
    /**
     *
     */
    public static ArrayList<List> allSubsets = new ArrayList<List>();
    public static ArrayList<Integer> currentSubset =  new ArrayList<>();
    
    static void isSubsetSumZero(int arr[], int n){

        allSubsets=new ArrayList<List>();
        double startTime = System.currentTimeMillis(); // timer startup

        
        int a = 2;// "asignaciones counter"
        int c = 0;// "comparaciones counter"
        int l = 0;// "lineas ejecutadas counter"

        currentSubset = new ArrayList<>();
        // There are total 2^n subsets
        int total = 1 << n;
        a++;

        // Consider all numbers from 0 to 2^n - 1
        for (int i = 0; i < total; i++) {

            int sum = 0;

            c++;
            a++;

            currentSubset = new ArrayList<>();

            // Consider binary representation of
            // current i to decide which elements
            // to pick.

            for (int j = 0; j < n; j++){
                c = c+2;

                if ((i & (1 << j)) != 0){
                    currentSubset.add(arr[j]);
                    sum += arr[j];
                    a++;
                }
            }
            c++;

            // Save subsets
            c=c+2;
            if(sum==0 && !currentSubset.isEmpty()){
                allSubsets.add(currentSubset);
                //System.out.print(sum + " ");
            }
        }
        c++;

        l=a+c;
        
        System.out.println(allSubsets.toString());
        System.out.println("Asignaciones: " + a);
        System.out.println("Comparaciones: " + c);
        System.out.println("Lineas ejecutadas: " + l);
        double endTime = System.currentTimeMillis() - startTime; // The current time at the end of the program
        System.out.println("Tiempo de ejecución: "+endTime+" ms"); // The final print for the system timer
    }

//__________________________________________________________________________________________________________________    
    
    static int maxSum = 100;
    static int arrSize = 51;
 
    // variable to store
    // states of dp
    static int[][] dp = new int[arrSize][maxSum];
    static boolean[][] visit = new boolean[arrSize][maxSum];
 
    // To find the number of subsets with sum equal to 0
    // Since S can be negative, we will maxSum
    // to it to make it positive
    static int isSubsetSumZeroDP(int i, int s, int arr[], int n){
        // Base cases
        if (i == n){
            if (s == 0){
                return 1;
            }else{
                return 0;
            }
        }
 
        // Returns the value if a state is already solved
        if (visit[i][s + arrSize]){
            return dp[i][s + arrSize];
        }
 
        // If the state is not visited, then continue
        visit[i][s + arrSize] = true;
 
        // Recurrence relation
        dp[i][s + arrSize] = isSubsetSumZeroDP(i + 1, s + arr[i], arr, n) + isSubsetSumZeroDP(i + 1, s, arr, n);
 
        // Returning the value
        return dp[i][s + arrSize];
    }
  
//__________________________________________________________________________________________________________________    
   
      
    /* Driver program to test above function */
    public static void main(String args[]){

        for(int i=3; i<=3;i++){
            
            //Randomdata array creation
            Random rd = new Random(); // creating Random object
            int[] arrAleatorio = new int[i]; // input the lenght of the array

            int[] arrQuemado = new int[]{-1,1,-2,2,-3};
            int n2 = arrQuemado.length;

            }
            

    }
}

        

