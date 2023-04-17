package bo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
//import javax.persistence.CollectionTable;
import javax.persistence.Column;
//import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name = "Team")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String teamId;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="id.player")
	@Fetch(FetchMode.JOIN)
	Set<PlayerSeason> seasons = new HashSet<PlayerSeason>();
	
	@Column
	String name;
	@Column
	String league;
	@Column
	Integer yearFounded;
	@Column
	Integer yearLast;
	

	public void addSeason(PlayerSeason s) {
		seasons.add(s);
	}

	public Set<PlayerSeason> getSeasons() {
		return seasons;
	}
	
	public PlayerSeason getSeason(int year) {
		for (PlayerSeason ps: seasons) {
			if (ps.getYear().equals(year)) return ps;
		}
		return null;
	}
	
	public void setSeasons(Set<PlayerSeason> seasons) {
		this.seasons = seasons;
	}
	
	public String getId() {
		return teamId;
	}
	public void setId(String id) {
		this.teamId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public String getLeague(){
        return league;
    }

    public void setLeage(String league){

        this.league = league;
    }

    public Integer getYearFounded(){

        return yearFounded;
    }
    
    public void setYearFounded(Integer d){

        this.yearFounded = d;
    }

    public Integer getYearLast(){

        return yearLast;
    }
    
    public void setYearLast(Integer d){

        this.yearLast = d;
    }

    
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Team)){
			return false;
		}
		Team other = (Team) obj;
		return (this.getName().equalsIgnoreCase(other.getName()) &&
				this.getLeague()==other.getLeague() &&
				this.getYearFounded()==other.getYearFounded());
	}
	 
	@Override
	public int hashCode() {
		Integer hash = 0;
		if (this.getName()!=null) hash += this.getName().hashCode(); 
		if (this.getLeague()!=null) hash += this.getLeague().hashCode();
		if (this.getYearFounded()!=null) hash += this.getYearFounded().hashCode();
		return hash;
	}
	
	
}
