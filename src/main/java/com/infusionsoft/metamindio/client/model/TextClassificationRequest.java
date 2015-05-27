package com.infusionsoft.metamindio.client.model;

public class TextClassificationRequest {
  private Long classifier_id = null;
  private String value = null;
  public Long getClassifier_id() {
    return classifier_id;
  }
  public TextClassificationRequest setClassifierId(Long classifierId) {
    this.classifier_id = classifierId;
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
    sb.append("  classifierId: ").append(classifier_id).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("]\n");
    return sb.toString();
  }
}

