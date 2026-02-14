import java.util.concurrent.*;

class Task implements Callable<String> {

    private String message;

    public Task(String message)
    {
        this.message = message;
    }

    public String call() throws Exception
    {
        return "Hi " + message + "!";
    }
}

public class Geeks {

    public static void main(String[] args)
    {

        Task task = new Task("GeeksForGeeks");

        // Creating object of ExecutorService class and Future object Class
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> result = executorService.submit(task);

        // Try block to check for exceptions
        try {
            System.out.println(result.get());
        }

        // Catch block to handle the exception
        catch (InterruptedException  | ExecutionException e) {

            System.out.println("Error occurred while executing the submitted task");
            e.printStackTrace();
        }

        // Cleaning resource and shutting down JVM by saving JVM state using shutdown() method
        executorService.shutdown();
    }
}