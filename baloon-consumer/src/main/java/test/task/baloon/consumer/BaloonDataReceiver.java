package test.task.baloon.consumer;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class BaloonDataReceiver {
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
	}

}
