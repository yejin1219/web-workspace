package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class ItemDAO implements ItemDAOTemplate {

	private static ItemDAO item = new ItemDAO();
	public ItemDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {}
	}
	
	public static ItemDAO getInstance() {
		return item;
	}
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps,conn);
		
	}

	@Override
	public ArrayList<Item> getAllItem() throws SQLException {
       Connection conn = getConnection();
       String query = "SELECT * FROM ITEM ";
       PreparedStatement ps = conn.prepareStatement(query);
       ResultSet rs = ps.executeQuery();
       ArrayList<Item> items = new ArrayList<>();
       while(rs.next()) {
    	   Item item = new Item(rs.getInt(1), rs.getString(2), rs.getInt(3),
    			   rs.getString(4), rs.getString(5),rs.getInt(6));
    	   items.add(item);
       }
       closeAll(rs,ps,conn);
		return items;
	}

	@Override
	public Item getItem(int itemId) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM ITEM WHERE ITEM_ID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, itemId);
		
		ResultSet rs = ps.executeQuery();
		Item item = null;
		if(rs.next()) {
			item = new Item(itemId, rs.getString(2), rs.getInt(3),
	    			   rs.getString(4), rs.getString(5),rs.getInt(6));
		}
		closeAll(ps,conn);
		return item;
	}

	@Override
	public boolean updateRecordCount(int itemId) throws SQLException {
		Connection conn = getConnection();
		String query = "UPDATE ITEM SET COUNT=? WHERE ITEM_ID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		
		int count = getItem(itemId).getCount();
		ps.setInt(1, ++count);
		ps.setInt(2, itemId);
		
		int result = ps.executeUpdate();
		if(result == 1) {
			return true;
		}else {
			return false;
		}
		
		
	}

}
