package com.suresh.ws.soap;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface FileWs {

	void upload(@WebParam(name = "file") DataHandler attchment);

	DataHandler download();

}
