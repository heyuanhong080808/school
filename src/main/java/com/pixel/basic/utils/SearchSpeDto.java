package com.pixel.basic.utils;

import org.springframework.data.jpa.domain.Specifications;

//多条件筛选,SearchDto增加属性
public class SearchSpeDto {

 /** 类型，and或者or */
 private String type;

 public SearchSpeDto(String type, Specifications spes) {
     this.type = type;
     this.spes = spes;
 }

 private Specifications spes;

 public Specifications getSpes() {
     return spes;
 }

 public String getType() {
     return type;
 }

 public void setSpes(Specifications spes) {
     this.spes = spes;
 }

 public void setType(String type) {
     this.type = type;
 }
}
