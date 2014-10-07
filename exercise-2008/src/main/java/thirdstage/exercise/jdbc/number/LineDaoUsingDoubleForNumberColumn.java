/**
 * 
 */
package thirdstage.exercise.jdbc.number;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Required;

/**
 * @author 3rdstage
 * 
 */
public class LineDaoUsingDoubleForNumberColumn implements LineDao {

	private DataSource dataSource;

	public LineDaoUsingDoubleForNumberColumn() {
	}

	protected DataSource getDataSource() {
		return this.dataSource;
	}

	@Required
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdstage.exercise.jdbc.number.LineDao#getLength(int)
	 */
	public String getLength(int id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		double x = 0.00;
		double y = 0.00;

		try {
			conn = this.getDataSource().getConnection();

			sql = "select id, x, y from tb_line1 where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getDouble("X");
				y = rs.getDouble("Y");
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}

		if (rs != null)
			return String.valueOf(y - x);
		else
			return null;
	}

}
