package com.SoltMachine.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ViewFront extends JFrame {

	private JPanel contentPane;
	public JTextField tf_lastWin;
	public JTextField tf_totSpin;
	public JTextField tf_bet;

	public JLabel la_img, la_img2, la_img3,aa;
	public JButton bt_spin;
	public ImageIcon imageArr[] = new ImageIcon[6];
	public int rdArr[];
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ViewFront() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		bt_spin = new JButton("SPIN");
		bt_spin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_spin.setBounds(229, 107, 64, 37);
		contentPane.add(bt_spin);

		JLabel lblNewLabel = new JLabel("LAST WIN");
		lblNewLabel.setBounds(30, 107, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel lblTotalSpin = new JLabel("TOTAL SPIN");
		lblTotalSpin.setBounds(99, 107, 78, 15);
		contentPane.add(lblTotalSpin);

		JLabel lblBet = new JLabel("BET");
		lblBet.setBounds(187, 107, 30, 15);
		contentPane.add(lblBet);

		tf_lastWin = new JTextField();
		tf_lastWin.setEditable(false);
		tf_lastWin.setBounds(30, 123, 57, 21);
		contentPane.add(tf_lastWin);
		tf_lastWin.setColumns(10);

		tf_totSpin = new JTextField();
		tf_totSpin.setEditable(false);
		tf_totSpin.setColumns(10);
		tf_totSpin.setBounds(109, 123, 50, 21);
		contentPane.add(tf_totSpin);

		tf_bet = new JTextField();
		tf_bet.setEditable(false);
		tf_bet.setColumns(10);
		tf_bet.setBounds(187, 123, 30, 21);
		contentPane.add(tf_bet);
		
		la_img = new JLabel("IMG1");
		la_img.setBounds(28, 10, 78, 70);
		contentPane.add(la_img);

		la_img2 = new JLabel("IMG2");
		la_img2.setBounds(118, 10, 78, 70);
		contentPane.add(la_img2);

		la_img3 = new JLabel("IMG3");
		la_img3.setBounds(208, 10, 78, 70);
		contentPane.add(la_img3);
		setVisible(true);
		setIcon();
		rdArr = new int[3];
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void setIcon(){
		
		imageArr[0] = new ImageIcon("slotImage/bar.png");
		imageArr[1] = new ImageIcon("slotImage/bigwin.png");
		imageArr[2] = new ImageIcon("slotImage/cherry.png");
		imageArr[3] = new ImageIcon("slotImage/seven.png");
		imageArr[4] = new ImageIcon("slotImage/sweetMelon.png");
		imageArr[5] = new ImageIcon("slotImage/banana.png");
		for (int i = 0; i < imageArr.length; i++) {
			imageArr[i] = resizeIcon(imageArr[i], 78,70);
		}
	}
	public void spinImage(){
		Random rd = new Random();
		for (int i = 0; i < rdArr.length; i++) {
			rdArr[i]=rd.nextInt(6);
		}					
		la_img.setIcon(imageArr[rdArr[0]]);
		la_img2.setIcon(imageArr[rdArr[1]]);
		la_img3.setIcon(imageArr[rdArr[2]]);
	}
	private ImageIcon resizeIcon(ImageIcon imageIcon,int h,int w){
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(h, w,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		return new ImageIcon(newimg);// transform it back
	}

}
