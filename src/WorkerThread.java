public class WorkerThread extends Thread{
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    private TaskQueue<Integer> task;
    private ResultTable<Integer, Integer> results;
    private Bpp bpp;

    public WorkerThread(TaskQueue<Integer> task, ResultTable<Integer, Integer> results) {
        this.task = task;
        this.results = results;
        this.bpp = new Bpp();
    }

    public void run() {
        try {
            while(!task.isEmpty()){
                int place = task.dequeue();
                int digit = bpp.getDecimal(place);
                results.put(place, digit);

                if(results.size() % 10 == 0){
                    System.out.flush();
                    System.out.print(ANSI_GREEN + "+" + ANSI_RESET);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
