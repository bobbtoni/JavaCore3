package lesson1;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public class Box <T extends Fruit>{
    ArrayList<T> arrayList;

    public Box(){
        arrayList = new ArrayList<>();
    };

    // На слуай если будем складывать дочерние объекты, а ссылки на них будут родителького типа
    // Тут никогда не должно срабатывать, потому что Fruit - абстрактный
    public Boolean checkType(T newType){
        if(arrayList.size() > 1) return newType.getClass() == arrayList.get(0).getClass();
        return true;
    }

    public void addFruit(T fruit) throws Exception {
        if (!checkType(fruit)) throw new Exception("В ящеке находятся другие предметы");
        arrayList.add(fruit);
    }

    public Double getWeight(){
        Double sum = 0.;
        for (int i = 0; i < arrayList.size(); i++) {
            sum += arrayList.get(i).getWeight();
        }
        return sum;
    }

    public ArrayList getArrayList(){
        return  arrayList;
    }

    public void emptyBox(){
        arrayList.clear();
    }

    public void toPour(Box box) throws Exception {
        if ((!arrayList.isEmpty() && !box.getArrayList().isEmpty()) &&
                (arrayList.get(0).getClass() != box.getArrayList().get(0).getClass()))
            throw new Exception("В ящеке находятся другие предметы");
        arrayList.addAll(box.getArrayList());
        box.emptyBox();
    }

    public Boolean compare(Box box) {
        return this.getWeight().equals(box.getWeight());
    }
}
