package com.generic_test_without;

public class SecurityBoxTest {
    public static void main(String[] args) {
        SecurityBox securityBox = new SecurityBox();
        securityBox.setSecurityThing(Integer.MAX_VALUE);

        Integer integer = (Integer) securityBox.getSecurityThing();
        System.out.println(integer);

        securityBox.setSecurityThing("security xxxx");
        Integer securityThing = (Integer) securityBox.getSecurityThing();

    }
}
