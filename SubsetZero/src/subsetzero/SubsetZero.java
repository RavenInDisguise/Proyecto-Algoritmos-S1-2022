/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubsetZero;
import java.util.ArrayList;
import java.util.Random;
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
    //Array que almacena todos los subsets encontrados de ambas funciones
    public static ArrayList<ArrayList<Integer>> allSubsets2 = new ArrayList<ArrayList<Integer>>();
    //Array auxiliar para almacenar los subsets del algoritmo de programación dinámica
    
    /*
    ~Función encargada de realizar el algoritmo de fuerza bruta para encontrar los 
    subconjuntos cuya suma equivale a cero.
    ~Datos que recibe: El array, el tamaño del array.
    ~Datos que retorna: Ninguno. 
    */
    
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

    /*
    ~Función encargada de realizar el algoritmo de fuerza bruta para encontrar los 
    subconjuntos cuya suma equivale a cero.
    ~Datos que recibe: El array, el tamaño del array.
    ~Datos que retorna: Ninguno. 
    */
    static void printSubsets(){
       boolean sameValues=false;
       boolean sameValuesAdded=false;
       int valueUsed=-16;
       
       allSubsets2.clear();
               
       for (int x=0; x < allSubsets.size(); x++) {
            int sum=0;
            for (int y=0; y < allSubsets.get(x).size(); y++) {
                 ArrayList<Integer> actualList=allSubsets.get(x);
                 sum+=actualList.get(y);
                 if(allSubsets.get(x).size()==2 && Math.abs(actualList.get(0))== Math.abs(actualList.get(1))
                         && Math.abs(actualList.get(0))!=valueUsed){
                    sameValues=true;
                    valueUsed=Math.abs(actualList.get(0));
                 } else{
                    sameValues=false;
                 } 
            }
            if(sum==0){
                if(sameValues && !sameValuesAdded){
                    allSubsets2.add(allSubsets.get(x));
                    sameValuesAdded=true;
                    //sameValues=false;
                }else if(!sameValues){
                    allSubsets2.add(allSubsets.get(x));
                    sameValues=false;
                }
            }


        }
        allSubsets.clear();
        allSubsets2.remove(allSubsets2.size()-1);
        System.out.println(allSubsets2.toString());
    }
   
    static int a2 = 6;// "asignaciones counter"
    static int c2 = 0;// "comparaciones counter"

    // To find the number of subsets with sum equal to 0
    // Since S can be negative, we will maxSum
    // to it to make it positive
    
    /*
    ~Función encargada de realizar el algoritmo de fuerza bruta para encontrar los 
    subconjuntos cuya suma equivale a cero.
    ~Datos que recibe: El array, el tamaño del array.
    ~Datos que retorna: Ninguno. 
    */
    static int isSubsetSumZeroDP(int i, int s, ArrayList<Integer> currentSubset, int arr[], int n){

        // Base cases
        c2++;
        if (i == n){
            c2++;
            if (s == 0){
                allSubsets.add(currentSubset);
                a2++;
                return 1;
            }else{
                return 0;
            }
        }

        allSubsets.add(currentSubset);
        a2++;

        // Returns the value if a state is already solved
        c2++;
        if (visit[i][s + arrSize]){
            return dp[i][s + arrSize];
        }

        // If the state is not visited, then continue
        visit[i][s + arrSize] = true;
        a2++;

        // Recurrence relation
        ArrayList<Integer> currentSubset2 =  new ArrayList<>();
        a2++;
        currentSubset2=(ArrayList<Integer>) currentSubset.clone();
        a2++;
        currentSubset.add(arr[i]);
        a2++;
        dp[i][s + arrSize] = isSubsetSumZeroDP(i + 1, s + arr[i], currentSubset, arr, n)
                + isSubsetSumZeroDP(i + 1, s, currentSubset2, arr, n);
        a2++;

        // End recursion

        return -1;



        // Returning the value
        //return dp[i][s + arrSize];
    }
    
    /*
    ~Función encargada de realizar el algoritmo de fuerza bruta para encontrar los 
    subconjuntos cuya suma equivale a cero.
    ~Datos que recibe: El array, el tamaño del array.
    ~Datos que retorna: Ninguno. 
    */
    static void printAC(int a, int c, double startTime2){

        System.out.println("Asignaciones: " + a);
        System.out.println("Comparaciones: " + c);
        System.out.println("Lineas ejecutadas: " + (a+c));
        double endTime2 = System.currentTimeMillis() - startTime2; // The current time at the end of the program
        System.out.println("Tiempo de ejecución: "+endTime2+" ms"); // The final print for the system timer
    }

