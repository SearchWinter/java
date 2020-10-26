package db.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Description 数据库操作中常用的方法
 * @Date 2020/9/1  12:35
 **/
public class AllUtils {
    //判断表是否存在。
    public Boolean isTableExist(String sTableName, Connection connection) throws Exception {
        //得到数据库元数据
        DatabaseMetaData dbms = connection.getMetaData();
        ResultSet rs = dbms.getTables(null, null, sTableName, new String[]{"TABLE"});
        while (rs.next()) {
            if (rs.getString("TABLE_NAME").equals(sTableName)) {
                return true;
            }
        }

        return false;
    }

    //创建表
    public void createTable(String sTableName,Connection connection) throws Exception {
        if (isTableExist(sTableName,connection)) {
            return;
        }

        String sql = "CREATE TABLE " + sTableName + " (" + "id int auto_increment primary key,"
                + "day_time varchar(64) not null," + "plat varchar(64) default \"\" ," + "app varchar(32) not null,"
                + "version varchar(32) default \"\"," + "channel varchar(64) default \"\","
                + "uid_type varchar(64) default \"\"," + "total_users int default 0,"
                + "unique `index_static`(day_time, plat, app, version,channel, uid_type),"
                + "last_user varchar(32) NOT NULL,"
                + "update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
                + ")ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.executeUpdate();
    }
}
