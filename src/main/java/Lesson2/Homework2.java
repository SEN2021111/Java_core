package Lesson2;

public class Homework2 {
    public static void main(String[] args) throws Exception {
        String[][] str = new String[4][4];
        String s = new String("");

        if (str.length != 4) {
            throw new MyArraySizeException();
        } else {
            for (int i = 0; i < str.length; i++) {
                for (int j = 0; j < str.length; j++) {
                    str[i][j] = "1";
                }
            }
            str[3][3] = "B";

            try (Arr arr = new Arr(str)) {
                for (int i = 0; i < str.length; i++) {
                    for (int j = 0; j < str.length; j++) {
                        s = str[i][j];
                        arr.checkSum(s);
                    }
                }
            } catch (MyArrayDataException e) {
                e.printStackTrace();
            }

        }

    }
}

/*
    public static void checkSum(String[][] a) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        int[][] b = new int[4][4];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                b[i][j] = Integer.parseInt(String.valueOf(Integer.parseInt(a[i][j])));
                sum = sum + b[i][j];
            }
        }
        System.out.println(sum);

    }
}*/



