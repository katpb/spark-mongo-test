/* Copyright (C) 2011 VeriFone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 13 January, 2012                                     Ganesh Kumar
 */
package com.verifone.isd.vsms2.sys.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for closing database specific resources.
 * 
 * @author Ganesh_K1
 */
public class DBUtil {	
	private static Logger logger
	= LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.DBUtil.class);
	
	/**
	 * Utility method to close ResultSet.
	 * 
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Error while closing ResultSet", e.getMessage());
			}
			rs = null;
		}
	}
	
	/**
	 * Utility method to close PreparedStatement.
	 * 
	 * @param ps
	 */
	public static void closePreparedStatement(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				logger.error("Error while closing PreparedStatement", e.getMessage());
			}
			ps = null;
		}
	}
	
	/**
	 * Utility method to close Connection.
	 * 
	 * @param con
	 */
	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e1) {
				logger.error("Error while closing connection", e1.getMessage());
			}
			con = null;
		}
	}

	/**
	 * Utility method to close Statement.
	 * @param stmt
	 */
	public static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				logger.error("Error while closing Statement ", e.getMessage());
			}
			stmt = null;
		}
	}
}
