package db.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
}
