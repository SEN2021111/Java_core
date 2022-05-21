package Lesson1;

public class Team {
    public String name;
    public Member[] members;

    public Team(String name1, Member[] members) {
        this.name = name1;
        this.members = members;
    }

    public void infoPassed(int a) {
        for (int i = 0; i < members.length; i++) {
            if (members[i].getPower() > a) {
                System.out.println(members[i].getName() + " прошел дистанцию");
            }
        }
    }

    public void info() {
        for (int i = 0; i < members.length; i++) {
            System.out.println(members[i].toString());
        }
    }

}
