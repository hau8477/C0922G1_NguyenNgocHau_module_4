package com.example.dictionary.service.impl;

import com.example.dictionary.repository.IDictionaryRepository;
import com.example.dictionary.repository.impl.DictionaryRepository;
import com.example.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;

public class DictionaryService implements IDictionaryService {
    private static final IDictionaryRepository dictionaryRepository = new DictionaryRepository();

    @Override
    public String translate(String english) {
        return dictionaryRepository.translate(english);
    }
}
