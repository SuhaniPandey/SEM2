package pieChart.core;

import pieChart.view.barChart.BarChartViewModel;
import pieChart.view.pieChart.PieChartViewModel;
import pieChart.view.textEditor.TextEditorViewModel;

public class ViewModelFactory {

    private PieChartViewModel pieChartViewModel;
    private TextEditorViewModel textEditorViewModel;
    private BarChartViewModel barChartViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        pieChartViewModel = new PieChartViewModel(modelFactory.getDataModel());
        textEditorViewModel= new TextEditorViewModel(modelFactory.getDataModel());
        barChartViewModel= new BarChartViewModel(modelFactory.getDataModel());
    }

    public PieChartViewModel getPieChartViewModel() {
        return pieChartViewModel;
    }

    public TextEditorViewModel getTextEditorViewModel()
    {
        return textEditorViewModel;

    }

    public BarChartViewModel getBarChartViewModel()
    {
        return barChartViewModel;
    }
}
