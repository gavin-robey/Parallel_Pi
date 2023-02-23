public class Worker extends Thread{
    private TaskQueue<Integer> task;
    private ResultTable<Integer, Integer> results;
    private Bpp bpp;

    public Worker(TaskQueue<Integer> task, ResultTable<Integer, Integer> results) {
        this.task = task;
        this.results = results;
        this.bpp = new Bpp();
        
    }

    public void run() {
        try {
            while(!task.isEmpty()){
                int place = task.dequeue();
                int digit = Integer.parseInt(Integer.toString(bpp.getDecimal(place)).substring(0, 1));
                results.put(place, digit);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
