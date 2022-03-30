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
        
        long startTime = System.currentTimeMillis(); // inicio del contador del tiempo
        
        
        int a = 2;//asignaciones
        int c = 0;//comparaciones
        int l = 0;// lineas ejecutadas
       
        
        ArrayList<Integer> currentSubset = new ArrayList<>();
        l++;
        // There are total 2^n subsets
        int total = 1 << n;
        l++;
        a++;
        
        // Consider all numbers from 0 to 2^n - 1
        for (int i = 0; i < total; i++) {
            
            l = l+3;
            
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
                    l = l+4; 
                    currentSubset.add(arr[j]);
                    sum += arr[j];
                    a++;
                }              
            }
            c++;
            
            // Print sum of picked elements.
            c++;
            if(sum==0 && !currentSubset.isEmpty()){
                l=l+2;
                allSubsets.add(currentSubset);
                //System.out.print(sum + " ");
            }
        }
        c++;
        
        System.out.println("asignaciones " + a);
        System.out.println("comparaciones " + c);
        System.out.println("lineas ejecutadas " + l);
        long endTime = System.currentTimeMillis() - startTime; // tiempo en que se ejecuta su for 
        System.out.println("tiempo de ejecucion " + endTime + "ms");
        
    }

 /* Driver program to test above function */
    public static void main(String args[]){
        int arr[] = new int[] {7,-14,32,2,-66,33,-1};
        int n = arr.length;
 
        isSubsetSumZero(arr, n);
        System.out.println(allSubsets.toString());
      
    }
    
}
   
