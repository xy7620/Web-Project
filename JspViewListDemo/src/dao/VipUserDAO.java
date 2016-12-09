package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBHelper;
import entity.Items;
import entity.VipUser;


public class VipUserDAO {

	public ArrayList<VipUser> getAllVipUser() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<VipUser> list = new ArrayList<VipUser>(); // 商品集合
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from vipuser;"; // SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				VipUser user = new VipUser();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setUage(rs.getInt("uage"));
				user.setUnumber(rs.getString("unumber"));
				user.setUgoods(rs.getString("ugoods"));
				list.add(user);// 把一个商品加入集合
			}
			return list; // 返回集合。
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	// 查找vip客户
		public VipUser getVipUserByName(String uname) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conn = DBHelper.getConnection();
				String sql = "select * from vipuser where uname=?;"; // SQL语句
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, uname);
				rs = stmt.executeQuery();
				if (rs.next()) {
					VipUser user = new VipUser();
					user.setUid(rs.getInt("uid"));
					user.setUname(rs.getString("uname"));
					user.setUage(rs.getInt("uage"));
					user.setUnumber(rs.getString("unumber"));
					user.setUgoods(rs.getString("ugoods"));
					return user;
				} else {
					return null;
				}

			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			} finally {
				// 释放数据集对象
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// 释放语句对象
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			}
		}
		//添加VIP
		public int addVipUser(VipUser vipUser){
			Connection conn = null;
			PreparedStatement stmt = null;
			int rs = 0;
			try {
				conn = DBHelper.getConnection();
				String sql = "insert  vipuser  (uname,uage,unumber,ugoods) values(?,?,?,?)"; // SQL语句
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, vipUser.getUname());
				stmt.setInt(2, vipUser.getUage());
				stmt.setString(3, vipUser.getUnumber());
				stmt.setString(4, vipUser.getUgoods());
				rs = stmt.executeUpdate();
				stmt.close();

			} catch (Exception ex) {
				ex.printStackTrace();
			} 
			return rs;
		}
		//删除VIP
		public int deleteVipUserById(int uid){
			Connection conn = null;
			PreparedStatement stmt = null;
			int rs = 0;
			try {
				conn = DBHelper.getConnection();
				String sql = "delete from vipuser where uid=?;"; // SQL语句
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, uid);
				rs = stmt.executeUpdate();
				stmt.close();

			} catch (Exception ex) {
				ex.printStackTrace();
			} 
			return rs;
		}
		//修改VIP
		public int updateVipUserById(int uid,VipUser vipUser){
			Connection conn = null;
			PreparedStatement stmt = null;
			int rs = 0;
			try {
				conn = DBHelper.getConnection();
				String sql = "update  vipuser  set uname='"+vipUser.getUname()+"',uage='"+vipUser.getUage()+"',"
						+ "unumber='"+vipUser.getUnumber()+"',ugoods='"+vipUser.getUgoods()+"'  where uid=?;"; // SQL语句
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, uid);
				rs = stmt.executeUpdate();
				stmt.close();

			} catch (Exception ex) {
				ex.printStackTrace();
			} 
			return rs;
		}
	
}
