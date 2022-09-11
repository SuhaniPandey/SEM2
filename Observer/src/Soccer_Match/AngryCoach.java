package Soccer_Match;

import java.beans.PropertyChangeEvent;

public class AngryCoach
{
  public AngryCoach(PropertyChangeSubject subject){
    subject.addPropertyChangeListener("OldBoysScoreGoal",this::reactToOldBoysTeamScoreGoal);
    subject.addPropertyChangeListener("DreamTeamScoreGoal",this::reactToDreamTeamScoreGoal);
  }


  public void reactToDreamTeamScoreGoal(PropertyChangeEvent evt){
    System.out.println("Dream Team Coach: Yaa we scored\n Old boys team:hey  what are you guys doing...");
  }
  public void reactToOldBoysTeamScoreGoal(PropertyChangeEvent evt){
    System.out.println("Dream Team Coach: Ohh Noo\n Old Boys Coach: Yaa we scored...");
  }
}
