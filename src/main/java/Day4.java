import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day4 {
    
    //need to create two int[], filling in the numbers for each range
    //need to compare the arrays to see if one fully contains the other or not

    public static void main(String[] args) throws Exception{

        String example = """
            2-4,6-8
            2-3,4-5
            5-7,7-9
            2-8,3-7
            6-6,4-6
            2-6,4-8
                """;

        BufferedReader br = new BufferedReader(new FileReader("inputs/day4.txt"));

        int count = 0;
        int secondCount = 0;
        int all = 0;

        String line;
        while ((line = br.readLine()) != null) {
        // for (String line : example.split("\n")) {
            String[] elfAssign = line.split(",");

            String[] assignOne = elfAssign[0].split("-");
            String[] assignTwo = elfAssign[1].split("-");

            int assignOneLow = Integer.parseInt(assignOne[0]);
            int assignOneHigh = Integer.parseInt(assignOne[1]);
            int assignTwoLow = Integer.parseInt(assignTwo[0]);
            int assignTwoHigh = Integer.parseInt(assignTwo[1]);

            if (assignOneLow <= assignTwoLow && assignOneHigh >= assignTwoHigh
            || assignTwoLow <= assignOneLow && assignTwoHigh >= assignOneHigh) {
                count ++;
            }

            if (assignOneLow > assignTwoHigh || assignTwoLow > assignOneHigh) {
                secondCount++;
            }

            all++;

        }

        System.out.println("Count One " + count);
        System.out.println("Count Two " + secondCount);
        System.out.println("All "+ all);
        System.out.println("The second answer is " + (all - secondCount));
    
    }
}
