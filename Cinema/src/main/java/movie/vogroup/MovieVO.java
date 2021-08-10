package movie.vogroup;

import java.io.Serializable;
import java.sql.Date;

public class MovieVO implements Serializable {
	
	private String movie_num;
	private String movie_name;
	private String movie_genre;
	private Date movie_premier;
	private String movie_director;
	private String movie_actor;
	private String movie_class;
	private String movie_poster;
	private String movie_url;
	private String movie_con;
	
	public MovieVO() {
		
	}
	
	public MovieVO(String movie_num, String movie_name, String movie_genre, Date movie_premier, String movie_director,
			String movie_actor, String movie_class, String movie_poster, String movie_url,
			String movie_con) {
		super();
		this.movie_num = movie_num;
		this.movie_name = movie_name;
		this.movie_genre = movie_genre;
		this.movie_premier = movie_premier;
		this.movie_director = movie_director;
		this.movie_actor = movie_actor;
		this.movie_class = movie_class;
		this.movie_poster = movie_poster;
		this.movie_url = movie_url;
		this.movie_con = movie_con;
	}
	
	
	public String getMovie_num() {
		return movie_num;
	}

	public void setMovie_num(String movie_num) {
		this.movie_num = movie_num;
	}

	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getMovie_genre() {
		return movie_genre;
	}
	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}
	public Date getMovie_premier() {
		return movie_premier;
	}
	public void setMovie_premier(Date movie_premier) {
		this.movie_premier = movie_premier;
	}
	public String getMovie_director() {
		return movie_director;
	}
	public void setMovie_director(String movie_director) {
		this.movie_director = movie_director;
	}
	public String getMovie_actor() {
		return movie_actor;
	}
	public void setMovie_actor(String movie_actor) {
		this.movie_actor = movie_actor;
	}
	public String getMovie_class() {
		return movie_class;
	}
	public void setMovie_class(String movie_class) {
		this.movie_class = movie_class;
	}
	public String getMovie_poster() {
		return movie_poster;
	}
	public void setMovie_poster(String movie_poster) {
		this.movie_poster = movie_poster;
	}
	public String getMovie_url() {
		return movie_url;
	}
	public void setMovie_url(String movie_url) {
		this.movie_url = movie_url;
	}
	public String getMovie_con() {
		return movie_con;
	}
	public void setMovie_con(String movie_con) {
		this.movie_con = movie_con;
	}
	
	
}
