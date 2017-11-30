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
	private JLabel lblArrivalTime;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblLastCommand;
	private String processName="";
	public String array[];
	

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
	 * @return 
	 */
	public GUI() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		DefaultTableModel model = new DefaultTableModel(); 
		JTable table = new JTable(model);
		JScrollPane spTable = new JScrollPane(table);
		JPanel panel = new JPanel();
		panel.add(spTable);
		

		// Create a couple of columns 
		model.addColumn("Process"); 
		model.addColumn("Size"); 
		model.addColumn("Arrival Time"); 
		model.addColumn("Run Time"); 
		model.addColumn("Status"); 
		model.addColumn("Last Command"); 

		// Append a row 
		model.addRow(new Object[]{"s", 1000000, "ditto", "sadf", "adsf", "asdf"});
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		txtEnterCommand = new JTextField();
		String processName = "";
		
		txtEnterCommand.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				 String text = txtEnterCommand.getText();
				 array=text.split(" ",2); //Splits the user data into two sub strings to separate the job file from the command
				 
				
			
				// processName = array[1];
				
				 switch(array[0]) {
				 
				 case "load": 
				 System.out.println("loading");
				 textArea.append(txtEnterCommand.getText()+"\n");
				model.addRow(new Object[]{array[1], 1000000, "ditto", "sadf", "adsf", "asdf"});
				 setProcessName(array[1]);
				 txtEnterCommand.setText("");
				 break;
				 
				 case "exe": 
				 System.out.println("executing");
				 textArea.append(txtEnterCommand.getText()+"\n");
				 break;
				 
				 case "proc":
				 System.out.println("processesing");
				 textArea.append(txtEnterCommand.getText()+"\n");
				 break;
				 
				 case "mem": 
				 System.out.println("mem");
				 textArea.append(txtEnterCommand.getText()+"\n");
				 break;
				 
				 case "reset": 
				 System.out.println("reseting");
				 textArea.append(txtEnterCommand.getText()+"\n");
				 break;
				 
				 case "exit":
				 textArea.append(txtEnterCommand.getText()+"\n");
				 System.exit(0);
				 break;
				 default:
				 {JOptionPane.showMessageDialog(null, "Invalid command");}
				 break;
				 
				 }
						 

			}
		
			});
			
		
		 txtEnterCommand.setText("");//clears the text field after entering
		String s = getProcessName();

		 txtEnterCommand.setColumns(10);
			
//			table_1 = new JTable();
//			table_1.setEnabled(false);
//			table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
//		table_1.setModel(new DefaultTableModel(
//		new Object[][] {
//				
//				
//				{s, 1000000, "ditto", "sadf", "adsf", "asdf"},
//				{"in my eyes", null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//			},
//			new String[] {
//				"Process", "Size", "Arrival Time", "Run Time", "Status", "Last Command"
//			}
//		));
		

		
		JLabel lblProcess = new JLabel("Process");
		lblProcess.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		lblArrivalTime = new JLabel("Arrival Time");
		lblArrivalTime.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		lblNewLabel = new JLabel("Run Time");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		lblNewLabel_1 = new JLabel("Status");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		lblLastCommand = new JLabel("Last Command");
		lblLastCommand.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		
		
	
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
						.addComponent(table, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
						.addComponent(txtEnterCommand, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(lblProcess)
							.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
							.addComponent(lblSize)
							.addGap(39)
							.addComponent(lblArrivalTime)
							.addGap(33)
							.addComponent(lblNewLabel_1)
							.addGap(44)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(lblLastCommand)
							.addGap(23)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProcess)
						.addComponent(lblLastCommand)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblArrivalTime)
						.addComponent(lblSize))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(txtEnterCommand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
}
	public void setProcessName(String s) {
		processName = s;
	}
	public String getProcessName() {
		return processName;
	}
}	

