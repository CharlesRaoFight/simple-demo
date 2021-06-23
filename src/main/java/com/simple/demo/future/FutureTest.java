package com.simple.demo.future;

import com.simple.demo.entity.Student;
import com.simple.demo.entity.Teacher;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Title:com.simple.demo.future.FutureTest
 * @Auther: Charles Rao
 * @Date: 2020/05/25/23:00
 * @Description:
 */
public class FutureTest {

    public static void main(String[] args) throws InterruptedException {
        Teacher teacher = new Teacher("Smith");
        Callable call1 = new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(5000);
                return teacher.attend();
            }
        };
        FutureTask futureTask1 = new FutureTask(call1);
        new Thread(futureTask1).start();
        Student student = new Student("Jack");
        Callable call2 = new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(3000);
                return student.attend();
            }
        };
        FutureTask futureTask2 = new FutureTask(call2);
        new Thread(futureTask2).start();
        while (true){
            if(!futureTask1.isDone()){
                System.out.println("teacher is not attend");
            }
            if(!futureTask2.isDone()){
                System.out.println("student is not attend");
            }
            if(futureTask1.isDone() && futureTask2.isDone()){
                System.out.println("begin class");
                break;
            }
        }

    }


}
