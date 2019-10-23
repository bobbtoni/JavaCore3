import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Testing {
    public static void start(Class testClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        if(testClass.getAnnotation(TestableClass.class) == null)
            return;
        Boolean NoRepetBeforeFlag=true, NoRepetAfterFlag=true;
        Object obj = testClass.newInstance();
        Method beforeMethod = null, afterMethod = null;
        for (Method meth: testClass.getDeclaredMethods()) {
            if (meth.getAnnotation(BeforeTest.class) != null) {
                if (!NoRepetBeforeFlag) throw new RuntimeException();
                beforeMethod = meth;
                NoRepetBeforeFlag = false;
            }
            else if (meth.getAnnotation(AfterTest.class) != null) {
                if (!NoRepetAfterFlag) throw new RuntimeException();
                afterMethod = meth;
                NoRepetAfterFlag = false;
            }
        }
        if (beforeMethod != null) beforeMethod.invoke(obj, new Object[]{});
        Map<Integer, Vector<Method>> mapTest = new HashMap<>();
        for (Method meth: testClass.getDeclaredMethods()) {
            if (meth.getAnnotation(Test.class) != null) {
                Integer priority = meth.getAnnotation(Test.class).priority();
                if (priority<1) priority=1;
                if (priority>10) priority=10;
                Vector<Method> methodVector = mapTest.get(priority);
                if (methodVector == null) {
                    mapTest.put(priority, methodVector = new Vector<Method>());
                }
                    methodVector.add(meth);
            }
        }
        for (int i = 1; i <= 10; i++) {
            if (mapTest.get(i) != null)
                for (Method method:mapTest.get(i)) {
                    method.invoke(obj, new Object[]{});
                }
        }
        if (afterMethod != null) afterMethod.invoke(obj, new Object[]{});
    }
}
