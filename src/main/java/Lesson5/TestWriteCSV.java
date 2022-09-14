package Lesson5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestWriteCSV {
    private List<String> header;
    private List<List<String>> data;
    private String pathToFile;
    private BufferedWriter writer;

    public TestWriteCSV(String pathToFile) {
        this.pathToFile = pathToFile;
        data = new ArrayList<>();
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = Arrays.asList(header);
    }

    public void addRecord(String[] record) {
        this.data.add(Arrays.asList(record));
    }

    public List<List<String>> getData() {
        return data;
    }

    private void writeRecord(BufferedWriter wr, List<String> rec) throws IOException {
        wr.write(stringListToString(rec));
        wr.newLine();
    }

    public void save() throws IOException {
        writer = new BufferedWriter(new FileWriter(pathToFile));
        writeRecord(writer, header);

        data.forEach(rec -> {
            try {
                writeRecord(writer, rec);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writer.flush();
        writer.close();
    }

    private String stringListToString(List<String> list) {
        String result = "";
        for (String s : list) result += ";" + s;
        return result.substring(1);
    }
}