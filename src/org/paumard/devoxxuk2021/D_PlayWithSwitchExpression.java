package org.paumard.devoxxuk2021;

public class D_PlayWithSwitchExpression {

    enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {

        DayOfWeek dayOfWeek = DayOfWeek.valueOf("TUESDAY");
        String message = "undefined";
        switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case THURSDAY:
            case FRIDAY:
                message = "School";
            case WEDNESDAY:
                message = "Sports";
            case SATURDAY:
                message = "Friends";
            case SUNDAY:
                message = "Family";
        }
        System.out.println("message = " + message);
    }
}
