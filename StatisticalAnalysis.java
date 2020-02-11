import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class StatisticalAnalysis{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList <Integer>();
        boolean isTrue = false;
        while(isTrue == false){
            displayMenu();
            int selection = CheckInput.getIntRange(1,6);
            switch(selection){

            case 1:
                sortList(list);
                System.out.println(list);
                
            case 2:


        
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
            System.out.print(array.get(i) + " ");
            if(i % 10 == 0 && i != 0){
                System.out.print("\n");
            }
        }
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
        int max = array.get(array.size() - 1);
        return max;
    }
    public static int displayMin(ArrayList<Integer> array){
        int min = array.get(0);
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
