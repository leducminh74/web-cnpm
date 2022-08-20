package com.example.projectcnpm.random;

public class Random {
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;

    private static java.util.Random generator = new java.util.Random();

    public static String randomPassword() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }



    private static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println(rand.randomPassword());
    }

}
