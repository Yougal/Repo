package com.yougal.si.filters;

import java.io.File;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

public class FileNameFilter implements MessageSelector{

	@Override
	public boolean accept(Message<?> message) {
		Object payload = message.getPayload();
		if(payload instanceof File ){
			File file = (File) payload;
			if(file.getName().endsWith(".msg")){
				return true;
			}
		}
		return false;
	}

}
