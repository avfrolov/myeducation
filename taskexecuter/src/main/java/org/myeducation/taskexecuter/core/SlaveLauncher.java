package org.myeducation.taskexecuter.core;


/**
 * Created with IntelliJ IDEA.
 * User: kirilkadurilka
 * Date: 13.02.13
 * Time: 1:04
 * To change this template use File | Settings | File Templates.
 */
public class SlaveLauncher {
    public static void main(String[] args){

        final Thread currentThread = Thread.currentThread();
        final Executor executor = new Executor();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {

                executor.shutDown();

                try {
                    currentThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
    }
}
