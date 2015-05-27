package com.infusionsoft.metamindio.client.model;

public class TextClassificationRequest {
  private Long classifierId = null;
  private String value = null;
  public Long getClassifierId() {
    return classifierId;
  }
  public TextClassificationRequest setClassifierId(Long classifierId) {
    this.classifierId = classifierId;
    return this;
  }

  public String getValue() {
    return value;
  }
  public TextClassificationRequest setValue(String value) {
    this.value = value;
    return this;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TextClassificationRequest [\n");
    sb.append("  classifierId: ").append(classifierId).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("]\n");
    return sb.toString();
  }
}

