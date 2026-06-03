class ThreadExample extends Thread{
    int threadNumber ;
    ThreadExample(int num) {
        threadNumber = num;
    }
    public void run() {
        for(int i=0;i<10;i++) {
            System.out.println("Thread is " + threadNumber + " count is " + i);
            try {
                Thread.sleep(1000);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}


public class ThreadEx {
    public static void main(String[] args) {
        ThreadExample t1 = new ThreadExample(1);
        ThreadExample t2 = new ThreadExample(2);
        t1.start();
        t2.start();
    }
}
