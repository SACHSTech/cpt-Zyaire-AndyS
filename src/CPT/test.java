package CPT;

public static Parent lineChart(String country, Stage primaryStage) {
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    LineChart<String, Long> chart = new LineChart(xAxis, yAxis);
    ArrayList<Country> cData = Methods.listByCountry(country);
    Country c;

    chart.setTitle("country");
    xAxis.setLabel("Year");
    yAxis.setLabel("Population");

    XYChart.Series <String, Long> data = new XYChart.Series <String, Long>();
    data.setName(country);

    for (int intCount = 0; intCount < cData.size(); intCount ++) {
        c = cData.get(intCount);
        data.getData().add(new XYChart.Data <String, Long> (c.getYear(), Long.parseLong(c.getPopulation())));
    }

    chart.getData().add(data);

    Button back = new Button("Back to Menu");
    back.setOnAction(e -> primaryStage.setScene(new Scene(mainMenu(primaryStage), 300, 250)));

    Button Settings = new Button("Settings");
    Settings.setOnAction(e -> primaryStage.setScene(new Scene(lineSettings(primaryStage), 300, 250)));

    VBox box = new VBox();
    box.getChildren().addAll(chart, Settings, back);

    return box;
}