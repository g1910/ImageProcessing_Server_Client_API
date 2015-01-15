package imgProcServerAPI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*
 * ImgProcProtocol defines the protocol to apply
 * various operations on the image
 */
public class ImgProcProtocol {

	// Defining the byte codes for various operations
	public static final byte GaussianBlur = 0;
	public static final byte InvertColor = 1;
	public static final byte ScaleUp = 2;
	public static final byte ScaleDown = 3;
	public static final byte Brighten = 4;
	public static final byte Darken = 5;
	public static final byte Sharpen = 6;

	// Defining the instance variables
	BufferedImage image, procImage;
	int width, height;

	// Getter and Setter Functions
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public BufferedImage getProcImage() {
		return procImage;
	}

	// Constructing the class with the image to be worked upon
	public ImgProcProtocol(BufferedImage image) {
		super();
		this.image = image;
		width = image.getWidth();
		height = image.getHeight();
		// Checking for valid image
		checkType();
	}

	// Checking type of the image and applying the required changes
	private void checkType() {
		// TODO Auto-generated method stub
		// TYPE_INT_RGB required for applying Convulation type transformations
		if (image.getType() != BufferedImage.TYPE_INT_RGB) {
			BufferedImage temp = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = temp.getGraphics();
			g.drawImage(image, 0, 0, null);
			image = temp;
		}
	}

	// Perform the operations by choosing the right one
	public String operate(Byte o) throws Throwable {
		String message = "Performing the Operation...\n";
		if (procImage != null) {
			image = procImage;
		}

		// Switching between various types of operations
		switch (o) {

		case GaussianBlur:
			procImage = ImgProcOperations.gaussianBlur(image);
			break;
		case InvertColor:
			procImage = ImgProcOperations.invertColor(image);
			break;
		case ScaleUp:
			procImage = ImgProcOperations.scaleUp(image);
			break;
		case ScaleDown:
			procImage = ImgProcOperations.scaleDown(image);
			break;
		case Brighten:
			procImage = ImgProcOperations.brighten(image);
			break;
		case Darken:
			procImage = ImgProcOperations.darken(image);
			break;
		case Sharpen:
			procImage = ImgProcOperations.sharpen(image);
			break;
		default:
			Exception e = new Exception("Error: Invalid Operation!");
			throw e;
		}
		message += "Success: Operation performed!";
		// Returning the feedback message
		return message;
	}

}
