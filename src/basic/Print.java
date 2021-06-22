package basic;
public class Print{
    public static void main(String[] args) {
        Sort_Search.Everything();
       /*  public Parent BarChartSettings(Stage primaryStage) {
            VBox layout = new VBox();
            ArrayList<Pervalence> list = Sort_Search.getList();
            String country;
              String prevC = "";
              Pervalence pervalence;
              ChoiceBox<Pervalence> c1 = new ChoiceBox <Pervalence>();
              c1.setMaxSize(140, ChoiceBox.USE_COMPUTED_SIZE);
      
              ChoiceBox<Pervalence> c2 = new ChoiceBox <Pervalence>();
              c2.setMaxSize(140, ChoiceBox.USE_COMPUTED_SIZE);
      
              ChoiceBox<Pervalence> c3 = new ChoiceBox <Pervalence>();
              c3.setMaxSize(140, ChoiceBox.USE_COMPUTED_SIZE);
      
              TextField startY = new TextField("What year?");
              startY.setMaxSize(140, TextField.USE_COMPUTED_SIZE);
      
              TextField endY = new TextField("Which disorder?");
              endY.setMaxSize(140, TextField.USE_COMPUTED_SIZE);
      
              Button create = new Button("Create!");
              Label settingLabel = new Label("BarChart Settings");
      
              for (int intCount = 0; intCount < list.size(); intCount++) {
                pervalence = list.get(intCount);
                country = pervalence.getCountry();
      
                  if (!country.equals(prevC)) {
                      c1.getItems().add(pervalence);
                      c2.getItems().add(pervalence);
                      c3.getItems().add(pervalence);
                  }
      
                  prevC = country;
              }
      
              create.setOnAction(e -> primaryStage.setScene(new Scene(createBarChart(startY.getText(), Year.getText(),
                      c1.getValue(), c2.getValue(), c3.getValue(), primaryStage))));
      
              Button back = new Button("Back to Menu");
              back.setOnAction(e -> primaryStage.setScene(new Scene(mainMenu(primaryStage), 300, 250)));
      
              layout.getChildren().addAll(settingLabel, c1, c2, c3, startY, endY, create, back);
              layout.setAlignment(Pos.CENTER);
      
              return layout; */
    }
}