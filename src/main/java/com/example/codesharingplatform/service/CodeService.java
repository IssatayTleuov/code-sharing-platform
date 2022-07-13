package com.example.codesharingplatform.service;

import com.example.codesharingplatform.model.Code;
import com.example.codesharingplatform.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CodeService {

    private final CodeRepository codeRepository;

    public CodeService(@Autowired CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public Optional<Code> getCodeById(int id) {
        return Optional. of(codeRepository.getCodeMap().get(id));
    }

    public int postCode(Code code) {
        int id = codeRepository.getId() + 1;
        codeRepository.setCodeMap(id, code);
        codeRepository.setId(id);
        return id;
    }

    public List<Code> getCodes() {
        int mapSize = codeRepository.getCodeMap().size();
        return populateList(mapSize, codeRepository.getCodeMap());

    }

    public static ArrayList<Code> populateList(int mapSize, TreeMap<Integer, Code> codeMap) {
        ArrayList<Code> codes = new ArrayList<>();
        if (mapSize <= 10) {
            codeMap.forEach((integer, code) -> codes.add(code));
        } else {
            //TODO Remove start and end variables
            int start = codeMap.size() - 9;
            int end = codeMap.size() + 1;
            SortedMap<Integer, Code> subMap = codeMap.subMap(start, end);
            subMap.forEach((integer, code) -> codes.add(code));
        }
        return codes;
    }
}
