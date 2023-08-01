package com.ngntuli.avaj.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOUtil {
	public static String read(String fileName) {
		StringBuilder lines = new StringBuilder();
		try (BufferedReader buff = new BufferedReader(new FileReader(new File(fileName)))) {

			String line;
			while ((line = buff.readLine()) != null) {
				lines.append(line).append("\n");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines.toString();

	}
}
