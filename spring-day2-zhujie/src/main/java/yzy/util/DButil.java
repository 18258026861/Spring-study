package yzy.util;

import yzy.entity.Account;

import java.sql.*;

public class DButil {

    public static int updateResult = -1;//执行语句的结果，不成功为-1
    public static ResultSet resultSet = null;
    public static PreparedStatement preparedStatement = null;
    public static Connection connection = null;
    public static boolean flag = false;
    Account account = new Account();


    //数据库连接,通过连接池进行连接
    public static Connection connection() {
        Connection conn = null; // 创建一个connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mobileshop?" +
                    "user=root&password=yzy665128&characterEncoding=gb2312";
            //建立连接
            conn = DriverManager.getConnection(url);

            /*Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/student");
            //建立连接
            conn = ds.getConnection();*/

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;

    }
    public static PreparedStatement preparedStatement(String sql,Object[] obj) throws SQLException {

        PreparedStatement  preparedStatement = connection().prepareStatement(sql);
        if(obj!=null){
            for (int i = 0; i <obj.length ; i++) {
                preparedStatement.setObject(i+1,obj[i]);
            }
        }

        return preparedStatement;
    }

    //通用的数据库增删改
    public static boolean executeUpdate(String sql,Object[] obj)  {
        try {
            updateResult = preparedStatement(sql,obj).executeUpdate();
            if (updateResult>0) {
                flag = true;
            } else {
                flag = false;
            }
        }  catch (SQLException e) {
            System.out.println();
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeAll(resultSet,preparedStatement,connection);
        }
        return flag;
    }

    //查询
    public  static ResultSet executeQuery(String sql,Object[] obj)  {
        try {
            resultSet = preparedStatement(sql,obj).executeQuery();
            return  resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }//不要关闭，如果关闭就无法查询了
        /*finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }*/
    }



    /*public static void close(AutoCloseable closeable){
        if(closeable !=null){
            try{
                closeable.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }*/

    public static void closeAll(ResultSet resultSet,Statement statement,Connection connection){
        try{
            if(resultSet!=null)resultSet.close();
            if(statement!=null)statement.close();
            if(connection!=null)connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
