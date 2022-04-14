package Lesson2;

public class Arr implements AutoCloseable {
    private int sum = 0;
    private String[][] s = new String[4][4];

    public Arr(String[][] a) throws MyArraySizeException {
        this.s = a;
    }

    public void checkSum(String a) throws MyArrayDataException {
        int b = 0;
        b = Integer.parseInt(String.valueOf(Integer.parseInt(a)));
        sum = sum + b;
    }



    @Override
    public void close() throws Exception {
        System.out.println(sum);
    }
}


