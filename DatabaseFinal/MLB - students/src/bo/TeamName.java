package bo;

public class TeamName {
    
    public TeamName(String n, String t, Integer y){
        name = n;
        teamID = t;
        year = y;
    }
    String name;
    String teamID;
    Integer year;

    public String getName(){
        return this.name;
    }
    public String getTeamId(){
        return this.teamID;
    }
    public Integer getYear(){
        return this.year;
    }
}


