package com.suresh.ws.soap.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import com.suresh.ws.soap.FileWs;

public class FileWsImpl implements FileWs {

	@Override
	public void upload(DataHandler attchment) {

		try {
			InputStream inputStream = attchment.getInputStream();
			OutputStream outputStream = new FileOutputStream(
					new File("G:\\WebServices\\mtom\\Files\\uploaded\\test.jpg"));

			byte[] b = new byte[10000];
			int bytesRead = 0;
			while ((bytesRead = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, bytesRead);
			}
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public DataHandler download() {
		return new DataHandler(new FileDataSource(new File("G:\\WebServices\\mtom\\Files\\uploaded\\test.jpg")));
	}
}
