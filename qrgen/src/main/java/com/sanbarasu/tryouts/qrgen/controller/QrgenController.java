package com.sanbarasu.tryouts.qrgen.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanbarasu.tryouts.qrgen.request.InputRequest;

@RestController
public class QrgenController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public InputRequest greeting(@RequestParam(value = "name", defaultValue = "Nuts") String name) {
		
		//Implement QR Generator here
		
		return new InputRequest(counter.incrementAndGet(), String.format(template, name));
	}

}
