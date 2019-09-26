package lesson1;


import javax.management.openmbean.ArrayType;
import java.util.ArrayList;

public class Application {
    // Задача 1
    public static void replaceElements(MyType[] a, int i, int j){
        MyType tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // Задача 2
    public static ArrayList<MyType> convertArrayToList(MyType[] a){
        ArrayList<MyType> arrayList = new ArrayList<>();
        int lng = a.length;
        for (int i = 0; i < lng; i++) {
            arrayList.add(a[i]);
        }
        return arrayList;
    }

    public static void main(String[] args){
        // Инициализация
        MyType<Integer>[] array = new MyType[10];
        for (int i = 0; i < 10; i++) {
            array[i] = new MyType<>(i);
        }
        replaceElements(array, 1, 2);

        // Вывод в консоль
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i].getObj() + " ");
        }

        System.out.println();
        ArrayList<MyType> arrayList = convertArrayToList(array);
        System.out.println(arrayList);

        // Задача 3
        Box<Apple> boxApple1 = new Box<>();
        for (int i = 0; i < 5; i++) {
            try {
                boxApple1.addFruit(new Apple(i + 1.));
            }catch (Exception e){
                System.out.println(e.toString());
            }
        }
        Box<Apple> boxApple2 = new Box<>();
        for (int i = 0; i < 5; i++) {
            try {
                boxApple2.addFruit(new Apple(i+1.));
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        try {
            boxApple1.toPour(boxApple2);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        System.out.println(boxApple1.getWeight() + " " + boxApple2.getWeight());
        System.out.println(boxApple1.compare(boxApple2));

        Box<Orange> boxOrange1 = new Box<>();
        for (int i = 0; i < 5; i++) {
            try {
                boxOrange1.addFruit(new Orange(i + 1.));
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        try {
            //boxOrange1.emptyBox(); // ящик почистили, а значит можно засыпать в него и яблоки
            boxOrange1.toPour(boxApple1);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        System.out.println(boxOrange1.getWeight());
    }
}
