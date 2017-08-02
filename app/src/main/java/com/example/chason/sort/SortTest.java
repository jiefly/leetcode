package com.example.chason.sort;


import java.net.URL;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by chgao on 17-7-20.
 */

public class SortTest {
    public static void main(String[] args) throws InterruptedException {
//        new SortTest().testEventBus();
//        Thread.sleep(1000);
        System.out.println(System.getProperty("java.ext.dirs"));
//        int[] in = new int[18];
//        System.out.println("raw data:");
//        for (int i = 0; i < in.length; i++) {
//            in[i] = new Random().nextInt(100);
//            System.out.print(in[i] + "_");
//        }
//        System.out.println("");
//        int[] tmp1 = copy(in);
//        Sort.shellSort(tmp1);
//        System.out.println("shell sort:");
//        for (int i : tmp1) {
//            System.out.print(i + "_");
//        }
//        System.out.println("");
//        tmp1 = copy(in);
//        System.out.println("insertion sort:");
//        Sort.insertionSort(tmp1);
//        for (int i : tmp1) {
//            System.out.print(i + "_");
//        }
//        System.out.println("");
//        tmp1 = copy(in);
//        System.out.println("selection sort:");
//        Sort.selectionSort(tmp1);
//        for (int i : tmp1) {
//            System.out.print(i + "_");
//        }
//        System.out.println("");
//        System.out.println("merge sort down:");
//        for (int i : Sort.mergeSortDown(copy(in))) {
//            System.out.print(i + "_");
//        }
//        System.out.println("");
//        tmp1 = copy(in);
//        System.out.println("quick sort:");
//        Sort.quickSort(tmp1, 0, tmp1.length - 1);
//        for (int i : tmp1) {
//            System.out.print(i + "_");
//        }
//        System.out.println("");
//        tmp1 = copy(in);
//        System.out.println("merge sort up:");
//        Sort.mergeSortUp(tmp1);
//        for (int i : tmp1) {
//            System.out.print(i + "_");
//        }
//        System.out.println("");
//        tmp1 = copy(in);
//        System.out.println("base sort:");
//        Sort.baseSort(tmp1, 3);
//        for (int i : tmp1) {
//            System.out.print(i + "_");
//        }
//        System.out.println("");
//        tmp1 = copy(in);
//        System.out.println("heap sort:");
//        Sort.heapSort(tmp1);
//        for (int i : tmp1) {
//            System.out.print(i + "_");
//        }
//        System.out.println("");
//        tmp1 = copy(in);
//        System.out.println("quick3way sort:");
//        Sort.quick3WaySort(tmp1, 0, tmp1.length - 1);
//        for (int i : tmp1) {
//            System.out.print(i + "_");
//        }
//        System.out.println("");
//        tmp1 = copy(in);
//        System.out.println("double pivot quick sort:");
//        Sort.doublePivotQuickSort(tmp1, 0, tmp1.length - 1);
//        for (int i : tmp1) {
//            System.out.print(i + "_");
//        }
//        System.out.println("\nend");

    }

    private static int[] copy(int[] from) {
        int[] result = new int[from.length];
        System.arraycopy(from, 0, result, 0, result.length);

        return result;
    }

    public static void printCurrentThread() {
        System.out.println(Thread.currentThread().getName());
    }

    public void testEventBus() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                System.out.println("start->");
                subscriber.onNext(123);
                printCurrentThread();
            }
        }).doOnSubscribe(new Action0() {
            @Override
            public void call() {

            }
        })
                .observeOn(Schedulers.io())
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        System.out.println("int->" + integer);
                        printCurrentThread();
                        return String.valueOf(integer);
                    }
                })
                .subscribeOn(Schedulers.from(new Executor() {
                    @Override
                    public void execute(final Runnable command) {
                        new Thread("jie") {
                            @Override
                            public void run() {
                                command.run();
                            }
                        }.start();

                    }
                }))
                .map(new Func1<String, Long>() {
                    @Override
                    public Long call(String s) {
                        System.out.println("String->" + s);
                        printCurrentThread();
                        return Long.parseLong(s);
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.computation())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        System.out.println("result->" + aLong);
                        printCurrentThread();
                    }
                });
    }

}
