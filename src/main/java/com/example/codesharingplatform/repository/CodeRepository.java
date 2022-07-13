package com.example.codesharingplatform.repository;

import com.example.codesharingplatform.model.Code;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.TreeMap;

@Component
public class CodeRepository {

    private int id = 0;
    private TreeMap<Integer, Code> codeMap = new TreeMap<>();

    public TreeMap<Integer, Code> getCodeMap() {
        return codeMap;
    }

    public void setCodeMap(int id, Code code) {
        this.codeMap.put(id, code);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
