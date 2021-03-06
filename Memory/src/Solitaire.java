
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Solitaire extends Mode {
	private static final long serialVersionUID = 1L;
	private Command cmd;
	private Drawing d;
	private Container c;
	
	
	/**
	 * Constructor 
	 * @param cp the container object 
	 * @param dwg	the drawing object
	 */
	public Solitaire(Drawing dwg, Container cp) {
		super(dwg, cp);
		cmd = new Command();
		d = dwg;
		c = cp;
	
		//Make JButton objects 
		//New Button Names
		JButton flipButton = new JButton("Turn Over Cards");
		JButton removeButton = new JButton("Remove Pair");
		JButton restartButton = new JButton("Restart Game");
		JButton quitButton = new JButton("Quit Game");
		
				
		//Add listeners to buttons
		//New Button listeners 
		flipButton.addActionListener(new FlipButtonListener());
		removeButton.addActionListener(new RemoveButtonListener());
		restartButton.addActionListener(new RestartButtonListener());
		quitButton.addActionListener(new QuitButtonListener());
		
		
		JPanel optionPanel = new JPanel();
		//optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.PAGE_AXIS));
		optionPanel.setLayout(new FlowLayout());
		
		//Changed button color from cyan to yellow, for 
		// aesthetic purposes
		flipButton.setBackground(Color.yellow);
		removeButton.setBackground(Color.yellow);
		restartButton.setBackground(Color.yellow);
		quitButton.setBackground(Color.yellow);
		
		optionPanel.add(flipButton);
	//	optionPanel.add(Box.createRigidArea(new Dimension(0,5)));
		optionPanel.add(removeButton);
		//optionPanel.add(Box.createRigidArea(new Dimension(0,5)));
		optionPanel.add(restartButton);
		optionPanel.add(quitButton);
		optionPanel.setBackground(Color.white);
		
		c.add(optionPanel, BorderLayout.NORTH);
		c.repaint();
		c.validate();
		
	}
	
	
	//Button Listeners altered to have more relevant names and 
	// different commands
	private class FlipButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new TurnOverCardsCmd();
			cmd.executeClick(d);
			c.repaint();
		}
	}
	
	private class RemoveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new RemovePairCmd();
			cmd.executeClick(d);
			ArrayList<Card> onTable = d.getTable();
			boolean gameNotOver = false;
			int ca = 0;
			for (int i = 0; i < onTable.size(); i++) {
				gameNotOver = onTable.get(i).getInPlay();
				if (gameNotOver == true) {
					ca++;
				}
			}
			if (ca == 0) {
				cmd = new HighScoresCmd();
				cmd.executeClick(d);
			}
			c.repaint();
		}
	}
	
	private class RestartButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new RestartCmd();
			cmd.executeClick(d);
			c.repaint();
		}
	}
		
	private class QuitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new QuitCmd();
			cmd.executeClick(d);
			c.repaint();
		}
	}
	
}
