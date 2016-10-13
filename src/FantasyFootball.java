/**
 *
 * @author CJ
 */

import java.io.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FantasyFootball extends Application {
    private TableView table;

    public void start(Stage primaryStage) throws FileNotFoundException {
        table = new TableView();
        Stats stats = new Stats();
        stats.readStats("WRs.csv");
        stats.readStats("QBs.csv");
        stats.readStats("RBs.csv");

        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Table View Sample");
        primaryStage.setWidth(1250);
        primaryStage.setHeight(500);

        final Label label = new Label("Stats");
        label.setFont(new Font("Arial", 20));

        table.setEditable(false);

        // Creating columns for WR stats
        TableColumn<WR, String> nameCol = new TableColumn("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<WR, String> teamCol = new TableColumn("Team");
        teamCol.setMinWidth(100);
        teamCol.setCellValueFactory(new PropertyValueFactory<>("team"));

        TableColumn<WR, Integer> yardsCol = new TableColumn("Yards");
        yardsCol.setMinWidth(100);
        yardsCol.setCellValueFactory(new PropertyValueFactory<>("yards"));

        TableColumn<WR, Integer>  tdsCol = new TableColumn("Tds");
        tdsCol.setMinWidth(100);
        tdsCol.setCellValueFactory(new PropertyValueFactory<>("tds"));

        TableColumn<WR, Integer>  gamesPlayedCol = new TableColumn("Games Played");
        gamesPlayedCol.setMinWidth(100);
        gamesPlayedCol.setCellValueFactory(new PropertyValueFactory<>("gamesPlayed"));

        TableColumn<WR, Integer>  receptionsCol = new TableColumn("Receptions");
        receptionsCol.setMinWidth(100);
        receptionsCol.setCellValueFactory(new PropertyValueFactory<>("receptions"));

        TableColumn<WR, Integer>  targetsCol = new TableColumn("Targets");
        targetsCol.setMinWidth(100);
        targetsCol.setCellValueFactory(new PropertyValueFactory<>("targets"));

        TableColumn<WR, Integer>  receptionsPerGameCol = new TableColumn("Receptions Per Game");
        receptionsPerGameCol.setMinWidth(100);
        receptionsPerGameCol.setCellValueFactory(new PropertyValueFactory<>("receptionsPerGame"));

        TableColumn<WR, Integer>  yardsPerGameCol = new TableColumn("Yards Per Game");
        yardsPerGameCol.setMinWidth(100);
        yardsPerGameCol.setCellValueFactory(new PropertyValueFactory<>("yardsPerGame"));

        TableColumn<WR, Integer>  yardsPerReceptionCol = new TableColumn("Yards Per Reception");
        yardsPerReceptionCol.setMinWidth(100);
        yardsPerReceptionCol.setCellValueFactory(new PropertyValueFactory<>("yardsPerReception"));

        TableColumn<WR, Integer>  yardsPerTargetCol = new TableColumn("Yards Per Target");
        yardsPerTargetCol.setMinWidth(100);
        yardsPerTargetCol.setCellValueFactory(new PropertyValueFactory<>("yardsPerTarget"));

        table.setItems(stats.getWRs());

        // Adding all the columns
        table.getColumns().addAll(nameCol , teamCol, yardsCol, tdsCol, gamesPlayedCol,
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

    public static void main(String[] args) {
        launch(args);
    }
}
