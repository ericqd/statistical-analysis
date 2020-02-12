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
                double average = displayAverage(list);
                DecimalFormat df = new DecimalFormat("0.0");
                System.out.println("The average was: " + df.format(average));
                break;
            case 3:
                int maximum = displayMax(list);
                System.out.println("The maximum grade was: " + maximum);
                break;
            case 4:
                int minimum = displayMin(list);
                System.out.println("The minimum grade was: " + minimum);
                break;
            case 5:
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
    public static double displayAverage(ArrayList<Integer> array){
        double sum = 0;
        double count = 0;
        for(int i = 0; i < array.size(); i++){
            sum += array.get(i);
            count++;
        }
        return sum/count;
    }
    public static double findMedian(ArrayList<Integer> array){
        double median = array.size() / 2;
        if(array.size() % 2 == 1){
            median = (array.get(array.size()/2) + array.get(array.size()/2 - 1))/2;
        }
        else{
            median = array.get(array.size()/2);
        }
        return median;
    }
    public static int displayMax(ArrayList<Integer> array){
        ArrayList<Integer> maxList = (ArrayList<Integer>) array.clone();
        for(int i = 0; i < maxList.size(); i++){
            int lowest = i;
            for(int j = i + 1; j< maxList.size(); j++){
                if(maxList.get(j) < maxList.get(lowest)){
                    lowest = j;
                }
            }
            int swap = maxList.get(i);
            maxList.set(i, maxList.get(lowest));
            maxList.set(lowest,swap);
        }
        int max = maxList.get(maxList.size() - 1);
        return max;
    }
    public static int displayMin(ArrayList<Integer> array){
        ArrayList<Integer> minList = (ArrayList<Integer>) array.clone();
        for(int i = 0; i < minList.size(); i++){
            int lowest = i;
            for(int j = i + 1; j< minList.size(); j++){
                if(minList.get(j) < minList.get(lowest)){
                    lowest = j;
                }
            }
            int swap = minList.get(i);
            minList.set(i, minList.get(lowest));
            minList.set(lowest,swap);
        }
        int min = minList.get(0);
        return min;
    }
    public static void displayMenu(){
        System.out.println("1. Display Sorted Grades");
        System.out.println("2. Display Average Grade");
        System.out.println("3. Display Maximum Grade");
        System.out.println("4. Display Minimum Grade");
        System.out.println("5. Display Median Grade");
        System.out.println("6. Quit");

    }
}
