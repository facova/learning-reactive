package com.reactivespring.reactivespring.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Devs {

  @Id
  private String id;
  private String name;
}
