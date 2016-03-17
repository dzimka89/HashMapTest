package com.generic_test_with;

public class UniversalCalculator<T extends Number> {

    private static double sum = 0;

    public static void main(String[] args) {
        UniversalCalculator<Float> floatUniversalCalculator = new UniversalCalculator<Float>();
        floatUniversalCalculator.sum(Float.MAX_VALUE);
        floatUniversalCalculator.sum(Float.MAX_VALUE);
        floatUniversalCalculator.sum(Float.MAX_VALUE);
        System.out.println(sum);

        UniversalCalculator<Long> longUniversalCalculator = new UniversalCalculator();
        longUniversalCalculator.sum(Long.MAX_VALUE);
        longUniversalCalculator.sum(Long.MAX_VALUE);
        longUniversalCalculator.sum(Long.MAX_VALUE);
        longUniversalCalculator.sum(Long.MAX_VALUE);
        longUniversalCalculator.sum(Long.MAX_VALUE);
        longUniversalCalculator.sum(Long.MAX_VALUE);
        longUniversalCalculator.sum(Long.MAX_VALUE);
        longUniversalCalculator.sum(Long.MAX_VALUE);
        longUniversalCalculator.sum(Long.MAX_VALUE);
        longUniversalCalculator.sum(Long.MAX_VALUE);
        longUniversalCalculator.sum(Long.MAX_VALUE);
        longUniversalCalculator.sum(Long.MAX_VALUE);
        longUniversalCalculator.sum(Long.MAX_VALUE);
        longUniversalCalculator.sum(Long.MAX_VALUE);
        System.out.println(sum);

 //       UniversalCalculator<String> stringUniversalCalculator = new UniversalCalculator<String>();
//        longUniversalCalculator.sum(Long.MAX_VALUE);
//        longUniversalCalculator.sum(Long.MAX_VALUE);
//        longUniversalCalculator.sum(Long.MAX_VALUE);
//        System.out.println(sum);
    }

    public void sum(T number) {
        sum += number.doubleValue();
    }

}
