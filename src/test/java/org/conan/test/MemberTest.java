package org.conan.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
@Log4j
public class MemberTest {
	@Setter(onMethod_= {@Autowired})
	private PasswordEncoder pwencoder;
	@Setter(onMethod_= {@Autowired})
	private DataSource ds;
	
	@Test
	public void testInsertMember() {
		String sql = "insert into tbl_member(userid, userpwd, username) values (?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		for(int i=0; i<30; i++) {
			try {
				conn=ds.getConnection();
				pstmt= conn.prepareStatement(sql);
				pstmt.setString(2, pwencoder.encode("pw"+i));
				if(i<10) {
					pstmt.setString(1, "user"+i);
					pstmt.setString(3, "일반 사용자"+i);
				}else if(i<20) {
					pstmt.setString(1, "member"+i);
					pstmt.setString(3, "운영자"+i);
				}else {
					pstmt.setString(1, "admin"+i);
					pstmt.setString(3,"관리자"+i);
				}
				pstmt.executeUpdate();
			}catch(SQLException e) {}
			finally {
				if(pstmt!=null) {
					try {
						pstmt.close();
					}catch(SQLException e) {}
					if(conn!=null) {
						try {
							conn.close();
						}catch(SQLException e) {}
					}
				}
			}
		}
	}
	
	//생성된 사용자에 권한 추가하기
	// user**에게 ROLE_USER권한
	//member**에게 ROLE_MEMBER권한
	//admin**에게 ROLE_ADMIN권한
	@Test
	public void testInsertAuth() {
		String sql = "insert into tbl_member_auth(userid,auth) values(?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		for(int i=0; i<30; i++) {
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				if(i<10) {
					pstmt.setString(1, "user"+i);
					pstmt.setString(2, "ROLE_USER");
				}else if(i<20) {
					pstmt.setString(1, "member"+i);
					pstmt.setString(2, "ROLE_MEMBER");
				}else {
					pstmt.setString(1, "admin"+i);
					pstmt.setString(2, "ROLE_ADMIN");	
				}
				pstmt.executeUpdate();
			}catch(SQLException e) {}
			finally {
				if(pstmt!=null) {
					try {
						pstmt.close();
					}catch(SQLException e) {}
					if(conn!=null) {
						try {
							conn.close();
						}catch(SQLException e) {}
					}
				}
			}
		} //for문 end
	}
	
}
