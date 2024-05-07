package com.rinbows.soft.myemoticonjava.data;

import java.io.Serializable;

import lombok.Data;

@Data
public class Identifier implements Serializable {
    private Integer count;
    private String identifierName;
    private String previewList;
    private String title;
    private String zipUrl;
}
