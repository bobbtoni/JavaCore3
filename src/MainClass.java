import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT/2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        final CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        Lock lock = new ReentrantLock();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT+1);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 100), cyclicBarrier, countDownLatch);
        }

        try {
            for (int i = 0; i < cars.length; i++) {
                new Thread(cars[i]).start();
            }
            cyclicBarrier.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            countDownLatch.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }catch (InterruptedException e){
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
