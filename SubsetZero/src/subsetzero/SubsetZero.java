/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsetzero;
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
public class SubsetZero {
    /**
     *
     */
//__________________________________________________________________________________________________________________    
  
    public static ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> allSubsets2 = new ArrayList<ArrayList<Integer>>();
    
    static void isSubsetSumZero(int arr[], int n){
        ArrayList<Integer> currentSubset = new ArrayList<Integer>();
        allSubsets=new ArrayList<ArrayList<Integer>>();
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

            
            c=c+2;
            // Save subsets
            if(sum==0){
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
 
    
    static void printSubsets(){
       boolean sameValues=false;
       boolean sameValuesAdded=false;
       
       for (int x=0; x < allSubsets.size(); x++) {
            int sum=0;
            for (int y=0; y < allSubsets.get(x).size(); y++) {
                 ArrayList<Integer> actualList=allSubsets.get(x);
                 sum+=actualList.get(y);
                 if(Math.abs(actualList.get(0))== Math.abs(actualList.get(0)) && allSubsets.get(x).size()==2){
                    sameValues=true;
                 } else{
                    sameValues=false;
                 } 
            }
            if(sum==0){
                if(sameValues && !sameValuesAdded){
                    allSubsets2.add(allSubsets.get(x));
                    sameValuesAdded=true;
                }else if(!sameValues){
                    allSubsets2.add(allSubsets.get(x));
                }
            }


        }
        System.out.println(allSubsets2.toString());
    }
    
    
    // To find the number of subsets with sum equal to 0
    // Since S can be negative, we will maxSum
    // to it to make it positive
    static int isSubsetSumZeroDP(int i, int s, ArrayList<Integer> currentSubset, int arr[], int n){
        
        // Base cases
        if (i == n){
            if (s == 0){
                allSubsets.add(currentSubset);
                return 1;
            }else{
                return 0;
            }
        }
        
        allSubsets.add(currentSubset);
        
        // Returns the value if a state is already solved
        if (visit[i][s + arrSize]){
            return dp[i][s + arrSize];
        }
 
        // If the state is not visited, then continue
        visit[i][s + arrSize] = true;
 
        // Recurrence relation
        ArrayList<Integer> currentSubset2 =  new ArrayList<>();
        currentSubset2=(ArrayList<Integer>) currentSubset.clone();
        currentSubset.add(arr[i]);
        dp[i][s + arrSize] = isSubsetSumZeroDP(i + 1, s + arr[i], currentSubset, arr, n) 
                + isSubsetSumZeroDP(i + 1, s, currentSubset2, arr, n);
        
        // End recursion
        return -1;
        
        // Returning the value
        //return dp[i][s + arrSize];
    }
  
//__________________________________________________________________________________________________________________    
   
      
    /* Driver program to test above function */
    public static void main(String args[]){
       
        int min = -15; //parametros para el minimo del numero aleatorio
        int max = 15; //parametros para el maximo del numero aleatorio
        
        for(int i=3; i <= 20;i++){

            //Randomdata array creation
            Random rd = new Random(); // creating Random object
            int[] arrAleatorio = new int[i]; // input the lenght of the array

            for (int j = 0; j < arrAleatorio.length; j++) {
                arrAleatorio[j] = rd.nextInt(max-min+1) + min; // storing random integers in an array

            }
            
            System.out.println("====================EJECUCION ALGORITMO PROGRAMACIÓN DINÁMICA================================\n\n");

            int n = arrAleatorio.length;
            ArrayList<Integer> currentSubset =  new ArrayList<>();
            int arr[] = {-5, 1, 2, 3, 4, 5, 30};
            int arrSize = arr.length;
            isSubsetSumZeroDP(0,0,currentSubset,arr,arrSize);
            printSubsets();

            System.out.println("\n====================EJECUCION ALGORITMO FUERZA BRUTA================================\n\n");

        

            //Random data
            System.out.println("--------------------Datos aleatorios--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n+" elementos");
            isSubsetSumZero(arrAleatorio, n);

        }

            //Stored data array creation
            int[] arrQuemado3 = new int[]{-1,1,-2};
            int n3 = arrQuemado3.length;

            int[] arrQuemado4 = new int[]{-1,1,-2,2};
            int n4 = arrQuemado4.length;

            int[] arrQuemado5 = new int[]{-1,1,-2,2,-3};
            int n5 = arrQuemado5.length;

            int[] arrQuemado6 = new int[]{-1,1,-2,2,-3,3};
            int n6 = arrQuemado6.length;

            int[] arrQuemado7 = new int[]{-1,1,-2,2,-3,3,-4};
            int n7 = arrQuemado7.length;

            int[] arrQuemado10 = new int[]{-1,1,-2,2,-3,3,-4,4,-5,5};
            int n10 = arrQuemado10.length;

            int[] arrQuemado11 = new int[]{-1,1,-2,2,-3,3,-4,4,-5,5,-6};
            int n11 = arrQuemado11.length;

            int[] arrQuemado12 = new int[]{-1,1,-2,2,-3,3,-4,4,-5,5,-6,6};
            int n12 = arrQuemado12.length;

            int[] arrQuemado13 = new int[]{-1,1,-2,2,-3,3,-4,4,-5,5,-6,6,-7};
            int n13 = arrQuemado13.length;

            int[] arrQuemado14 = new int[]{-1,1,-2,2,-3,3,-4,4,-5,5,-6,6,-7,7};
            int n14 = arrQuemado14.length;

            int[] arrQuemado15 = new int[]{-1,1,-2,2,-3,3,-4,4,-5,5,-6,6,-7,7,-8};
            int n15 = arrQuemado15.length;

            int[] arrQuemado20 = new int[]{-1,1,-2,2,-3,3,-4,4,-5,5,-6,6,-7,7,-8,8,-9,9,-10,10};
            int n20 = arrQuemado20.length;

            System.out.println("\n"+"\n*~~~~~~~~~~~~~~~~~~~~~~~~~~~INICIO DE SEGUNDA PARTE (DATOS QUEMADOS)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*"+"\n");

            //Stored data
            System.out.println("\n--------------------3 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n3+" elementos");
            isSubsetSumZero(arrQuemado3, n3);

            System.out.println("\n--------------------4 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n4+" elementos");
            isSubsetSumZero(arrQuemado4, n4);

            System.out.println("\n--------------------5 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n5+" elementos");
            isSubsetSumZero(arrQuemado5, n5);

            System.out.println("\n--------------------6 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n6+" elementos");
            isSubsetSumZero(arrQuemado6, n6);

            System.out.println("\n--------------------7 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n7+" elementos");
            isSubsetSumZero(arrQuemado7, n7);

            System.out.println("\n--------------------10 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n10+" elementos");
            isSubsetSumZero(arrQuemado10, n10);

            System.out.println("\n--------------------11 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n11+" elementos");
            isSubsetSumZero(arrQuemado11, n11);

            System.out.println("\n--------------------12 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n12+" elementos");
            isSubsetSumZero(arrQuemado12, n12);

            System.out.println("\n--------------------13 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n13+" elementos");
            isSubsetSumZero(arrQuemado13, n13);

            System.out.println("\n--------------------14 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n14+" elementos");
            isSubsetSumZero(arrQuemado14, n14);

            System.out.println("\n--------------------15 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n15+" elementos");
            isSubsetSumZero(arrQuemado15, n15);
          
            System.out.println("\n--------------------20 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n20+" elementos");
            isSubsetSumZero(arrQuemado20, n20);
    }
}

        
