package src.main.java.Day02;

import src.main.java.AdventDay;

public class Day02 {

    public static void main(String[] args) {
        var day2 = new AdventDay<Long>(2025, 2, /* testing */ true);
        String input = day2.getInput();

        day2.doAnswer(1, () -> {
            String[] split = input.split(",");

            long answer = 0;

            for (String range : split) {
                String[] rangeSplit = range.split("-");
                long low = Long.parseLong(rangeSplit[0]);
                long high = Long.parseLong(rangeSplit[1]);

                // System.out.println("low = " + low + ", high = " + high);

                for (long i = low; i < high + 1; i++) {
                    if (invalid(i)) {
                        answer += i;
                    }
                }
            }
            return answer;
        });

    }

    private static boolean invalid(long num) {
        String asString = Long.toString(num);
        if (asString.startsWith("0")) {
            return true;
        }

        if (asString.matches("(\\d+)\\1")) {
            return true;
        }

        return false;
    }

}