//MovingRectangle.java by Austin Wilburn, austinwilburn93@gmail.com
//The program is a javafx application that is an animation
//with a red rectangle in the middle that can be moved with 
//the arrow keys and a choice box for the speed of the movement.
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.input.*;
import javafx.scene.Scene;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.event.*;
//the class extends application
public class MovingRectangle extends Application {
	//one local variable speed so that methods can use it
	private int speed;
	//main method
	public static void main(String[] args) {
		//launch the application
        launch(args);
    }
	 @Override
	 	//primary method for javafx
	public void start(Stage primaryStage) {
	 	//set title
	 	primaryStage.setTitle("Moving Rectangle");
	 	//start speed at 1
	 	speed = 1;
	 	//a new rectangle put in the middle
	 	final Rectangle rectangle = new Rectangle(325, 225, 150, 75);
	 	//color it red
	    rectangle.setFill(Color.RED);
		//new choice box with numbers 1, 2, 3, 4, 5
		ChoiceBox cb = new ChoiceBox();
		cb.getItems().addAll("1", "2", "3", "4", "5");
		//select 1 first
		cb.getSelectionModel().selectFirst();
		//if a new choicebox option is selected
		cb.getSelectionModel().selectedItemProperty().addListener((ObservableValue observable,
        Object oldValue, Object newValue)->{
        //store the value as a string
        String speedString = cb.getSelectionModel().getSelectedItem().toString();
        //parse it to an int and store it to speed
        speed = Integer.parseInt(speedString);
        });
		//a group with rectangle and choice box as input
		final Group group = new Group(rectangle, cb);
		//new scene with group and size as input
	    Scene scene = new Scene(group, 800, 500);
	    //put scene in stage
	    primaryStage.setScene(scene);
	    //if arrow key is pressed
	    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
	        public void handle(KeyEvent k){
	        //if right arrow key is pressed and there's room
	        if(k.getCode() == KeyCode.RIGHT && rectangle.getX() + 150 <= 800)
	        	//go right with speed determining how far
	        	rectangle.setX(rectangle.getX() + speed);
	        //if left arrow key is pressed and there's room
	        else if(k.getCode() == KeyCode.LEFT && rectangle.getX() >= 0)
	        	//go left with speed determining how far
	        	rectangle.setX(rectangle.getX() - speed);
	        //if down arrow key is pressed and there's room
	        else if(k.getCode() == KeyCode.DOWN && rectangle.getY() + 75 <= 500)
	        	//go down with speed determining how far
	        	rectangle.setY(rectangle.getY() + speed);
	        //if up arrow key is pressed and there's room
	        else if(k.getCode() == KeyCode.UP && rectangle.getY() >= 0)
	        	//go up with speed determining how far
	        	rectangle.setY(rectangle.getY() - speed);
	        }
	        });
	 		//show the stage
	 		primaryStage.show();
	 		
	 		
	 	}
}
