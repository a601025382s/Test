package com.linb.sql;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.linb.util.IdHandler;

/**
 * @ClassName ReadSql
 * @Description 读片会sql
 * @author linb
 * @date 2016年5月17日 下午1:50:54
 */
public class ReadSql {
    private static final String url = "jdbc:mysql://115.159.1.60:6060/ylpt?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
    private static final String user = "test";
    private static final String password = "09408117yuan";
    
    public static void main(String[] args) {
        setPathologyViewCount();
        setPacsViewCount();
        System.out.println("sql end !!!!!!!!!");
    }

    /**
     * @Description 修改影像点击量
     */
    public static void setPacsViewCount() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        FileWriter writer = null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // 各dicomId点击量计数
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM user_flow WHERE url_name = '/weixin/pacs.htm' AND is_delete = '1' AND request_data LIKE 'dicomId=%';";
            rs = stmt.executeQuery(sql);
            File file = new File("C:\\Users\\ucmed\\Desktop\\pacs.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            writer = new FileWriter("C:\\Users\\ucmed\\Desktop\\pacs.txt", true); 
            writer.write("# update pacs viewCount \n");
            while(rs.next()) {
                String requestData = rs.getString("request_data");
                int st = requestData.indexOf("=");
                int en = requestData.indexOf("&");
                Integer dicomId = IdHandler.idDecryptToInteger(requestData.substring(st + 1, en));
                if (null == map.get(dicomId)) {
                    map.put(dicomId, 1);
                } else {
                    map.put(dicomId, map.get(dicomId) + 1);
                }
            }
            for (Integer key : map.keySet()) {
                writer.write("UPDATE read_dicom SET view_count = " + map.get(key) + " WHERE dicom_id = " + key + ";\n");
            }
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
     * @Description 修改病理点击量
     */
    public static void setPathologyViewCount() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        FileWriter writer = null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // 各dicomId点击量计数
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM user_flow WHERE url_name = '/weixin/pathology.htm' AND is_delete = '1' AND request_data LIKE 'dicomId=%';";
            rs = stmt.executeQuery(sql);
            File file = new File("C:\\Users\\ucmed\\Desktop\\bl.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            writer = new FileWriter("C:\\Users\\ucmed\\Desktop\\bl.txt", true); 
            writer.write("# update pathology viewCount \n");
            while(rs.next()) {
                String requestData = rs.getString("request_data");
                int st = requestData.indexOf("=");
                int en = requestData.indexOf("&");
                Integer dicomId = IdHandler.idDecryptToInteger(requestData.substring(st + 1, en));
                if (null == map.get(dicomId)) {
                    map.put(dicomId, 1);
                } else {
                    map.put(dicomId, map.get(dicomId) + 1);
                }
            }
            for (Integer key : map.keySet()) {
                writer.write("UPDATE read_dicom SET view_count = " + map.get(key) + " WHERE dicom_id = " + key + ";\n");
            }
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
}
