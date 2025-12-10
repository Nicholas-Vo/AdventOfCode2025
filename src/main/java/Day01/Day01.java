package src.main.java.Day01;

import src.main.java.AdventDay;

public class Day01 {

    public static void main(String[] args) {
        var day1 = new AdventDay<Long>(2025, 1, /* testing */ true);
        String[] rotations = day1.getInputLines();

        // System.out.println(Arrays.toString((rotations)));

        day1.doAnswer(1, () -> {
            // number of times the dial is left pointing at 0 after any rotation
            long timesAtZero = 0;
            int position = 50;

            for (String rotation : rotations) {
                char direction = rotation.charAt(0); // L or R
                // the amount of times to turn the dial
                int turns = Integer.parseInt(rotation.substring(1));

                position = rotateDial(position, direction, turns);
                // System.out.println("The dial is rotated " + rotation + " to point at "
                // + (position == 0 ? "0 <-------" : position));

                if (position == 0) {
                    timesAtZero++;
                }
            }

            return timesAtZero;
        });

        day1.doAnswer(2, () -> {
            // number of times the dial is left pointing at 0 after any rotation
            long timesPastZero = 0;
            int pos = 50;

            int MAX_DIAL = 100;
            int MIN_DIAL = 0;

            for (String rotation : rotations) {
                char direction = rotation.charAt(0);
                long turns = Integer.parseInt(rotation.substring(1));

                if (direction == 'L') {
                    long turnsToCompleteCycle = pos == MIN_DIAL ? MAX_DIAL : pos;
                    long newPosition = pos - turns;

                    if (turns >= turnsToCompleteCycle) {
                        timesPastZero += 1 + (turns - turnsToCompleteCycle) / MAX_DIAL;
                    }

                    long remainder = newPosition % MAX_DIAL;
                    long plusOneHundred = remainder + MAX_DIAL;

                    pos = Math.toIntExact(plusOneHundred % MAX_DIAL);
                }

                if (direction == 'R') {
                    long newPosition = pos + turns;

                    timesPastZero += newPosition / MAX_DIAL;
                    pos = Math.toIntExact(newPosition % MAX_DIAL);
                }
            }

            return timesPastZero;
        });

    }

    private static int rotateDial(int pos, char direction, int turns) {
        if (direction == 'L') {
            pos = (pos - turns) % 100;
            if (pos < 0) {
                pos += 100;
            }
        }

        if (direction == 'R') {
            pos = (pos + turns) % 100;
        }
        return pos;
    }

}