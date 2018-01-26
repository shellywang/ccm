package cn.edu.saif.shared.manager;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Xiao GuangLei
 *
 */
public class JmsListener implements MessageListener {

	final static Logger logger = LoggerFactory.getLogger(JmsListener.class);

//	@Autowired
//	JmsManager jmsManager;
	
	@Override
	public void onMessage(Message message) {
		TextMessage textMsg = (TextMessage) message;
		
		try {
			logger.info(textMsg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
	

}
