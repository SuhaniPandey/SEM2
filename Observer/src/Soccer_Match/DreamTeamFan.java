package Soccer_Match;

import java.beans.PropertyChangeEvent;

public class DreamTeamFan
{

  public DreamTeamFan(PropertyChangeSubject subject){
     subject.addPropertyChangeListener("DreamTeamRoughTackle",this::reactToDreamTeamRoughTackle);
     subject.addPropertyChangeListener("DreamTeamScoreGoal",this::reactToDreamTeamScoreGoal);
     subject.addPropertyChangeListener("OldBoysRoughTackleRoughTackle",this::reactToOldBoysRoughTackle);
     subject.addPropertyChangeListener("OldBoysScoreGoal",this::reactToOldBoysTeamScoreGoal);
  }

  public void reactToDreamTeamScoreGoal(PropertyChangeEvent evt){
    System.out.println("Dream Team Fan: Yaa we scored");
  }
  public void reactToOldBoysTeamScoreGoal(PropertyChangeEvent evt){
    System.out.println("Dream Team Fan: Ohh Noo");
  }

  public void reactToDreamTeamRoughTackle(PropertyChangeEvent evt){
    System.out.println("Dream Team Fan: Ohh...Its rough tackle");
  }

  public void reactToOldBoysRoughTackle(PropertyChangeEvent evt){
    System.out.println("Dream Team Fan: What are they doing...");
  }
}
