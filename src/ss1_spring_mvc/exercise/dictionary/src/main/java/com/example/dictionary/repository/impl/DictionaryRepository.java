package com.example.dictionary.repository.impl;

import com.example.dictionary.repository.IDictionaryRepository;

import java.util.HashMap;
import java.util.Map;

public class DictionaryRepository implements IDictionaryRepository {
    private static final Map<String,String> dictionary = new HashMap<>();
    static {
        dictionary.put("go","đi");
        dictionary.put("school","trường học");
        dictionary.put("student","học sinh");
        dictionary.put("teacher","giáo viên");
        dictionary.put("dictionary","từ điển");
    }

    public String translate(String english){
        String vietnamese;
        for (Map.Entry<String,String> entry:dictionary.entrySet()) {
            if (english.equals(entry.getKey())){
                vietnamese = entry.getValue();
                return vietnamese;
            }
        }
        return "Không tìm thấy trong từ điển";
    }
}
