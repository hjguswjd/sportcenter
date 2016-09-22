package mxk.v1.dao;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-20.
 */
public class rentalDAO implements Initializable {

    // 데이터 접속정보
    private static String DRV = "oracle.jdbc.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@//192.168.93.128:1521/xe";
    private static String USR = "MIN";
    private static String PWD = "123";


    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {

    }
}
