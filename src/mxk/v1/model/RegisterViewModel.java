package mxk.v1.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by java on 2016-09-21.
 */
public class RegisterViewModel {
    private SimpleStringProperty lesson;
    private SimpleStringProperty term;
    private SimpleStringProperty rpay;
    private SimpleStringProperty username;
    private SimpleStringProperty lrdate;
    private SimpleStringProperty edit;

    public RegisterViewModel(String lesson, String term, String rpay, String username, String lrdate, String edit) {
        this.lesson =new SimpleStringProperty(lesson);
        this.term = new SimpleStringProperty(term);
        this.rpay = new SimpleStringProperty(rpay);
        this.username = new SimpleStringProperty(username);
        this.lrdate = new SimpleStringProperty(lrdate);
        this.edit = new SimpleStringProperty(edit);
    }

    public String getLesson() {
        return lesson.get();
    }

    public SimpleStringProperty lessonProperty() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson.set(lesson);
    }

    public String getTerm() {
        return term.get();
    }

    public SimpleStringProperty termProperty() {
        return term;
    }

    public void setTerm(String term) {
        this.term.set(term);
    }

    public String getRpay() {
        return rpay.get();
    }

    public SimpleStringProperty rpayProperty() {
        return rpay;
    }

    public void setRpay(String rpay) {
        this.rpay.set(rpay);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getLrdate() {
        return lrdate.get();
    }

    public SimpleStringProperty lrdateProperty() {
        return lrdate;
    }

    public void setLrdate(String lrdate) {
        this.lrdate.set(lrdate);
    }

    public String getEdit() {
        return edit.get();
    }

    public SimpleStringProperty editProperty() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit.set(edit);
    }
}
