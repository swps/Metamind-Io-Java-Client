package com.infusionsoft.metamindio.client.model;

public class Prediction {
  private Long classId = null;
  private String className = null;
  private Double prob = null;
  public Long getClassId() {
    return classId;
  }
  public Prediction setClassId(Long classId) {
    this.classId = classId;
    return this;
  }

  public String getClassName() {
    return className;
  }
  public Prediction setClassName(String className) {
    this.className = className;
    return this;
  }

  public Double getProb() {
    return prob;
  }
  public Prediction setProb(Double prob) {
    this.prob = prob;
    return this;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Prediction [\n");
    sb.append("  classId: ").append(classId).append("\n");
    sb.append("  className: ").append(className).append("\n");
    sb.append("  prob: ").append(prob).append("\n");
    sb.append("]\n");
    return sb.toString();
  }
}

