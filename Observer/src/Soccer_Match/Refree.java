package Soccer_Match;

import java.beans.PropertyChangeEvent;

public class Refree
{
  public Refree(PropertyChangeSubject subject){

    subject.addPropertyChangeListener("DreamTeamRoughTackle",this::reactToDreamTeamRoughTackle);
    subject.addPropertyChangeListener("OldBoysRoughTackleRoughTackle",this::reactToOldBoysRoughTackle);
  }

  public void reactToDreamTeamRoughTackle(PropertyChangeEvent evt){
    System.out.println("Refree: Gives dream team yellow card for rough tackle");
  }

  public void reactToOldBoysRoughTackle(PropertyChangeEvent evt){
    System.out.println("Refree gives Old boys yellow card for rough tackle");
  }
}
