package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Config.ServerInfo;
import servlet.model.vo.MemberDTO;


// Repository는 dao 역할 (명칭차이일 뿐 ) - 시험
public class MemberRepository implements MemberDAOTemplate{
	
	
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("데이터베이스 연결 완료 ");
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
	public void registerMember(MemberDTO dto) throws SQLException {
		Connection conn = getConnection();
		String query = "INSERT INTO MEMBER2(ID,PASSWORD,NAME, ADDRESS) VALUES(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPassword());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getAddress());
		
		System.out.println(ps.executeUpdate()+ "명 가입");
		
		closeAll(ps,conn);
		
	}

	@Override
	public MemberDTO login(String id, String password) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM MEMBER2 WHERE ID=? AND PASSWORD=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		MemberDTO dto = new MemberDTO();

		if(rs.next()) {
			dto.setId(id);
			dto.setPassword(password);
			dto.setName(rs.getString("name"));
			dto.setAddress(rs.getString("address"));
		}
		closeAll(rs,ps,conn);
		return dto;
	}

	@Override
	public MemberDTO findByIdMember(String id) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM MEMBER2 WHERE ID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		MemberDTO dto = null;
		if(rs.next()) {
			dto = new MemberDTO();
			dto.setId(id);
			dto.setPassword(rs.getString("password"));
			dto.setName(rs.getString("name"));
			dto.setAddress(rs.getString("address"));
		}
		closeAll(rs,ps,conn);
		return dto;
	}

	@Override
	public ArrayList<MemberDTO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM MEMBER2 ";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		 ArrayList<MemberDTO> list = new ArrayList<>();
		 
		 
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPassword(rs.getString("password"));
			dto.setName(rs.getString("name"));
			dto.setAddress(rs.getString("address"));
			list.add(dto);
		}
		
		return list;
	}
	@Override
	public void updateMember(MemberDTO dto) throws SQLException {
		Connection conn = getConnection();
		String query = "UPDATE MEMBER2 SET PASSWORD=? , NAME=? ,ADDRESS=? WHERE ID=?  ";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, dto.getPassword());
		ps.setString(2, dto.getName());
		ps.setString(3, dto.getAddress());
		ps.setString(4, dto.getId());
		
		ps.executeUpdate();
		
		closeAll(ps,conn);
		  
		
		
		
	}

}
