package com.example.codesharingplatform.controller;

import com.example.codesharingplatform.model.Code;
import com.example.codesharingplatform.service.CodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Controller
@Tag(name = "Code Controller", description = "Endpoints to work with code")
public class CodeController {
//TODO Create openapi configuration file
    private final CodeService codeService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CodeController.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

    public CodeController(@Autowired CodeService codeService) {
        this.codeService = codeService;
    }

    @ResponseBody
    @GetMapping("/api/code/{id}")
    @Operation(description = "Get code by ID as JSON")
    public ResponseEntity<Code> getCodeByIdJSON(@PathVariable
                                                @Parameter(description = "Code id") String id) {
        Optional<Code> code = codeService.getCodeById(id);
        if (code.isPresent()) {
            LOGGER.info("Code: {}", code.get());
            return ResponseEntity.ok(code.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/code/{id}")
    @Operation(description = "Get code by ID as HTML page")
    public String getCodeByIdHTML(@PathVariable
                                  @Parameter(description = "Code id") String id, Model model) {
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
    @Operation(description = "Add code to platform by JSON")
    public ResponseEntity<Map<String, String>> postCodeJSON(@RequestBody Code code) {
        try {
            code.setDate(LocalDateTime.now().format(dateTimeFormatter));
            String uuid = codeService.postCode(code);
            return ResponseEntity.ok(Map.of("id", uuid));
        } catch (Exception e) {
            LOGGER.error("Error - postCodeJSON. Error msg: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping ("/code/new")
    @Operation(description = "Add code to platform on HTML page")
    public String postCodeHTML() {
        return "new_code";
    }

    @GetMapping("/api/code/latest")
    @ResponseBody
    @Operation(description = "Get latest committed code as JSON")
    public ResponseEntity<List<Code>> getCodesJSON() {
        List<Code> codes = codeService.getCodes();
        LOGGER.info("Code list: {}", codes);
        return ResponseEntity.ok(codes);
    }

    @GetMapping("/code/latest")
    @Operation(description = "Get latest committed code on HTML page")
    public String getCodesHTML(Model model) {
        List<Code> codes = codeService.getCodes();
        LOGGER.info("Code list: {}", codes);
        model.addAttribute("codes", codes);
        return "latest_code";
    }
}
