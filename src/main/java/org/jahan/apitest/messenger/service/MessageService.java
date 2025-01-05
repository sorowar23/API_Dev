package org.jahan.apitest.messenger.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jahan.apitest.messenger.database.DatabaseClass;
import org.jahan.apitest.messenger.model.Message;

public class MessageService {
	
	Connection con = null;
	
	//private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		//messages.put(1L, new Message(1, "Hello World!", "Jahan"));
		//messages.put(2L, new Message(2, "Hello Jersey!", "Sarowar"));
		String url = "jdbc:mysql://localhost:3306/messengerdb";
		String username = "root";
		String password = "12iUSA@db";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
		}
	}

	public List<Message> getAllMessages(){
		
		List<Message> messages = new ArrayList<>();
		String sql = "SELECT * FROM message";
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Message message = new Message();
				message.setId(rs.getLong(1));
				message.setMessage(rs.getString(2));
				message.setPoint(rs.getString(3));
				message.setAuthor(rs.getString(4));
				
				messages.add(message);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return messages; 
	}
	
	public Message getMessage(long id) {
		String sql = "SELECT * FROM message where id="+id;
		Message message = new Message();
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				message.setId(rs.getLong(1));
				message.setMessage(rs.getString(2));
				message.setPoint(rs.getString(3));
				message.setAuthor(rs.getString(4));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return message;
		//return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		/*message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;*/
		String sql = "INSERT INTO message VALUES (?,?,?,?)";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setLong(1, message.getId());
			st.setString(2, message.getMessage());
			st.setString(3, message.getPoint());
			st.setString(4, message.getAuthor());
			st.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return message;
	}

	public Message updateMessage(Message message) {
		
		String sql = "update message set message=?, point=?, author=? where id=?";
		
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, message.getMessage());
			st.setString(2, message.getPoint());
			st.setString(3, message.getAuthor());
			st.setLong(4, message.getId());
			if(message.getId() <= 0) 
			{
				return null;
			}else {
				st.executeUpdate();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return message;
	}
	
	public void removeMessage(long id) {
		String sql = "delete from message where id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setLong(1, id);
			st.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		//return messages.remove(id);
	}
	
}
