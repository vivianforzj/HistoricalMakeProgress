package personal.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by jzhou on 16-3-28.
 */
public class BlockingQueueCase {

    static class Producer extends Thread {
        BlockingQueue<String> blockingQueue;
        int count;
        String threadName;

        public Producer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
            this.count = 1;
        }

        @Override
        public void run() {
            this.threadName = Thread.currentThread().getName();
            while (count <= 10)
                try {
                    String str = "Producer-" + this.threadName + ": " + this.count;
                    blockingQueue.put(str);
                    System.out.println(str);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    static class Consumer extends Thread {
        BlockingQueue<String> blockingQueue;
        String threadName;
        boolean isRunning;

        public Consumer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
            this.isRunning = true;
        }

        @Override
        public void run() {
            this.threadName = Thread.currentThread().getName();
            while (isRunning) {
                String str = null;
                try {
                    str = blockingQueue.poll(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (str != null)
                    System.out.println("Consumer-" + this.threadName + " Get " + str);
                else
                    isRunning = false;
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(2);
        int producerNum = 4, consumerNum = 2;
        Producer[] producers = new Producer[producerNum];
        Consumer[] consumers = new Consumer[consumerNum];

        for (int i = 0; i < producerNum; i++) {
            producers[i] = new Producer(blockingQueue);
            producers[i].start();
        }
        for (int i = 0; i < consumerNum; i++) {
            consumers[i] = new Consumer(blockingQueue);
            consumers[i].start();
        }

        for (int i = 0; i < producerNum; i++)
            producers[i].join();


        for (int i = 0; i < consumerNum; i++)
            consumers[i].join();
    }

}
