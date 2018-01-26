package cn.edu.saif.ccm.cache.service.runnble;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageRunnable implements Runnable {

	private static final Logger logger = LoggerFactory
			.getLogger(MessageRunnable.class);

	private String message;

	public MessageRunnable(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		logger.info(message);
	}

}
