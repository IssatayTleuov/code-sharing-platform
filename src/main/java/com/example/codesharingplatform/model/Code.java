package com.example.codesharingplatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "codes")
public class Code {
    @Id
    @GenericGenerator(name = "code_id", strategy = "com.example.codesharingplatform.generator.CodeIdGenerator")
    @GeneratedValue(generator = "code_id")
    @JsonIgnore
    private String id;
    @Column(name = "code")
    private String code;
    @Column(name = "date")
    private String date;

    public Code() {
    }

    public Code(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
