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
 * @author Mónica Alfaro, Ignacio Brenes
 */
public class FuerzaBruta {
    /**
     *
     */
    public static ArrayList<List> allSubsets = new ArrayList<List>();

    static void isSubsetSumZero(int arr[], int n){

        allSubsets=new ArrayList<List>();
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
    
    /* Driver program to test above function */
    public static void main(String args[]){

        for(int i=3; i<=30;i++){
            
            //Randomdata array creation
            Random rd = new Random(); // creating Random object
            int[] arrAleatorio = new int[i]; // input the lenght of the array

            for (int j = 0; j < arrAleatorio.length; j++) {
                arrAleatorio[j] = rd.nextInt(); // storing random integers in an array
            }
            int n = arrAleatorio.length;
            
            //Stored data array creation
            int[] arrQuemado = new int[]{-1,1,-2,2,-3};
            int n2 = arrQuemado.length;

            

            System.out.println("\n"+"*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*"+"\n");
            
            //Random data
            System.out.println("--------------------Datos aleatorios--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n+" elementos");
            isSubsetSumZero(arrAleatorio, n);
            

            //Stored data
            System.out.println("\n--------------------Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n2+" elementos");
            isSubsetSumZero(arrQuemado, n2);
            
        }
    }
}
