import java.util.ArrayList;

public class Assign3{
    private static ArrayList<Integer> digits = new ArrayList<>();
    private static TaskQueue<Integer> tasks = new TaskQueue<>();
    private static ResultTable<Integer, Integer> results = new ResultTable<>();
    public static void main(String[] args) {
        populateQueue();
        long startTime = System.nanoTime(); // Get the start time in nanoseconds
        
        try {
            execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long endTime = System.nanoTime(); // Get the end time in nanoseconds
        long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
        
        System.out.println(" ");
        System.out.println("Time taken: " + duration + "ms");
    }

    public static void execute() throws InterruptedException{
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Executing using " + cores + " cores");
        System.out.println(" ");
        WorkerThread[] threads = new WorkerThread[cores];

        for(int i = 0; i < threads.length; i++){
            threads[i] = new WorkerThread(tasks, results);
            threads[i].start();
        }
        for (WorkerThread thread : threads) {
            thread.join();
        }

        System.out.println(" ");
        System.out.println(results.toString());
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