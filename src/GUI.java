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

public class GUI extends JFrame {
int a =0;
	private JPanel contentPane;
	private JTextField txtEnterCommand;
	private JTable table_1;
	

	

	/**
	 * Launch the application.
	 */
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
		
		txtEnterCommand = new JTextField();
		txtEnterCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String text = txtEnterCommand.getText();
				 String array[]=text.split(" ",2); //Splits the user data into two sub strings to separate the job file from the command
				 
				 String load = "load";
				 String exe = "exe";
				 String proc = "proc";
				 String mem = "mem";
				 String exit = "exit";
				 String reset = "reset";
				 txtEnterCommand.setText("");//clears the text field after entering
				 
				 if (array[0].equals(load)) {
	            	 System.out.println("loading");
	             }
				 
	             else if(array[0].equals(exe))
	             {System.out.println("execuitng");}
				 
	             else if(array[0].equals(proc))
	             {System.out.println("Processing");}
				 
	             else if(array[0].equals(exit))
	             {System.exit(0);}
				 
	             else if(array[0].equals(mem))
	             {System.out.println("mem used");}
				 
	             else if(array[0].equals(reset))
	             {}//clear the space
			}
		});
		
		
		
		
		txtEnterCommand.setColumns(10);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", "", null, null},
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
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(table_1, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(txtEnterCommand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 160, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(txtEnterCommand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);


	}

}
