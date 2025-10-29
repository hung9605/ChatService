package com.app.dto;

import com.app.constants.AppHttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBean {

     Object data;
     String message;
     AppHttpStatus status = AppHttpStatus.SUCCESS;
     
	public ResponseBean(Object data) {
		super();
		this.data = data;
	}


	
	
     
     
    
  
   
}