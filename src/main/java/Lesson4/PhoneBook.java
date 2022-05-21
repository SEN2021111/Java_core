package Lesson4;

import java.util.*;

public class PhoneBook {
    private HashMap<String, List<String>> recordList = new HashMap<>();

    public void add(String ownerName, String phoneNumber) {
        List<String> existingList = recordList.get(ownerName);
        if (Objects.isNull(existingList)) {
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            recordList.put(ownerName, numbers);
        } else {
            existingList.add(phoneNumber);
        }
    }

    public List get(String ownerName) {
        return recordList.get(ownerName);
    }
}
