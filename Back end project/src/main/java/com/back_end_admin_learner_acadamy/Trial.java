package com.back_end_admin_learner_acadamy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class Trial extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	//Define datasource/connection pool for reference
	
		@Resource(name="jdbc")
		private DataSource dataSource;
		
		
		
		
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			// Set the printwriter
			PrintWriter out = response.getWriter();
			response.setContentType("text/plain");
			
			// establish connection to the DB
			Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRs = null;
			
			try {
				
				myConn = dataSource.getConnection();
			//create a sql statement
			String sql = "select * from students";
			myStmt = myConn.createStatement();
			
			
			//execute the sql statement
			myRs = myStmt.executeQuery(sql);
			
			//process the resultset
			while(myRs.next()) {
				String fname = myRs.getString("fname");
				out.println(fname);
				
			}
			
			
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
}
