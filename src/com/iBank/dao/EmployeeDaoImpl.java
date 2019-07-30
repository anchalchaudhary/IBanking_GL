package com.iBank.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iBank.pojo.EmployeePojo;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {

	@Override
	public int saveEmployee(EmployeePojo employeePojo) {

		ResultSet rs = null;
		PreparedStatement ps = null;
		int empId = -1;

		try{
			getDBConnection();
			con.setAutoCommit(false);
			String insertQuery = "insert into employee_details (emp_first_name, emp_last_name, emp_age, emp_gender) values (?, ?, ?, ?)";
			ps = con.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, employeePojo.getFname());
			ps.setString(2, employeePojo.getLname());
			ps.setInt(3, employeePojo.getAge());
			ps.setString(4, employeePojo.getGender());
			int insertCount = ps.executeUpdate();

			if(insertCount>0) {

				rs = ps.getGeneratedKeys();
				if(rs.next()) {
					con.commit();
					empId = rs.getInt(1);
					employeePojo.setEmpId(empId);
				} else {
					con.rollback();
				}
			} else {
				System.out.println("Couldn't add");
			}
		}
		catch (Exception e) {
			System.out.println("ERROR: Couldn't create Employee");
		} finally {
			closeResultSet(rs);
			closePreparedStatement(ps);
			closeConnection();
		}
		return empId;
	}

	@Override
	public List<EmployeePojo> listEmployee() {

		ResultSet rs = null;
		PreparedStatement ps = null;
		List<EmployeePojo> empList = new ArrayList<EmployeePojo>();
		try{
			getDBConnection();
				String selectQuery = "select * from employee_details";
				ps = con.prepareStatement(selectQuery);
				rs = ps.executeQuery();
				while(rs.next()) {
					EmployeePojo employeePojo = new EmployeePojo();
					employeePojo.setEmpId(rs.getInt("emp_id"));
					employeePojo.setFname(rs.getString("emp_first_name"));
					employeePojo.setLname(rs.getString("emp_last_name"));
					employeePojo.setAge(rs.getInt("emp_age"));
					employeePojo.setGender(rs.getString("emp_gender"));
					empList.add(employeePojo);
				}
			
		} catch (Exception e) {
			System.out.println("Couldn't load details");
		} finally {
			closeResultSet(rs);
			closePreparedStatement(ps);
			closeConnection();
		}
		return empList;
	}
	
	@Override
	public EmployeePojo getEmployee(int empId) {

		ResultSet rs = null;
		PreparedStatement ps = null;
		EmployeePojo employeePojo = new EmployeePojo();
		try {
			getDBConnection();
			ps = con.prepareStatement("select * from employee_details where emp_id=?");
			ps.setInt(1, empId);
			rs = ps.executeQuery();
			if(rs.next()) {
				employeePojo.setEmpId(rs.getInt("emp_id"));
				employeePojo.setFname(rs.getString("emp_first_name"));
				employeePojo.setLname(rs.getString("emp_last_name"));
				employeePojo.setAge(rs.getInt("emp_age"));
				employeePojo.setGender(rs.getString("emp_gender"));
			}
		} catch (Exception e) {
			System.out.println("Could not load employee details");
		} finally {
			closeResultSet(rs);
			closePreparedStatement(ps);
			closeConnection();
		}
		return employeePojo;
	}

	@Override
	public void updateEmployee(EmployeePojo employeePojo) {
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			getDBConnection();

			String updateQuery = "update  employee_details set emp_first_name=?, emp_last_name=?, emp_age=?, emp_gender=? where emp_id=?";
			ps = con.prepareStatement(updateQuery);

			ps.setString(1, employeePojo.getFname().trim());
			ps.setString(2, employeePojo.getLname().trim());
			ps.setInt(3, employeePojo.getAge());
			ps.setString(4, employeePojo.getGender().trim());
			ps.setInt(5, employeePojo.getEmpId());

			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println("Updated Employee record successfully...");
			} else {
				System.out.println("Error in updating Employee record...");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			closeConnection();
			closeResultSet(rs);
			closePreparedStatement(ps);
		}
	}

	@Override
	public void deleteEmployee(int empId) {

		PreparedStatement ps = null;

		try {
			getDBConnection();

			String deleteQuery = "delete from  employee_details  where emp_id=?";
			ps = con.prepareStatement(deleteQuery);

			ps.setInt(1, empId);

			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println("Deleted Employee record successfully...");
			} else {
				System.out.println("Error in deleting Employee record...");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			closeConnection();
			closePreparedStatement(ps);
		}
	}
}
