package com.pattern.strategyfactrory.model.req;

import com.pattern.strategyfactrory.error.base.ErrorException;
import lombok.Data;

@Data
public class ErrorRequest {

  private ErrorException errorException;

}