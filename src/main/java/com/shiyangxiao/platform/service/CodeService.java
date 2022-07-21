package com.shiyangxiao.platform.service;


import com.shiyangxiao.platform.entity.CodeSnippet;
import com.shiyangxiao.platform.repo.CodeSnippetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CodeService {
    private final CodeSnippetRepository codeRepository;

    public CodeSnippet add(CodeSnippet snippet) {

        snippet.setTime_restricted(snippet.getSecondsLeft() != 0);
        snippet.setView_restricted(snippet.getViewsAllowed() != 0);

        codeRepository.save(snippet);
        return snippet;
    }

    public CodeSnippet getById(String id) {

        CodeSnippet snippet = codeRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (snippet.getView_restricted())
            snippet.setViewsAllowed(snippet.getViewsAllowed() - 1);
        if (snippet.getTime_restricted())
            snippet.setSecondsLeft(snippet.getSecondsLeft() -
                    ChronoUnit.SECONDS.between(snippet.getCreated(), LocalDateTime.now()));
        if (snippet.getTime_restricted() && snippet.getSecondsLeft() < 0 ||
                snippet.getView_restricted() && snippet.getViewsAllowed() < 0) {
            codeRepository.delete(snippet);
            throw new NoSuchElementException("snippet has expired");
        }
        codeRepository.save(snippet);
        return snippet;
    }

    public List<CodeSnippet> getLatestTenNotRestricted() {
        return codeRepository.findNotRestrictedOrderByCreatedDesc().stream().limit(10)
                .collect(Collectors.toList());
    }

}
