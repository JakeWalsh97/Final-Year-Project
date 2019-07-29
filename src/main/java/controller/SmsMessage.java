package controller;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class SmsMessage {

    @Id
    @GeneratedValue
    public long id;
    public String username;
    public long phoneNumber;
    public String message;
    public Date textDate;

    public SmsMessage() {
    }

    public SmsMessage(long id, String username, long phoneNumber, String message, Date textDate) {
        this.id = id;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.message = message;
        this.textDate = textDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTextDate() {
        return textDate;
    }

    public void setTextDate(Date textDate) {
        this.textDate = textDate;
    }

    @Override
    public String toString() {
        return "SmsMessage{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", message='" + message + '\'' +
                ", textDate=" + textDate +
                '}';
    }
}
