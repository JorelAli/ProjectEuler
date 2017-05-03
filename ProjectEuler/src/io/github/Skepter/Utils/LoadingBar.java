package io.github.Skepter.Utils;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class LoadingBar {

	private JFrame frame;
	private JProgressBar progressBar;
	private int max;

	/**
	 * Create the application.
	 */
	public LoadingBar(int max) {
		this.max = max;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		progressBar = new JProgressBar();
		progressBar.setMaximum(max);
		frame.getContentPane().add(progressBar, BorderLayout.CENTER);
	}
	
	public void updateBar(int i) {
		progressBar.setValue(i);
	}

}
