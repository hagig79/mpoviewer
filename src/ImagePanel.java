import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JPanel;

import jp.skr.soundwing.mpo.MPOFile;
import jp.skr.soundwing.mpo.MPOImage;
import jp.skr.soundwing.mpo.MPOLoader;

public class ImagePanel extends JPanel {
	MPOFile image;

	public void read(File file) {
		try {
			image = MPOLoader.read(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		if (image != null) {
			g.drawImage(image.getLeftImage().getBufferedImage(), 0, 0, this);
			g.drawImage(image.getRightImage().getBufferedImage(), image
					.getLeftImage().getBufferedImage().getWidth(), 0, this);
		}
	}
}
