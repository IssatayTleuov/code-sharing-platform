package com.example.codesharingplatform.presentation;

import com.example.codesharingplatform.businesslayer.Code;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@Controller
public class CodeController {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private Code code = new Code("public static void main(String[] args) {\n    SpringApplication.run(CodeSharingPlatform.class, args);\n}", LocalDateTime.now().format(formatter));

    @GetMapping("/code")
    public String getCodeHTML(Model model) {
        model.addAttribute("date", code.getDate());
        model.addAttribute("code", code.getCode());
        System.out.printf("\n\ngetCodeHTML code: %s," +
                "date: %s", code.getCode(), code.getDate());
        return "get_code.html";
    }

    @GetMapping("/api/code")
    @ResponseBody
    public Code getCodeJSON() {
        System.out.printf("\n\ngetCodeJSON code: %s," +
                "date: %s", code.getCode(), code.getDate());
        return this.code;
    }

    @PostMapping("/api/code/new")
    @ResponseBody
    public List<String> createCodeJSON(@RequestBody Code code) {
        this.code = code;
        this.code.setDate(LocalDateTime.now().format(formatter));
        System.out.printf("\n\ncreateCodeJSON code: %s," +
                "date: %s", code.getCode(), code.getDate());
        return Collections.emptyList();
    }

    @GetMapping("/code/new")
    public String createCodeHTML() {
        return "new_code.html";
    }
}