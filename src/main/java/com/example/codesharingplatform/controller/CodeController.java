package com.example.codesharingplatform.controller;

import com.example.codesharingplatform.model.Code;
import com.example.codesharingplatform.service.CodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

//TODO add swagger
@Controller
public class CodeController {

    private final CodeService codeService;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

    private static final Logger LOGGER = LoggerFactory.getLogger(CodeController.class);

    public CodeController(@Autowired CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("api/code/{id}")
    @ResponseBody
    public ResponseEntity<Code> getCodeByIdJSON(@PathVariable int id) {
        Optional<Code> code = codeService.getCodeById(id);
        if (code.isPresent()) {
            LOGGER.info("Code: {}", code.get());
            return ResponseEntity.ok(code.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("code/{id}")
    public String getCodeByIdHTML(@PathVariable int id, Model model) {
        Optional<Code> code = codeService.getCodeById(id);
        if (code.isPresent()) {
            model.addAttribute("date", code.get().getDate());
            model.addAttribute("code", code.get().getCode());
            return "get_code";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/api/code/new")
    public ResponseEntity<Map<String, String>> postCodeJSON(@RequestBody Code code) {
        code.setDate(LocalDateTime.now().format(dateTimeFormatter));
        int id = codeService.postCode(code);
        LOGGER.info("Posted code: {}, {}", code.getCode(), code.getDate());
        return ResponseEntity.ok(Map.of("id", String.valueOf(id)));
    }

    @GetMapping ("/code/new")
    public String postCodeHTML() {
        return "new_code";
    }

    @GetMapping("/api/code/latest")
    @ResponseBody
    public ResponseEntity<List<Code>> getCodesJSON() {
        Optional<List<Code>> optionalCodes = Optional.of(codeService.getCodes());
        List<Code> codes = optionalCodes.get();
        Collections.reverse(codes);
        LOGGER.info("Code list: {}", codes.toString());
        return ResponseEntity.ok(codes);
    }

    @GetMapping("code/latest")
    public String getCodesHTML(Model model) {
        Optional<List<Code>> optionalCodes = Optional.of(codeService.getCodes());
        List<Code> codes = optionalCodes.get();
        Collections.reverse(codes);
        LOGGER.info("Code list: {}", codes.toString());
        model.addAttribute("codes", codes);
        return "latest_code";
    }
}
