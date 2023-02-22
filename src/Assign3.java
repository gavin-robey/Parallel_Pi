import java.util.ArrayList;

public class Assign3{
    private static ArrayList<Integer> digits = new ArrayList<>();
    private static TaskQueue<Integer> tasks = new TaskQueue<>();
    public static void main(String[] args) {
        populateQueue();

        // TODO: Calculate how many CPU cores there are
        // TODO: Create as many worker threads as there are CPU cores 
        // TODO: 


    }

    public static void populateQueue(){
        for(int i = 1; i <= 1000; i++){
            digits.add(i);
        }

        java.util.Collections.shuffle(digits);

        for(Integer digit: digits){
            tasks.enqueue(digit);
        }
    }
}