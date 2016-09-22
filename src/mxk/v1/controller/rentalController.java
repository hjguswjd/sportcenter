package mxk.v1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-19.
 */
public class rentalController implements Initializable{

    @FXML TabPane rentalTab;
    @FXML Button nextbtn;
    @FXML Button nextbtn2;
    @FXML public AnchorPane apg;
    @FXML public AnchorPane rpg;
    @FXML public AnchorPane crpg;
    @FXML private TextField userid;
    @FXML private TextField username;
    @FXML private TextField addr;
    @FXML private TextField tel;
    @FXML private TextField userid2;
    @FXML private TextField username2;
    @FXML private TextField addr2;
    @FXML private TextField tel2;

    public int checkAgree;
    public int checkAgree2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        checkAgree = 0;
        checkAgree2 = 0;
    }

    public void r0() throws Exception{
        SingleSelectionModel<Tab> sm = rentalTab.getSelectionModel();
        sm.select(0);
    }

    public void r1() throws Exception{
        SingleSelectionModel<Tab> sm = rentalTab.getSelectionModel();
        sm.select(1);
    }

    public void showbtn(ActionEvent event) {
        if (checkAgree == 1) {
            nextbtn.setDisable(true);
            checkAgree = 0;
        } else {
            nextbtn.setDisable(false);
            checkAgree = 1;
        }
    }

    public void g2rpg(ActionEvent event) {
        apg.setVisible(false);
        rpg.setVisible(true);
        crpg.setVisible(false);

        userid.setText(mainController.mlm.getUserid());
        username.setText(mainController.mlm.getUsername());
        addr.setText(mainController.mlm.getAddr());
        tel.setText(mainController.mlm.getTel());
    }

    public void showbtn2(ActionEvent event) {
        if (checkAgree2 == 1) {
            nextbtn2.setDisable(true);
            checkAgree2 = 0;
        } else {
            nextbtn2.setDisable(false);
            checkAgree2 = 1;
        }
    }

    public void g2crpg(ActionEvent event) {
        apg.setVisible(false);
        rpg.setVisible(false);
        crpg.setVisible(true);

        userid2.setText(mainController.mlm.getUserid());
        username2.setText(mainController.mlm.getUsername());
        addr2.setText(mainController.mlm.getAddr());
        tel2.setText(mainController.mlm.getTel());
    }


}
