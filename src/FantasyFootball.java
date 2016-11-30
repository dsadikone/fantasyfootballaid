/**
 *
 * @author CJ
 */

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FantasyFootball extends Application {

    private MenuBar menuBar;
    private Menu menuFile;
    private Menu menuHelp;
    private MenuItem exit;
    private MenuItem about;
    private TableView wrTable;
    private TableView qbTable;
    private TableView rbTable;
    private Button wrButton;
    private Button qbButton;
    private Button rbButton;
    private Label welcomeText;
    private Label leftArrow;
    private Label downArrow;
    private Label rightArrow;
    private Stage primaryStage;
    Connection conn = null;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {


        try {

            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:\\Users\\CJ\\Desktop\\sqllite\\PlayerStats.sqlite";
            conn = DriverManager.getConnection(url);
            System.out.println("connected");

        } catch(Exception e) {
            e.printStackTrace();
        }


        this.primaryStage = primaryStage;
        primaryStage.setOnCloseRequest(confirmCloseEventHandler);

        // Setting up a menu
        menuBar = new MenuBar();
        menuFile = new Menu("File");
        menuHelp = new Menu("Help");
        exit = new MenuItem("Exit");
        about = new MenuItem("About");
        menuFile.getItems().add(exit);
        menuHelp.getItems().add(about);
        menuBar.getMenus().addAll(menuFile, menuHelp);

        wrButton = new Button("WR Stats");
        qbButton = new Button("QB Stats");
        rbButton = new Button("RB Stats");
        wrTable = new TableView();
        qbTable = new TableView();
        rbTable = new TableView();

        // Welcome page
        welcomeText = new Label("Welcome to Football Stats");
        welcomeText.setFont(new Font("Arial", 60));

        leftArrow = new Label();
        rightArrow = new Label();
        downArrow = new Label();

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


        final ObservableList<WR> wrData = FXCollections.observableArrayList();
        final ObservableList<QB> qbData = FXCollections.observableArrayList();
        final ObservableList<RB> rbData = FXCollections.observableArrayList();

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
        root.setTop(menuBar);
        root.setBottom(hbox);

        BorderPane welcomePage = new BorderPane();


        Image leftArrowImage = new Image(getClass().getResourceAsStream("left-arrow.png"));
        Image rightArrowImage = new Image(getClass().getResourceAsStream("right-arrow.png"));
        Image downArrowImage = new Image(getClass().getResourceAsStream("down-arrow.png"));


        // Change images for navigation
        Image rbImage = new Image(getClass().getResourceAsStream("rb-arrow.png"));
        Image qbImage = new Image(getClass().getResourceAsStream("qb-arrow.png"));
        Image wrImage = new Image(getClass().getResourceAsStream("wr-arrow.png"));


        leftArrow.setGraphic(new ImageView(leftArrowImage));
        rightArrow.setGraphic(new ImageView(rightArrowImage));
        downArrow.setGraphic(new ImageView(downArrowImage));


        // Adding elements to the welcome page

        welcomePage.setCenter(welcomeText);
        welcomePage.setAlignment(welcomeText,Pos.CENTER);
        welcomePage.setLeft(leftArrow);
        welcomePage.setAlignment(leftArrow, Pos.CENTER);
        welcomePage.setAlignment(rightArrow, Pos.CENTER);
        welcomePage.setRight(rightArrow);
        welcomePage.setBottom(downArrow);
        welcomePage.setAlignment(downArrow, Pos.CENTER);



        Scene scene = new Scene(root, 1250, 550);
        Scene welcomeScene = new Scene(welcomePage, 1250, 550);


        scene.getStylesheets().add(FantasyFootball.class.getResource("style.css")
                .toExternalForm());

        welcomeScene.getStylesheets().add(FantasyFootball.class.getResource("style.css")
                .toExternalForm());

        primaryStage.setScene(welcomeScene);
        primaryStage.show();

        leftArrow.setOnMouseClicked((MouseEvent e) -> {
            primaryStage.setScene(scene);
            qbButton.fire(); // simulates a button click
        });

        leftArrow.setOnMouseEntered((MouseEvent e) -> {
            leftArrow.setGraphic(new ImageView(qbImage));
        });

        leftArrow.setOnMouseExited((MouseEvent e) -> {
            leftArrow.setGraphic(new ImageView(leftArrowImage));
        });

        rightArrow.setOnMouseClicked((MouseEvent e) -> {
            primaryStage.setScene(scene);
            rbButton.fire(); // simulates a button click
        });

        rightArrow.setOnMouseEntered((MouseEvent e) -> {
           rightArrow.setGraphic(new ImageView(rbImage));
        });

        rightArrow.setOnMouseExited((MouseEvent e) -> {
            rightArrow.setGraphic(new ImageView(rightArrowImage));
        });

        downArrow.setOnMouseClicked((MouseEvent e) -> {
            primaryStage.setScene(scene);
            wrButton.fire(); // simulates a button click
        });

        downArrow.setOnMouseEntered((MouseEvent e) -> {
            downArrow.setGraphic(new ImageView(wrImage));
        });

        downArrow.setOnMouseExited((MouseEvent e) -> {
            downArrow.setGraphic(new ImageView(downArrowImage));
        });


        exit.setOnAction((ActionEvent) -> {

            primaryStage.fireEvent(
                    new WindowEvent(
                            primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST
                    )
            );
        });

        about.setOnAction((ActionEvent) -> {
            try {
                // Getting default browser on desktop and opening the browser to the url provided.
                Desktop.getDesktop().browse(new URL("https://www.google.com").toURI());

            } catch (Exception e) {
                e.printStackTrace(); // printing list of errors
            }
        });

        wrButton.setOnAction((ActionEvent) -> {


            try {

                wrTable.getItems().clear();

                String sql = "SELECT * FROM WRs";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {

                    wrData.add(new WR(
                        rs.getString("name"),
                        rs.getString("team"),
                        rs.getInt("gamesPlayed"),
                        rs.getInt("receptions"),
                        rs.getInt("targets"),
                        rs.getInt("yards"),
                        rs.getInt("tds")
                    ));
                    wrTable.setItems(wrData);
                }

                root.setCenter(displayWR);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        qbButton.setOnAction((ActionEvent) -> {

            try {

                qbTable.getItems().clear();

                String sql = "SELECT * FROM QBs";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {

                    qbData.add(new QB(
                            rs.getString("name"),
                            rs.getString("team"),
                            rs.getInt("yards"),
                            rs.getInt("tds"),
                            rs.getInt("gamesPlayed"),
                            rs.getInt("completions"),
                            rs.getInt("attempts")
                    ));
                    qbTable.setItems(qbData);
                }

                root.setCenter(displayQB);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        rbButton.setOnAction((ActionEvent) -> {

            try {

                rbTable.getItems().clear();

                String sql = "SELECT * FROM RBs";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {

                    rbData.add(new RB(
                            rs.getString("name"),
                            rs.getString("team"),
                            rs.getInt("yards"),
                            rs.getInt("tds"),
                            rs.getInt("carries"),
                            rs.getInt("twenty"),
                            rs.getInt("gamesPlayed")
                    ));
                    rbTable.setItems(rbData);
                }

                root.setCenter(displayRB);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }


    private EventHandler<WindowEvent> confirmCloseEventHandler = event -> {
        Alert closeConfirmation = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Are you sure you want to exit?"
        );
        Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton(
                ButtonType.OK
        );
        exitButton.setText("Exit");
        closeConfirmation.setHeaderText("Confirm Exit");
        closeConfirmation.initModality(Modality.APPLICATION_MODAL);
        closeConfirmation.initOwner(primaryStage);


        Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
        if (!ButtonType.OK.equals(closeResponse.get())) {
            event.consume();
        }
    };

    public static void main(String[] args) throws FileNotFoundException {

        launch(args);
    }
}
