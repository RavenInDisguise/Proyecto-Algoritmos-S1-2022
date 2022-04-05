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

        //System.out.println(allSubsets.toString());
        System.out.println("Asignaciones: " + a);
        System.out.println("Comparaciones: " + c);
        System.out.println("Lineas ejecutadas: " + l);
        double endTime = System.currentTimeMillis() - startTime; // The current time at the end of the program
        System.out.println("Tiempo de ejecución: "+endTime+" ms"+"\n"); // The final print for the system timer
    }

    /* Driver program to test above function */
    public static void main(String args[]){

        int min = -15; //parametros para el minimo del numero aleatorio
        int max = 15; //parametros para el maximo del numero aleatorio

        System.out.println("====================EJECUCION ALGORITMO FUERZA BRUTA================================\n\n");

        for(int i=3; i <= 20;i++){

            //Randomdata array creation
            Random rd = new Random(); // creating Random object
            int[] arrAleatorio = new int[i]; // input the lenght of the array

            for (int j = 0; j < arrAleatorio.length; j++) {
                arrAleatorio[j] = rd.nextInt(max-min+1) + min; // storing random integers in an array

            }

            int n = arrAleatorio.length;

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
