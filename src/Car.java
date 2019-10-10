import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static ReentrantReadWriteLock rwLock;
    private static volatile boolean chekWin;
    private static CyclicBarrier cyclicBarrier;
    static {
        CARS_COUNT = 0;
        chekWin = false;
        rwLock = new ReentrantReadWriteLock();
    }
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch countDownLatch;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier cb, CountDownLatch countDownLatch) {
        this.race = race;
        this.speed = speed;
        this.cyclicBarrier = cb;
        this.countDownLatch = countDownLatch;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        // тут вопрос. Заблокируется ли исполнение, если во время работы с тунелем из Car
        // какой-то класс попытается изменить значение полей этого тунеля?
        // или заблокируется изменение этих полей до окончания работы Car?
        rwLock.readLock().lock();
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        rwLock.readLock().unlock();
        countDownLatch.countDown();
        if (chekWin == false){
            System.out.println(this.name +  " - WIN");
            chekWin = true;
        }
    }
}