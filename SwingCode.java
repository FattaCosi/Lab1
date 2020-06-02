import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingCode {
	
	private JFrame frame;
	private JPanel panel;
	private JLabel lbl1;
	private JLabel lbl2;
	private JTextField txt1;
	private JTextField txt2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lblOut1;
	private JLabel lblOut2;
	private JButton btn1;
	private JButton btn2;
	
	SwingCode()
	{
		frame = new JFrame();
		frame.setSize(800, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel(new GridLayout(2,5,3,3));

		frame.add(panel);
		
		lbl1 = new JLabel("Íåøèôðîâàííûé òåêñò:");
		lbl2 = new JLabel("Çàøèôðîâàííûé òåêñò:");
		txt1 = new JTextField();
		txt2 = new JTextField();
		lbl3 = new JLabel("Çàøèôðîâàííûé òåêñò:");
		lbl4 = new JLabel("Ðàñøèôðîâàííûé òåêñò:");
		lblOut1 = new JLabel();
		lblOut2 = new JLabel();
		
		btn1 = new JButton("Çàøèôðîâàòü");
		btn1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				lblOut1.setText(EncodeString(txt1.getText()));
				
			
				Toolkit
				.getDefaultToolkit()
				.getSystemClipboard()
				.setContents(new StringSelection(lblOut1.getText()), null);
			}
		});
		
		btn2 = new JButton("Ðàñøèôðîâàòü");
		btn2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				lblOut2.setText(EncodeString(txt2.getText()));
				
				Toolkit
				.getDefaultToolkit()
				.getSystemClipboard()
				.setContents(new StringSelection(lblOut1.getText()), null);
			}
		});
		
		panel.add(lbl1);
		panel.add(txt1);
		panel.add(lbl3);
		panel.add(lblOut1);
		panel.add(btn1);
		
		panel.add(lbl2);
		panel.add(txt2);
		panel.add(lbl4);
		panel.add(lblOut2);
		panel.add(btn2);
		
		frame.setVisible(true);
	}
	
	private String EncodeString(String input)
	{
		
		String output = "";
		byte arr[] = input.getBytes();
		
		for(int i = 0; i < input.length(); i++)
		{
			if(arr[i] >= ' ' && arr[i] <= '~')
			{
				if(arr[i] < 'O')	
				{
					arr[i] += 48;
				}
				else if (arr[i] > 'O')
				{
					arr[i] -= 48;
				}
			}
			output += (char)arr[i];
		}
		
		return output;
	}
}
