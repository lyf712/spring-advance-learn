package org.example.transaction;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author liyunfei
 **/
public class JdbcBase {
    private static Properties mysqlProperties;
    static {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("jdbc_config.properties"));
            mysqlProperties = properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void baseOp() throws ClassNotFoundException {
        // 1.加载驱动，SPI机制，交由厂商去实现————，mysql-java,--  oracle, sql-server，思考背景
        Class.forName(mysqlProperties.getProperty("datasource.mysql.driver-class-name"));
        try {
            final String url = mysqlProperties.getProperty("datasource.mysql.url");
            final String username = mysqlProperties.getProperty("datasource.mysql.username");
            final String password = mysqlProperties.getProperty("datasource.mysql.password");
            // 2.创建连接,TCP --socket 分析底层的实现~,以及druid等工具类是如何去优化的
            //    int TRANSACTION_NONE = 0;
            //    int TRANSACTION_READ_UNCOMMITTED = 1;
            //    int TRANSACTION_READ_COMMITTED = 2;
            //    int TRANSACTION_REPEATABLE_READ = 4;
            //    int TRANSACTION_SERIALIZABLE = 8;
            //   Connection con = aDriver.driver.connect(url, info);
            Connection connection = DriverManager.getConnection(url,username,password);
            String sql = "SELECT * FROM user";
            // 3.预编译语句，SQL
            //  * An object that represents a precompiled SQL statement.
            // * <P>A SQL statement is precompiled and stored in a
            // * <code>PreparedStatement</code> object. This object can then be used to
            // * efficiently execute this statement multiple times.
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //The object used for executing a static SQL statement
            // * and returning the results it produces.
            Statement statement = connection.createStatement();
//            preparedStatement.execute();
//            preparedStatement.executeQuery();
//            preparedStatement.executeUpdate();

            statement.execute(sql);

            // 4.提交
            // connection.setAutoCommit();
            // connection.commit();

            // 5.回滚
            connection.rollback();

            // 6.关闭会话
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
