package com.shiyangxiao.platform.controller;

import com.shiyangxiao.platform.entity.CodeSnippet;
import com.shiyangxiao.platform.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {
    private final CodeService codeService;

    @GetMapping("/code/{id}")
    public ResponseEntity<CodeSnippet> getSnippetById(@PathVariable String id) {
        try {
            return ResponseEntity.ok().body(codeService.getById(id));
        } catch (Exception exc) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/code/new")
    public ResponseEntity<?> PostCode(@RequestBody CodeSnippet snippet) {
        CodeSnippet codeSnippet = codeService.add(snippet);
        return ResponseEntity.ok()
                .body(Map.of("id", codeSnippet.getId()));
    }


    @GetMapping("/code/latest")
    public ResponseEntity<List<CodeSnippet>> getLatestTenSnippets() {
        return ResponseEntity.ok().body(codeService.getLatestTenNotRestricted());
    }


}
