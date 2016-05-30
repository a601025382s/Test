package com.linb.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.linb.util.IdHandler;

/**
 * @ClassName MySql
 * @Description mysql数据库操作测试
 * @author linb
 * @date 2016年1月21日 下午1:35:21
 */
public class MySql {
    // private static final String url = "jdbc:mysql://127.0.0.1:3306/linb?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
    // private static final String user = "root";
    // private static final String password = "";
    private static final String url = "jdbc:mysql://115.159.1.60:4040/test?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
    private static final String user = "ucmed";
    private static final String password = "txtest@mysql";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM live_point_app";
            rs = stmt.executeQuery(sql);
            List<Point> points = new ArrayList<Point>();
            while(rs.next()) {
                Integer id = rs.getInt("id");
                String clientUser = rs.getString("client_user");
                Integer userId = IdHandler.idDecryptToInteger(clientUser);
                points.add(new Point(id, userId));
            }
            
            if (CollectionUtils.isNotEmpty(points)) {
                for (Point point : points) {
                    String updateSql = "UPDATE live_point_app SET user_id = " + point.getUserId() + " WHERE id = " + point.getId();
                    stmt.execute(updateSql);
                }
            }
        } catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("sql end!!!");
    }
    
    public static class Point {
        private Integer id;
        private Integer userId;
        Point(Integer id, Integer userId) {
            this.id = id;
            this.userId = userId;
        }
        
        public Integer getId() {
            return id;
        }
        
        public Integer getUserId() {
            return userId;
        }
    }
}
