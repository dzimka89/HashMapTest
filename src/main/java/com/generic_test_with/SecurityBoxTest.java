package com.generic_test_with;

public class SecurityBoxTest {
    public static void main(String[] args) {
        SecurityBox<Integer> securityBox = new SecurityBox();
        securityBox.setSecurityThing(Integer.MAX_VALUE);
        Integer integer = securityBox.getSecurityThing();
        System.out.println(integer);


        SecurityBox<String> securityBox1 = new SecurityBox();
        securityBox1.setSecurityThing("security xxxx");

       // Integer securityThing = (Integer) securityBox1.getSecurityThing();

    }
}
