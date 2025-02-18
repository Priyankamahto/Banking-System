import java. awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class search1 extends JFrame implements ActionListener
{	
JLabel a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23;
JTextField t1,t1a,t1b,t2,t3,t4,t5,t6,t7,t8,t8a,t8b,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23;
JButton ct,dt;
ButtonGroup bg;
JRadioButton r1,r2;
JComboBox cb1,cb2;
JList l1,l2;
JTextArea ta1,ta2;
JScrollPane jp1,jp2;
String gender[]={"MAlE","FEMALE","OTHERS"};
String account[]={"SAVINGS ACCOUNT","CURRENT ACCOUNT","FIXED DEPOSIT ACCOUNT","RECURRING DEPOSIT ACCOUNT"};
Container cn;
Connection con;
Statement st;
String s1,s1a,s1b,s2,s3,s4,s5,s6,s7,s8,s8a,s8b,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23;
search1()
{
super("Account Search");
cn=getContentPane();
cn.setLayout(null);

a23=new JLabel("Account no");
a23.setBounds(10,10,100,25);
cn.add(a23);
t23=new JTextField(10);
t23.setBounds(150,10,150,25);
cn.add(t23);


a1=new JLabel("Applicant Name");
a1.setBounds(10,50,100,25);
cn.add(a1);
t1=new JTextField(10);
t1.setBounds(150,50,150,25);
cn.add(t1);
t1a=new JTextField(10);
t1a.setBounds(310,50,150,25);
cn.add(t1a);
t1b=new JTextField(10);
t1b.setBounds(470,50,150,25);
cn.add(t1b);


a2=new JLabel("Phone No.");
a2.setBounds(10,100,80,25);
cn.add(a2);
t2=new JTextField(10);
t2.setBounds(150,100,150,25);
cn.add(t2);

a3=new JLabel("Email");
a3.setBounds(400,100,50,25);
cn.add(a3);
t3=new JTextField(10);
t3.setBounds(500,100,200,25);
cn.add(t3);

a4=new JLabel("Date Of Birth");
a4.setBounds(10,150,120,25);
cn.add(a4);
t4=new JTextField(10);
t4.setBounds(150,150,100,25);
cn.add(t4);

a5=new JLabel("Gender");
a5.setBounds(400,150,100,25);
cn.add(a5);
cb1=new JComboBox(gender);
cb1.setBounds(550,150,100,25);
cn.add(cb1);

a6=new JLabel("PAN No");
a6.setBounds(10,200,50,25);
cn.add(a6);
t6=new JTextField(10);
t6.setBounds(150,200,150,25);
cn.add(t6);

a7=new JLabel("Aadhar no");
a7.setBounds(400,200,100,25);
cn.add(a7);
t7=new JTextField(10);
t7.setBounds(520,200,150,25);
cn.add(t7);

a8=new JLabel("Father's/Husband's Name");
a8.setBounds(10,280,180,25);
cn.add(a8);
t8=new JTextField(10);
t8.setBounds(200,280,150,25);
cn.add(t8);
t8a=new JTextField(10);
t8a.setBounds(360,280,150,25);
cn.add(t8a);
t8b=new JTextField(10);
t8b.setBounds(520,280,150,25);
cn.add(t8b);

a9=new JLabel("Date of Birth");
a9.setBounds(10,330,150,25);
cn.add(a9);
t9=new JTextField(10);
t9.setBounds(200,330,200,25);
cn.add(t9);

a10=new JLabel("PAN No");
a10.setBounds(450,330,50,25);
cn.add(a10);
t10=new JTextField(10);
t10.setBounds(500,330,200,25);
cn.add(t10);

a11=new JLabel("Aadhar No");
a11.setBounds(10,380,150,25);
cn.add(a11);
t11=new JTextField(10);
t11.setBounds(200,380,200,25);
cn.add(t11);

a12=new JLabel("Applicant Married status");
a12.setBounds(10,450,200,25);
cn.add(a12);
bg=new ButtonGroup();
r1=new JRadioButton("Yes");
r1.setBounds(250,450,50,25);
cn.add(r1);
r2=new JRadioButton("No");
r2.setBounds(350,450,50,25);
cn.add(r2);

bg.add(r1);
bg.add(r2);

a13=new JLabel("Correspondence Address");
a13.setBounds(80,520,150,25);
cn.add(a13);
ta1=new JTextArea(10,10);
ta1.setBounds(10,550,300,100);
cn.add(ta1);

a14=new JLabel("Pin");
a14.setBounds(10,670,30,25);
cn.add(a14);
t14=new JTextField(10);
t14.setBounds(80,670,80,25);
cn.add(t14);

a15=new JLabel("State");
a15.setBounds(200,670,50,25);
cn.add(a15);
t15=new JTextField(10);
t15.setBounds(250,670,80,25);
cn.add(t15);

a16=new JLabel("Country");
a16.setBounds(100,700,50,25);
cn.add(a16);
t16=new JTextField(10);
t16.setBounds(150,700,80,25);
cn.add(t16);

a17=new JLabel("Permanent Address");
a17.setBounds(650,520,150,25);
cn.add(a17);
ta2=new JTextArea(10,10);
ta2.setBounds(550,550,300,100);
cn.add(ta2);

a18=new JLabel("Pin");
a18.setBounds(550,670,50,25);
cn.add(a18);
t18=new JTextField(10);
t18.setBounds(600,670,80,25);
cn.add(t18);

a19=new JLabel("State");
a19.setBounds(720,670,50,25);
cn.add(a19);
t19=new JTextField(10);
t19.setBounds(780,670,80,25);
cn.add(t19);

a20=new JLabel("Country");
a20.setBounds(650,700,50,25);
cn.add(a20);
t20=new JTextField(10);
t20.setBounds(700,700,80,25);
cn.add(t20);

a21=new JLabel("Account Type");
a21.setBounds(750,50,100,25);
cn.add(a21);
cb2=new JComboBox(account);
cb2.setBounds(850,50,150,25);
cn.add(cb2);

a22=new JLabel("Opening Balance");
a22.setBounds(750,100,100,25);
cn.add(a22);
t22=new JTextField(10);
t22.setBounds(900,100,150,25);
/*t22.setEditable(false);*/
cn.add(t22);

ct=new JButton("BACK");
ct.setBounds(700,750,100,25);
cn.add(ct);

dt=new JButton("SEARCH");
dt.setBounds(400,10,100,25);
cn.add(dt);
 
ct.addActionListener(this);
dt.addActionListener(this);

 
setSize(1150,1000);
setLocation(170,0);
show();
}


public void actionPerformed(ActionEvent ae)
{


try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
}


catch(ClassNotFoundException ce)
{
System.out.println(ce);
}


try
{

con=DriverManager.getConnection("jdbc:odbc:account");
			st=con.createStatement();
			if(ae.getSource()==dt)
			{
				String no=t23.getText();
				String Str1="select* from account where(Account_No='"+no+"')";
                                ResultSet rs=st.executeQuery(Str1);
if(rs.next())
{
 s1=rs.getString(1);
 s2=rs.getString(2);
 s3=rs.getString(3);
 s4=rs.getString(4);
 s5=rs.getString(5);

 s6=rs.getString(6);
 s7=rs.getString(7);
 s8=rs.getString(8);
 s9=rs.getString(9);
 s10=rs.getString(10);
 s11=rs.getString(11);
 s13=rs.getString(13);
 s14=rs.getString(14);
 s15=rs.getString(15);
 s16=rs.getString(16);
 s17=rs.getString(17);
 s18=rs.getString(18);
 s19=rs.getString(19);
 s20=rs.getString(20);
 s21=rs.getString(21);

 s22=rs.getString(22);

String s12=rs.getString(12);
if(s12.equals("yes"))
{
r1.setSelected(true);
}

if(s12.equals("no"))
{
r2.setSelected(true);
}

t1.setText(s1);
t2.setText(s2);
t3.setText(s3);
t4.setText(s4);
ta1.setText(s13);
ta2.setText(s17);
t6.setText(s6);
t7.setText(s7);
t8.setText(s8);
t9.setText(s9);
t10.setText(s10);
t11.setText(s11);
t14.setText(s14);
t15.setText(s15);
t16.setText(s16);
t18.setText(s18);
t19.setText(s19);
t20.setText(s20);
t22.setText(s22);
cb1.setSelectedItem(s5);
cb2.setSelectedItem(s21);
}
}
if(ae.getSource()==ct)
{
new oppage();
setVisible(false);
}
}
catch(SQLException e)
{
System.out.print(e);
}
}
public static void main(String arg[])
{
new search1();
}
}