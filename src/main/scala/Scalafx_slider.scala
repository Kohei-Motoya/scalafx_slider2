import scalafx.application.JFXApp
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.image.Image
import scalafx.scene.image.ImageView
import scalafx.scene.layout.StackPane
import scalafx.stage.Stage
import scalafx.scene.control.{Slider, TextField}
import scalafx.scene.layout.{Region, VBox}


object ImgaeViewDemo extends JFXApp {
	stage = new JFXApp.PrimaryStage {
		title.value = "Imageviewer Demo"
		width = 512
		height = 512
		scene = new Scene {
			content = new StackPane {
  			content = new ImageView {
  				image = new Image(getClass().getResourceAsStream("test.png"))
  			}
			}
		}
	}
}
