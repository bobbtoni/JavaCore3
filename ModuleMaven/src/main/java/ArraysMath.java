import java.util.Arrays;

public class ArraysMath {

    final Integer PARSER_INT = 4;
    // пункт 2
    public Integer[] returnLast4(Integer[] intArr){
        if (intArr.length == 0) throw new RuntimeException();
        if (intArr == null) throw new NullPointerException();
        for (int i = intArr.length-1; i >= 0 ; i--) {
            if (intArr[i] == PARSER_INT) {
                return Arrays.copyOfRange(intArr, i + 1, intArr.length);
            }
        }
        throw new RuntimeException();
    }

    public boolean checkInt(Integer[] intArr, Integer num){
        for (Integer i: intArr) {
            if (i.equals(num)) return true;
        }
        return false;
    }

    public boolean check1and4(Integer[] intArr){
         return checkInt(intArr, 1) & checkInt(intArr, 4);
    }
}
