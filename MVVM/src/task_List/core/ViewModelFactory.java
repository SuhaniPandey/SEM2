package task_List.core;

import task_List.view.add.AddTaskViewModel;
import task_List.view.all.NextTaskViewModel;
import task_List.view.remove.AllTasksViewModel;

public class ViewModelFactory
{
  private AddTaskViewModel addTaskViewModel;
  private AllTasksViewModel allTasksViewModel;
  private NextTaskViewModel nextTaskViewModel;
  private ModelFactory modelFactory;

  public ViewModelFactory(ModelFactory modelFactory){
    this.modelFactory=modelFactory;
  }

  public AddTaskViewModel getAddTaskViewModel()
  {
    if (addTaskViewModel== null){
      addTaskViewModel= new AddTaskViewModel(modelFactory.getTaskModelManager());
    }
    return addTaskViewModel;
  }

  public AllTasksViewModel getAllTasksViewModel()
  {
    if (allTasksViewModel== null){
      allTasksViewModel= new AllTasksViewModel(modelFactory.getTaskModelManager());
    }
    return allTasksViewModel;
  }

  public NextTaskViewModel getNextTaskViewModel()
  {
    if (nextTaskViewModel== null){
      nextTaskViewModel= new NextTaskViewModel(
          modelFactory.getTaskModelManager());
    }
    return nextTaskViewModel;
  }
}
