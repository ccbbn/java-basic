package chap05;

import java.util.Calendar;

public class EnumExample {
    public static void main(String[] args) {
        // 열거 타입
        // 월 화 수 목 금 토 일
        // 가독성 측면에서 좋다
        Week today = null;

        Calendar cal = Calendar.getInstance();  // 자바에 내장된 Calendar 클래스
        int week = cal.get(Calendar.DAY_OF_WEEK);

        System.out.println(week);

        switch (week) {
            case 1:
                today = Week.SUNDAY;
                break;
            case 2:
                today = Week.MONDAY;
                break;
            case 3:
                today = Week.TUESDAY;
                break;
            case 4:
                today = Week.WEDNESDAY;
                break;
            case 5:
                today = Week.THURSDAY;
                break;
            case 6:
                today = Week.FRIDAY;
                break;
            case 7:
                today = Week.SATURDAY;
                break;
        }

        System.out.println(today);
        System.out.println(today.name());
        System.out.println(today.ordinal());


        Week[] days = Week.values();
        for (Week day : days) {
            System.out.println(day);
        }
    }
}
