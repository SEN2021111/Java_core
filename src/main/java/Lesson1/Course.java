package Lesson1;

public class Course {
    private int coursePower;

    public Course(int complexityRun, int complexityJump, int complexitySwim) {
        Barier.setAllValue (complexityRun,complexityJump,complexitySwim);
        coursePower = complexityRun + complexityJump + complexitySwim;

    }

    public enum Barier{

        Run{
            private int complexity;

            @Override
            public void setComplexity(int complexity) {
                this.complexity = complexity;
            }
            @Override
            public int getComplexity() {
                return complexity;
            }
        },
        Jump{
            private int complexity;

            @Override
            public void setComplexity(int complexity) {
                this.complexity = complexity;
            }
            @Override
            public int getComplexity() {
                return complexity;
            }
        },
        Swim{
            private int complexity;

            @Override
            public void setComplexity(int complexity) {
                this.complexity = complexity;
            }
            @Override
            public int getComplexity() {
                return complexity;
            }
        };

        public abstract void setComplexity(int complexity);
        public abstract int getComplexity();


        public static void setAllValue (int complexityRun, int complexityJump, int complexitySwim){
            Run.setComplexity(complexityRun);
            Jump.setComplexity(complexityJump);
            Swim.setComplexity(complexitySwim);
        }
    }
    public int getCoursePower() {
         return coursePower;
    }

    public boolean doIt(Team team) {
        int j = 0;
        for (int i = 0; i < team.members.length; i++) {
            if (team.members[i].getPower() > getCoursePower()) {
                j++;
            }
        }
        if (j != team.members.length) {
            return false;
        }
        return true;
    }
}
