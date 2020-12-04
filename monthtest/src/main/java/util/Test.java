package util;

import java.sql.Connection;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/11/30 14:38
 * @Version: V1.0
 */
public class Test {


    public static void main(String[] args) {
        BaseDao dao = new BaseDao();

        Connection con = dao.getConnection();

        System.out.println(con);
    }
}