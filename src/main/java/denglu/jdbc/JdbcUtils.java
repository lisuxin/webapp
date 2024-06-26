package denglu.jdbc;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DataSource dataSource;
    static {
        try {
            //加载配置文件
            Properties pro = new Properties();
            //使用ClassLoader加载配置文件，获取字节输入流
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pro.load(is);
            //初始化连接池
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    * 获取连接池对象
    * */
    public static DataSource getDataSource(){
        return dataSource;
    }
    /*
    * 获取链接Connection对象
    * */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
