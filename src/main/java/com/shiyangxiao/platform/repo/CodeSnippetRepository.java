package com.shiyangxiao.platform.repo;

import com.shiyangxiao.platform.entity.CodeSnippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface CodeSnippetRepository extends JpaRepository<CodeSnippet, String> {


    @Query("from snippets s " +
            "where s.view_restricted = false " +
            "and s.time_restricted = false " +
            "order by s.created desc")
    List<CodeSnippet> findNotRestrictedOrderByCreatedDesc();
}