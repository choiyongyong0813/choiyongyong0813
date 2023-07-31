package com.itwill.address;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.common.DataSource;

/*
 * Dao(Data Access Object) 클래스
 *    - address테이블에 CRUD(Create,Read,Update,Delete)작업을하는
 *      단위메쏘드를 가지고있는 클래스
 *    
 * 
 */
public class AddressDao {
	/*
	 * DataSource객체를 멤버필드로 가짐
	 * (Connection을 생성하고 해지하는 객체)
	 */
	private DataSource dataSource;

	public AddressDao() throws Exception{
		/*
		 * dataSource멤버필드 초기화
		 */
		this.dataSource = new DataSource();
	}

	public int insert(Address newAddress) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_INSERT);
		pstmt.setString(1, newAddress.getName());
		pstmt.setString(2, newAddress.getPhone());
		pstmt.setString(3, newAddress.getAddress());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);

		return rowCount;
	}

	public int update(Address updateAddress) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_UPDATE);

		pstmt.setString(1, updateAddress.getName());
		pstmt.setString(2, updateAddress.getPhone());
		pstmt.setString(3, updateAddress.getAddress());
		pstmt.setInt(4, updateAddress.getNo());

		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public int delete(int no) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_DELETE);
		pstmt.setInt(1, no);

		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public Address findByPrimaryKey(int no) throws Exception {

		Address findAddress = null;

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_SELECT_BY_NO);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			int n = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			findAddress = new Address(no, name, phone, address);
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return findAddress;
	}

	public List<Address> findAll() throws Exception {

		List<Address> addressList = new ArrayList<Address>();

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			do {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String addr = rs.getString("address");
				Address address = new Address(no, name, phone, addr);
				addressList.add(address);
			} while (rs.next());
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return addressList;
	}

}