import java.util.ArrayList;

public class Assign3{
    public synchronized static void main(String[] args) {
        ArrayList<Integer> digits = new ArrayList<>();
        TaskQueue<Integer> tasks = new TaskQueue<>();
        ResultTable<Integer, Integer> results = new ResultTable<>();
        populateQueue(digits, tasks);
        
        long startTime = System.nanoTime(); // Get the start time in nanoseconds
        
        try {
            execute(tasks, results, 8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long endTime = System.nanoTime(); // Get the end time in nanoseconds
        long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
        
        System.out.println("Time taken: " + duration + "ms");
    }

    public static void execute(TaskQueue<Integer> tasks, ResultTable<Integer, Integer> results, int cores) throws InterruptedException{
        Worker[] threads = new Worker[cores];
        for(int i = 0; i < threads.length; i++){
            threads[i] = new Worker(tasks, results);
            threads[i].start();
        }
        for (Worker thread : threads) {
            thread.join();
        }
        System.out.println(results.toString());
    }

    public synchronized static void populateQueue(ArrayList<Integer> digits, TaskQueue<Integer> tasks){
        for(int i = 1; i <= 500; i++){
            digits.add(i);
        }
        java.util.Collections.shuffle(digits);

        for(Integer digit: digits){
            tasks.enqueue(digit);
        }
    }
}