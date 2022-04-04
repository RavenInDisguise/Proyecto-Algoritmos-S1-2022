/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuerzabruta;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author IBrenes
 */
public class FuerzaBruta {
    /**
     *
     */
    public static ArrayList<List> allSubsets = new ArrayList<List>();

    static void isSubsetSumZeroAleatorio(int arr[], int n){

        double startTime = System.currentTimeMillis(); // timer startup

        int a = 2;// "asignaciones counter"
        int c = 0;// "comparaciones counter"
        int l = 0;// "lineas ejecutadas counter"

        ArrayList<Integer> currentSubset = new ArrayList<>();
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

            // Print sum of picked elements.
            c=c+2;
            if(sum==0 && !currentSubset.isEmpty()){
                allSubsets.add(currentSubset);
                //System.out.print(sum + " ");
            }
        }
        c++;

        l=a+c;

        System.out.println("asignaciones " + a);
        System.out.println("comparaciones " + c);
        System.out.println("lineas ejecutadas " + l);
        double endTime = System.currentTimeMillis() - startTime; // The current time at the end of the program
        System.out.println("tiempo de ejecucion "+endTime+" ms"); // The final print for the system timer
    }

    public static ArrayList<List> allSubsets2 = new ArrayList<List>();

    static void isSubsetSumZeroQuemado(int arrQuemado[], int n2){

        double startTime2 = System.currentTimeMillis(); // timer startup

        int a2 = 2;// "asignaciones counter"
        int c2 = 0;// "comparaciones counter"
        int l2 = 0;// "lineas ejecutadas counter"

        ArrayList<Integer> currentSubset2 = new ArrayList<>();
        // There are total 2^n subsets
        int total = 1 << n2;
        a2++;

        // Consider all numbers from 0 to 2^n - 1
        for (int i = 0; i < total; i++) {

            int sum = 0;

            c2++;
            a2++;

            currentSubset2 = new ArrayList<>();

            // Consider binary representation of
            // current "i" to decide which elements
            // to pick.

            for (int j = 0; j < n2; j++){
                c2 = c2+2;

                if ((i & (1 << j)) != 0){
                    currentSubset2.add(arrQuemado[j]);
                    sum += arrQuemado[j];
                    a2++;
                }
            }
            c2++;

            // Print sum of picked elements.
            c2 = c2+2;
            if(sum==0 && !currentSubset2.isEmpty()){
                allSubsets2.add(currentSubset2);
                //System.out.print(sum + " ");
            }
        }
        c2++;

        l2 = a2 + c2;

        System.out.println("asignaciones " + a2);
        System.out.println("comparaciones " + c2);
        System.out.println("lineas ejecutadas " + l2);
        double endTime2 = System.currentTimeMillis() - startTime2; // The current time at the end of the program
        System.out.println("tiempo de ejecucion "+endTime2+" ms"); // The final print for the system timer
    }






 /* Driver program to test above function */
    public static void main(String args[]){

      //Randomdata array creation

      Random rd = new Random(); // creating Random object
      int[] arr = new int[5]; // input the lenght of the array
      for (int i = 0; i < arr.length; i++) {
         arr[i] = rd.nextInt(); // storing random integers in an array
      }
        int n = arr.length;


        //Stored data array creation

        int[] arrQuemado = new int[]{-1,1,-2,2,-3};
        int n2 = arrQuemado.length;

        //Random data

        System.out.println("--------------------Datos aleatorios--------------------");
        isSubsetSumZeroAleatorio(arr, n);
        System.out.println("\nDesempeño del algoritmo con "+n+" elementos");

        //Stored data

        System.out.println("--------------------Datos quemados--------------------");
        isSubsetSumZeroQuemado(arrQuemado, n2);
        System.out.println("\nDesempeño del algoritmo con "+n+" elementos");
        }
    }
