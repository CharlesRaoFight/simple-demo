package com.simple.demo.threadpool;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title:com.simple.demo.threadpool.MyThreadPoolService
 * @Auther: Charles Rao
 * @Date: 2020/06/07/22:00
 * @Description:
 */
public class MyThreadPoolService {

    private int coreThreadSize;
    private int blockingQueueSize;
    private List<Thread> threadList = new ArrayList<>();

    public MyThreadPoolService(int coreThreadSize, int blockingQueueSize) {
        this.coreThreadSize = coreThreadSize;
        this.blockingQueueSize = blockingQueueSize;
        for(int index = 0 ; index < coreThreadSize ; index++){
            threadList.add(new TaskThread());
        }
    }

    class TaskThread extends Thread{
        @Override
        public void run() {
            while(true){

            }
        }
    }

    void start(){


    }






}
