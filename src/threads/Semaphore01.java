package threads;

import java.util.concurrent.Semaphore;

/*
Semaphore, ortak bir kaynaga sadece n tane thread in ayni anda erismesine izin vermemizi saglar.
Synchronized, ortak kaynaga (method/block) ayni anda sace 1 thread in erisimine izin verir.
 */
public class Semaphore01 {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(4); // 4 tane kaynaga erisim icin izin ver.

        System.out.println("Toplam park yeri : " + semaphore.availablePermits());

        Car car1 = new Car("Kawasaki", 7000, semaphore);
        Car car2 = new Car("Yamaha", 9000, semaphore);
        Car car3 = new Car("Honda", 5000, semaphore);
        Car car4 = new Car("Mondial", 7000, semaphore);
        Car car5 = new Car("Bajaj", 8000, semaphore);
        Car car6 = new Car("BMW", 4000, semaphore);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();


    }

}

class Car extends Thread {

    private String carName;
    private int duration;
    private Semaphore semaphore;

    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            System.out.println(carName + " park etmek istiyor...");
            semaphore.acquire(); // kodlara erisim icin izin alindi.
            // Ortak kaynak baslangic
            System.out.println("--> " + carName + " park yerine girdi.");
            System.out.println("|| " + carName + " park yerinde bekliyor. ||");
            Thread.sleep(duration);
            System.out.println("<-- " + carName + " park yerinden ayriliyor...");
            // Ortak kaynak bitis
            semaphore.release(); // izin belgesi geri verildi.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
