package db;

import db.utils.DataSourceUtils;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

/**
 * @Description 获取数据库连接
 * @Date 2020/9/1  12:32
 **/
public class Demo1 {
    public static void main(String[] args) throws Exception {
        BasicDataSource ds = DataSourceUtils.createDataSource(
                "jdbc:mysql://192.168.7.239:3306/db_taf_es_log?rewriteBatchedStatements=true&useUnicode=true&characterEncoding=UTF-8",
                "root", "123456");
        Connection connection = ds.getConnection();

        connection.close();
    }
}
