package reflect;

import java.lang.reflect.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;

public class Homework1 {

    /**
     * Prints the declared methods of java.lang.String sorted by name.
     */
    public static void streamPipeline1() {
        Arrays.stream(String.class.getDeclaredMethods())
                .sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    /**
     *  Prints all distinct names of the declared methods of java.lang.String sorted alphabetically.
     */
    public static void streamPipeline2() {
        Arrays.stream(String.class.getDeclaredMethods())
                .sorted(Comparator.comparing(Method::getName))
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with two or more parameters whose parameters are all of the same type, sorted by name.
     */
    public static void streamPipeline3() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .filter(method -> method.getParameterCount() >= 2 && Arrays.stream(method.getParameterTypes()).allMatch(par -> par == Arrays.stream(method.getParameterTypes()).findFirst().get()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    /**
     * Prints all distinct return types of the declared methods of java.lang.String sorted alphabetically.
     */
    public static void streamPipeline4() {
        Arrays.stream(String.class.getDeclaredMethods())
                .map(Method::getReturnType)
                .distinct()
                .sorted(Comparator.comparing(Class::getName))
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with at least one boolean parameter, sorted by name.
     */
    public static void streamPipeline5() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .filter(method -> Arrays.stream(method.getParameterTypes()).anyMatch(par -> par == boolean.class))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    

    /**
     * Returns the longest name of the declared methods of java.lang.String.
     */
    public static String streamPipeline7() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .map(Method::getName)
                .max(Comparator.comparing(String::length))
                .get();
    }

    /**
     *  Returns the longest one from the names of the public declared methods of java.lang.String.
     */
    public static String streamPipeline8() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .filter(method -> method.getModifiers() == java.lang.reflect.Modifier.PUBLIC)
                .map(Method::getName)
                .max(Comparator.comparing(String::length))
                .get();
    }

    /**
     * Returns summary statistics about the number of parameters for the declared methods of java.lang.String.
     */
    public static IntSummaryStatistics streamPipeline9() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .mapToInt(Method::getParameterCount)
                .summaryStatistics();
    }

    /**
     * Returns the maximum number of parameters accepted by the declared methods of java.lang.String.
     */
    public static int streamPipeline10() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .mapToInt(Method::getParameterCount)
                .max()
                .getAsInt();
    }

    /**
     * Returns the declared method of java.lang.String with the most number of parameters.
     */
    public static Method streamPipeline11() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .max(Comparator.comparing(Method::getParameterCount))
                .get();
    }

    

}
