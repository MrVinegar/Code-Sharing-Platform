package com.shiyangxiao.platform.controller;

import com.shiyangxiao.platform.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class WebController {
    private final CodeService codeService;


    @GetMapping("/code/{id}")
    public String getSnippetById(@PathVariable String id, Model model) {
        model.addAttribute("snippet", codeService.getById(id));
        return "snippet";
    }

    @GetMapping("/code/latest")
    public String getLatestTenSnippets(Model model) {
        model.addAttribute("snippets", codeService.getLatestTenNotRestricted());
        return "latest_snippets";
    }

    @GetMapping("/code/new")
    public String getEmptyForm() {
        return "create_new";
    }

}
