package com.example.demo.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

	@PostMapping("/doUpload")
	public String doUpload(@RequestParam MultipartFile myFile) throws IllegalStateException, IOException {

		if (!myFile.isEmpty()) {
			String name = myFile.getOriginalFilename();

			File file = new File("D:\\" + name);

			myFile.transferTo(file);
		}

		return "Uploaded successfully.";
	}

}
