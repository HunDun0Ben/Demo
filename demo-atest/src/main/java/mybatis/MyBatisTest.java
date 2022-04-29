package mybatis;

import mybatis.entity.Userinfo;
import mybatis.mapper.UserinfoMapper;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    
    private static final Logger log = LoggerFactory.getLogger(MyBatisTest.class);

    public MyBatisTest() {
    }

    public static void main(String[] args) throws IOException {
        SqlSessionFactory xfactory = buildFactoryByXML();
        SqlSession xsqlSession = xfactory.openSession();
        Userinfo userinfo = xsqlSession.selectOne("getById", "1");
        log.info("XML get result = {}", userinfo.toString());

        SqlSessionFactory jfactory = buildFactoryByJava();
        SqlSession jsession = jfactory.openSession();
        List<Map> jlist = jsession.selectList("selectUserinfo");
        log.info("Java get result = {}", jlist.toString());
    }

    public static SqlSessionFactory buildFactoryByXML() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        return sqlSessionFactory;
    }

    public static SqlSessionFactory buildFactoryByJava() {
        String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
        String username = "root";
        String pwd = "root";
        DataSource dataSource = new UnpooledDataSource("com.mysql.cj.jdbc.Driver", url, username, pwd);
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UserinfoMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }
}