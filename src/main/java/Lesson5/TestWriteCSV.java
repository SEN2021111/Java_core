package Lesson5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestWriteCSV {
    private String[] header;
    private List<String> data;
    private String pathToFile;
    private BufferedWriter writer;

    public TestWriteCSV(String pathToFile) {
        this.pathToFile = pathToFile;
        data = new ArrayList();
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void addRecord(String[] record) {
        data.add(stringListToString(record));
    }

    public List<String> getData() {
        return data;
    }

    public void save() throws IOException {
        writer = new BufferedWriter(new FileWriter(pathToFile));
        writer.write(stringListToString(header));
        writer.newLine();

        for (int i = 0; i < data.size(); i++) {
            writer.write(data.get(i).toString());
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }

    private String stringListToString(String[] list) {
        String result = "";
        for (String s : list) result += s + ";";
        return result;
    }
}