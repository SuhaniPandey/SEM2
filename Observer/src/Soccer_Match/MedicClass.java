package Soccer_Match;

import java.beans.PropertyChangeEvent;

public class MedicClass
{
  public MedicClass(PropertyChangeSubject subject){
    subject.addPropertyChangeListener("DreamTeamRoughTackle",this::reactToDreamTeamRoughTackle);
    subject.addPropertyChangeListener("OldBoysRoughTackleRoughTackle",this::reactToOldBoysRoughTackle);

  }

  public void reactToDreamTeamRoughTackle(PropertyChangeEvent evt){
    System.out.println("Ohh ...medic takes dream team for recovery");
  }

  public void reactToOldBoysRoughTackle(PropertyChangeEvent evt){
    System.out.println("Ohh medic takes old boys team for recovery");
  }
}