//__________________________________________________________________________________________________________________


    /* Driver program to test above function */
    public static void main(String args[]){

        int min = -15; //parametros para el minimo del numero aleatorio
        int max = 15; //parametros para el maximo del numero aleatorio

        for(int i=3; i <= 21;i++){

            //Randomdata array creation
            Random rd = new Random(); // creating Random object
            int[] arrAleatorio = new int[i]; // input the lenght of the array

            for (int j = 0; j < arrAleatorio.length; j++) {
                arrAleatorio[j] = rd.nextInt(max-min+1) + min; // storing random integers in an array
            }

            int n = arrAleatorio.length;

            System.out.println("====================EJECUCION ALGORITMO PROGRAMACIÓN DINÁMICA================================\n");
            //Random data
            System.out.println("--------------------Datos aleatorios--------------------");
            System.out.println("\nDesempeño del algoritmo con "+n+" elementos");
            ArrayList<Integer> currentSubset =  new ArrayList<>();
            double startTime2 = System.currentTimeMillis(); // timer startup
            isSubsetSumZeroDP(0,0,currentSubset,arrAleatorio, n);
            printSubsets();
            printAC(a2, c2, startTime2);

            System.out.println("====================EJECUCION ALGORITMO FUERZA BRUTA================================\n");

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

            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~INICIO DE SEGUNDA PARTE (DATOS QUEMADOS)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*"+"\n");

            //Stored data
            System.out.println("\n--------------------3 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Fuerza Bruta con "+n3+" elementos");
            isSubsetSumZero(arrQuemado3, n3);

            System.out.println("\n--------------------3 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Programacion Dinamica con "+n3+" elementos");
            ArrayList<Integer> currentSubset3 =  new ArrayList<>();
            double startTime3 = System.currentTimeMillis(); // timer startup
            isSubsetSumZeroDP(0,0,currentSubset3,arrQuemado3, n3);
            printSubsets();
            printAC(a2, c2, startTime3);

            System.out.println("\n--------------------4 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Fuerza Bruta con "+n4+" elementos");
            isSubsetSumZero(arrQuemado4, n4);

            System.out.println("\n--------------------4 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Programacion Dinamica con "+n4+" elementos");
            ArrayList<Integer> currentSubset4 =  new ArrayList<>();
            double startTime4 = System.currentTimeMillis(); // timer startup
            isSubsetSumZeroDP(0,0,currentSubset4,arrQuemado4, n4);
            printSubsets();
            printAC(a2, c2, startTime4);

            System.out.println("\n--------------------5 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Fuerza Bruta con "+n5+" elementos");
            isSubsetSumZero(arrQuemado5, n5);

            System.out.println("\n--------------------5 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Programacion Dinamica con "+n5+" elementos");
            ArrayList<Integer> currentSubset5 =  new ArrayList<>();
            double startTime5 = System.currentTimeMillis(); // timer startup
            isSubsetSumZeroDP(0,0,currentSubset5,arrQuemado5, n5);
            printSubsets();
            printAC(a2, c2, startTime5);

            System.out.println("\n--------------------6 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Fuerza Bruta con "+n6+" elementos");
            isSubsetSumZero(arrQuemado6, n6);

            System.out.println("\n--------------------6 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Programacion Dinamica con "+n6+" elementos");
            ArrayList<Integer> currentSubset6 =  new ArrayList<>();
            double startTime6 = System.currentTimeMillis(); // timer startup
            isSubsetSumZeroDP(0,0,currentSubset6,arrQuemado6, n6);
            printSubsets();
            printAC(a2, c2, startTime6);

            System.out.println("\n--------------------7 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Fuerza Bruta con "+n7+" elementos");
            isSubsetSumZero(arrQuemado7, n7);

            System.out.println("\n--------------------7 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Programacion Dinamica con "+n7+" elementos");
            ArrayList<Integer> currentSubset7 =  new ArrayList<>();
            double startTime7 = System.currentTimeMillis(); // timer startup
            isSubsetSumZeroDP(0,0,currentSubset7,arrQuemado7, n7);
            printSubsets();
            printAC(a2, c2, startTime7);

            System.out.println("\n--------------------10 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Fuerza Bruta con "+n10+" elementos");
            isSubsetSumZero(arrQuemado10, n10);

            System.out.println("\n--------------------10 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Programacion Dinamica con "+n10+" elementos");
            ArrayList<Integer> currentSubset10 =  new ArrayList<>();
            double startTime10 = System.currentTimeMillis(); // timer startup
            isSubsetSumZeroDP(0,0,currentSubset10,arrQuemado10, n10);
            printSubsets();
            printAC(a2, c2, startTime10);

            System.out.println("\n--------------------11 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Fuerza Bruta con "+n11+" elementos");
            isSubsetSumZero(arrQuemado11, n11);

            System.out.println("\n--------------------11 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Programacion Dinamica con "+n11+" elementos");
            ArrayList<Integer> currentSubset11 =  new ArrayList<>();
            double startTime11 = System.currentTimeMillis(); // timer startup
            isSubsetSumZeroDP(0,0,currentSubset11,arrQuemado11, n11);
            printSubsets();
            printAC(a2, c2, startTime11);

            System.out.println("\n--------------------12 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Fuerza Bruta con "+n12+" elementos");
            isSubsetSumZero(arrQuemado12, n12);

            System.out.println("\n--------------------12 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Programacion Dinamica con "+n12+" elementos");
            ArrayList<Integer> currentSubset12 =  new ArrayList<>();
            double startTime12 = System.currentTimeMillis(); // timer startup
            isSubsetSumZeroDP(0,0,currentSubset12,arrQuemado12, n12);
            printSubsets();
            printAC(a2, c2, startTime12);

            System.out.println("\n--------------------13 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Fuerza Bruta con "+n13+" elementos");
            isSubsetSumZero(arrQuemado13, n13);

            System.out.println("\n--------------------13 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Programacion Dinamica con "+n13+" elementos");
            ArrayList<Integer> currentSubset13 =  new ArrayList<>();
            double startTime13 = System.currentTimeMillis(); // timer startup
            isSubsetSumZeroDP(0,0,currentSubset13,arrQuemado13, n13);
            printSubsets();
            printAC(a2, c2, startTime13);

            System.out.println("\n--------------------14 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Fuerza Bruta con "+n14+" elementos");
            isSubsetSumZero(arrQuemado14, n14);

            System.out.println("\n--------------------14 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Programacion Dinamica con "+n14+" elementos");
            ArrayList<Integer> currentSubset14 =  new ArrayList<>();
            double startTime14 = System.currentTimeMillis(); // timer startup
            isSubsetSumZeroDP(0,0,currentSubset14,arrQuemado14, n14);
            printSubsets();
            printAC(a2, c2, startTime14);

            System.out.println("\n--------------------15 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Fuerza Bruta con "+n15+" elementos");
            isSubsetSumZero(arrQuemado15, n15);

            System.out.println("\n--------------------15 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Programacion Dinamica con "+n15+" elementos");
            ArrayList<Integer> currentSubset15 =  new ArrayList<>();
            double startTime15 = System.currentTimeMillis(); // timer startup
            isSubsetSumZeroDP(0,0,currentSubset15,arrQuemado15, n15);
            printSubsets();
            printAC(a2, c2, startTime15);

            System.out.println("\n--------------------20 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Fuerza Bruta con "+n20+" elementos");
            isSubsetSumZero(arrQuemado20, n20);

            System.out.println("\n--------------------20 Datos quemados--------------------");
            System.out.println("\nDesempeño del algoritmo Programacion Dinamica con "+n20+" elementos");
            ArrayList<Integer> currentSubset20 =  new ArrayList<>();
            double startTime20 = System.currentTimeMillis(); // timer startup
            isSubsetSumZeroDP(0,0,currentSubset20,arrQuemado20, n20);
            printSubsets();
            printAC(a2, c2, startTime20);

    }
}
