package mxk.v1.controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import mxk.v1.model.loginViewModel;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-19.
 */
public class mainController implements Initializable {
    @FXML
    public Button exitbtn;

    @FXML
    Label lbltime;
    @FXML
    Pane mainPane;
    @FXML
    private Label username;
    @FXML
    private Label nim;
    @FXML
    private Button logoutbtn;

    public static loginViewModel mlm = null;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Task<Void> t = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
                while (true) {
                    String today = sdf.format(new Date());
                    updateMessage(today);
                    // lblTime 속성 변경
                    if (isCancelled()) break;
                    Thread.sleep(1000);
                }
                return null;
            }//call
        };

        lbltime.textProperty().bind(t.messageProperty());

        Thread task = new Thread(t);
        task.setDaemon(true);
        task.start();
    }

    public void g2c0(ActionEvent ae) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/center.fxml"));
        Parent root = loader.load();

        mainPane.getChildren().clear();
        mainPane.getChildren().add(root);

        centerController cCtr = loader.getController();
        cCtr.c0();
    }

    public void g2c1(ActionEvent ae) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/center.fxml"));
        Parent root = loader.load();

        mainPane.getChildren().clear();
        mainPane.getChildren().add(root);

        centerController cCtr = loader.getController();
        cCtr.c1();
    }

    public void g2c2(ActionEvent ae) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/center.fxml"));
        Parent root = loader.load();

        mainPane.getChildren().clear();
        mainPane.getChildren().add(root);

        centerController cCtr = loader.getController();
        cCtr.c2();
    }

    public void g2c3(ActionEvent ae) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/center.fxml"));
        Parent root = loader.load();

        mainPane.getChildren().clear();
        mainPane.getChildren().add(root);

        centerController cCtr = loader.getController();
        cCtr.c3();

    }

    public void g2r0(ActionEvent ae) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/rental.fxml"));
        Parent root = loader.load();

        mainPane.getChildren().clear();
        mainPane.getChildren().add(root);

        rentalController rCtr = loader.getController();
        rCtr.r0();
    }

    public void g2r1(ActionEvent ae) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/rental.fxml"));
        Parent root = loader.load();

        mainPane.getChildren().clear();
        mainPane.getChildren().add(root);

        rentalController rCtr = loader.getController();
        rCtr.r1();
    }

    public void g2k0(ActionEvent ae) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/kangseup.fxml"));
        Parent root = loader.load();

        mainPane.getChildren().clear();
        mainPane.getChildren().add(root);

        kangseupController kCtr = loader.getController();
        kCtr.k0();
    }

    public void g2k1(ActionEvent ae) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/kangseup.fxml"));
        Parent root = loader.load();

        mainPane.getChildren().clear();
        mainPane.getChildren().add(root);

        kangseupController kCtr = loader.getController();
        kCtr.k1();
    }

    public void g2m0(ActionEvent ae) throws Exception {

    }

    public void g2m1(ActionEvent ae) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/member.fxml"));
        Parent root = loader.load();

        mainPane.getChildren().clear();
        mainPane.getChildren().add(root);

        memberController mCtr = loader.getController();
        mCtr.m1();
    }

    public void g2m2(ActionEvent ae) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/member.fxml"));
        Parent root = loader.load();

        mainPane.getChildren().clear();
        mainPane.getChildren().add(root);

        memberController mCtr = loader.getController();
        mCtr.m2();
    }

    public void g2h0(ActionEvent ae) {
        helpController hc = new helpController();
        hc.g2h0();
    }

    public void g2h1(ActionEvent ae) {
        helpController hc = new helpController();
        hc.g2h1();
    }

    public void g2h2(ActionEvent ae) {
        helpController hc = new helpController();
        hc.g2h2();
    }

    public void exitApp(ActionEvent ae) {
        //exitbtn.setOnAction(event -> closeApp(event));
        closeApp(ae);
    }

    public void closeApp(Event event) {
        Alert warn = new Alert(Alert.AlertType.CONFIRMATION);
        warn.setTitle(":: 프로그램을 종료합니다 ::");
        //warn.getIcons().add(new Image("mxk/img/tlogofinal.png"));
        warn.setHeaderText(null);
        warn.setContentText("정말 종료하시겠습니까?");

        ButtonType okbtn = new ButtonType("종 료", ButtonBar.ButtonData.OK_DONE);
        ButtonType nobtn = new ButtonType("취 소", ButtonBar.ButtonData.CANCEL_CLOSE);
        warn.getButtonTypes().setAll(okbtn, nobtn);

        Optional<ButtonType> result = warn.showAndWait();
        if (result.get() == okbtn) Platform.exit();
        else event.consume();
    }

    public void closeApp2(Event event) {
        Alert warn = new Alert(Alert.AlertType.CONFIRMATION);
        warn.setTitle(":: 프로그램을 종료합니다 ::");
        //warn.getIcons().add(new Image("mxk/img/tlogofinal.png"));
        warn.setHeaderText(null);
        warn.setContentText("로그인 혹은 회원가입 후 로그인을 하셔야 이용 가능합니다.\n" +
                "프로그램을 종료하시겠습니까?");

        ButtonType okbtn = new ButtonType("종 료", ButtonBar.ButtonData.OK_DONE);
        ButtonType nobtn = new ButtonType("취 소", ButtonBar.ButtonData.CANCEL_CLOSE);
        warn.getButtonTypes().setAll(okbtn, nobtn);

        Optional<ButtonType> result = warn.showAndWait();
        if (result.get() == okbtn) Platform.exit();
        else event.consume();
    }


    //로그인시 넘기는 정보들
    public Label getUsername() {
        return username;
    }
    public Label getNim() {
        return nim;
    }
    public Button getLogoutbtn() {
        return logoutbtn;
    }

    public void g2m2(Pane aaaa) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/member.fxml"));
        Parent root = loader.load();

        aaaa.getChildren().clear();
        aaaa.getChildren().add(root);

        memberController mCtr = loader.getController();
        mCtr.m2();

    }


}