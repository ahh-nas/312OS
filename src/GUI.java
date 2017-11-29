import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Font;

public class GUI extends JFrame {
int a =0;
	private JPanel contentPane;
	private JTextField txtEnterCommand;
	private JTable table_1;

    	
	public String[] array;
	public String  thing;
	
	private JLabel lblArrivalTime;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblLastCommand;

	
 public  String[] command;
	/**
	 * Launch the application.
	 */
 public void getValue()
 {
	 System.out.println("values is: "+ thing);
 }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public GUI() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JTable table = new JTable();
		JScrollPane spTable = new JScrollPane(table);
		JPanel panel = new JPanel();
		panel.add(spTable);
		
		
		JTextPane textPane = new JTextPane();
		
		txtEnterCommand = new JTextField();
		
		txtEnterCommand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 String text = txtEnterCommand.getText();
				
				  array=text.split(" ",2); //Splits the user data into two sub strings to separate the job file from the command
				  
				  int mid = text.length() / 2; //get the middle of the String
				 String[] parts = {text.substring(0, mid),text.substring(mid)};
				 thing = parts[1];
				 String load = "load";
				 String exe = "exe";
				 String proc = "proc";
				 String mem = "mem";
				 String exit = "exit";
				 String reset = "reset";
<<<<<<< HEAD
					//System.out.println(thing);
				 txtEnterCommand.setText("");//clears the text field after entering
=======
				
>>>>>>> branch 'master' of https://github.com/ahh-nas/312OS.git
				 
<<<<<<< HEAD
				 
				/* switch(text.toLowerCase())
				 {
				 case "load":
					 thing = parts[1];
					 return;
				 case "exe":
				 case "proc":
				 case "mem":
				 case "exit":
				 case "reset":
					 
				 }*/
				 
				if (array[0].equals(load)) {
					
				 
				//	command=text.split(" ",2);
					 //array[0] = String.parseString( text.split(" ",2);
					 thing = parts[1];
					return;
	            	// System.out.println("loading");
=======
				 if (array[0].equals(load)) {
	            	 System.out.println("loading");
	            	 textPane.setText(txtEnterCommand.getText());
>>>>>>> branch 'master' of https://github.com/ahh-nas/312OS.git
	             }
				 
	             else if(array[0].equals(exe))
	             {System.out.println("execuitng");
	             textPane.setText(txtEnterCommand.getText());}
				 
	             else if(array[0].equals(proc))
	             {System.out.println("Processing");
	             textPane.setText(txtEnterCommand.getText());}
				 
	             else if(array[0].equals(exit))
	             {textPane.setText(txtEnterCommand.getText());
	            	 System.exit(0);}
				 
	             else if(array[0].equals(mem))
	             {System.out.println("mem used");
	             textPane.setText(txtEnterCommand.getText());}
				 
	             else if(array[0].equals(reset))
	             {textPane.setText(txtEnterCommand.getText());}//clear the space
				 
				 
				 
	             else
	             {JOptionPane.showMessageDialog(null, "Invalid command");}
				 
				 
				 txtEnterCommand.setText("");//clears the text field after entering
			}
			
		});
			
	
		//array[0]=text.split(" ",2);
		
		txtEnterCommand.setColumns(10);
		
		table_1 = new JTable();
		table_1.setEnabled(false);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {

				{thing, null , "", "", null, null},

				{"array[1]", 1000000, "ditto", "sadf", "adsf", "asdf"},

				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Process", "Size", "Arrival Time", "Run Time", "Status", "Last Command"
			}
		));
		
		JLabel lblProcess = new JLabel("Process");
		lblProcess.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		lblArrivalTime = new JLabel("Arrival Time");
		lblArrivalTime.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		lblNewLabel = new JLabel("Run Time");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		lblNewLabel_1 = new JLabel("Status");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		lblLastCommand = new JLabel("Last Command");
		lblLastCommand.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
	
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtEnterCommand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
								.addComponent(table_1, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblProcess)
							.addGap(34)
							.addComponent(lblSize)
							.addGap(30)
							.addComponent(lblArrivalTime)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(lblLastCommand)
							.addGap(20))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSize)
						.addComponent(lblProcess)
						.addComponent(lblLastCommand)
						.addComponent(lblNewLabel_1)
						.addComponent(lblArrivalTime)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtEnterCommand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);


	}
}
