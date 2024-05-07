package com.rinbows.soft.myemoticonjava.data;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Category implements Serializable {
    private String categoryName;
    private List<Identifier> childList;
}
