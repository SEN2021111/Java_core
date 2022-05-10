package Lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestReadCSV {
    private String pathToFile;
    private List<String> header;
    private BufferedReader br;
    private List<List<String>> data;

    public TestReadCSV(String pathToFile) throws IOException {
        this.pathToFile = pathToFile;
        data = new ArrayList<>();
        br = new BufferedReader(new FileReader(pathToFile));

        header = Arrays.asList(br.readLine().split(";"));

        String line;
        while ((line = br.readLine()) != null) {
            this.data.add(Arrays.asList(line.split(";")));
        }

        br.close();
    }

    public List<List<String>> getData() {
        return data;
    }

    public List<String> getHeader() {
        return header;
    }
}
