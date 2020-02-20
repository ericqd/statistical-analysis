import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;
public class StatisticalAnalysis{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList <Integer>();
        populateGrades(list);
        boolean isTrue = false;
        while(isTrue == false){
            displayMenu();
            int selection = CheckInput.getIntRange(1,6);
            switch(selection){

            case 1:
                sortList(list);
                displayGrades(list);
                break;
            case 2:
                sortList(list);
                double average = displayAverage(list)/ list.size();
                DecimalFormat df = new DecimalFormat("0.0");
                System.out.println("The average was: " + df.format(average));
                break;
            case 3:
                sortList(list);
                int maximum = list.get(list.size()-1);
                System.out.println("The maximum grade was: " + maximum);
                break;
            case 4:
                sortList(list);
                int minimum = list.get(0);
                System.out.println("The minimum grade was: " + minimum);
                break;
            case 5:
                sortList(list);
                double median = findMedian(list);
                DecimalFormat df2 = new DecimalFormat("0.0");
                System.out.println("The median was: " + df2.format(median));
                break;
            case 6:
                isTrue = true;
                System.out.println("Goodbye");
                break;
            }
        }
    }
    /**
     * Read a text file line by line and add the grade from that line and add it into the arraylist
     * @param array
     * @return arraylist
     */
    public static ArrayList<Integer> populateGrades(ArrayList<Integer> array) {
        try{
            Scanner read = new Scanner(new File("grades.txt"));
            while(read.hasNext()){
                int line = read.nextInt();
                array.add(line);
            }
            read.close();
        } catch(FileNotFoundException fnf){
            System.out.println("File was not found");
        }
        return array;
    }
    /**
     * Print out values in the arraylist in rows of 10
     * @param array
     */
    public static void displayGrades(ArrayList<Integer> array){
        for(int i=0; i < array.size(); i++){
           if(i % 10 == 0 && i > 0 ){
               System.out.print("\n" + array.get(i) + " ");
           }
           else{
               System.out.print(array.get(i) + " ");
           }
        }
        System.out.println("\n");
    } 
    /**
     * Sorts arraylist using selection sort algorithm
     * @param array
     * @return array
     */
    public static ArrayList<Integer> sortList(ArrayList<Integer> array){
        for(int i = 0; i < array.size(); i++){
            int lowest = i;
            for(int j = i + 1; j< array.size(); j++){
                if(array.get(j) < array.get(lowest)){
                    lowest = j;
                }
            }
            int swap = array.get(i);
            array.set(i, array.get(lowest));
            array.set(lowest,swap);
        }
        return array;
    }
    /**
     * Calculates the average of the arraylist and prints it out
     * @param array
     * @return sum/count
     */
    public static double displayAverage(ArrayList<Integer> array){
        double sum = 0;
        double count = 0;
        for(int i = 0; i < array.size(); i++){
            sum += array.get(i);
            count++;
        }
        return sum;
    }
    /**
     * Finds the middle of the arraylist
     * @param array
     * @return median 
     */
    public static double findMedian(ArrayList<Integer> array){
        double median = 0;
        if(array.size() % 2 == 0){
            median = (double)(array.get((array.size()/2) - 1) + (array.get(array.size()/2)))/2;
        }
        else{
            median = array.get(array.size() /2);
        }
        return median;
    }
    /**
     * Creates a display menu for the user
     */
    public static void displayMenu(){
        System.out.println("1. Display Sorted Grades");
        System.out.println("2. Display Average Grade");
        System.out.println("3. Display Maximum Grade");
        System.out.println("4. Display Minimum Grade");
        System.out.println("5. Display Median Grade");
        System.out.println("6. Quit");

    }
}
