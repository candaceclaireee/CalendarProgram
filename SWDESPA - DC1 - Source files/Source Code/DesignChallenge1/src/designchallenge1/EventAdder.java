package designchallenge1;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EventAdder extends JFrame implements ActionListener{

    Date d = new Date();
    
	public JFrame frmEvent;
	public JPanel eventPanel;
	public Container pane;
	
    public JTextField titleField;
	public JLabel titleLabel, dateLabel, colorLabel;
	
	public JButton btnAdd;
    public JComboBox<String> cmbDay, cmbMonth, cmbYear, cmbColor;
    
    public String[] colors = {"Green","Red","Blue", "Yellow","Orange", "Pink"};
        
    public EventAdder() {

    	frmEvent = new JFrame ("Add New Event");
    	frmEvent.setSize(400, 450);
    	frmEvent.setResizable(false);
    	frmEvent.setVisible(true);
    	frmEvent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	init();
    }
    
    public void init() {

		pane = frmEvent.getContentPane();
		pane.setLayout(null);
		
		titleField = new JTextField("");
		titleLabel = new JLabel("Event Name");
		dateLabel = new JLabel("Date");
		colorLabel = new JLabel("Color");
		cmbDay = new JComboBox();
		cmbMonth = new JComboBox();
		cmbYear = new JComboBox();
		cmbColor = new JComboBox();
		
		btnAdd = new JButton ("ADD");

		btnAdd.addActionListener(this);
		eventPanel = new JPanel(null);

		pane.add(eventPanel);
		eventPanel.add(titleField);
		eventPanel.add(titleLabel);
		eventPanel.add(dateLabel);
		eventPanel.add(colorLabel);
		eventPanel.add(cmbDay);
		eventPanel.add(cmbMonth);
		eventPanel.add(cmbYear);
		eventPanel.add(cmbColor);
		
		eventPanel.add(btnAdd);
		
		eventPanel.setBounds(0, 00, 380, 700);
		titleField.setBounds(150, 80,200, 40);
		titleLabel.setBounds(40,30, 100, 150);
		dateLabel.setBounds(40,100, 100,150);
		colorLabel.setBounds(40,170, 100,150);
		cmbDay.setBounds(160, 150, 80, 50);
		cmbMonth.setBounds(220, 150, 90, 50);
		cmbYear.setBounds(280, 150, 80, 50);
		cmbColor.setBounds(170, 220, 180,40);
		
		cmbDay.setSize(40, 40);
		cmbMonth.setSize(40, 40);
		cmbYear.setSize(60, 40);
		cmbColor.setSize(160, 45);
		
		btnAdd.setBounds(240, 330, 100, 50);
		
		for (int i=1; i <=31; i++){
			cmbDay.addItem(String.valueOf(i));
		}
		for (int i=1; i <=12; i++){
			cmbMonth.addItem(String.valueOf(i));
		}
		for (int i= d.getYearBound()-100; i <= d.getYearBound()+100; i++){
			cmbYear.addItem(String.valueOf(i));
		}
		for (int i=0; i<colors.length; i++){
			cmbColor.addItem(String.valueOf(colors[i]));
		}
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
