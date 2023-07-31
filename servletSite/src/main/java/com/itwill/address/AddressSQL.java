package com.itwill.address;


public class AddressSQL {
	private AddressSQL() {
	}

	public static final String ADDRESS_INSERT = "insert into address values(address_no_seq.nextval,?,?,?)";
	public static final String ADDRESS_UPDATE = "update address set name=? ,phone=?,address=? where no=?";
	public static final String ADDRESS_DELETE = "delete address where no=?";
	public static final String ADDRESS_SELECT_BY_NO = "select no,name,phone,address from address where no=?";
	public static final String ADDRESS_SELECT_ALL = "select no,name,phone,address from address";
}