package cn.edu.saif.shared.manager;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author Xiao GuangLei
 *
 */

public class JmsManager extends AbstractManager {

	final static Logger logger = LoggerFactory.getLogger(JmsManager.class);
	
	private JmsTemplate jmsTemplate;

	public JmsManager(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public boolean send(String message) {

		jmsTemplate.convertAndSend("queue.message", message);
		return true;

	}

	public void receive() {

		Message msg = jmsTemplate.receive("queue.message");
		TextMessage textMessage = (TextMessage) msg;

		if (msg != null) {
			try {
				
				logger.info(textMessage.getText());

			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

	}

}
