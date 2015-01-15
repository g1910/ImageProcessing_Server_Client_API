package imgProcServerAPI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ByteLookupTable;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.RescaleOp;

/*
 * Class defining the various Image Processing Operations
 */
public class ImgProcOperations {

	// Defining the required variables(matrices and buffered images)
	static final float[] gBlurMat = { 1 / 16f, 1 / 8f, 1 / 16f, 1 / 8f, 1 / 4f,
			1 / 8f, 1 / 16f, 1 / 8f, 1 / 16f };

	static final float[] sharpen = { 0f, -1f, -0f, -1f, 5f, -1f, 0f, -1f, 0f };

	static BufferedImage procImage;

	// Function the invert color of the image
	public static BufferedImage invertColor(BufferedImage image) {
		// TODO Auto-generated method stub
		byte opp[] = new byte[256];
		for (int j = 0; j < 256; ++j) {
			opp[j] = (byte) (255 - j);
		}
		ByteLookupTable blut = new ByteLookupTable(0, opp);
		BufferedImageOp op = new LookupOp(blut, null);
		procImage = new BufferedImage(image.getWidth(), image.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		op.filter(image, procImage);
		return procImage;
	}

	// Function to applying Gaussian Blur on the image
	public static BufferedImage gaussianBlur(BufferedImage image) {
		BufferedImageOp op = new ConvolveOp(new Kernel(3, 3, gBlurMat),
				ConvolveOp.EDGE_NO_OP, null);
		procImage = new BufferedImage(image.getWidth(), image.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		op.filter(image, procImage);
		return procImage;
	}

	// Function to Scale Up the image
	public static BufferedImage scaleUp(BufferedImage image) {
		Image rez = image.getScaledInstance(image.getWidth() * 2, -1,
				Image.SCALE_SMOOTH);
		procImage = new BufferedImage(rez.getWidth(null), rez.getHeight(null),
				BufferedImage.TYPE_INT_RGB);
		Graphics g = procImage.getGraphics();
		g.drawImage(rez, 0, 0, null);
		g.dispose();
		return procImage;
	}

	// Function to Scale Down the image
	public static BufferedImage scaleDown(BufferedImage image) {
		Image rez = image.getScaledInstance(image.getWidth() / 2, -1,
				Image.SCALE_SMOOTH);
		procImage = new BufferedImage(rez.getWidth(null), rez.getHeight(null),
				BufferedImage.TYPE_INT_RGB);
		Graphics g = procImage.getGraphics();
		g.drawImage(rez, 0, 0, null);
		g.dispose();
		return procImage;
	}

	// Function to sharpen the image
	public static BufferedImage sharpen(BufferedImage image) {
		BufferedImageOp op = new ConvolveOp(new Kernel(3, 3, sharpen),
				ConvolveOp.EDGE_NO_OP, null);
		procImage = new BufferedImage(image.getWidth(), image.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		op.filter(image, procImage);
		return procImage;
	}

	// Function to Brighten the image by 50%
	public static BufferedImage brighten(BufferedImage image) {
		RescaleOp op = new RescaleOp(1.5f, 0.0f, null);
		procImage = new BufferedImage(image.getWidth(), image.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		op.filter(image, procImage);
		return procImage;
	}

	// Function to Darken the image by 50%
	public static BufferedImage darken(BufferedImage image) {
		RescaleOp op = new RescaleOp(0.5f, 0.0f, null);
		procImage = new BufferedImage(image.getWidth(), image.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		op.filter(image, procImage);
		return procImage;
	}
}
