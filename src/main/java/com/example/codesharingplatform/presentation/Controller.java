package com.example.codesharingplatform.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/code")
    public String getHTML() {
        return "<html>\n" +
                "<head>\n" +
                "    <title>Code</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <pre>\n" +
                "public static void main(String[] args) {\n" +
                "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
                "}</pre>\n" +
                "</body>\n" +
                "</html>";
    }

    @GetMapping("/api/code")
    public Map<String, String> getJSON() {
        return Map.of("code",
                "public static void main(String[] args) {\n    SpringApplication.run(CodeSharingPlatform.class, args);\n}");
    }
}
