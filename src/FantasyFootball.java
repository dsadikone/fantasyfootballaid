/**
 *
 * @author CJ
 */

import java.io.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FantasyFootball extends Application {
    private TableView wrTable;
    private TableView qbTable;
    private TableView rbTable;
    private Button wrButton;
    private Button qbButton;
    private Button rbButton;

    public void start(Stage primaryStage) throws FileNotFoundException {

        wrButton = new Button("WR Stats");
        qbButton = new Button("QB Stats");
        rbButton = new Button("RB Stats");
        wrTable = new TableView();
        qbTable = new TableView();
        rbTable = new TableView();
        Stats stats = new Stats();
        stats.readStats("WRs.csv");
        stats.readStats("QBs.csv");
        stats.readStats("RBs.csv");


        primaryStage.setTitle("Table View Sample");
        primaryStage.setWidth(1250);
        primaryStage.setHeight(550);

        final Label wrLabel = new Label("WR Stats");
        wrLabel.setFont(new Font("Arial", 20));

        final Label qbLabel = new Label("QB Stats");
        qbLabel.setFont(new Font("Arial", 20));

        final Label rbLabel = new Label("RB Stats");
        rbLabel.setFont(new Font("Arial", 20));

        wrTable.setEditable(false);
        qbTable.setEditable(false);
        rbTable.setEditable(false);

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

        wrTable.getColumns().addAll(nameCol , teamCol, yardsCol, tdsCol, gamesPlayedCol,
                receptionsCol, targetsCol, receptionsPerGameCol, yardsPerGameCol,
                yardsPerReceptionCol, yardsPerTargetCol);



        // Creating columns for QB stats
        TableColumn<QB, String> qbNameCol = new TableColumn("Name");
        qbNameCol.setMinWidth(200);
        qbNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<QB, String> qbTeamCol = new TableColumn("Team");
        qbTeamCol.setMinWidth(100);
        qbTeamCol.setCellValueFactory(new PropertyValueFactory<>("team"));

        TableColumn<QB, Integer> qbYardsCol = new TableColumn("Yards");
        qbYardsCol.setMinWidth(100);
        qbYardsCol.setCellValueFactory(new PropertyValueFactory<>("yards"));

        TableColumn<QB, Integer>  qbTdsCol = new TableColumn("Tds");
        qbTdsCol.setMinWidth(100);
        qbTdsCol.setCellValueFactory(new PropertyValueFactory<>("tds"));

        TableColumn<QB, Integer>  qbGamesPlayedCol = new TableColumn("Games Played");
        qbGamesPlayedCol.setMinWidth(100);
        qbGamesPlayedCol.setCellValueFactory(new PropertyValueFactory<>("gamesPlayed"));

        TableColumn<QB, Integer>  qbCompletionsCol = new TableColumn("Completions");
        qbCompletionsCol.setMinWidth(100);
        qbCompletionsCol.setCellValueFactory(new PropertyValueFactory<>("completions"));

        TableColumn<QB, Double>  qbAttemptsCol = new TableColumn("Attempts");
        qbAttemptsCol.setMinWidth(100);
        qbAttemptsCol.setCellValueFactory(new PropertyValueFactory<>("attempts"));

        TableColumn<QB, Double>  qbYardsPerAttemptCol = new TableColumn("Yards Per Attempt");
        qbYardsPerAttemptCol.setMinWidth(100);
        qbYardsPerAttemptCol.setCellValueFactory(new PropertyValueFactory<>("yardsPerAttempt"));

        TableColumn<QB, Double>  qbCompletionPercentageCol = new TableColumn("Completion %");
        qbCompletionPercentageCol.setMinWidth(100);
        qbCompletionPercentageCol.setCellValueFactory(new PropertyValueFactory<>("completionPercentage"));

        TableColumn<QB, Double>  qbYardsPerGameCol = new TableColumn("Yards Per Game");
        qbYardsPerGameCol.setMinWidth(100);
        qbYardsPerGameCol.setCellValueFactory(new PropertyValueFactory<>("yardsPerGame"));

        TableColumn<QB, Double>  tdPerGameCol = new TableColumn("Td Per Game");
        tdPerGameCol.setMinWidth(100);
        tdPerGameCol.setCellValueFactory(new PropertyValueFactory<>("tdPerGame"));

        qbTable.getColumns().addAll(qbNameCol, qbTeamCol, qbYardsCol, qbTdsCol,
                qbGamesPlayedCol, qbCompletionsCol, qbAttemptsCol, qbYardsPerAttemptCol,
                qbCompletionPercentageCol, qbYardsPerGameCol, tdPerGameCol);


        // Creating columns for RB stats
        TableColumn<RB, String> rbNameCol = new TableColumn("Name");
        rbNameCol.setMinWidth(200);
        rbNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<RB, String> rbTeamCol = new TableColumn("Team");
        rbTeamCol.setMinWidth(100);
        rbTeamCol.setCellValueFactory(new PropertyValueFactory<>("team"));

        TableColumn<RB, Integer> rbYardsCol = new TableColumn("Yards");
        rbYardsCol.setMinWidth(100);
        rbYardsCol.setCellValueFactory(new PropertyValueFactory<>("yards"));

        TableColumn<RB, Integer>  rbTdsCol = new TableColumn("Tds");
        rbTdsCol.setMinWidth(100);
        rbTdsCol.setCellValueFactory(new PropertyValueFactory<>("tds"));

        TableColumn<RB, Integer>  rbCarries = new TableColumn("Carries");
        rbCarries.setMinWidth(100);
        rbCarries.setCellValueFactory(new PropertyValueFactory<>("carries"));

        TableColumn<RB, Integer>  rbTwentyYardRuns = new TableColumn("Twenty yr runs");
        rbTwentyYardRuns.setMinWidth(100);
        rbTwentyYardRuns.setCellValueFactory(new PropertyValueFactory<>("twentyYardRuns"));

        TableColumn<RB, Integer>  rbGamesPlayed = new TableColumn("Games Played");
        rbGamesPlayed.setMinWidth(100);
        rbGamesPlayed.setCellValueFactory(new PropertyValueFactory<>("gamesPlayed"));

        TableColumn<RB, Double>  carriesPerGame = new TableColumn("Carries Per Game");
        carriesPerGame.setMinWidth(100);
        carriesPerGame.setCellValueFactory(new PropertyValueFactory<>("carriesPerGame"));

        TableColumn<RB, Double>  rbYardsPerGame = new TableColumn("Yards Per Game");
        rbYardsPerGame.setMinWidth(100);
        rbYardsPerGame.setCellValueFactory(new PropertyValueFactory<>("yardsPerGame"));

        TableColumn<RB, Double>  rbYardsPerCarry = new TableColumn("Yards Per Carry");
        rbYardsPerCarry.setMinWidth(100);
        rbYardsPerCarry.setCellValueFactory(new PropertyValueFactory<>("yardsPerCarry"));

        TableColumn<RB, Double>  breakoutRunPercentage = new TableColumn("BR Run Percent");
        breakoutRunPercentage.setMinWidth(100);
        breakoutRunPercentage.setCellValueFactory(new PropertyValueFactory<>("breakoutRunPercentage"));

        rbTable.getColumns().addAll(rbNameCol, rbTeamCol, rbYardsCol, rbTdsCol,
                rbCarries, rbTwentyYardRuns, rbGamesPlayed, carriesPerGame,
                rbYardsPerGame, rbYardsPerCarry, breakoutRunPercentage);

        int num1 = 412;
        int num2 = 94;
        double num3 = (double) num1 /num2;
        System.out.println(num3);


        final HBox hbox = new HBox();
        hbox.setSpacing(5);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.getChildren().addAll(wrButton, qbButton, rbButton);

        // GridPane for WR data
        GridPane displayWR = new GridPane();
        displayWR.add(wrLabel,0,0);
        displayWR.add(wrTable,0,1);
        displayWR.setHgap(10);
        displayWR.setVgap(10);
        displayWR.setPadding(new Insets(25,25,25,25));

        // GridPane for QB data
        GridPane displayQB = new GridPane();
        displayQB.add(qbLabel,0,0);
        displayQB.add(qbTable,0,1);
        displayQB.setHgap(10);
        displayQB.setVgap(10);
        displayQB.setPadding(new Insets(25,25,25,25));

        // GridPane for RB data
        GridPane displayRB = new GridPane();
        displayRB.add(rbLabel,0,0);
        displayRB.add(rbTable,0,1);
        displayRB.setHgap(10);
        displayRB.setVgap(10);
        displayRB.setPadding(new Insets(25,25,25,25));

        BorderPane root = new BorderPane();
        root.setTop(hbox);
        Scene scene = new Scene(root, 1250, 550);

        primaryStage.setScene(scene);
        primaryStage.show();


        wrButton.setOnAction((ActionEvent) -> {

            wrTable.setItems(stats.getWRs());
            root.setCenter(displayWR);

        });

        qbButton.setOnAction((ActionEvent) -> {

            qbTable.setItems(stats.getQBs());
            root.setCenter(displayQB);

        });

        rbButton.setOnAction((ActionEvent) -> {

            rbTable.setItems(stats.getRBs());
            root.setCenter(displayRB);

        });
    }

    public static void main(String[] args) throws FileNotFoundException {


        Stats stat = new Stats();
        stat.readStats("RBs.csv");
        stat.printStats();

        /*
        * (IMPORTANT NOTE)
        * The only column not working is yards per carry.
        * It seems to be calculating the right number based off
        * the print stat data.
        */


        launch(args);
    }
}
