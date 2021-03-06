package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import caRo.GameWorld;

public class Panel2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel p6, p4, p5, p7, p8, p9;
	private JLabel lb1;
	public JLabel lb2;
	private JLabel lbHinh2;;
	private JButton btAbout, btExit;
	public JButton btNewGame;
	private JButton btOption;

	private GameWorld swing;

	public Panel2(GameWorld swing) {

		this.swing = swing;

		setThongSo();

		create();

		setDeleteBackGroundandBorder();

		action();

		setBorder();

	}

	public void action() {
		btNewGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				swing.panel3.newMatch();
			}
		});
		btExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				swing.panel3.exit();
			}
		});
		btOption.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// dinggggggggg
				if (swing.panel3.effor == false) {
					try {
						swing.getSound().musicDing();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ee) {
						ee.printStackTrace();
					}
				}

				swing.panel3.t.stop();
				swing.createSetting();
			}
		});
		btAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				about();
			}
		});
	}

	public void setBorder() {
		p6.setBorder(new BevelBorder(BevelBorder.LOWERED));
		p8.setBorder(new BevelBorder(BevelBorder.LOWERED));
		p5.setBorder(new BevelBorder(BevelBorder.RAISED, Color.white, Color.black));
	}

	public void setDeleteBackGroundandBorder() {
		btNewGame.setContentAreaFilled(false);
		btNewGame.setBorderPainted(false);
		btOption.setContentAreaFilled(false);
		btOption.setBorderPainted(false);
		btAbout.setContentAreaFilled(false);
		btAbout.setBorderPainted(false);
		btExit.setContentAreaFilled(false);
		btExit.setBorderPainted(false);
	}

	public void create() {
		add(p6 = new JPanel());
		p6.setBackground(new Color(255, 234, 184));
		p6.add(lb1 = new JLabel(new ImageIcon("image/hinh1.png")));
		lb1.setPreferredSize(new Dimension(300, 300));

		// t???o p4

		add(p4 = new JPanel());
		p4.setBackground(new Color(255, 234, 184));
		p4.setLayout(new GridLayout(1, 2));
		p4.add(p7 = new JPanel());
		p7.setLayout(new BoxLayout(p7, BoxLayout.Y_AXIS));
		p7.add(p8 = new JPanel());
		p7.add(p9 = new JPanel());
		p8.setBackground(new Color(255, 234, 184));
		p9.setBackground(new Color(255, 234, 184));
		p8.add(lb2 = new JLabel());
		p9.add(setLbHinh2(new JLabel(new ImageIcon("image/lbHinh2.png"))));
		p7.setBackground(new Color(255, 234, 184));
		lb2.setIcon(new ImageIcon("image/xLabel.png"));

		// t???o p5

		p4.add(p5 = new JPanel());
		p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));
		p5.setBackground(new Color(255, 234, 184));
		p5.add(btNewGame = new JButton());
		p5.add(btOption = new JButton());
		p5.add(btAbout = new JButton());
		p5.add(btExit = new JButton());
		btNewGame.setToolTipText("Nh???n ????? l??m v??n m???i");
		btOption.setToolTipText("Nh???n ????? c??i ?????t");
		btAbout.setToolTipText("Nh???n ????? xem h?????ng d???n v?? th??ng tin ph??t tri???n");
		btExit.setToolTipText("Nh???n ????? tho??t");
