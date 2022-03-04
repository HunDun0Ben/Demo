package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBatisTest {
    
    private static final Logger log = LoggerFactory.getLogger(MyBatisTest.class);

    public MyBatisTest() {
    }

    public static void main(String[] args) throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Map> list = sqlSession.selectList("selectUserinfo");
        log.info(list.toString());
    }
}