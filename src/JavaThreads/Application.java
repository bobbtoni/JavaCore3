package JavaThreads;

public class Application {
    Runnable tA, tB, tC;
    volatile String currentLatter = "A";

    void printABC(){
        printABC(1, 1, 1);
    } // печатать последовательность ABCABC...

    void printABC(Integer repA, Integer repB, Integer repC) {
        Object lock = new Object();
        tA = () -> {
            synchronized (lock){
                while(true) {
                    while (currentLatter != "A") {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (int i = 0; i < repA; i++) {
                        System.out.print("A");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    currentLatter = "B";
                    lock.notifyAll();
                }
            }
        };

        tB = () -> {
            synchronized (lock){
                while(true) {
                    while (currentLatter != "B") {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (int i = 0; i < repB; i++) {
                        System.out.print("B");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    currentLatter = "C";
                    lock.notifyAll();
                }
            }
        };

        tC = () -> {
            synchronized (lock){
                while(true) {
                    while (currentLatter != "C") {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (int i = 0; i < repC; i++) {
                        System.out.print("C");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    currentLatter = "A";
                    lock.notifyAll();
                }
            }
        };

        new Thread(tA).start();
        new Thread(tB).start();
        new Thread(tC).start();
    } // печатать последовательность A...B...C...

    public static void main(String[] args){
        new Application().printABC();
        new Application().printABC(2,1,2);
    }
}
