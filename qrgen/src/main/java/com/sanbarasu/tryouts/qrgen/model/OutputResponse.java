package com.sanbarasu.tryouts.qrgen.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OutputResponse {

	private long id = 0;
    private String content = null;
	private byte[] outputQR;
	
}
