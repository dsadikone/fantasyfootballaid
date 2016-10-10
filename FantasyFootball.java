/**
 *
 * @author CJ
 */

import java.io.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FantasyFootball extends Application {
    private TableView<Stats> table;

    public void start(Stage primaryStage) {
        table = new TableView();
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Table View Sample");
        primaryStage.setWidth(1100);
        primaryStage.setHeight(500);

        final Label label = new Label("Stats");
        label.setFont(new Font("Arial", 20));

        table.setEditable(false);

        // Creating columns
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(100);
        TableColumn teamCol = new TableColumn("Team");
        teamCol.setMinWidth(100);
        TableColumn yardsCol = new TableColumn("Yards");
        yardsCol.setMinWidth(100);
        TableColumn tdsCol = new TableColumn("Tds");
        tdsCol.setMinWidth(100);
        TableColumn gamesPlayedCol = new TableColumn("Games Played");
        gamesPlayedCol.setMinWidth(100);
        TableColumn receptionsCol = new TableColumn("Receptions");
        receptionsCol.setMinWidth(100);
        TableColumn targetsCol = new TableColumn("Targets");
        targetsCol.setMinWidth(100);
        TableColumn receptionsPerGameCol = new TableColumn("Receptions Per Game");
        receptionsPerGameCol.setMinWidth(100);
        TableColumn yardsPerGameCol = new TableColumn("Yards Per Game");
        yardsPerGameCol.setMinWidth(100);
        TableColumn yardsPerReceptionCol = new TableColumn("Yards Per Reception");
        yardsPerReceptionCol.setMinWidth(100);
        TableColumn yardsPerTargetCol = new TableColumn("Yards Per Target");
        yardsPerTargetCol.setMinWidth(100);


        // Adding all the columns
        table.getColumns().addAll(nameCol, teamCol, yardsCol, tdsCol, gamesPlayedCol,
                receptionsCol, targetsCol, receptionsPerGameCol, yardsPerGameCol,
                yardsPerReceptionCol, yardsPerTargetCol);


        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws FileNotFoundException {
        launch(args);

        Stats stats = new Stats();
        stats.readStats("WRs.csv");
        stats.readStats("QBs.csv");
        stats.readStats("RBs.csv");
        stats.printStats();
    }
}
