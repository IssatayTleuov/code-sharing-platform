package com.example.codesharingplatform.service;

import com.example.codesharingplatform.model.Code;
import com.example.codesharingplatform.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class CodeService {

    private final CodeRepository codeRepository;

    public CodeService(@Autowired CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public Optional<Code> getCodeById(Long id) {
        return codeRepository.findById(id);
    }

    public Long postCode(Code code) {
        codeRepository.save(code);
        return code.getId();
    }

    public List<Code> getCodes() {
        List<Code> codes = (List<Code>) codeRepository.findAll();
        Collections.reverse(codes);
        return codes.stream().limit(10).collect(Collectors.toList());
    }

    @Deprecated
    public static ArrayList<Code> populateList(int mapSize, TreeMap<Integer, Code> codeMap) {
        ArrayList<Code> codes = new ArrayList<>();
        if (mapSize <= 10) {
            codeMap.forEach((integer, code) -> codes.add(code));
        } else {
            SortedMap<Integer, Code> subMap = codeMap.subMap(codeMap.size() - 9, codeMap.size() + 1);
            subMap.forEach((integer, code) -> codes.add(code));
        }
        return codes;
    }
}
