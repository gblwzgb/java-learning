package cn.java.learning.test;

/**
 * Created by l_x_l on 2016-12-04.
 */
public class DateGenerate {

    public static void main(String[] args) {
        print(4, 30, 0);
    }

    private static void print(int month, int days, int weekOfFirstDay) {
        for (int i = 1; i <= days; i++) {
            int week = weekOfFirstDay % 7;
            System.out.println("");
            System.out.println("#### "+month + "月" + i + "日~" + Week.getKey(week));
            if (week != 6 && week != 0) {
                System.out.println("- 工作:");
                System.out.println("    1. x");
                System.out.println("- 生活:");
                System.out.println("    1. x");
                System.out.println("- 锻炼:");
                System.out.println("    1. x");
            }
            weekOfFirstDay++;
        }
    }

    enum Week {
        week1("星期一", 1),
        week2("星期二", 2),
        week3("星期三", 3),
        week4("星期四", 4),
        week5("星期五", 5),
        week6("星期六", 6),
        week7("星期日", 0);

        private String name;
        private int index;

        Week(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public static String getKey(int value) {
            for (Week week : Week.values()) {
                if (week.getIndex() == value) {
                    return week.getName();
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
