import java.util.ArrayList;

public class Assign3{
    private static ArrayList<Integer> digits = new ArrayList<>();
    private static TaskQueue<Integer> tasks = new TaskQueue<>();
    private static ResultTable<Integer, Integer> results = new ResultTable<>();

    /**
     * main driver of the program
     * Calculates how many threads need to be ran and allocates tasks to each thread
     * @param args
     */
    public static void main(String[] args) {
        populateQueue(1000);
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

    /**
     * Runs all threads and passes in tasks and results
     * Once threads are complete, the results are printed out
     * @throws InterruptedException Caused by thread.join()
     */
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
            thread.join(); // code after this only runs once threads are complete
        }

        System.out.println(" ");
        System.out.println(results.toString()); // Prints results in a formatted matter
    }

    /**
     * populates the task queue with shuffled digit values
     * @param numOfDigits how many digits of pi will be calculated
     */
    public static void populateQueue(int numOfDigits ){
        for(int i = 1; i <= numOfDigits; i++){
            digits.add(i);
        }
        java.util.Collections.shuffle(digits);

        for(Integer digit: digits){
            tasks.enqueue(digit);
        }
    }
}