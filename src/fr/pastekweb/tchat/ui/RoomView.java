package fr.pastekweb.tchat.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;

import fr.pastekweb.tchat.event.IMessageListener;
import fr.pastekweb.tchat.model.Room;

/**
 * The {@link Room} view
 * 
 * @author Antoine LELAISANT <antoine.lelaisant@gmail.com>
 */
public class RoomView extends JPanel implements IMessageListener
{
	private static final long serialVersionUID = -4458295478133444427L;

	/**
	 * The {@link Room}
	 */
	private Room room;
	
	/**
	 * The user list
	 */
	private JList<String> userList;
	/**
	 * The messages view
	 */
	private MessagesView messagesView;
	/**
	 * The connected users map
	 */
	private MapView mapView;
	
	/**
	 * Initialize the {@link Room} view
	 * @param room The {@link Room}
	 */
	public RoomView(Room room)
	{
		super(new BorderLayout());
		this.room = room;
		this.room.addMessageListener(this);
		
		userList = new JList<>();
		userList.setModel(room.getUsers());
		
		messagesView = new MessagesView();
		
		mapView = new MapView();
		mapView.setModel(room.getUsers());
		
		createView();
	}
	
	/**
	 * Creates the view containing all graphical components
	 */
	private void createView()
	{
		userList.setPreferredSize(new Dimension(100, 400));
		this.add(userList, BorderLayout.WEST);
		
		this.add(messagesView, BorderLayout.CENTER);
		
		mapView.setPreferredSize(new Dimension(200, 200));
		this.add(mapView, BorderLayout.EAST);
	}
	
	/**
	 * Gets the messages' view
	 * @return The Messages View
	 */
	public MessagesView getMessagesView()
	{
		return messagesView;
	}

	@Override
	public void hasNewMessage(String from, String message)
	{
		this.messagesView.addMessage(from, message);
	}
}
