package upperCase.core;

import upperCase.view.UppercaseViewModel;

public class ViewModelFactory
{
  private final ModelFactory modelFactory;
  private UppercaseViewModel uppercaseVM;

  public ViewModelFactory(ModelFactory modelFactory){
  this.modelFactory= modelFactory;
  }

  public UppercaseViewModel getUppercaseVM()
  {
    if (uppercaseVM == null){
      UppercaseViewModel uppercaseVM = new UppercaseViewModel(modelFactory.getTextConverter());
    return uppercaseVM;
  }
   return null;
  }

}
