package org.example.task4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class B {
    private int value;

    public B() {
        value = 0;
        System.out.println("without arg");
    }

    public B(int value) {
        this.value = value;
        System.out.println("with arg");
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
//        Create your own custom class with a few constructors, and make an object for it.
//        Use getDeclaredConstructors() to print out all the constructors of the class and their parameter types.
//        Choose a specific constructor and create a new instance of the class using newInstance().
//        Print out your results or processing progress.

        B obj = new B(10);

        Constructor<?>[] constructors = B.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getName());
            }
            System.out.println();
        }

        try {
            Constructor<?> constructor = B.class.getDeclaredConstructor();
            B newObj = (B) constructor.newInstance();
            System.out.println(newObj.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Constructor<?> constructor = B.class.getDeclaredConstructor(int.class);
            B newObj = (B) constructor.newInstance(22);
            System.out.println(newObj.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
