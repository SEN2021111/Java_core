package Lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestReadCSV {
    private String pathToFile;
    private String[] header;
    private BufferedReader br;
    private List<String> data;

    public TestReadCSV(String pathToFile) throws IOException {
        this.pathToFile = pathToFile;
        data = new ArrayList<>();
        br = new BufferedReader(new FileReader(pathToFile));

        header = parseRowToArray(br.readLine());

        String line;
        while ((line = br.readLine()) != null) {
            data.add(line);
        }

        br.close();
    }

    private String[] parseRowToArray(String s) {
        String[] result;
        result = s.split(";");
        return result;
    }

    public List<String> getData() {
        return data;
    }

    public String[] getHeader() {
        return header;
    }
}
