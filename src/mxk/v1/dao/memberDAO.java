package mxk.v1.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mxk.v1.model.memberModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class memberDAO {
    private static String DRV = "oracle.jdbc.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@//192.168.93.128:1521/xe";
    private static String USR = "MIN";
    private static String PWD = "123";

    private static String cLmm = "select * from member where userid=?";
    private static String cLpm = "select*from prent where mno = (select mno from member where userid=?)";
    private static String cLrm = "select*from register where mno = (select mno from member where userid=?)";
    private static  String newMember  = "insert into member(mno, userid,passwd,username,bday,gender,addr,tel,email,ldate)"
                                    + "VALUES(sq_mno.nextval, ?,?,?,?,?,?,?,?,?)"; // 저장하기

    private static String zipsql = "select DISTINCT zipcode, do, gun, myeon, gil, ri from zipcode where myeon = ?";

    private static String select = "select userid, passwd,username,bday,gender,addr,tel,email from member where ";

    private static ObservableList ziplist;

    public static Connection openConn () {
        Connection conn = null;
        try {
            Class.forName(DRV);
            conn = DriverManager.getConnection(URL, USR, PWD);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return conn;
    } // openConn

    public static void closeConn(Connection c, PreparedStatement p , ResultSet r){
        if (r != null) try { r.close(); r=null; }catch (Exception e){}
        if (p != null) try { p.close(); p=null; }catch (Exception e){}
        if (c != null) try { c.close(); c=null; }catch (Exception e){}
    } // closeConn

    public static ObservableList showzipcode(String myeon) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuilder sb = null;
        ziplist = null;

        try {
            conn = openConn();
            pstmt = conn.prepareStatement(zipsql);
            pstmt.setString(1, myeon);
            rs = pstmt.executeQuery();

            ziplist = FXCollections.observableArrayList();

            while (rs.next()) {
                sb = new StringBuilder();
                sb.append(rs.getString(1))
                .append(rs.getString(2)).append(" ")
                .append(rs.getString(3)).append(" ")
                .append(rs.getString(4)).append(" ")
                .append(rs.getString(5)).append(" ")
                .append(rs.getString(6)).append(" ");
                ziplist.add(sb.toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
           closeConn(conn, pstmt, rs);
        }
        return ziplist;
    } // showzipcode

    public static void savedb(memberModel md) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = openConn();
            pstmt = conn.prepareStatement(newMember);
                pstmt.setString(1, md.getId());
                pstmt.setString(2, md.getPw());
                pstmt.setString(3, md.getName());
                pstmt.setString(4, md.getBday());
                pstmt.setString(5, md.getGender());
                pstmt.setString(6, md.getAddr1()+"-"+md.getAddr2()+" "+md.getAddr3()+" "+md.getAddr4());
                pstmt.setString(7, md.getTel());
                pstmt.setString(8, md.getEmail());
                pstmt.setString(9, md.getLdate());

            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConn(conn, pstmt, null);
        } // try-catch
    } // savedb


 /*   //회원대관정보 생성
    public static List<loginPrentModel> createlpm(String uid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<loginPrentModel> result = new ArrayList<>();


        try {
            conn = openConn();
            pstmt = conn.prepareStatement(cLpm);
            pstmt.setString(1,uid);
            rs = pstmt.executeQuery();

            if(rs.next()){
                loginPrentModel lm = new loginPrentModel(
                        rs.getString("prno"),
                        rs.getString("mno"),
                        rs.getString("pdate"),
                        rs.getString("tdate"),
                        rs.getString("prime"),
                        rs.getString("ring"));

                result.add(lm);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConn(conn, pstmt,rs);
        }

        return result;
    }
    //회원강습정보 생성
    public static List<loginRegisterModel> createlrm(String uid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<loginRegisterModel> result = new ArrayList<>();

        try {
            conn = openConn();
            pstmt = conn.prepareStatement(cLrm);
            pstmt.setString(1,uid);
            rs = pstmt.executeQuery();

            while (rs.next()){
                loginRegisterModel lm = new loginRegisterModel(
                        rs.getString("rno"),
                        rs.getString("mno"),
                        rs.getString("lesson"),
                        rs.getString("rldate"),
                        rs.getString("rtdate"),
                        rs.getString("rting"));

                result.add(lm);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConn(conn, pstmt,rs);
        }

        return result;
    }*/








} // class