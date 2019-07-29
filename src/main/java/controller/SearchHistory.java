package controller;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class SearchHistory {

    @Id
    @GeneratedValue
    public long id;
    public long movie_id;
    public String movie_title;
    public long genre_id;
    public String username;

    public SearchHistory() {
    }

    public SearchHistory(long id, long movie_id, String movie_title, long genre_id, String username) {
        this.id = id;
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.genre_id = genre_id;
        this.username = username;
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

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(long genre_id) {
        this.genre_id = genre_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUser_id(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "SearchHistory{" +
                "id=" + id +
                ", movie_id=" + movie_id +
                ", movie_title='" + movie_title + '\'' +
                ", genre_id=" + genre_id +
                ", username=" + username +
                '}';
    }
}
