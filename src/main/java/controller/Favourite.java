package controller;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Favourite {

    @Id
    @GeneratedValue
    public long id;
    public String username;
    public long movie_id;
    public String title;
    public String poster_path;
    public Date release_date;

    public Favourite() {
    }

    public Favourite(long id, String username, long movie_id, String title, String poster_path, Date release_date) {
        this.id = id;
        this.username = username;
        this.movie_id = movie_id;
        this.title = title;
        this.poster_path = poster_path;
        this.release_date = release_date;
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

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    @Override
    public String toString() {
        return "Favourite{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", movie_id=" + movie_id +
                ", title='" + title + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", release_date=" + release_date +
                '}';
    }
}
