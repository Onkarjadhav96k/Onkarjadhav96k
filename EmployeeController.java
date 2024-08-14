package com.qsp.demo.Controller;

import java.sql.*;
import java.util.*;

import com.qsp.demo.models.Employee;

public class EmployeeController {
	static String url="jdbc:postgresql://localhost:5432/QSP";
	static String un="postgres";
	static String pwd="root";
	static String path="org.postgresql.Driver";
	static Connection con;
	
	static {
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, un, pwd);
		} catch (ClassNotFoundException  | SQLException e) {
			
			e.printStackTrace();
		}
		 
	}
	public static void insert(Employee e) {
		try {
			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setDouble(3, e.getSal());
			ps.executeUpdate();
			
			
			
		}catch(SQLException se) {
			se.printStackTrace();
			
		}
	}
	public static boolean UpdateNameById(int id,String name) {
		Employee emp=fetchById(id);
		if(emp.getName() !=null) {
			//3rd step
				try {
					PreparedStatement ps=con.prepareStatement("UPDATE employee set name=? where id=?");
					ps.setString(1, name);
					ps.setInt(2, id);
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
			return true;
		}
		else {
			return false;
		}
		
	}
	public static Employee fetchById(int id) {
		Employee e=new Employee();
		try {
			PreparedStatement ps=con.prepareStatement("select * from employee where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setSal(rs.getDouble("sal"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return e;
	}
	public static boolean deleteById(int id) {
		Employee e=fetchById(id);
		if(e.getName() !=null) {
			try {
				PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
				ps.setInt(1, id);
				ps.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return true;
		}
		else {
			return false;
		}
	}
	public static  List<Employee> fetchAll(){
		List<Employee> li =new ArrayList<Employee>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee emp=new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSal(rs.getDouble("sal"));
				li.add(emp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
		
	}

	
	public static void main(String[] args) {
		

	}

}
