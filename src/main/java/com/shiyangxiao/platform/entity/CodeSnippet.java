package com.shiyangxiao.platform.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "snippets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CodeSnippet {

    @Id
    @JsonIgnore
    private String id = UUID.randomUUID().toString();;

    private String code;

    @JsonProperty("date")
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;

    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @JsonProperty("views")
    private Long viewsAllowed;
    @JsonProperty("time")
    private Long secondsLeft;

    @JsonIgnore
    private Boolean view_restricted;
    @JsonIgnore
    private Boolean time_restricted;

}
