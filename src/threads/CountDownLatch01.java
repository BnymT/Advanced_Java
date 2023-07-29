package threads;

import java.util.concurrent.CountDownLatch;

/*
Bazi thread lerin once calismasini bu arada diger thread lerin ve main thread in de beklemesini istedigimiz
durumlarda CountDownLatch ile bir sayac olusturulur ve oncelik verdigimiz her bir thread isini tamamladiginda
sayac 1 azaltilir. Sayac 0 oldugunda diger thread lerin ve main thread in calismaya devam etmesine izin verilir.
 */
public class CountDownLatch01 {

    public static void main(String[] args) {

        System.out.println("Main thread calismaya basladi");

        CountDownLatch latch = new CountDownLatch(4);

        Thread thread1 = new Thread(new Runnable() { // Araba
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "calismaya basladi");
                try {
                    latch.await(); // CountDown methodu ile sayac 0 olana kadar bekler
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "calismaya devam ediyor");
            }
        }, "Car"); // new Thread(Runnable target, String name)
        thread1.start();

        WorkerThreads worker1 = new WorkerThreads("Worker1", 6000, latch); // Tren vagonlari
        WorkerThreads worker2 = new WorkerThreads("Worker2", 5000, latch);
        WorkerThreads worker3 = new WorkerThreads("Worker3", 3000, latch);
        WorkerThreads worker4 = new WorkerThreads("Worker4", 7000, latch);
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        try {
            latch.await(); // worker thread leri bekle
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main thread calisiyor");

    }
}

class WorkerThreads extends Thread {

    private int duration; // bekleme suresini dinamik olarak belirlemek icin
    private CountDownLatch latch;

    public WorkerThreads(String name, int duration, CountDownLatch latch) {
        super(name);
        this.duration = duration;
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName() + " çalışmaya başladı.");
            Thread.sleep(duration);
            System.out.println(Thread.currentThread().getName() + " isini bitirdi.");
            latch.countDown(); // 3-2-1 --> 0 oldugunda diger thread lere izin ver.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}