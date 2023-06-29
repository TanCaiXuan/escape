package com.caixuan.assignment;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class assignment extends Application {
    @Override

    public void start(Stage stage) throws IOException {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 1280, 720);

        stage.setTitle("Escape Here");
        stage.setScene(scene);
        stage.show();


        // create a horizontal box to store menuItem
        HBox menuHbox = new HBox(10,new MenuItem("Menu",()->{}),new MenuItem("Doc",()->{}),new MenuItem("White Paper",()->{}),new MenuItem("Quit",()-> Platform.exit()));

        menuHbox.setTranslateX(400);
        menuHbox.setTranslateY(2);

        // to set background image, title image , play image,icon
        Image image = new Image(assignment.class.getResource("bgImage.jpg").toString());
        Image title = new Image(assignment.class.getResource("escape.png").toString());
        Image play = new Image(assignment.class.getResource("play.png").toString());
        Image icon = new Image(assignment.class.getResource("icon.png").toString());
        ImageView titleView = new ImageView(title);
        ImageView playView = new ImageView(play);
        ImageView iconView = new ImageView(icon);
        playView.setPreserveRatio(true);

        // to set title position
        titleView.setX(0);
        titleView.setY(2);

        // to set icon position
        iconView.setX(375);
        iconView.setY(275);

        // to create play button
        Button playBtn = new Button();
        playBtn.setTranslateX(975);
        playBtn.setTranslateY(625);
        playBtn.setPrefSize(100,40);
        playBtn.setGraphic(playView);
        playBtn. setStyle("-fx-background-color: #000000; ");

        // to set the official page button
        Image fb = new Image(assignment.class.getResource("facebook.png").toString());
        Image wechat = new Image(assignment.class.getResource("wechat.jpg").toString());
        Image ig = new Image(assignment.class.getResource("ig.png").toString());

        ImageView fbView = new ImageView(fb);
        ImageView wcView = new ImageView(wechat);
        ImageView igView = new ImageView(ig);

        // set facebook button
        Button fbbtn = new Button();
        fbbtn.setGraphic(fbView);
        fbbtn.setPrefSize(40,40);
        fbbtn. setStyle("-fx-background-color: #000000; ");

         // set wechat button
        Button wcbtn = new Button();
        wcbtn.setGraphic(wcView);
        wcbtn.setPrefSize(40,40);
        wcbtn. setStyle("-fx-background-color: #000000; ");

         // set Instagram button
        Button igBtn = new Button();
        igBtn.setGraphic(igView);
        igBtn.setPrefSize(40,40);
        igBtn. setStyle("-fx-background-color: #000000; ");

        // to store those adv button
        VBox advBox = new VBox();
        advBox.setSpacing(12);
        advBox.getChildren().addAll(fbbtn,wcbtn,igBtn);
        advBox.setTranslateY(300);
        advBox.setTranslateX(3);

        // to write "Stare in the night too long and you will eventually see what isnt there"
        Text t1= new Text();
        t1.setText("STARE..in the..\nN\nI\nG\nH\nT");
        t1.setFont(Font.font ("Constantia", 25));
        t1.setFill(Color.RED);
        t1.setTextAlignment(TextAlignment.RIGHT);
        Text t2= new Text();

        t2.setText("                                               t...oo long an...d....");
        t2.setFont(Font.font ("Constantia", 23));
        t2.setFill(Color.RED);
        t2.setTextAlignment(TextAlignment.RIGHT);
        Text t3= new Text();

        t3.setText("Y...ou will eve...ntual..ly s..ee what isn't the..re");
        t3.setFont(Font.font ("Constantia", 23));
        t3.setFill(Color.RED);

        VBox txtBox = new VBox(t2,t3);
        HBox txtBox2 = new HBox(t1);

        txtBox.setTranslateX(650);
        txtBox.setTranslateY(530);
        txtBox2.setTranslateX(950);
        txtBox2.setTranslateY(350);


        // to set background picture
        BackgroundSize bgSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false);
        pane.setBackground(new Background(new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bgSize)));

        pane.getChildren().addAll(txtBox,txtBox2,advBox,titleView,iconView,menuHbox,playBtn);


    }

    // design menu 
    private static class MenuItem extends StackPane{
        MenuItem(String name, Runnable action){
            LinearGradient gradient = new LinearGradient(0,0.5,1,0.5,true, CycleMethod.NO_CYCLE,new Stop(0.1,Color.web("black",0.75)), new Stop(1.0, Color.web("black",0.15)));

            Rectangle rec = new Rectangle(80,30,gradient);
            Rectangle line = new Rectangle(5,30);

            line.fillProperty().bind(
                    Bindings.when(hoverProperty()).then(Color.AZURE).otherwise(Color.GRAY)
            );
            Text text = new Text(name);
            text.fillProperty().bind(
                    Bindings.when(hoverProperty()).then(Color.WHITE).otherwise(Color.GRAY)
            );

            HBox decHbox = new HBox(15,line,text);
            decHbox.setAlignment(Pos.CENTER_LEFT);
            getChildren().addAll(rec,decHbox);
        }

    }




    public static void main(String[] args) {
        launch();
    }
}
