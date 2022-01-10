package phone;

import connector.Connector;
import receiver.Receiver;
import sender.Sender;
import speaker.Speaker;

public class Phone {
	
	public Sender phoneSender = new Sender();
	public Receiver phoneReceiver = new Receiver();
	public Connector phoneConnector = new Connector();
//	public Button phoneButton = new Button();
	public Speaker phoneSpeaker = new Speaker();
	
	public PhoneButton phoneButton = new PhoneButton();

}
