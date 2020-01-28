package Lesson7;

import Lesson7.Interfaces.AfterTest;
import Lesson7.Interfaces.BeforeTest;
import Lesson7.Interfaces.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Tester {
    public static void start(Class _class) throws InvocationTargetException, IllegalAccessException {
        Method beforeMethod = null;
        Method afterMethod = null;
        ArrayList<Method> testMethods = new ArrayList<>();

        Object obj = null;
        try {
            obj = _class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        for (Method m : _class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                testMethods.add(m);
            } else if (m.isAnnotationPresent(BeforeTest.class)) {
                if (beforeMethod == null) {
                    beforeMethod = m;
                } else {
                    throw new RuntimeException("Должно быть не более одного метода с аннотацией @BeforeSuite");
                }
            } if (m.isAnnotationPresent(AfterTest.class)) {
                if (afterMethod == null) {
                    afterMethod = m;
                } else {
                    throw new RuntimeException("Должно быть не более одного метода с аннотацией @AfterSuite");
                }
            }
        }

        if (beforeMethod != null) {
            beforeMethod.invoke(obj);
        }

        testMethods.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority()));

        for (Method m : testMethods) {
            m.invoke(obj);
        }

        if (afterMethod != null) {
            afterMethod.invoke(obj);
        }
    }
}