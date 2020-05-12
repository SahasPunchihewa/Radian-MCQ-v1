package Sahas;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;

import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
public class MCQ extends JFrame implements ActionListener,ItemListener{
JFrame f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27,l28,l32,l33,l34,l35,l36,l37,l38,l39,l40,l41,l42,l43,l44,l45,l46,l47,l48,l49,l50;
JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15,lb16,lb17,lb18,lb19,lb20;
JTextArea t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
JPasswordField p1,p2,p3,p4;;
JCheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20;
JMenuBar jmb1,jmb2;
JMenu jm1,jm2;
JMenuItem jmi1,jmi2,jmi3,jmi4,jmi5;
JFileChooser fc1;
File fi1,fil;;
int qn=1,answ=0,an=1,pla=0,pq=9,ac=1,ne=0,log=1,sign=0,clog=0,n=1,nw=0,ans=0,nc=0,x,y,lb=1,max=0,maxn=0,min=0,minn=0,rank=0,qa=0,ses=1,sesdb=0,nol=0,edi=0,sesr=0,res,nimg=0,sc=0,stna=0,stni=0,jop;
String a1,a2,a3,a4,a5,cans,un,pw,sun,spw,path1="",stma,stmi,ip;
static Connection con;
GraphicsEnvironment ge;
GraphicsDevice Screen;
Rectangle rect;
PreparedStatement sta;
FileInputStream fist;
ResultSet rs;
InputStream ist;
OutputStream out;
FileOutputStream fos;
BufferedImage buf1,buf2;
byte b[];
Blob blo;
Image rimg,rimg2;
String[] JOPB = {"Retry","Cancel"};
public MCQ()
{
	//b9,l29,l30,l31 is awailable
	ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
	Screen=ge.getDefaultScreenDevice();
	rect=Screen.getDefaultConfiguration().getBounds();
	x=(int)(rect.getMaxX());
	y=(int)(rect.getMaxY());
	f10=new JFrame();
	f10.setUndecorated(true);
	lb10=new JLabel("");
	lb10.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/load.png")));
	lb10.setSize(400,200);
	f10.setState(ICONIFIED);
	f10.setLocation((x/2)-200,(y/2)-100);
	l22=new JLabel("");
	l22.setHorizontalAlignment(SwingConstants.CENTER);
	l22.setHorizontalTextPosition(SwingConstants.CENTER);
	l22.setForeground(Color.WHITE);
	l22.setFont(new Font("Century Gothic", Font.BOLD, 12));
	l22.setLocation(61, 144);
	l22.setSize(277, 25);
	l22.setText("Initializing Variables...");
	lb16=new JLabel();
	lb16.setIcon(new ImageIcon(MCQ.class.getResource("/ICO/IconM.png")));
	lb16.setBounds(10,11,120,120);
	load(f10);
	f1=new JFrame();
	f1.setIconImage(Toolkit.getDefaultToolkit().getImage(MCQ.class.getResource("/ICO/IconS.png")));
	f1.setResizable(false);
	f2=new JFrame();
	f2.setResizable(false);
	f2.setIconImage(Toolkit.getDefaultToolkit().getImage(MCQ.class.getResource("/ICO/IconS.png")));
	f3=new JFrame();
	f3.setIconImage(Toolkit.getDefaultToolkit().getImage(MCQ.class.getResource("/ICO/IconS.png")));
	f3.setResizable(false);
	f4=new JFrame();
	f4.setResizable(false);
	f4.setIconImage(Toolkit.getDefaultToolkit().getImage(MCQ.class.getResource("/ICO/IconS.png")));
	f5=new JFrame();
	f5.setResizable(false);
	f5.setIconImage(Toolkit.getDefaultToolkit().getImage(MCQ.class.getResource("/ICO/IconS.png")));
	f6=new JFrame();
	f6.setIconImage(Toolkit.getDefaultToolkit().getImage(MCQ.class.getResource("/ICO/IconS.png")));
	f6.setResizable(false);
	f7=new JFrame();
	f7.setResizable(false);
	f7.setIconImage(Toolkit.getDefaultToolkit().getImage(MCQ.class.getResource("/ICO/IconS.png")));
	f8=new JFrame();
	f8.setResizable(false);
	f8.setIconImage(Toolkit.getDefaultToolkit().getImage(MCQ.class.getResource("/ICO/IconS.png")));
	f9=new JFrame();
	f9.setResizable(false);
	f9.setIconImage(Toolkit.getDefaultToolkit().getImage(MCQ.class.getResource("/ICO/IconS.png")));
	f11=new JFrame();
	f11.setResizable(false);
	f11.setIconImage(Toolkit.getDefaultToolkit().getImage(MCQ.class.getResource("/ICO/IconS.png")));
	f12=new JFrame();
	f12.setResizable(false);
	f12.setIconImage(Toolkit.getDefaultToolkit().getImage(MCQ.class.getResource("/ICO/IconS.png")));
	f10.setState(NORMAL);
	l22.setText("Loading Database...");
	db();
	l22.setText("Setting Attibutes...");
	l1=new JLabel("Username");
	l1.setForeground(Color.WHITE);
	l1.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l2=new JLabel("The MCQ");
	l2.setVerticalTextPosition(SwingConstants.TOP);
	l2.setForeground(Color.WHITE);
	l2.setFont(new Font("Century Gothic", Font.BOLD, 20));
	l2.setVerticalAlignment(SwingConstants.TOP);
	l2.setAlignmentX(Component.CENTER_ALIGNMENT);
	l3=new JLabel("Search Question No");
	l3.setForeground(Color.WHITE);
	l3.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l4=new JLabel("Question");
	l4.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l4.setForeground(Color.WHITE);
	l5=new JLabel("Username");
	l5.setForeground(Color.WHITE);
	l5.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l6=new JLabel("Password");
	l6.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l6.setForeground(Color.WHITE);
	l7=new JLabel("Password");
	l7.setForeground(Color.WHITE);
	l7.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l8=new JLabel("Or");
	l8.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l8.setForeground(Color.WHITE);
	l8.setHorizontalAlignment(SwingConstants.CENTER);
	l8.setHorizontalTextPosition(SwingConstants.CENTER);
	l8.setAlignmentX(Component.CENTER_ALIGNMENT);
	l9=new JLabel("Username");
	l9.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l9.setForeground(Color.WHITE);
	l10=new JLabel("password");
	l10.setForeground(Color.WHITE);
	l10.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l11=new JLabel("<html>Confirm Password</html>");
	l11.setForeground(Color.WHITE);
	l11.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l12=new JLabel("N/A of N/A Are Correct");
	l12.setHorizontalTextPosition(SwingConstants.CENTER);
	l12.setHorizontalAlignment(SwingConstants.CENTER);
	l12.setBorder(null);
	l12.setVerticalTextPosition(SwingConstants.TOP);
	l12.setVerticalAlignment(SwingConstants.TOP);
	l12.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l12.setForeground(Color.WHITE);
	l13=new JLabel("<html>Welcome to M.C.Q Challenge.</html>");
	l13.setHorizontalAlignment(SwingConstants.CENTER);
	l13.setForeground(Color.WHITE);
	l13.setFont(new Font("Century Gothic", Font.BOLD, 24));
	l14=new JLabel("<html>You Can Select one of below two sections.</html>");
	l14.setVerticalAlignment(SwingConstants.TOP);
	l14.setForeground(Color.WHITE);
	l14.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l15=new JLabel("<html>Please Log in to Your Teacher's Account</html>");
	l15.setHorizontalAlignment(SwingConstants.CENTER);
	l15.setForeground(Color.WHITE);
	l15.setFont(new Font("Century Gothic", Font.BOLD, 22));
	l16=new JLabel("<html><center>Please Log in to Your Student Account or Create New Account</center></html>");
	l16.setHorizontalTextPosition(SwingConstants.LEADING);
	l16.setForeground(Color.WHITE);
	l16.setFont(new Font("Century Gothic", Font.BOLD, 22));
	l17=new JLabel("<html><center>Create New Account</center></html>");
	l17.setHorizontalAlignment(SwingConstants.CENTER);
	l17.setForeground(Color.WHITE);
	l17.setFont(new Font("Century Gothic", Font.BOLD, 22));
	l18=new JLabel("<html><center>Welcome</center></html>");
	l18.setHorizontalAlignment(SwingConstants.CENTER);
	l18.setFont(new Font("Century Gothic", Font.BOLD, 22));
	l18.setForeground(Color.WHITE);
	l19=new JLabel("<html><center>You Can Answer Questions or You Can See Your Status.</center></html>");
	l19.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l19.setForeground(Color.WHITE);
	l20=new JLabel("<html><center>Your Status</html></center>");
	l20.setHorizontalAlignment(SwingConstants.CENTER);
	l20.setForeground(Color.WHITE);
	l20.setFont(new Font("Century Gothic", Font.BOLD, 22));
	l21=new JLabel("<html><center>Radian is an application for Answer new Questions, Making new Questions made by Sahas Punchihewa<br><br></html></center>");
	l21.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l21.setForeground(Color.WHITE);
	l23=new JLabel("Or");
	l23.setHorizontalTextPosition(SwingConstants.CENTER);
	l23.setHorizontalAlignment(SwingConstants.CENTER);
	l23.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l23.setForeground(Color.WHITE);
	l24=new JLabel("Student");
	l24.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l24.setHorizontalAlignment(SwingConstants.CENTER);
	l24.setForeground(Color.WHITE);
	l25=new JLabel("Teacher");
	l25.setHorizontalAlignment(SwingConstants.CENTER);
	l25.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l25.setForeground(Color.WHITE);
	l26=new JLabel("Or");
	l26.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l26.setForeground(Color.WHITE);
	l27=new JLabel("Answer Questions");
	l27.setHorizontalTextPosition(SwingConstants.CENTER);
	l27.setHorizontalAlignment(SwingConstants.CENTER);
	l27.setForeground(Color.WHITE);
	l27.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l28=new JLabel("Your Marks");
	l28.setHorizontalAlignment(SwingConstants.CENTER);
	l28.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l28.setForeground(Color.WHITE);
	l32=new JLabel("<html>Radian<br>1.0.0.0<br>\u00A9 2018 Allright Reserved</html>");
	l32.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l32.setForeground(Color.WHITE);
	l33=new JLabel("Highest Marks is N/A");
	l33.setHorizontalTextPosition(SwingConstants.CENTER);
	l33.setHorizontalAlignment(SwingConstants.CENTER);
	l33.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l33.setForeground(Color.WHITE);
	l34=new JLabel("Lowest Marks is N/A");
	l34.setHorizontalTextPosition(SwingConstants.CENTER);
	l34.setHorizontalAlignment(SwingConstants.CENTER);
	l34.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l34.setForeground(Color.WHITE);
	l35=new JLabel("Your Rank is N/A");
	l35.setHorizontalTextPosition(SwingConstants.CENTER);
	l35.setHorizontalAlignment(SwingConstants.CENTER);
	l35.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l35.setForeground(Color.WHITE);
	l36=new JLabel();
	l37=new JLabel("Add an Image");
	l37.setForeground(Color.WHITE);
	l37.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l38=new JLabel("New Test");
	l38.setHorizontalAlignment(SwingConstants.CENTER);
	l38.setForeground(Color.WHITE);
	l38.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l39=new JLabel("Edit Test");
	l39.setHorizontalAlignment(SwingConstants.CENTER);
	l39.setForeground(Color.WHITE);
	l39.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l40=new JLabel("Welcome");
	l40.setHorizontalAlignment(SwingConstants.CENTER);
	l40.setFont(new Font("Century Gothic", Font.BOLD, 20));
	l40.setForeground(Color.WHITE);
	l41=new JLabel("Plese Create New Test or Edit Existing Test");
	l41.setHorizontalAlignment(SwingConstants.LEFT);
	l41.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l41.setForeground(Color.WHITE);
	l42=new JLabel("Or");
	l42.setFont(new Font("Century Gothic", Font.BOLD, 18));
	l42.setForeground(Color.WHITE);
	l43=new JLabel();
	lb1=new JLabel();
	lb1.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/Read.png")));
	lb2=new JLabel();
	lb2.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/Write.png")));
	lb3=new JLabel("");
	lb3.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/Log.png")));
	lb4=new JLabel("");
	lb4.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/Log.png")));
	lb5=new JLabel("");
	lb5.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/Switch.png")));
	lb6=new JLabel("");
	lb6.setHorizontalAlignment(SwingConstants.CENTER);
	lb6.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/Create.png")));
	lb7=new JLabel("");
	lb7.setVerticalAlignment(SwingConstants.TOP);
	lb7.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/STSwitch.png")));
	lb8=new JLabel("");
	lb8.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/Stat.png")));
	lb9=new JLabel("");
	lb9.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/About.png")));
	lb10=new JLabel();
	lb10.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/Trance.png")));
	lb11=new JLabel();
	lb11.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/Trance.png")));
	lb12=new JLabel();
	lb12.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/Trance.png")));
	lb13=new JLabel();
	lb13.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/Trance.png")));
	lb14=new JLabel();
	lb14.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/Trance.png")));
	lb15=new JLabel();
	lb15.setIcon(new ImageIcon(MCQ.class.getResource("/ICO/IconL.png")));
	lb17=new JLabel();
	lb17.setVerticalAlignment(SwingConstants.TOP);
	lb17.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/NTest.png")));
	lb18=new JLabel();
	lb18.setLocation(0, 0);
	t1=new JTextArea();
	t1.setFont(new Font("Monospaced", Font.PLAIN, 15));
	t2=new JTextArea();
	t2.setWrapStyleWord(true);
	t2.setLineWrap(true);
	t2.setFont(new Font("Monospaced", Font.PLAIN, 15));
	t2.setColumns(1);
	t3=new JTextArea();
	t3.setFont(new Font("Monospaced", Font.PLAIN, 15));
	t4=new JTextArea();
	t4.setFont(new Font("Monospaced", Font.PLAIN, 15));
	t5=new JTextArea();
	t5.setFont(new Font("Monospaced", Font.PLAIN, 15));
	t6=new JTextArea();
	t6.setFont(new Font("Monospaced", Font.PLAIN, 15));
	t7=new JTextArea();
	t7.setFont(new Font("Monospaced", Font.PLAIN, 15));
	t8=new JTextArea();
	t9=new JTextArea();
	t9.setFont(new Font("Monospaced", Font.PLAIN, 15));
	t10=new JTextArea();
	t11=new JTextArea();
	t12=new JTextArea();
	p1=new JPasswordField();
	p1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	p1.setBorder(null);
	p1.setEchoChar('*');
	p2=new JPasswordField();
	p2.setBorder(null);
	p2.setEchoChar('*');
	p3=new JPasswordField();
	p3.setBorder(null);
	p3.setEchoChar('*');
	p4=new JPasswordField();
	p4.setBorder(null);
	p4.setEchoChar('*');
	l22.setText("Initializing Buttons...");
	b1=new JButton("");
	b1.setIcon(new ImageIcon(MCQ.class.getResource("/Button/Sub.png")));
	b1.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/Sub2.png")));
	b1.setBorder(null);
	b1.setContentAreaFilled(false);
	b2=new JButton("");
	b2.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/StuSelect2.png")));
	b2.setBorder(null);
	b2.setContentAreaFilled(false);
	b2.setIcon(new ImageIcon(MCQ.class.getResource("/Button/StuSelect.png")));
	b3=new JButton("");
	b3.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/TSelect2.png")));
	b3.setIcon(new ImageIcon(MCQ.class.getResource("/Button/TSelect.png")));
	b3.setContentAreaFilled(false);
	b3.setBorder(null);
	b4=new JButton("Sign in");
	b4.setFont(new Font("Century Gothic", Font.BOLD, 18));
	b4.setForeground(Color.BLACK);
	b5=new JButton("Cancel");
	b5.setFont(new Font("Century Gothic", Font.BOLD, 18));
	b5.setForeground(Color.BLACK);
	b6=new JButton("");
	b6.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/Add2.png")));
	b6.setIcon(new ImageIcon(MCQ.class.getResource("/Button/Add.png")));
	b6.setContentAreaFilled(false);
	b6.setBorder(null);
	b7=new JButton("");
	b7.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/Edit2.png")));
	b7.setIcon(new ImageIcon(MCQ.class.getResource("/Button/Edit.png")));
	b7.setContentAreaFilled(false);
	b7.setBorder(null);
	b8=new JButton("");
	b8.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/Search2.png")));
	b8.setIcon(new ImageIcon(MCQ.class.getResource("/Button/Search.png")));
	b8.setContentAreaFilled(false);
	b8.setBorder(null);
	b10=new JButton("");
	b10.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/Clear2.png")));
	b10.setIcon(new ImageIcon(MCQ.class.getResource("/Button/Clear.png")));
	b10.setContentAreaFilled(false);
	b10.setBorder(null);
	b11=new JButton("");
	b11.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/Next2.png")));
	b11.setIcon(new ImageIcon(MCQ.class.getResource("/Button/Next.png")));
	b11.setBorder(null);
	b11.setContentAreaFilled(false);
	b12=new JButton("");
	b12.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/Pre2.png")));
	b12.setIcon(new ImageIcon(MCQ.class.getResource("/Button/Pre.png")));
	b12.setBorder(null);
	b12.setContentAreaFilled(false);
	b13=new JButton("Sign In");
	b13.setVerticalTextPosition(SwingConstants.TOP);
	b13.setForeground(Color.BLACK);
	b13.setFont(new Font("Century Gothic", Font.BOLD, 18));
	b13.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/Signin2.png")));
	b13.setIcon(null);
	b14=new JButton("Cancel");
	b14.setVerticalTextPosition(SwingConstants.TOP);
	b14.setForeground(Color.BLACK);
	b14.setFont(new Font("Century Gothic", Font.BOLD, 18));
	b14.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/Cancel2.png")));
	b14.setIcon(null);
	b15=new JButton("Sign Up");
	b15.setVerticalTextPosition(SwingConstants.TOP);
	b15.setForeground(Color.BLACK);
	b15.setFont(new Font("Century Gothic", Font.BOLD, 18));
	b15.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/Signup2.png")));
	b15.setIcon(null);
	b16=new JButton("Create");
	b16.setVerticalTextPosition(SwingConstants.TOP);
	b16.setFont(new Font("Century Gothic", Font.BOLD, 18));
	b16.setForeground(Color.BLACK);
	b17=new JButton("Cancel");
	b17.setVerticalTextPosition(SwingConstants.TOP);
	b17.setFont(new Font("Century Gothic", Font.BOLD, 18));
	b17.setForeground(Color.BLACK);
	b18=new JButton("");
	b18.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/QSelect2.png")));
	b18.setIcon(new ImageIcon(MCQ.class.getResource("/Button/QSelect.png")));
	b18.setContentAreaFilled(false);
	b18.setBorder(null);
	b19=new JButton("");
	b19.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/StatSelect2.png")));
	b19.setIcon(new ImageIcon(MCQ.class.getResource("/Button/StatSelect.png")));
	b19.setContentAreaFilled(false);
	b19.setBorder(null);
	b20=new JButton("");
	b20.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/About2.png")));
	b20.setBorder(null);
	b20.setContentAreaFilled(false);
	b20.setIcon(new ImageIcon(MCQ.class.getResource("/Button/About.png")));
	b21=new JButton("");
	b21.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/NewT2.png")));
	b21.setIcon(new ImageIcon(MCQ.class.getResource("/Button/NewT.png")));
	b21.setContentAreaFilled(false);
	b21.setBorder(null);
	b22=new JButton("");
	b22.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/EditT2.png")));
	b22.setIcon(new ImageIcon(MCQ.class.getResource("/Button/EditT.png")));
	b22.setContentAreaFilled(false);
	b22.setBorder(null);
	b23=new JButton("");
	b23.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/Button/Image2.png")));
	b23.setIcon(new ImageIcon(MCQ.class.getResource("/Button/Image.png")));
	b23.setBorder(null);
	b23.setContentAreaFilled(false);
	b24=new JButton("");
	b24.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/IMG/Trance.png")));
	b24.setIcon(new ImageIcon(MCQ.class.getResource("/IMG/Trance2.png")));
	b24.setContentAreaFilled(false);
	b24.setBorder(null);
	b25=new JButton("Ok");
	b26=new JButton("Cancel");
	c1=new JCheckBox("I");
	c1.setForeground(Color.WHITE);
	c1.setFont(new Font("Century Gothic", Font.BOLD, 18));
	c1.setContentAreaFilled(false);
	c2=new JCheckBox("II");
	c2.setFont(new Font("Century Gothic", Font.BOLD, 18));
	c2.setForeground(Color.WHITE);
	c2.setContentAreaFilled(false);
	c3=new JCheckBox("III");
	c3.setForeground(Color.WHITE);
	c3.setFont(new Font("Century Gothic", Font.BOLD, 18));
	c3.setContentAreaFilled(false);
	c4=new JCheckBox("IV");
	c4.setFont(new Font("Century Gothic", Font.BOLD, 18));
	c4.setForeground(Color.WHITE);
	c4.setContentAreaFilled(false);
	c5=new JCheckBox("V");
	c5.setForeground(Color.WHITE);
	c5.setFont(new Font("Century Gothic", Font.BOLD, 18));
	c5.setContentAreaFilled(false);
	c6=new JCheckBox("I)");
	c6.setForeground(Color.WHITE);
	c6.setFont(new Font("Century Gothic", Font.BOLD, 18));
	c6.setContentAreaFilled(false);
	c6.setVerticalAlignment(SwingConstants.TOP);
	c7=new JCheckBox("II)");
	c7.setForeground(Color.WHITE);
	c7.setFont(new Font("Century Gothic", Font.BOLD, 18));
	c7.setContentAreaFilled(false);
	c7.setVerticalAlignment(SwingConstants.TOP);
	c8=new JCheckBox("III)");
	c8.setForeground(Color.WHITE);
	c8.setFont(new Font("Century Gothic", Font.BOLD, 18));
	c8.setContentAreaFilled(false);
	c8.setVerticalAlignment(SwingConstants.TOP);
	c9=new JCheckBox("IV)");
	c9.setForeground(Color.WHITE);
	c9.setFont(new Font("Century Gothic", Font.BOLD, 18));
	c9.setContentAreaFilled(false);
	c9.setVerticalAlignment(SwingConstants.TOP);
	c10=new JCheckBox("V)");
	c10.setForeground(Color.WHITE);
	c10.setFont(new Font("Century Gothic", Font.BOLD, 18));
	c10.setContentAreaFilled(false);
	c10.setVerticalAlignment(SwingConstants.TOP);
	c11=new JCheckBox("Show/Hide");
	c11.setForeground(Color.WHITE);
	c11.setFont(new Font("Century Gothic", Font.BOLD, 18));
	c11.setContentAreaFilled(false);
	c12=new JCheckBox("Show/Hide");
	c12.setFont(new Font("Century Gothic", Font.BOLD, 18));
	c12.setForeground(Color.WHITE);
	c12.setContentAreaFilled(false);
	c13=new JCheckBox("Show/Hide");
	c13.setFont(new Font("Century Gothic", Font.BOLD, 18));
	c13.setForeground(Color.WHITE);
	c13.setContentAreaFilled(false);
	c14=new JCheckBox("Show/Hide");
	c14.setFont(new Font("Century Gothic", Font.BOLD, 18));
	c14.setForeground(Color.WHITE);
	c14.setContentAreaFilled(false);
	l22.setText("setting bounds...");
	jmb1=new JMenuBar();
	jmb1.setBorderPainted(false);
	jmb1.setBorder(null);
	jmb1.setOpaque(false);
	jmb2=new JMenuBar();
	jmb2.setBorderPainted(false);
	jmb2.setBorder(null);
	jmb2.setOpaque(false);
	jm1=new JMenu("");
	jm1.setHorizontalTextPosition(SwingConstants.CENTER);
	jm1.setHorizontalAlignment(SwingConstants.CENTER);
	jm1.setIcon(new ImageIcon(MCQ.class.getResource("/Button/Menu.png")));
	jm1.setContentAreaFilled(false);
	jm1.setBorder(null);
	jm2=new JMenu("");
	jm2.setHorizontalAlignment(SwingConstants.CENTER);
	jm2.setIcon(new ImageIcon(MCQ.class.getResource("/Button/Menu.png")));
	jm2.setContentAreaFilled(false);
	jm2.setBorder(null);
	jmi3=new JMenuItem("Your Status");
	jmi3.setContentAreaFilled(false);
	jmi3.setIcon(new ImageIcon(MCQ.class.getResource("/ICO/StatSelectS.png")));
	jmi5=new JMenuItem("About");
	jmi5.setIcon(new ImageIcon(MCQ.class.getResource("/ICO/AboutS.png")));
	jmi5.setContentAreaFilled(false);
	jmb1.add(jm1);
	jmb2.add(jm2);
	jm1.add(jmi3);
	jmi2=new JMenuItem("About");
	jmi2.setContentAreaFilled(false);
	jmi2.setIcon(new ImageIcon(MCQ.class.getResource("/ICO/AboutS.png")));
	jm1.add(jmi2);
	jmi2.addActionListener(this);
	jmi1=new JMenuItem("Log out");
	jmi1.setContentAreaFilled(false);
	jmi1.setIcon(new ImageIcon(MCQ.class.getResource("/ICO/Logout.png")));
	jm1.add(jmi1);
	jmi1.addActionListener(this);
	jm2.add(jmi5);
	jmi4=new JMenuItem("Log out");
	jmi4.setIcon(new ImageIcon(MCQ.class.getResource("/ICO/Logout.png")));
	jmi4.setContentAreaFilled(false);
	jm2.add(jmi4);
	fc1=new JFileChooser();
	fi1=new File("");
	jmb1.setBounds(0,0,47,35);
	jmb2.setBounds(0,0,47,35);
	l1.setBounds(31,139,100,25);
	l2.setBounds(35,46,540,140);
	l3.setBounds(26,25,182,25);
	l4.setBounds(26,73,120,25);
	l5.setBounds(31,139,100,25);
	l6.setBounds(31,189,100,25);
	l7.setBounds(31,189,100,25);
	l8.setBounds(197,396,100,25);
	l9.setBounds(26,119,115,25);
	l10.setBounds(26,175,115,25);
	l11.setBounds(26,253,115,44);
	l12.setBounds(47,158,400,30);
	l13.setBounds(57,32,479,52);
	l14.setBounds(32,98,530,100);
	l15.setBounds(34,32,425,52);
	l16.setBounds(29,28,435,100);
	l17.setBounds(29,11,435,77);
	l18.setBounds(39,4,515,71);
	l19.setBounds(39,59,505,62);
	l20.setBounds(30,48,433,62);
	l21.setBounds(30,175,333,161);
	l23.setBounds(273,200,30,30);
	l24.setBounds(57,296,150,30);
	l25.setBounds(369,296,150,30);
	l26.setBounds(282,232,30,30);
	l27.setBounds(63,328,164,36);
	l28.setBounds(368,327,164,37);
	l32.setBounds(204,25,162,126);
	l33.setBounds(47,314,400,30);
	l34.setBounds(47,392,400,30);
	l35.setBounds(47,236,400,30);
	l37.setBounds(42,245,152,25);
	l38.setBounds(61,360,152,25);
	l39.setBounds(365,360,152,25);
	l40.setBounds(221,27,152,25);
	l41.setBounds(66,85,370,25);
	l42.setBounds(282,268,30,30);
	l43.setBounds(607,46,140,140);
	lb1.setSize(800,600);
	lb2.setSize(700,700);
	lb3.setSize(500,550);
	lb4.setSize(500,450);
	lb5.setSize(600,400);
	lb6.setSize(500,500);
	lb7.setSize(600,450);
	lb8.setSize(500,500);
	lb9.setSize(400,400);
	lb17.setSize(600,450);
	lb18.setSize(694,671);
	lb10.setBounds(35,223,335,50);
	lb11.setBounds(412,223,335,50);
	lb12.setBounds(35,297,335,50);
	lb13.setBounds(412,297,335,50);
	lb14.setBounds(210,368,354,50);
	lb15.setBounds(27,25,150,150);
	t1.setBounds(234,25,433,25);
	t2.setBounds(234,75,433,200);
	t3.setBounds(100,325,569,25);
	t4.setBounds(100,375,569,25);
	t5.setBounds(100,425,569,25);
	t6.setBounds(100,475,569,25);
	t7.setBounds(100,525,569,25);
	t8.setBounds(162,139,300,25);
	t9.setBounds(162,139,300,25);
	t10.setBounds(167,119,299,25);
	t11.setBounds(147,154,300,25);
	t12.setBounds(147,126,300,25);
	p1.setBounds(162,189,300,25);
	p2.setBounds(162,189,300,25);
	p3.setBounds(167,175,299,25);
	p4.setBounds(167,268,299,25);
	c1.setBounds(25,325,50,25);
	c2.setBounds(25,375,50,25);
	c3.setBounds(25,425,50,25);
	c4.setBounds(25,475,50,25);
	c5.setBounds(25,525,50,25);
	c6.setBounds(41,223,335,50);
	c7.setBounds(417,223,335,50);
	c8.setBounds(41,297,335,50);
	c9.setBounds(417,297,335,50);
	c10.setBounds(220,368,354,50);
	c11.setBounds(172,245,150,25);
	c12.setBounds(172,245,150,25);
	c13.setBounds(172,222,150,25);
	c14.setBounds(172,317,150,25);
	b1.setBounds(346,460,100,50);
	b2.setBounds(57,143,150,150);
	b3.setBounds(369,143,150,150);
	b4.setBounds(34,297,425,30);
	b5.setBounds(34,346,425,30);
	b6.setBounds(58,600,100,50);
	b7.setBounds(216,600,100,50);
	b8.setBounds(374,600,100,50);
	b10.setBounds(532,600,100,50);
	b11.setBounds(569,460,100,50);
	b12.setBounds(123,460,100,50);
	b13.setBounds(34,297,425,30);
	b14.setBounds(34,346,425,30);
	b15.setBounds(34,438,425,30);
	b16.setBounds(34,367,425,30);
	b17.setBounds(34,424,425,30);
	b18.setBounds(66,174,150,150);
	b19.setBounds(378,174,150,150);
	b20.setBounds(549,325,35,35);
	b21.setBounds(66,209,150,150);
	b22.setBounds(378,209,150,150);
	b23.setBounds(54,124,100,100);
	b24.setBounds(607,46,140,140);
	//vimage(f12);
	//ntest(f11);
	//about(f9);
	//ressheet(f8);
	//readres(f7);
	//cslog(f6);
	//slog(f5);
	//tlog(f4);
	//fread(f1);
	//fwrite(f2);
	l22.setText("Adding Actions...");
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	b5.addActionListener(this);
	b6.addActionListener(this);
	b7.addActionListener(this);
	b8.addActionListener(this);
	b10.addActionListener(this);
	b11.addActionListener(this);
	b12.addActionListener(this);
	b13.addActionListener(this);
	b14.addActionListener(this);
	b15.addActionListener(this);
	b16.addActionListener(this);
	b17.addActionListener(this);
	b18.addActionListener(this);
	b19.addActionListener(this);
	b20.addActionListener(this);
	b21.addActionListener(this);
	b22.addActionListener(this);
	b23.addActionListener(this);
	b24.addActionListener(this);
	c1.addItemListener(this);
	c2.addItemListener(this);
	c3.addItemListener(this);
	c4.addItemListener(this);
	c5.addItemListener(this);
	c6.addItemListener(this);
	c7.addItemListener(this);
	c8.addItemListener(this);
	c9.addItemListener(this);
	c10.addItemListener(this);
	c11.addItemListener(this);
	c12.addItemListener(this);
	c13.addItemListener(this);
	c14.addItemListener(this);
	jmi3.addActionListener(this);
	jmi4.addActionListener(this);
	jmi5.addActionListener(this);
	f10.dispose();
	fselect(f3);
}
public void db()
{
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/mcqdesktop?useSSL=false","root","");
		System.out.println("Connecting To The Local DataBase ...");
	}
	catch(SQLException e1)
	{
		landb();
	}
	catch(ClassNotFoundException ex)
	{
		JOptionPane.showMessageDialog(null,"System Error.1"+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}
}
public void landb()
{
	ip=JOptionPane.showInputDialog(null,"Enter Your Host Ip Address","IP Input",JOptionPane.INFORMATION_MESSAGE);
	if(ip==null)
	{
		System.exit(0);
	}
	try
	{
		con=DriverManager.getConnection("jdbc:mysql://"+ip+"/mcqdesktop?useSSL=false","remote","remote");
	}
	catch(SQLException e)
	{
		jop=5;
        jop=JOptionPane.showOptionDialog(null,"Could Not Found Any Local or LAN Database Retry ?","Choose Your Option",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,JOPB,JOPB[0]);
        if(jop==0)
        {
        	landb();
        }
        else if(jop==1)
        {
        	System.exit(0);
        }
        else if(jop==-1)
        {
        	System.exit(0);
        }
	}
}
public void fread(JFrame f1)
{
	f1.setVisible(true);
	f1.setSize(800,600);
	f1.setLocation((x/2)-400,(y/2)-300);
	f1.setTitle("Answer Questions");
	f1.getContentPane().setLayout(null);
	f1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	f1.getContentPane().add(jmb1);
	f1.getContentPane().add(l2);
	f1.getContentPane().add(c6);
	f1.getContentPane().add(c7);
	f1.getContentPane().add(c8);
	f1.getContentPane().add(c9);
	f1.getContentPane().add(b1);
	f1.getContentPane().add(c10);
	f1.getContentPane().add(b11);
	f1.getContentPane().add(b12);
	f1.getContentPane().add(b24);
	f1.getContentPane().add(lb10);
	f1.getContentPane().add(lb11);
	f1.getContentPane().add(lb12);
	f1.getContentPane().add(lb13);
	f1.getContentPane().add(lb14);
	f1.getContentPane().add(l43);
	f1.getContentPane().add(lb1);
}
public void fwrite(JFrame f2)
{
	f2.setVisible(true);
	f2.setSize(700,700);
	f2.setLocation((x/2)-350,(y/2)-350);
	f2.setTitle("Add New Questions");
	f2.getContentPane().setLayout(null);
	f2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	f2.getContentPane().add(l3);
	f2.getContentPane().add(l4);
	f2.getContentPane().add(t1);
	f2.getContentPane().add(t2);
	f2.getContentPane().add(t3);
	f2.getContentPane().add(t4);
	f2.getContentPane().add(t5);
	f2.getContentPane().add(t6);
	f2.getContentPane().add(t7);
	f2.getContentPane().add(b6);
	f2.getContentPane().add(b7);
	f2.getContentPane().add(b8);
	f2.getContentPane().add(b10);
	f2.getContentPane().add(c1);
	f2.getContentPane().add(c2);
	f2.getContentPane().add(c3);
	f2.getContentPane().add(c4);
	f2.getContentPane().add(c5);
	f2.getContentPane().add(b23);
	f2.getContentPane().add(l37);
	f2.getContentPane().add(lb2);
}
public void fselect(JFrame f3)
{
	f3.setVisible(true);
	f3.setTitle("Radian M.C.Q");
	f3.setSize(600,400);
	f3.setLocation((x/2)-300,(y/2)-200);
	f3.getContentPane().setLayout(null);
	f3.setDefaultCloseOperation(EXIT_ON_CLOSE);
	f3.getContentPane().add(b2);
	f3.getContentPane().add(b3);
	f3.getContentPane().add(l13);
	f3.getContentPane().add(l14);
	f3.getContentPane().add(b20);
	f3.getContentPane().add(l23);
	f3.getContentPane().add(l24);
	f3.getContentPane().add(l25);
	f3.getContentPane().add(lb5);
	
}
public void tlog(JFrame f4)
{
	f4.setVisible(true);
	f4.setTitle("Teacher's Login");
	f4.setSize(500,450);
	f4.setLocation((x/2)-250,(y/2)-225);
	f4.getContentPane().setLayout(null);
	f4.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	f4.getContentPane().add(b4);
	f4.getContentPane().add(b5);
	f4.getContentPane().add(l1);
	f4.getContentPane().add(l6);
	f4.getContentPane().add(t9);
	f4.getContentPane().add(p1);
	f4.getContentPane().add(c11);
	f4.getContentPane().add(l15);
	f4.getContentPane().add(lb4);
}
public void slog(JFrame f5)
{
	f5.setVisible(true);
	f5.setTitle("Student's Login");
	f5.setSize(500,550);
	f5.setLocation((x/2)-250,(y/2)-275);
	f5.getContentPane().setLayout(null);
	f5.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	f5.getContentPane().add(b13);
	f5.getContentPane().add(b14);
	f5.getContentPane().add(b15);
	f5.getContentPane().add(l5);
	f5.getContentPane().add(l7);
	f5.getContentPane().add(l8);
	f5.getContentPane().add(t8);
	f5.getContentPane().add(p2);
	f5.getContentPane().add(c12);
	f5.getContentPane().add(l16);
	f5.getContentPane().add(lb3);
}
public void cslog(JFrame f6)
{
	f6.setVisible(true);
	f6.setTitle("Create New Student Account");
	f6.setSize(500,530);
	f6.setLocation((x/2)-250,(y/2)-265);
	f6.getContentPane().setLayout(null);
	f6.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	f6.getContentPane().add(l9);
	f6.getContentPane().add(l10);
	f6.getContentPane().add(l11);
	f6.getContentPane().add(t10);
	f6.getContentPane().add(p3);
	f6.getContentPane().add(p4);
	f6.getContentPane().add(b16);
	f6.getContentPane().add(b17);
	f6.getContentPane().add(c13);
	f6.getContentPane().add(c14);
	f6.getContentPane().add(l17);
	f6.getContentPane().add(lb6);
}
public void readres(JFrame f7)
{
	f7.setVisible(true);
	f7.setSize(600,450);
	f7.setLocation((x/2)-300,(y/2)-200);
	f7.setTitle("Radian M.C.Q");
	f7.getContentPane().setLayout(null);
	f7.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	f7.getContentPane().add(jmb2);
	f7.getContentPane().add(b18);
	f7.getContentPane().add(b19);
	f7.getContentPane().add(l18);
	f7.getContentPane().add(l19);
	f7.getContentPane().add(l26);
	f7.getContentPane().add(l27);
	f7.getContentPane().add(l28);
	f7.getContentPane().add(t12);
	f7.getContentPane().add(lb7);
}
public void ressheet(JFrame f8)
{
	f8.setVisible(true);
	f8.setSize(500,500);
	f8.setLocation((x/2)-250,(y/2)-250);
	f8.setTitle("Your Status");
	f8.getContentPane().setLayout(null);
	f8.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	f8.getContentPane().add(l12);
	f8.getContentPane().add(l20);
	f8.getContentPane().add(l33);
	f8.getContentPane().add(l34);
	f8.getContentPane().add(l35);
	f8.getContentPane().add(lb8);
}
public void about(JFrame f9)
{
	f9.setVisible(true);
	f9.setSize(400,400);
	f9.setLocation((x/2)-200,(y/2)-200);
	f9.setTitle("About");
	f9.getContentPane().setLayout(null);
	f9.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	f9.getContentPane().add(l21);
	f9.getContentPane().add(lb15);
	f9.getContentPane().add(l32);
	f9.getContentPane().add(lb9);
}
public void load(JFrame f10)
{
	f10.setVisible(true);
	f10.setSize(400,200);
	f10.getContentPane().setLayout(null);
	f10.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	f10.getContentPane().add(l22);
	f10.getContentPane().add(lb16);
	f10.getContentPane().add(lb10);
}
public void ntest(JFrame f11)
{
	f11.setVisible(true);
	f11.setTitle("Radian M.C.Q");
	f11.setSize(600,450);
	f11.setLocation((x/2)-300,(y/2)-225);
	f11.getContentPane().setLayout(null);
	f11.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	f11.getContentPane().add(b21);
	f11.getContentPane().add(b22);
	f11.getContentPane().add(t11);
	f11.getContentPane().add(l38);
	f11.getContentPane().add(l39);
	f11.getContentPane().add(l40);
	f11.getContentPane().add(l41);
	f11.getContentPane().add(l42);
	f11.getContentPane().add(lb17);
}
public void vimage(JFrame f12)
{
	f12.setVisible(true);
	f12.setTitle("M.C.Q Image");
	f12.setSize(700,700);
	f12.setLocation((x/2)-350,(y/2)-350);
	f12.getContentPane().setLayout(null);
	f12.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	f12.getContentPane().add(lb18);
}
public void next()
{
	try
	{
		ResultSet r=con.createStatement().executeQuery("SELECT * FROM questions where No='"+((sesr*100000)+qn+1)+"'");
		if(r.next())
		{
			ne=1;
		}
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
}
public void readdb()
{
	sc=0;
	try
	{
		ResultSet r=con.createStatement().executeQuery("SELECT * FROM questions where No='"+((sesr*100000)+qn)+"'");
		if(r.next())
		{
			l2.setText("<html>"+"Q"+qn+")  "+r.getString("MCQ")+"</html>");
			a1=r.getString("One");
			a2=r.getString("Two");
			a3=r.getString("Three");
			a4=r.getString("Four");
			a5=r.getString("Five");
			c6.setText("I)  "+a1);
			c7.setText("II)  "+a2);
			c8.setText("III)  "+a3);
			c9.setText("IV)  "+a4);
			c10.setText("V)  "+a5);
			sc=1;
		}
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	if(sc==1)
	{
		try
		{
			ResultSet r=con.createStatement().executeQuery("SELECT * FROM answers where No='"+((sesr*100000)+qn)+"'");
			if(r.next())
			{
				cans=r.getString("ans");
			}
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		try
		{
	    	fil=new File("C:\\Users\\Public\\Pictures\\mcqimg.jpg");
	    	fos=new FileOutputStream(fil);
	    	ResultSet r=con.createStatement().executeQuery("SELECT * FROM questions where No='"+((sesr*100000)+qn)+"'");
	    	if(r.next())
	    	{
	    		blo=r.getBlob("IMG");
	    		b=blo.getBytes(1,(int)blo.length());
	    		fos.write(b);
	    	}
	    	try
	    	{
	    		nimg=0;
	    		buf1=ImageIO.read(new File("C:\\Users\\Public\\Pictures\\mcqimg.jpg"));
	    		rimg=buf1.getScaledInstance(140,140,Image.SCALE_SMOOTH);
	    		l43.setIcon(new ImageIcon(rimg));
	    		b24.setRolloverIcon(new ImageIcon(MCQ.class.getResource("/IMG/Trance.png")));
	    	}
	    	catch(NullPointerException e1)
	    	{
	    		JOptionPane.showMessageDialog(null,"Error");
	    	}
	    	l2.setBounds(35,46,540,140);
	    }
		catch(SQLException e)
		{
		   JOptionPane.showMessageDialog(null,e.getMessage());
		}
		catch(IOException ex)
		{
			JOptionPane.showMessageDialog(null,"IO");
		}
		catch(NullPointerException ex1)
		{
			nimg=1;
			l43.setIcon(null);
			b24.setRolloverIcon(null);
			l2.setBounds(35,46,712,140);
		}
	}
}
public void cacc()
{
	try
	{
		con.createStatement().execute("insert into accounts(No,UName,Pass)values('"+ac+"','"+t10.getText()+"','"+p3.getText()+"')");
		c13.setSelected(false);
		c14.setSelected(false);
		t10.setText("");
		p3.setText("");
		p4.setText("");
		ac++;
		f6.dispose();
		slog(f5);
	}
	catch(SQLException ex)
	{
		ac++;
		cacc();
	}
}
public void qnew()
{
	try
	{
		ResultSet r=con.createStatement().executeQuery("SELECT MAX(Sess) FROM questions");
		if(r.next())
		{
			sesdb=r.getInt(1);
			ses=sesdb+1;
		}
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
}
public void qadd()
{
	if(path1.equals(""))
	{
		try
		{
			con.createStatement().execute("insert into questions(No,Sess,MCQ,One,Two,Three,Four,Five)values('"+((ses*100000)+an)+"','"+ses+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"')");
		}
		catch(SQLException ex)
		{
			an++;
			qadd();
		}
	}
	else
	{
		if((answ>0)&&(answ<6))
		{
			
			try
			{
				 sta=con.prepareStatement("insert into questions(No,Sess,MCQ,IMG,One,Two,Three,Four,Five) values('"+((ses*100000)+an)+"','"+ses+"','"+t2.getText()+"',?,'"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"')");
				 fist=new FileInputStream(new File(path1));
				 sta.setBinaryStream(1,fist);
				 sta.execute();
			}
			catch(SQLException ex)
			{
				an++;
				qadd();
			}
			catch(FileNotFoundException ex1)
			{
				JOptionPane.showMessageDialog(this,ex1.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
public void ssign()
{
	try
	{
		ResultSet r=con.createStatement().executeQuery("SELECT * FROM accounts where No='"+(log)+"'");
		if(r.next())
		{
			sign=1;
			sun=r.getString("UName");
			spw=r.getString("Pass");
			if((sun.equals(t8.getText()))&&(spw.equals(p2.getText())))
			{
				l18.setText("Welcome "+sun);
				f7.setTitle("Welcome "+sun);
				f5.dispose();
				readres(f7);
			}
			else
			{
				log++;
				sign=0;
				ssign();
			}
		}
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
}
public void res()
{
	try
	{
		ResultSet r=con.createStatement().executeQuery("SELECT * FROM player where No='"+((((sesr*1000)+n)*1000000)+clog)+"'");
		if(r.next())
		{
			ans=r.getInt("Correct");
			if(ans==1)
			{
				nc++;
			}
			else if(ans==0)
			{
				nw++;
			}
			n++;
			res();
		}
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
}
public void chal()
{
	try
	{
		con.createStatement().execute("insert into stat(No,Corr,Sess)values('"+((sesr*100000)+clog)+"','"+((sesr*100000)+nc)+"','"+sesr+"')");
	}
	catch(SQLException ex)
	{
	try
		{
			con.createStatement().execute("update stat SET Corr='"+((sesr*100000)+nc)+"'where No='"+((sesr*100000)+clog)+"'");
		}
		catch(SQLException ex1)
		{
			JOptionPane.showMessageDialog(this,ex1.getMessage(),"dgsdfgsdf",JOptionPane.ERROR_MESSAGE);
		}
	}
}
public void leader()
{
	stna=0;
	stni=0;
	try
	{
		ResultSet r=con.createStatement().executeQuery("SELECT MAX(Corr) FROM `stat` WHERE(Corr)<'"+((sesr+1)*100000)+"'");
		if(r.next())
		{
			max=((r.getInt(1))-(sesr*100000));
			maxn=r.getInt(1);
		}
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	try
	{
		ResultSet r=con.createStatement().executeQuery("SELECT MIN(Corr) FROM `stat` WHERE(Corr)<'"+((sesr+1)*100000)+"'");
		if(r.next())
		{
			min=((r.getInt(1))-(sesr*100000));
			minn=r.getInt(1);
		}
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	try
	{	
		ResultSet r=con.createStatement().executeQuery("SELECT No,Corr, FIND_IN_SET( Corr, ( SELECT GROUP_CONCAT( Corr ORDER BY Corr DESC ) FROM stat WHERE Sess='"+sesr+"')) AS rank FROM stat WHERE No='"+((sesr*100000)+clog)+"'");
		if(r.next())
		{
			rank=r.getInt("rank");
		}
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	try
	{
		ResultSet r=con.createStatement().executeQuery("SELECT * FROM `stat` WHERE Corr='"+maxn+"'");
		if(r.next())
		{
			stna=((r.getInt("No"))-(sesr*100000));
		}
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	try
	{
		ResultSet r=con.createStatement().executeQuery("SELECT * FROM `stat` WHERE Corr='"+minn+"'");
		if(r.next())
		{
			stni=((r.getInt("No"))-(sesr*100000));
		}
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	try
	{
		ResultSet r=con.createStatement().executeQuery("SELECT * FROM `accounts` WHERE No='"+stna+"'");
		if(r.next())
		{
			stma=r.getString("UName");
		}
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	try
	{
		ResultSet r=con.createStatement().executeQuery("SELECT * FROM `accounts` WHERE No='"+stni+"'");
		if(r.next())
		{
			stmi=r.getString("UName");
		}
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
}
public void nextsub()
{
	if((pla>0)&&(pla<6))
	{
		if(pla==1)
		{
			if(c6.getText().equals("I)  "+cans))
			{
				
				pq=1;
				try
				{
					con.createStatement().execute("insert into player(No,USName,Correct)values('"+((((sesr*1000)+qn)*1000000)+clog)+"','"+sun+"','"+pq+"')");
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(this,"You Have Alredy Answerd This Question","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			else
			{
				pq=0;
				try
				{
					con.createStatement().execute("insert into player(No,USName,Correct)values('"+((((sesr*1000)+qn)*1000000)+clog)+"','"+sun+"','"+pq+"')");
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(this,"You Have Alredy Answerd This Question","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		else if(pla==2)
		{
			if(c7.getText().equals("II)  "+cans))
			{
				pq=1;
				try
				{
					con.createStatement().execute("insert into player(No,USName,Correct)values('"+((((sesr*1000)+qn)*1000000)+clog)+"','"+sun+"','"+pq+"')");
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(this,"You Have Alredy Answerd This Question","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			else
			{
				pq=0;
				try
				{
					con.createStatement().execute("insert into player(No,USName,Correct)values('"+((((sesr*1000)+qn)*1000000)+clog)+"','"+sun+"','"+pq+"')");
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(this,"You Have Alredy Answerd This Question","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}	
		}
		else if(pla==3)
		{
			if(c8.getText().equals("III)  "+cans))
			{
				pq=1;
				try
				{
					con.createStatement().execute("insert into player(No,USName,Correct)values('"+((((sesr*1000)+qn)*1000000)+clog)+"','"+sun+"','"+pq+"')");
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(this,"You Have Alredy Answerd This Question","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			else
			{
				pq=0;
				try
				{
					con.createStatement().execute("insert into player(No,USName,Correct)values('"+((((sesr*1000)+qn)*1000000)+clog)+"','"+sun+"','"+pq+"')");
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(this,"You Have Alredy Answerd This Question","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		else if(pla==4)
		{
			if(c9.getText().equals("IV)  "+cans))
			{
				pq=1;
				try
				{
					con.createStatement().execute("insert into player(No,USName,Correct)values('"+((((sesr*1000)+qn)*1000000)+clog)+"','"+sun+"','"+pq+"')");
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(this,"You Have Alredy Answerd This Question","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			else
			{
				pq=0;
				try
				{
					con.createStatement().execute("insert into player(No,USName,Correct)values('"+((((sesr*1000)+qn)*1000000)+clog)+"','"+sun+"','"+pq+"')");
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(this,"You Have Alredy Answerd This Question","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		else if(pla==5)
		{
			if(c10.getText().equals("V)  "+cans))
			{
				pq=1;
				try
				{
					con.createStatement().execute("insert into player(No,USName,Correct)values('"+((((sesr*1000)+qn)*1000000)+clog)+"','"+sun+"','"+pq+"')");
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(this,"You Have Alredy Answerd This Question","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			else
			{
				pq=0;
				try
				{
					con.createStatement().execute("insert into player(No,USName,Correct)values('"+((((sesr*1000)+qn)*1000000)+clog)+"','"+sun+"','"+pq+"')");
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(this,"You Have Alredy Answerd This Question","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
	else
	{
		JOptionPane.showMessageDialog(this,"Please Select an Answer","ERROR",JOptionPane.WARNING_MESSAGE);
	}
	qn=qn+1;
	readdb();
	c6.setSelected(false);
	c7.setSelected(false);
	c8.setSelected(false);
	c9.setSelected(false);
	c10.setSelected(false);
	ne=0;
}
public void aadd()
{
	if(answ==1)
	{
	try
	{
		con.createStatement().execute("insert into answers(No,ans)values('"+((ses*100000)+an)+"','"+t3.getText()+"')");
		c1.setSelected(false);
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	}
	else if(answ==2)
	{
	try
	{
		con.createStatement().execute("insert into answers(No,ans)values('"+((ses*100000)+an)+"','"+t4.getText()+"')");
		c2.setSelected(false);
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	}
	else if(answ==3)
	{
	try
	{
		con.createStatement().execute("insert into answers(No,ans)values('"+((ses*100000)+an)+"','"+t5.getText()+"')");
		c3.setSelected(false);
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	}
	else if(answ==4)
	{
	try
	{
		con.createStatement().execute("insert into answers(No,ans)values('"+((ses*100000)+an)+"','"+t6.getText()+"')");
		c4.setSelected(false);
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	}
	else if(answ==5)
	{
	try
	{
		con.createStatement().execute("insert into answers(No,ans)values('"+((ses*100000)+an)+"','"+t7.getText()+"')");
		c5.setSelected(false);
	}
	catch(SQLException ex)
	{
		JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	}
	else
	{
		JOptionPane.showMessageDialog(this,"Please Select Correct Answer","Warning",JOptionPane.WARNING_MESSAGE);
	}
	t2.setText("");
	t3.setText("");
	t4.setText("");
	t5.setText("");
	t6.setText("");
	t7.setText("");
	answ=0;
}
public void itemStateChanged(ItemEvent b)
{
	if(b.getItemSelectable()==c1)
	{
		if(b.getStateChange()==ItemEvent.SELECTED)
		{
		c2.setSelected(false);
		c3.setSelected(false);
		c4.setSelected(false);
		c5.setSelected(false);
		answ=1;
		}
	}
	else if(b.getItemSelectable()==c2)
	{
		if(b.getStateChange()==ItemEvent.SELECTED)
		{
		c1.setSelected(false);
		c3.setSelected(false);
		c4.setSelected(false);
		c5.setSelected(false);
		answ=2;
		}
	}
	else if(b.getItemSelectable()==c3)
	{
		if(b.getStateChange()==ItemEvent.SELECTED)
		{
		c2.setSelected(false);
		c1.setSelected(false);
		c4.setSelected(false);
		c5.setSelected(false);
		answ=3;
		}
	}
	else if(b.getItemSelectable()==c4)
	{
		if(b.getStateChange()==ItemEvent.SELECTED)
		{
		c2.setSelected(false);
		c3.setSelected(false);
		c1.setSelected(false);
		c5.setSelected(false);
		answ=4;
		}
	}
	else if(b.getItemSelectable()==c5)
	{
		if(b.getStateChange()==ItemEvent.SELECTED)
		{
		c2.setSelected(false);
		c3.setSelected(false);
		c4.setSelected(false);
		c1.setSelected(false);
		answ=5;
		}
	}
	else if(b.getItemSelectable()==c6)
	{
		if(b.getStateChange()==ItemEvent.SELECTED)
		{
			c7.setSelected(false);
			c8.setSelected(false);
			c9.setSelected(false);
			c10.setSelected(false);
			pla=1;
		}
	}
	else if(b.getItemSelectable()==c7)
	{
		if(b.getStateChange()==ItemEvent.SELECTED)
		{
			c6.setSelected(false);
			c8.setSelected(false);
			c9.setSelected(false);
			c10.setSelected(false);
			pla=2;
		}
	}
	else if(b.getItemSelectable()==c8)
	{
		if(b.getStateChange()==ItemEvent.SELECTED)
		{
			c7.setSelected(false);
			c6.setSelected(false);
			c9.setSelected(false);
			c10.setSelected(false);
			pla=3;
		}
	}
	else if(b.getItemSelectable()==c9)
	{
		if(b.getStateChange()==ItemEvent.SELECTED)
		{
			c7.setSelected(false);
			c8.setSelected(false);
			c6.setSelected(false);
			c10.setSelected(false);
			pla=4;
		}
	}
	else if(b.getItemSelectable()==c10)
	{
		if(b.getStateChange()==ItemEvent.SELECTED)
		{
			c7.setSelected(false);
			c8.setSelected(false);
			c9.setSelected(false);
			c6.setSelected(false);
			pla=5;
		}
	}
	else if(b.getItemSelectable()==c11)
	{
		if(b.getStateChange()==ItemEvent.SELECTED)
		{
			p1.setEchoChar((char) 0);
		}
		else if(b.getStateChange()==ItemEvent.DESELECTED)
		{
			p1.setEchoChar('*');
		}
	}
	else if(b.getItemSelectable()==c12)
	{
		if(b.getStateChange()==ItemEvent.SELECTED)
		{
			p2.setEchoChar((char) 0);
		}
		else if(b.getStateChange()==ItemEvent.DESELECTED)
		{
			p2.setEchoChar('*');
		}
	}
	else if(b.getItemSelectable()==c13)
	{
		if(b.getStateChange()==ItemEvent.SELECTED)
		{
			p3.setEchoChar((char) 0);
		}
		else if(b.getStateChange()==ItemEvent.DESELECTED)
		{
			p3.setEchoChar('*');
		}
	}
	else if(b.getItemSelectable()==c14)
	{
		if(b.getStateChange()==ItemEvent.SELECTED)
		{
			p4.setEchoChar((char) 0);
		}
		else if(b.getStateChange()==ItemEvent.DESELECTED)
		{
			p4.setEchoChar('*');
		}
	}
	
}
public void actionPerformed(ActionEvent a) 
{
	if(a.getSource()==b1)
	{
		if(qa==0)
		{
			next();
			if(ne==1)
			{
				nextsub();
			}
			else if(ne==0)
			{
				qa++;
				nextsub();
			}
		}
	}
	else if(a.getSource()==b2)
	{
		slog(f5);
	}
	else if(a.getSource()==b3)
	{
		tlog(f4);
	}
	else if(a.getSource()==b4)
	{
		un=t9.getText();
		pw=p1.getText();
		if((un.equals("1"))&&(pw.equals("1")))
		{
			p1.setText("");
			t9.setText("");
			f4.dispose();
			ntest(f11);
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Incorrect User Name or Passwoed","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	else if(a.getSource()==b5)
	{
		p1.setText("");
		t9.setText("");
		f4.dispose();
	}
	else if(a.getSource()==b6)
	{
		if(nol==1)
		{
			qadd();
			aadd();
		}
		else if(nol==2)
		{
			qadd();
			aadd();
		}
	}
	else if(a.getSource()==b7)
	{
		try
		{
			con.createStatement().execute("update questions SET MCQ='"+t2.getText()+"',One='"+t3.getText()+"',Two='"+t4.getText()+"',Three='"+t5.getText()+"',Four='"+t6.getText()+"',Five='"+t7.getText()+"'where No='"+((ses*10000)+t1.getText())+"'");
			JOptionPane.showMessageDialog(this,"Successfully Updated");
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
	else if(a.getSource()==b8)
	{
		try
		{
			ResultSet r=con.createStatement().executeQuery("SELECT * FROM questions where No='"+((ses*10000)+t1.getText())+"'");
			if(r.next())
			{
				t2.setText(r.getString("MCQ"));
				t3.setText(r.getString("One"));
				t4.setText(r.getString("Two"));
				t5.setText(r.getString("Three"));
				t6.setText(r.getString("Four"));
				t7.setText(r.getString("Five"));
			}
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
	else if(a.getSource()==b10)
	{
		t1.setText("");
		t2.setText(null);
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
	}
	else if(a.getSource()==b11)
	{
		next();
		if(ne==1)
		{
		qn=qn+1;
		readdb();
		ne=0;
		}
	}
	else if(a.getSource()==b12)
	{
		if(qn>1)
		{
		qn=qn-1;
		readdb();
		}
	}
	else if(a.getSource()==b13)
	{
		clog=0;
		if(t8.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"Plese Enter Your Username","Warning",JOptionPane.WARNING_MESSAGE);
		}
		else if(p2.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"Plese Enter Your Password","Warning",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
		ssign();
		if(sign==0)
		{
			JOptionPane.showMessageDialog(this,"Incorrect Username Password Combination","Error",JOptionPane.ERROR_MESSAGE);
		}
		}
		clog=log;
		log=1;
	}
	else if(a.getSource()==b14)
	{
		t8.setText("");
		p2.setText("");
		f5.dispose();
	}
	else if(a.getSource()==b15)
	{
		cslog(f6);
	}
	else if(a.getSource()==b16)
	{
		if(t10.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"Please Enter Your Username","Warning",JOptionPane.WARNING_MESSAGE);
		}
		else if(p3.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"Plese Enter Your Password","Warning",JOptionPane.WARNING_MESSAGE);
		}
		else if(p4.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"Plese Confirm Your Password","Warning",JOptionPane.WARNING_MESSAGE);
		}
		else if(p3.getText().equals(p4.getText()))
		{
			cacc();
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Password Mismatch","Warning",JOptionPane.WARNING_MESSAGE);
		}
	}
	else if(a.getSource()==b17)
	{
		f6.dispose();
	}
	else if(a.getSource()==b18)
	{
		sesr=Integer.parseInt(t12.getText());
		readdb();
		if(sc==0)
		{
			JOptionPane.showMessageDialog(this,"Please Enter Valid Session Number","Warrning",JOptionPane.WARNING_MESSAGE);
		}
		else if(sc==1)
		{
			fread(f1);
		}
	}
	else if(a.getSource()==b19)
	{
		sesr=Integer.parseInt(t12.getText());
		readdb();
		if(sc==0)
		{
			JOptionPane.showMessageDialog(this,"Please Enter Valid Session Number","Warrning",JOptionPane.WARNING_MESSAGE);
		}
		else if(sc==1)
		{
			n=1;
			nc=0;
			nw=0;
			res();
			chal();
			leader();
			l12.setText(nc+"  of  "+(nc+nw)+"  Are Correct");
			l35.setText("Your Rank is  "+rank);
			l33.setText("Highest Marks is  "+max+" by "+stma);
			l34.setText("Lowest Marks is  "+min+" by "+stmi);
			ressheet(f8);
		}
		l2.setText("N/A");
		c6.setText("N/A");
		c7.setText("N/A");
		c8.setText("N/A");
		c9.setText("N/A");
		c10.setText("N/A");
		l43.setIcon(null);
		b24.setRolloverIcon(null);
		qn=1;
	}
	else if(a.getSource()==b20)
	{
		about(f9);
	}
	else if(a.getSource()==b21)
	{
		fwrite(f2);
		qnew();
		nol=1;
	}
	else if(a.getSource()==b22)
	{
		if(t11.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"Please Enter Session Number","Warning",JOptionPane.WARNING_MESSAGE);
		}
		else if(Integer.parseInt(t11.getText())==0)
		{
			JOptionPane.showMessageDialog(this,"Please Enter Valid Number","Warning",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			ses=Integer.parseInt(t11.getText());
			try
			{
				ResultSet r=con.createStatement().executeQuery("SELECT * FROM questions where No='"+((ses*100000)+1)+"'");
				if(r.next())
				{
					edi=1;
				}
			}
			catch(SQLException ex)
			{
				JOptionPane.showMessageDialog(this,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
			if(edi==0)
			{
				JOptionPane.showMessageDialog(this,"Cannot Found Session You Enterd","Warning",JOptionPane.WARNING_MESSAGE);
				edi=0;
			}
			else
			{
				fwrite(f2);
				nol=2;
				edi=0;
			}
		}
	}
	else if(a.getSource()==b23)
	{
		path1="";
		fc1.setCurrentDirectory(new File(System.getProperty("user.home")));
		res=fc1.showOpenDialog(fc1);
		if (res== JFileChooser.APPROVE_OPTION) {
		    fi1=fc1.getSelectedFile();
		    path1=fi1.getAbsolutePath();
		    System.out.println(path1);
		}
	}
	else if(a.getSource()==b24)
	{
		if(nimg==0)
		{
			rimg2=buf1.getScaledInstance(700,700,Image.SCALE_SMOOTH);
			lb18.setIcon(new ImageIcon(rimg2));
			vimage(f12);
		}
	}
	else if(a.getSource()==jmi1)
	{
		f1.dispose();
		f7.dispose();
		f8.dispose();
		t8.setText("");
		p2.setText("");
		l2.setText("N/A");
		c6.setText("N/A");
		c7.setText("N/A");
		c8.setText("N/A");
		c9.setText("N/A");
		c10.setText("N/A");
		l43.setIcon(null);
		b24.setRolloverIcon(null);
		qn=1;
		slog(f5);
	}
	else if(a.getSource()==jmi2)
	{
		about(f9);
	}
	else if(a.getSource()==jmi3)
	{
		n=1;
		nc=0;
		nw=0;
		res();
		chal();
		leader();
		l12.setText(nc+"  of  "+(nc+nw)+"  Are Correct");
		l35.setText("Your Rank is  "+rank);
		l33.setText("Highest Marks is  "+max);
		l34.setText("Lowest Marks is  "+min);
		ressheet(f8);
	}
	else if(a.getSource()==jmi4)
	{
		f1.dispose();
		f7.dispose();
		f8.dispose();
		t8.setText("");
		p2.setText("");
		l2.setText("N/A");
		c6.setText("N/A");
		c7.setText("N/A");
		c8.setText("N/A");
		c9.setText("N/A");
		c10.setText("N/A");
		l43.setIcon(null);
		b24.setRolloverIcon(null);
		qn=1;
		slog(f5);
	}
	else if(a.getSource()==jmi5)
	{
		about(f9);
	}
}
public static void main(String[] args) 
{
	new MCQ();
}
}
