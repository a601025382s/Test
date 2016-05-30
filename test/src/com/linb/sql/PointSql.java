package com.linb.sql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.linb.util.IdHandler;

public class PointSql {
    private static final String url = "jdbc:mysql://115.159.1.60:6060/ylpt?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
    private static final String user = "test";
    private static final String password = "09408117yuan";

    public static void main(String[] args) {
        System.out.println("start-------------------------");
        // perfect();
        doctor();
    }
    
    /**
     * @Description 医生认证
     */
    public static void doctor() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer();
        FileWriter writer = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            String sql = "SELECT a.id, IF(ypup.available_point IS NULL, 0, ypup.available_point) available_point, a.check_time FROM ("
                    + " SELECT u.*, ul.check_time FROM `user` u LEFT JOIN user_license ul ON u.id = ul.user_id AND ul.is_delete = '1'"
                    + " WHERE u.is_delete = '1' AND u.user_channel = '0' AND u.user_state = '0' AND ul.id IS NOT NULL"
                    + " AND ul.expert_name IS NOT NULL AND ul.hospital IS NOT NULL AND ul.hospital != ''"
                    + " ) a LEFT JOIN ("
                    + " SELECT * FROM ylpt_point_once_records ypor WHERE ypor.point_rule_id = 'a06ca682-c178-11e5-8fe0-5cb901886854' "
                    + " AND ypor.is_delete = '1' AND ypor.is_valid = '1'"
                    + " ) b ON a.id = b.user_id"
                    + " LEFT JOIN ylpt_point_user_point ypup ON a.id = ypup.user_id"
                    + " WHERE b.record_id IS NULL";
            rs = stmt.executeQuery(sql);
            List<Integer> userIds = new ArrayList<Integer>();
            List<String> records = new ArrayList<String>();
            File file = new File("C:\\Users\\ucmed\\Desktop\\1.txt");
            writer = new FileWriter("C:\\Users\\ucmed\\Desktop\\1.txt", true); 
            writer.write("# insert ylpt_point_once_records \n");
            while(rs.next()) {
                Integer id = rs.getInt("id");
                userIds.add(id);
                String availablePoint = rs.getString("available_point");
                Date date = rs.getTimestamp("check_time");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String checkTime = format.format(null == date ? new Date() : date);
                String res = "INSERT INTO `ylpt_point_once_records` (record_id, user_id,"
                        + " point_rule_id, point_number, point_balance, create_time) "
                        + " VALUES (UUID(), " + id + ", 'a06ca682-c178-11e5-8fe0-5cb901886854', '500', '" 
                        + (Double.parseDouble(availablePoint) + 500) + "', '" + checkTime +"');" ;
                String res2 = "INSERT INTO `ylpt_point_records` (record_id, user_id,"
                        + " point_rule_id, point_number, point_balance, create_time, point_source) "
                        + " VALUES (UUID(), " + id + ", 'a06ca682-c178-11e5-8fe0-5cb901886854', '500', '" 
                        + (Double.parseDouble(availablePoint) + 500) + "', NOW(), '2');" ;
                System.out.println(res);
                writer.write(res + "\n");
                
                records.add(res2);
            }
            
            System.out.println("");
            System.out.println("");
            writer.write("\n\n\n# insert ylpt_point_records \n");
            for (String record : records) {
//                System.out.println(record);
                writer.write(record + "\n");
            }
            System.out.println("");
            System.out.println("");
            writer.write("\n\n\n# update ylpt_user_point \n");
            for (int i = 0; i < userIds.size(); i++) {
                String selectSql = "SELECT * FROM ylpt_point_user_point WHERE is_delete = '1' AND user_id = " + userIds.get(i);
                rs = stmt.executeQuery(selectSql);
                if (!rs.next()) {
                    String insertSql = "INSERT ylpt_point_user_point (user_point_id, total_point, available_point, user_id, create_time) "
                            + " VALUES (UUID(), '500', '500', " + userIds.get(i) + ", NOW());";
                    // System.out.println(insertSql);
                    writer.write(insertSql + "\n");
                } else {
                    String userPointId = rs.getString("user_point_id");
                    String updateSql = "UPDATE ylpt_point_user_point SET available_point = available_point + 500,"
                            + " total_point = total_point + 500"
                            + " WHERE user_point_id = '" + userPointId +"';";
                    // System.out.println(updateSql);
                    writer.write(updateSql + "\n");
                }
            }
            
            writer.flush();
        } catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch(IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    /**
     * @Description 完善资料
     */
    public static void perfect() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            String sql = "SELECT t.id, IF(ypup.available_point IS NULL, 0, ypup.available_point) available_point FROM"
                    + " (SELECT u.*, ypor.record_id FROM `user` u"
                    + " LEFT JOIN ylpt_point_once_records ypor "
                    + " ON ypor.point_rule_id = 'c6298cd3-c179-11e5-8fe0-5cb901886854'"
                    + " AND ypor.is_delete = '1' AND ypor.is_valid = '1' AND ypor.user_id = u.id"
                    + " WHERE u.user_nick IS NOT NULL AND u.user_nick != ''"
                    + " AND u.user_photo_url IS NOT NULL AND u.user_photo_url != ''"
                    + " AND u.user_sex IS NOT NULL AND u.user_sex != '' AND u.user_sex != '0'"
                    + " )t LEFT JOIN ylpt_point_user_point ypup ON t.id = ypup.user_id AND ypup.is_delete = '1'"
                    + " WHERE record_id IS NULL;";
            rs = stmt.executeQuery(sql);
            List<Integer> userIds = new ArrayList<Integer>();
            List<String> records = new ArrayList<String>();
            while(rs.next()) {
                Integer id = rs.getInt("id");
                userIds.add(id);
                String availablePoint = rs.getString("available_point");
                String res = "INSERT INTO `ylpt_point_once_records` (record_id, user_id,"
                        + " point_rule_id, point_number, point_balance, create_time) "
                        + " VALUES (UUID(), " + id + ", 'c6298cd3-c179-11e5-8fe0-5cb901886854a', '5', '" 
                        + (Double.parseDouble(availablePoint) + 5) + "', NOW());" ;
                String res2 = "INSERT INTO `ylpt_point_records` (record_id, user_id,"
                        + " point_rule_id, point_number, point_balance, create_time, point_source) "
                        + " VALUES (UUID(), " + id + ", 'c6298cd3-c179-11e5-8fe0-5cb901886854a', '5', '" 
                        + (Double.parseDouble(availablePoint) + 5) + "', NOW(), '4');" ;
                System.out.println(res);
                records.add(res2);
            }
            System.out.println("");
            System.out.println("");
            for (String record : records) {
                System.out.println(record);
            }
            System.out.println("");
            System.out.println("");
            for (int i = 0; i < userIds.size(); i++) {
                String selectSql = "SELECT * FROM ylpt_point_user_point WHERE is_delete = '1' AND user_id = " + userIds.get(i);
                rs = stmt.executeQuery(selectSql);
                if (!rs.next()) {
                    String insertSql = "INSERT ylpt_point_user_point (user_point_id, total_point, available_point, user_id, create_time) "
                            + " VALUES (UUID(), '5', '5', " + userIds.get(i) + ", NOW());";
                    System.out.println(insertSql);
                } else {
                    String userPointId = rs.getString("user_point_id");
                    String updateSql = "UPDATE ylpt_point_user_point SET available_point = available_point + 5,"
                            + " total_point = total_point + 5"
                            + " WHERE user_point_id = '" + userPointId +"';";
                    System.out.println(updateSql);
                }
            }
            
            
        } catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
