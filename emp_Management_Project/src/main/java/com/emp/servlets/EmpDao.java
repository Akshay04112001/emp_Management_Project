package com.emp.servlets;

import java.util.*;
import java.sql.*;

public class EmpDao {
	static Connection con;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empAppdb", "root", "root");
			System.out.println("connection .........................Succesful");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static int save(Emp e) {
		int status = 0;
		try {
			con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into user905(empid, name, email, number, location, date, batch) values (?,?,?,?,?,?,?)");
			ps.setString(1, e.getEmpid());
			ps.setString(2, e.getName());
			ps.setString(3, e.getEmail());
			ps.setLong(4, e.getNumber());
			ps.setString(5, e.getLocation());
			ps.setString(6, e.getDate());
			ps.setString(7, e.getBatch());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Emp e) {
		int status = 0;
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update user905 set name=?, email=?, number=?,location=?, date=?, batch=? where empid=?");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setLong(3, e.getNumber());
			ps.setString(4, e.getLocation());
			ps.setString(5, e.getDate());
			ps.setString(6, e.getBatch());
			ps.setString(7, e.getEmpid());

			
//	        System.out.println("Executing update query: " + ps.toString());
			status = ps.executeUpdate();
			;
			con.close();
			
//            System.out.println("Update status: " + status);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(String sid) {
		int status = 0;
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from user905 where empid=?");
			ps.setString(1, sid);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Emp getEmployeeById(String empid) {
		Emp e = new Emp();

		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user905 where empid=?");
			ps.setString(1, empid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setEmpid(rs.getString(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setNumber(rs.getLong(4));
				e.setLocation(rs.getString(5));
				e.setDate(rs.getString(6));
				e.setBatch(rs.getString(7));
				e.setNumber(rs.getLong(empid));

			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<Emp> getAllEmployees() {
		List<Emp> list = new ArrayList<Emp>();

		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user905");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Emp e = new Emp();
				e.setEmpid(rs.getString(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setNumber(rs.getLong(4));
				;
				e.setLocation(rs.getString(5));
				e.setDate(rs.getString(6));
				e.setBatch(rs.getString(7));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}