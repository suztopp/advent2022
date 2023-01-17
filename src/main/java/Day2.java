import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Day2 {

    static final Integer rock = 1;
    static final Integer paper = 2;
    static final Integer scissors = 3;

    static final Integer loss = 0;
    static final Integer draw = 3;
    static final Integer win = 6;

    public static void main(String[] args) throws Exception{

        Map<String, Integer> shapes = new HashMap<>();
        shapes.put("A", rock);
        shapes.put("B", paper);
        shapes.put("C", scissors);
        shapes.put("X", rock);
        shapes.put("Y", paper);
        shapes.put("Z", scissors);

        BufferedReader br = new BufferedReader(new FileReader("inputs/daytwo.txt"));

        Integer scoreOne = 0;
        Integer predscore = 0;

        String line;
        while ((line = br.readLine()) != null) {

            String[] match = line.trim().split(" ");

            if (match.length != 2) continue;

            if (shapes.get(match[0]).equals(shapes.get(match[1]))) {
                scoreOne += draw;
            } else if (shapes.get(match[0]) == rock && shapes.get(match[1]) == paper){
                scoreOne += win;
            } else if (shapes.get(match[0]) == paper && shapes.get(match[1]) == scissors){
                 scoreOne += win;
            } else if (shapes.get(match[0]) == scissors && shapes.get(match[1]) == rock){
                scoreOne += win;
            } else {
                scoreOne += loss;
            }
            scoreOne += shapes.get(match[1]);

            if (match[1].equals("X")) {
                predscore += loss;

                if (shapes.get(match[0]) == rock) {
                    predscore += scissors;
                }
                if (shapes.get(match[0]) == paper) {
                    predscore += rock;
                }
                if (shapes.get(match[0]) == scissors) {
                    predscore += paper;
                }
            }
            if (match[1].equals("Y")) {
                predscore += draw;
                predscore += shapes.get(match[0]);
            }
            if (match[1].equals("Z")) {
                predscore += win;

                if (shapes.get(match[0]) == rock) {
                    predscore += paper;
                }
                if (shapes.get(match[0]) == paper) {
                    predscore += scissors;
                }
                if (shapes.get(match[0]) == scissors) {
                    predscore += rock;
                }
            }
        }

        System.out.println(scoreOne);
        System.out.println(predscore);
    }
}