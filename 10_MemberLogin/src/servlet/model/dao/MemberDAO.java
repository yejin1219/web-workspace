package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Config.ServerInfo;
import servlet.model.vo.MemberDTO;
import servlet.model.dao.MemberDAO;

public class MemberDAO implements MemberDAOTemplate{
	
	
	
	/*
	싱글톤 패턴 - 클래스의 객체가 항상 하나만 존재하도록 
	DAO를 반복적으로 생성하고 패제하는 것은 비효율적
	객체지향적 설계! 상글톤 패턴은 객체지향적 설계 원칙을 준수 -> 중앙에서 처리!
	싱글톤은 전역 상태를 가질 수 있으므로 오남용하면 애플리케이션의 복잡성이 증가
	*/
	
	public static void main(String[] args) {
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
//		dto.setId("user");
//		dto.setPassword("1234");
//		dto.setName("김씨");
//		dto.setAddress("서울");
		try {
//			dao.registerMember(dto);
			System.out.println( dao.login("user", "1234").getName());
			System.out.println(dao.findByIdMember("dpwls1219"));
//			System.out.println(dao.showAllMember());
			} catch (SQLException e) {
			
		}
		
		
	}
	
	private static MemberDAO dao = new MemberDAO();
	public MemberDAO(){
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {}
		
	}
	public static MemberDAO getInstance() {
		return dao;
	}
//	public MemberDAO(){
//		try {
//			Class.forName(ServerInfo.DRIVER_NAME);
//			System.out.println("드라이버 연결 완료");
//		} catch (ClassNotFoundException e) {}
//		
//	}
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

}
