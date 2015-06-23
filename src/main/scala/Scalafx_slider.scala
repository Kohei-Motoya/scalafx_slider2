//This program is scalafx slider sample.
//This is based on Javafx official demo (https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/slider.htm).

import scalafx.application.JFXApp
import scalafx.beans.value.ObservableValue
import scalafx.geometry.Insets
import scalafx.scene.Group
import scalafx.scene.Scene
import scalafx.scene.control.{Label, Slider}
import scalafx.scene.effect.SepiaTone
import scalafx.scene.image.Image
import scalafx.scene.image.ImageView
import scalafx.scene.layout.GridPane
import scalafx.scene.paint.Color
import scalafx.stage.Stage


object SliderSample extends JFXApp {
  private final val opacityLevel = new Slider(0, 1, 1)
  private final val sepiaTone = new Slider(0, 1, 1)
  private final val scaling = new Slider (0.5, 1, 1)

  private final val image = new Image(getClass().getResourceAsStream("test.png"))

  private final val opacityCaption = new Label("Opacity Level:")
  private final val sepiaCaption = new Label("Sepia Tone:")
  private final val scalingCaption = new Label("Scaling Factor:")

  private final val opacityValue = new Label(opacityLevel.value.toString)
  private final val sepiaValue = new Label(sepiaTone.value.toString)
  private final val scalingValue = new Label(scaling.value.toString)  

  private final val textColor = Color.BLACK
  private final val sepiaEffect = new SepiaTone();

  private final val root = new Group() 

	stage = new JFXApp.PrimaryStage {
		title = "Slider Sample"
		val s = new Scene(root, 535, 700)

    val grid = new GridPane()
    grid.padding = Insets(10, 10, 10, 10)
    grid.vgap = 10
    grid.hgap = 70

    val cappuccino = new ImageView (image)
    cappuccino.effect = sepiaEffect;
    GridPane.setConstraints(cappuccino, 0, 0)
    GridPane.setColumnSpan(cappuccino, 3)
    grid.children.add(cappuccino)

    s.root = grid

    opacityCaption.textFill = textColor
    GridPane.setConstraints(opacityCaption, 0, 1)
    grid.children.add(opacityCaption)

    cappuccino.opacity <==> opacityLevel.value
    opacityValue.text <== opacityLevel.value.asString("%.2f")

    GridPane.setConstraints(opacityLevel, 1, 1)
    grid.children.add(opacityLevel)

    opacityValue.textFill = textColor
    GridPane.setConstraints(opacityValue, 2, 1)
    grid.children.add(opacityValue)

    sepiaCaption.textFill = textColor
    GridPane.setConstraints(sepiaCaption, 0, 2)
    grid.children.add(sepiaCaption)

    sepiaEffect.level <==> sepiaTone.value
    sepiaValue.text <== sepiaTone.value.asString("%.2f")

    GridPane.setConstraints(sepiaTone, 1, 2)
    grid.children.add(sepiaTone)

    sepiaValue.textFill = textColor
    GridPane.setConstraints(sepiaValue, 2, 2)
    grid.children.add(sepiaValue)

    scalingCaption.textFill = textColor
    GridPane.setConstraints(scalingCaption, 0, 3)
    grid.children.add(scalingCaption)

    cappuccino.scaleX <==> scaling.value
    cappuccino.scaleY <==> scaling.value
    scalingValue.text <== scaling.value.asString("%.2f")

    GridPane.setConstraints(scaling, 1, 3)
    grid.children.add(scaling)

    scalingValue.textFill = textColor
    GridPane.setConstraints(scalingValue, 2, 3)
    grid.children.add(scalingValue)

    scene = s
  }  

}
