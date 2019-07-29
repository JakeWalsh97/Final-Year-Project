package controller;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue
    public long id;
    public long movie_id;
    public String movie_name;
    public String username;
    public String reviewText;
    public Date reviewDate;

    public Review() {
    }

    public Review(long movie_id, String movie_name, String username, String reviewText, Date reviewDate) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.username = username;
        this.reviewText = reviewText;
        this.reviewDate = reviewDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", movie_id=" + movie_id +
                ", movie_name='" + movie_name + '\'' +
                ", username='" + username + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", reviewDate=" + reviewDate +
                '}';
    }
}
