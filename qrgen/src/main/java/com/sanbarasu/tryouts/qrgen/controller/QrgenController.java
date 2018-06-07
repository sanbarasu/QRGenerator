package com.sanbarasu.tryouts.qrgen.controller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.sanbarasu.tryouts.qrgen.model.OutputResponse;
import com.sanbarasu.tryouts.qrgen.service.QrgenService;

@RestController
public class QrgenController {

	private final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public OutputResponse greeting(@RequestParam(value = "name", defaultValue = "Nuts") String name) {
		byte[] qrCodeImage = null;
		//Implement QR Generator here
		try {
			qrCodeImage = QrgenService.getQRCodeImage(name, 350, 350);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new OutputResponse(counter.incrementAndGet(), String.format(template,name), qrCodeImage);
	}

}
