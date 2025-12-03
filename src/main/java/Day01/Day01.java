package src.main.java.Day01;

import src.main.java.AdventDay;

public class Day01 {
    public static void main(String[] args) {
        var day1 = new AdventDay<Long>(2025, 1, /* testing */ true);
        String[] rotations = day1.getInputLines();

        day1.doAnswer(1, () -> {
            // number of times the dial is left pointing at 0 after any rotation
            long timesAtZero = 0;
            int position = 50;

            for (String rotation : rotations) {
                char direction = rotation.charAt(0); // L or R
                // the amount of times to turn the dial
                int turns = Integer.parseInt(rotation.substring(1));

                position = rotateDial(position, direction, turns);

                if (position == 0) {
                    timesAtZero++;
                }
            }

            return timesAtZero;
        });

    }

    private static int rotateDial(int pos, char direction, int turns) {
        if (direction == 'L') {
            pos -= turns;
            if (pos < 0) {
                pos += 100;
            }
        }

        if (direction == 'R') {
            pos += turns;
            if (pos >= 100) {
                pos -= 100;
            }
        }
        return pos;
    }

}