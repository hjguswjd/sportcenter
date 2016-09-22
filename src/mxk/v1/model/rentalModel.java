package mxk.v1.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by java on 2016-09-20.
 */
public class rentalModel {

    private SimpleStringProperty userid;
    private SimpleStringProperty username;
    private SimpleStringProperty addr;
    private SimpleStringProperty tel;

    public rentalModel(String userid, String username, String addr, String tel) {
        this.userid = new SimpleStringProperty(userid);
        this.username = new SimpleStringProperty(username);
        this.addr = new SimpleStringProperty(addr);
        this.tel = new SimpleStringProperty(tel);
    }

    public String getUserid() {
        return userid.get();
    }

    public void setUserid(String userid) {
        this.userid.set(userid);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getAddr() {
        return addr.get();
    }

    public void setAddr(String addr) {
        this.addr.set(addr);
    }

    public String getTel() {
        return tel.get();
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }
}
