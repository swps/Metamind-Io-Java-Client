package com.infusionsoft.metamindio.client.model;

import java.util.*;
public class TextClassificationResponse {
  private List<Prediction> predictions = new ArrayList<Prediction>();
  public List<Prediction> getPredictions() {
    return predictions;
  }
  public TextClassificationResponse setPredictions(List<Prediction> predictions) {
    this.predictions = predictions;
    return this;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TextClassificationResponse [\n");
    sb.append("  predictions: ").append(predictions).append("\n");
    sb.append("]\n");
    return sb.toString();
  }
}

