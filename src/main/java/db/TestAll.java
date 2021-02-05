package db;


import db.utils.DataSourceUtils;
import db.utils.Utils;
import org.apache.commons.dbcp2.BasicDataSource;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
import java.sql.*;

/**
 * @author up-517
 * @date 2020/07/02
 */
public class TestAll {
    private static BasicDataSource ds = null;

    public static void setUpBeforeClass() throws Exception {
        ds = DataSourceUtils.createDataSource(
                "jdbc:mysql://x.x.x.x:3306/db_es_taf_stat_md?rewriteBatchedStatements=true&useUnicode=true&characterEncoding=UTF-8",
                "root", "123456");
    }

    /**
     * @throws java.lang.Exception
     */
    public static void tearDownAfterClass() throws Exception {
        ds.close();
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

        System.out.println("setUp");
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }


    @org.junit.Test
    public void testRead() {
        System.out.println("testRead");
    }

    /** ResultSet的三种取时间方法
     * getDate()    只返回日期部分
     * getTime()    只返回时间部分
     * getTimestamp()   返回时间和日期
     * */
    @Test
    public void testGetDate() throws SQLException {
        String tableName="taf_stat_test";
        //limit 前面有空格，不然和tableName连在一起
        String sql="select * from  "+tableName +" limit 1";

        Connection connection = ds.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            try{
                ResultSet resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
                    Date date = resultSet.getDate(1);
                    System.out.println(date);

                    Time time = resultSet.getTime(1);
                    System.out.println(time);

                    Timestamp timestamp = resultSet.getTimestamp(1);
                    System.out.println(timestamp);
                }
            }finally {
                statement.close();
            }
        }finally {
            connection.close();
        }
    }

    /** output
     * 2020-11-24
     * 15:05:08
     * 2020-11-24 15:05:08.0
     */

    /** 测试DriverManger.getConnection */
    @Test
    public void testGetConnection() throws SQLException {
        String dbUrl="jdbc:mysql://172.16.8.137:3306/db_es_taf_trace_log";
        String dbUser="root";
        String dbPwd="123456";
        Connection connection = Utils.getConnection(dbUrl, dbUser, dbPwd);

        connection.close();
    }
}
