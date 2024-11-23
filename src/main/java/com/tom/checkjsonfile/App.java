package com.tom.checkjsonfile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		String fileName = "config.json"; // JSON file name

		System.out.println("Hello");
		// Read the JSON file from resources folder
		try {
			URL filePath = App.class.getClassLoader().getResource(fileName);
			 if (filePath == null) {
                System.err.println("Resource not found: config.json");
                return;
            }else {
			System.out.println(filePath);
			String content = new String(Files.readAllBytes(Paths.get(filePath.toURI())));

			// Parse the JSON content
			JSONObject jsonObject = new JSONObject(content);

			// Print the JSON content
			System.out.println(jsonObject.getJSONArray("HK")); // Pretty print with indentation
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
