package test;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureStudy {
    public static void main(String[] args) throws InterruptedException, ExecutionException {  
        ExecutorService executor = Executors.newCachedThreadPool(); 
        Future<?> runFuture = executor.submit(new MyRunTask());
        Future<String> callFuture = executor.submit(new MyCallTask());
        Future<?> taskFuture = executor.submit(new MyFutureTask());
        System.out.println("任务全部提交成功，开始get 获取返回结果....... ");
        Thread.sleep(3000);

        System.out.println(runFuture.get());
        System.out.println(callFuture.get());
        System.out.println(taskFuture.get());
        executor.shutdown();  
    }  

    static class MyFutureTask extends FutureTask<String> {  

        public MyFutureTask(){
            this(new Callable<String>(){

                @SuppressWarnings("unchecked")
                @Override
                public String call() throws Exception {
                    System.out.println(" FutureTask 线程执行完毕！~" );  
                    return (String) "FutureTask 返回值！~";
                }


            });
        }

        public MyFutureTask(Callable<String> callable) {  
            super(callable);  
        }  

        @Override  
        protected void done() {  
            System.out.println("执行回调的done方法~"); 
        }     
    }  

    static class MyCallTask implements Callable<String> {  

        @Override  
        public String call() throws Exception {  
            System.out.println(" callable 线程执行完毕！~" );  
            return "callable返回值";  
        }  
    }

    static class MyRunTask implements Runnable {  

        @Override  
        public void run() {
            System.out.println(" runnable 线程执行完毕！~, 无返回值" );  
        }  
    }
}