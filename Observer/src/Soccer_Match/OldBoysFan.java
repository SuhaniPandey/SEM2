package Soccer_Match;

import java.beans.PropertyChangeEvent;

public class OldBoysFan
{
  public OldBoysFan(PropertyChangeSubject subject){

    subject.addPropertyChangeListener("DreamTeamRoughTackle",this::reactToDreamTeamRoughTackle);
    subject.addPropertyChangeListener("DreamTeamScoreGoal",this::reactToDreamTeamScoreGoal);
    subject.addPropertyChangeListener("OldBoysRoughTackleRoughTackle",this::reactToOldBoysRoughTackle);
    subject.addPropertyChangeListener("OldBoysScoreGoal",this::reactToOldBoysTeamScoreGoal);

  }
  public void reactToDreamTeamScoreGoal(PropertyChangeEvent evt){
    System.out.println("OldBoys Fan: Ohh no..they scored");
  }
  public void reactToOldBoysTeamScoreGoal(PropertyChangeEvent evt){
    System.out.println("OldBoys Fan: Yaa..We scored");
  }

  public void reactToDreamTeamRoughTackle(PropertyChangeEvent evt){
    System.out.println("OldBoys Fan: What are they doing...");
  }

  public void reactToOldBoysRoughTackle(PropertyChangeEvent evt){
    System.out.println("OldBoys Fan: Ohh...Its rough tackle");
  }


}
