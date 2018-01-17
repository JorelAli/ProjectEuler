package io.github.skepter.utils;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoadingBar {

	private JFrame frame;
	private JProgressBar progressBar;
	private int max;
	private String title;

	/**
	 * Create the application.
	 */
	public LoadingBar(String title, int max) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		this.title = title;
		this.max = max;
		initialize(title);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String title) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 76);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(title);
		frame.setVisible(true);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setMaximum(max);
		frame.getContentPane().add(progressBar, BorderLayout.CENTER);
	}
	
	public void updateBar(int i) {
		progressBar.setValue(i);
	}
	
	public void updateTitle(Object info) {
		frame.setTitle(title + " - " + String.valueOf(info));
	}

}
