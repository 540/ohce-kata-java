package com.deg540.tdd;

public class Ohce {
    public static final String NIGHT_GREETING = "Buenas noches";
    public static final String MORNING_GREETING = "Buenos días";
    public static final String AFTERNOON_GREETING = "Buenas tardes";
    public static final String PALINDROME_GREETING = "¡Bonita palabra!";
    private final TimeProvider timeProvider;
    private String userName;

    public Ohce(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public String run(String word) {
        if (word.startsWith("Ohce")) {
            this.userName = word.split(" ")[1];
            return this.greet() + " " + userName;
        }
        if (isPalindrome(word)) {
            return word + " " + PALINDROME_GREETING;
        }
        if (word.equals("Stop!")){
            return "Adiós " + userName;
        }

        return reverse(word);
    }

    private String reverse(String word) {
        StringBuilder stringBuilder = new StringBuilder(word);
        return stringBuilder.reverse().toString();
    }

    private boolean isPalindrome(String word) {
        return reverse(word).equals(word);
    }

    private String greet() {
        int currentHour = timeProvider.getCurrentHour();
        if (currentHour >= 20 || currentHour < 6) {
            return NIGHT_GREETING;
        }
        else if (currentHour <= 12) {
            return MORNING_GREETING;
        }

        return AFTERNOON_GREETING;
    }
}
