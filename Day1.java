import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class Day1 {
    
  public static boolean isInteger(char str) {
    return Character.isDigit(str);
}

    public static void main(String[] args) {
      
      try {
        File myObj = new File("day1.txt");
        Scanner reader = new Scanner(myObj);
        ArrayList<Integer> outerArray = new ArrayList<>(Arrays.asList());

        while (reader.hasNextLine()) {
          
          String data = reader.nextLine();
          ArrayList<Integer> innerArray = new ArrayList<>(Arrays.asList());
          for (int i=0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (isInteger(c)) {
              int d = (int) Character.getNumericValue(c);
              innerArray.add(d);
            }
          
          }

          Integer[] nArray = innerArray.toArray(new Integer[0]);
        
          if(innerArray.size() > 1) {
            String first = String.valueOf(nArray[0]);
            String second = String.valueOf(nArray[innerArray.size()-1]);
            int output = Integer.parseInt(first+second);
            outerArray.add(output);
          }
          else if (innerArray.size() == 1) {
            String output = String.valueOf(nArray[0]) + String.valueOf(nArray[0]);
            outerArray.add(Integer.parseInt(output));       
            }
          

        }
        reader.close();

        Integer[] rArray = outerArray.toArray(new Integer[0]);

        int sum = 0;
        for (int i : rArray) {
          sum = sum + i;
        }
        System.out.println(sum);
      }
      catch (FileNotFoundException e){
        System.out.println(e);
        e.printStackTrace();
      }
    }
  }