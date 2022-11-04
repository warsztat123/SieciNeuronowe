package neuralNet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import data.SaveReadFile;

import gui.DrawingPanel;

//import Test.MojKomponent;

public class Projekt_1_MLP extends JFrame {

	private Siec siec;
	private SaveReadFile saveReadFile;
	private JComboBox<String> trainAsCombo;
	private JButton buttonZapis;
	private JPanel mainPanel;
	private JPanel panelOpcji;
	private DrawingPanel drawingPanel;
	private JPanel panelWyboruLiter;
	private JButton clearButton;
	private final int rozdzielczosc = 20;
	private ButtonGroup grupa;

	public Projekt_1_MLP(String string) {
		super(string);
		panelGlowny();
		PanelDoRysowania();
		panelOpcji();
		// panelWyboruLiter();
		// panelWyboru();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(new Dimension(680, 470));
		setLocationRelativeTo(null);
		setResizable(false);

		setOnClicks();
		int[] tab = new int[3];
		tab[0] = 25;
		tab[1] = 5;
		tab[2] = 1;
		siec = new Siec(2, 3, tab);

	}

	private void panelGlowny() {
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		setContentPane(mainPanel);
	}

	private void PanelDoRysowania() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setPreferredSize(new Dimension(410, 420));
		drawingPanel = new DrawingPanel(400, 400, rozdzielczosc);
		panel.add(drawingPanel);

		mainPanel.add(panel);
	}

	private void panelOpcji() {
		panelOpcji = new JPanel();
		panelOpcji.setBackground(Color.LIGHT_GRAY);
		panelOpcji.setPreferredSize(new Dimension(200, 420));
		/*
		 * JRadioButton radioButtonA = new JRadioButton("A");
		 * radioButtonA.setBackground(Color.LIGHT_GRAY); JRadioButton radioButtonO = new
		 * JRadioButton("O"); radioButtonO.setBackground(Color.LIGHT_GRAY); JRadioButton
		 * radioButtonC = new JRadioButton("C");
		 * radioButtonC.setBackground(Color.LIGHT_GRAY); grupa = new ButtonGroup();
		 * grupa.add(radioButtonA); grupa.add(radioButtonO); grupa.add(radioButtonC);
		 * panelOpcji.add(radioButtonA); panelOpcji.add(radioButtonO);
		 * panelOpcji.add(radioButtonC);
		 */
		trainAsCombo = new JComboBox<>(new String[] { "A", "O", "C" });
		trainAsCombo.setPreferredSize(new Dimension(50, 30));
		panelOpcji.add(trainAsCombo);
		buttonZapis = new JButton("Zapisz");
		buttonZapis.setPreferredSize(new Dimension(100, 30));
		clearButton = new JButton("Wyczyœæ");
		clearButton.setPreferredSize(new Dimension(100, 30));
		panelOpcji.add(buttonZapis);
		panelOpcji.add(clearButton);

		mainPanel.add(panelOpcji);
	}

	private void setOnClicks() {
		clearButton.addActionListener(e -> drawingPanel.clear());
		
		buttonZapis.addActionListener(e -> {
			String letter = (String) trainAsCombo.getSelectedItem();
			SaveReadFile.saveToFile(drawingPanel.getPixels(), letter);
			
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Projekt_1_MLP("Rozpoznawanie liter AOC");
			}
		});

	}

}
