package controller;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Query {

    @Id
    @GeneratedValue
    public long id;
    public String username;
    public String queryTitle;
    public String queryText;
    public Date queryDate;
    public String responseText;

    public Query() {
    }

    public Query(long id, String username, String queryTitle, String queryText, Date queryDate, String responseText) {
        this.id = id;
        this.username = username;
        this.queryTitle = queryTitle;
        this.queryText = queryText;
        this.queryDate = queryDate;
        this.responseText = responseText;
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

    public String getQueryTitle(){
        return queryTitle;
    }

    public void setQueryTitle(String queryTitle){
        this.queryTitle = queryTitle;
    }

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public Date getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(Date queryDate) {
        this.queryDate = queryDate;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    @Override
    public String toString() {
        return "Query{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", queryTitle='" + queryTitle + '\'' +
                ", queryText='" + queryText + '\'' +
                ", queryDate=" + queryDate +
                ", responseText='" + responseText + '\'' +
                '}';
    }
}
