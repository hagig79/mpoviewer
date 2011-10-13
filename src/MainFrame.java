import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.plaf.FileChooserUI;

public class MainFrame extends JFrame {

	ImagePanel imagePanel;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainFrame app = new MainFrame();
		app.setVisible(true);

	}

	public MainFrame() {
		setSize(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("ファイル");
		menuBar.add(fileMenu);

		JMenuItem itemOpen = new JMenuItem("開く");
		itemOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int selected = fc.showOpenDialog(MainFrame.this);
				if (selected == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					imagePanel.read(f);
					repaint();
				}
			}
		});
		fileMenu.add(itemOpen);

		imagePanel = new ImagePanel();
		getContentPane().add(imagePanel, BorderLayout.CENTER);
	}
}
