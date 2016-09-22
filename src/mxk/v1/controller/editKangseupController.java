package mxk.v1.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mxk.v1.dao.kangseupDAO;
import mxk.v1.dao.memberDAO;
import mxk.v1.model.kReservationModel;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by java on 2016-09-22.
 */
public class editKangseupController implements Initializable {
    @FXML public Pane editpane;
    @FXML
    public ComboBox selt1;
    @FXML
    public ComboBox selt2;
    @FXML
    public ComboBox selt3;
    @FXML
    public TextField payText;


    @FXML public TextField userId;
    @FXML public TextField userName;
    @FXML public TextField addr;
    @FXML public TextField tel;


    //콤보박스에 들어갈 아이템들을 저장할 변수
    private String[] kangseup = new String[2];
    private String[] program = new String[3];
    private String[] term = new String[3];
    private String apay;
    private String rsl;
    private String as;

    private /*static*/ String rno;
    private ObservableList<kReservationModel> krmList = null;
    private int num = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        kangseup[0] = "수영";
        kangseup[1] = "테니스";

        program[0] = "어린이반";
        program[1] = "성인반";
        program[2] = "직장인반";

        term[0] = "10월(1일~31일)";
        term[1] = "11월(1일~30일)";
        term[2] = "12월(1일~31일)";


        ObservableList k1 = FXCollections.observableArrayList(kangseup);
        ObservableList k2 = FXCollections.observableArrayList(program);
        ObservableList k3 = FXCollections.observableArrayList(term);

        selt1.setItems(k1);
        selt2.setItems(k2);
        selt3.setItems(k3);

        userId.setText(mainController.mlm.getUserid());
        userName.setText(mainController.mlm.getUsername());
        addr.setText(mainController.mlm.getAddr());
        tel.setText(mainController.mlm.getTel());


    }

    public void kStep1(Event event) {
        if (selt1.getSelectionModel().getSelectedItem() != null) {
            selt2.setDisable(false);
        }

    }

    public void kStep2(Event event) {
        if (selt2.getSelectionModel().getSelectedItem() != null) {
            selt3.setDisable(false);
            rsl = selt1.getSelectionModel().getSelectedItem() + "-" + selt2.getSelectionModel().getSelectedItem();
            kangseupDAO kd = new kangseupDAO();
            apay = String.valueOf(kd.payCk(rsl));
        }

    }

    public void kStep3(Event event) {
        if (selt3.getSelectionModel().getSelectedItem() != null) {
            payText.setText(apay);
            as = selt3.getSelectionModel().getSelectedItem() + " ";
        }
    }

    public void  sendData(String rno,ObservableList<kReservationModel> krmList, int num) {
        this.rno = rno;
        this.krmList = krmList;
        System.out.println("b:"+this.rno);
        addr.setText(rno);
    }


    public void update(ActionEvent actionEvent) {

        kangseupDAO kd = new kangseupDAO();
        kd.updateKS(rsl,as, this.rno);
        System.out.println(rsl+"/"+as+"/"+rno);

        Stage stage = (Stage)editpane.getScene().getWindow();
        stage.close();
    }

    public void delete(ActionEvent actionEvent) {

    }






}