//		btNewGame.setIcon(new ImageIcon("image/newGame.png"));
		btOption.setIcon(new ImageIcon("image/option.png"));
		btAbout.setIcon(new ImageIcon("image/help.png"));
		btExit.setIcon(new ImageIcon("image/exit.png"));
	}

	public void setThongSo() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(new Color(255, 234, 184));
		setPreferredSize(new Dimension(350, 710));
	}

	public void about() {

		if (swing.panel3.effor == false) {
			try {
				swing.getSound().musicDing();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
		}

		swing.panel3.t.stop();
		String s = "";
		s = s + "1. Game c?? b??n c??? l?? 20x20 ( C?? th??? thay ?????i trong ph???n option).\n";
		s = s + "2. ????? b???t ?????u game, tr?????c h???t b???n ph???i nh???p t??n c???a 2 ng?????i ch??i v??o 2 ?? textField ??? b??n ph???i m??n h??nh, sau ???? nh???t Start ho???c ph??m ENTER ????? b???t ?????u ch??i.\n";
		s = s + "3. Ng?????i n??o t???o ???????c 5 ?? c??ng h??ng(ch??o , ngang , d???c) v?? kh??ng b??? ng?????i kia ch???n 2 ?????u th?? s??? th???ng.\n";
		s = s + "4. Th???i gian suy ngh?? l?? 20 gi??y ( C?? th??? thay ?????i trong option) cho m???i ng?????i , h???t th???i gian suy ngh?? m?? kh??ng ????a ra n?????c ??i th?? b??? x??? thua v??n ????.\n";
		s = s + "5. Ai thua th?? v??n sau s??? ???????c ????nh tr?????c ????? ?????m b???o c??ng b???ng :D.\n";
		s = s + "6. Nh???n v??o reset ????? kh???i t???o l???i ch?? ch??i (Nh???p t??n ng?????i ch??i m???i, ?????t l???i s??? ??i???m,....).\n";
		s = s + "7. Game c?? t??ch h???p Undo ( Ctrl Z ) v?? Redo ( Ctrl Y ) ????? d??ng khi ????nh nh???m ch???ng h???n :D.\n";
		s = s + "8. B???n c?? th??? c??i ?????t ??m l?????ng nh???c n???n hay nh???c hi???u ???ng to l??n hay nh??? xu???ng trong ph???n c??i ?????t.\n";
		s = s + "9. M???t s??? ph??m t???t trong game:\n - Ctrl + Z : Undo.\n - Ctrl + Y : Redo.\n - Ctrl + X : B???t t???t nh???c n???n.\n - Ctrl + C : B???t t???t ??m thanh hi???u ???ng.\n - Ctrl + Q : Tho??t game.\n - Ctrl + R : T???o m???i tr?? ch??i.\n - Ctrl + N : New game.\n - Ctrl + M : New match.\n - Ctrl + A : H?????ng d???n.\n";
		s = s + "10. N???u c?? g??p ?? n??o ho???c l???i th?? mong c??c b???n g???i qua cho m??nh :((  :\n   - Link fb: https://www.facebook.com/hvvien2k.\n   -  Gmail: 18130281@st.hcmuaf.edu.vn.\n :>";
		int a = JOptionPane.showConfirmDialog(null, s, "About ?", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, new ImageIcon("image/about.png"));
		if (a == JOptionPane.OK_OPTION) {
			if (swing.panel3.effor == false) {
				try {
					swing.getSound().musicPop();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
					e.printStackTrace();
				}
			}
			if (swing.panel3.statrr == true) {
				int count = 0;
				for (int i = 0; i < swing.arr.length; i++) {
					for (int j = 0; j < swing.arr[i].length; j++) {
						if (swing.arr[i][j] != 0)
							count++;
					}
				}
				if (count != 0) {
					swing.panel3.t.start();
				}
			}
		} else {
			if (swing.panel3.effor == false) {
				try {
					swing.getSound().musicPop();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
					e.printStackTrace();
				}
			}
			if (swing.panel3.statrr == true) {
				int count = 0;
				for (int i = 0; i < swing.arr.length; i++) {
					for (int j = 0; j < swing.arr[i].length; j++) {
						if (swing.arr[i][j] != 0)
							count++;
					}
				}
				if (count != 0) {
					swing.panel3.t.start();
				}
			}
		}
	}

	public JLabel getLbHinh2() {
		return lbHinh2;
	}

	public JLabel setLbHinh2(JLabel lbHinh2) {
		this.lbHinh2 = lbHinh2;
		return lbHinh2;
	}

}
