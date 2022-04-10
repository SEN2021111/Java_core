package Lesson1;

public class Homework1 {
    public static void main(String[] args) {
        Member[] members1 = new Member[4];

        members1[0] = new Member(50, 50, 40, "Финист");
        members1[1] = new Member(30, 20, 30, "Федор");
        members1[2] = new Member(40, 100, 20, "Иван");
        members1[3] = new Member(90, 90, 90, "Петр");

        Member[] members2 = new Member[4];

        members2[0] = new Member(50, 50, 40, "Олег");
        members2[1] = new Member(30, 50, 30, "Коля");
        members2[2] = new Member(40, 100, 20, "Василий");
        members2[3] = new Member(90, 90, 90, "Денис");

        Team team1 = new Team("Первая", members1);
        Team team2 = new Team("Вторая", members2);

        Course course = new Course();
        team1.info();
        team1.infoPassed();

        team2.info();
        team2.infoPassed();

        boolean b1 = course.doIt(team1);
        boolean b2 = course.doIt(team2);

        if (b1 == b2) {
            if (b1) {
                System.out.println("Ничья, обе команды победили");
            } else {
                System.out.println("Ничья, обе команды проиграли");
            }
        } else if (b1) {
            System.out.println("Победила первая команда");
        } else {
            System.out.println("Победила вторая команда");
        }
    }

}
