import java. awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class employee extends JFrame implements ActionListener
{	
JLabel a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14;
JTextField t1,t1a,t1b,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
JButton bt,ct;
ButtonGroup bg;
JRadioButton r1,r2,r3;
JComboBox cb1,cb2;
JList l1,l2;
JTextArea ta1;
JScrollPane jp1;
String post[]={"CLERK","MANAGER","PO","ACCOUNTANT","FIELD OFFICER","CASHIER","STAFF","INTERN"};
Container cn;
Connection con;
Statement st;
String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14;
employee()
{
super("EMPLOYEE  PAGE");
cn=getContentPane();
cn.setLayout(null);

a1=new JLabel("Employee Id");
a1.setBounds(10,10,100,25);
cn.add(a1);
t1=new JTextField(10);
t1.setBounds(150,10,150,25);
cn.add(t1);


a2=new JLabel("Employee Name");
a2.setBounds(10,50,100,25);
cn.add(a2);
t2=new JTextField(10);
t2.setBounds(150,50,150,25);
cn.add(t2);

a3=new JLabel("Email");
a3.setBounds(10,100,80,25);
cn.add(a3);
t3=new JTextField(10);
t3.setBounds(150,100,150,25);
cn.add(t3);

a4=new JLabel("Date Of Birth");
a4.setBounds(10,150,120,25);
cn.add(a4);
t4=new JTextField(10);
t4.setBounds(150,150,200,25);
cn.add(t4);

a5=new JLabel("Contact No");
a5.setBounds(10,200,120,50);
cn.add(a5);
t5=new JTextField(10);
t5.setBounds(150,210,100,25);
cn.add(t5);

a6=new JLabel("GENDER");
a6.setBounds(10,250,100,50);
cn.add(a6);
bg=new ButtonGroup();
r1=new JRadioButton("Male");
r1.setBounds(150,260,80,25);
cn.add(r1);
r2=new JRadioButton("Female");
r2.setBounds(250,260,100,25);
cn.add(r2);
r3=new JRadioButton("Others");
r3.setBounds(350,260,100,25);
cn.add(r3);

bg.add(r1);
bg.add(r2);
bg.add(r3);

a7=new JLabel("PAN No");
a7.setBounds(10,300,50,25);
cn.add(a7);
t7=new JTextField(10);
t7.setBounds(150,300,150,25);
cn.add(t7);

a8=new JLabel("Aadhar no");
a8.setBounds(10,350,100,25);
cn.add(a8);
t8=new JTextField(10);
t8.setBounds(150,350,150,25);
cn.add(t8);

a9=new JLabel("Address");
a9.setBounds(10,400,100,25);
cn.add(a9);
ta1=new JTextArea(10,10);
ta1.setBounds(150,400,300,50);
cn.add(ta1);

a10=new JLabel("Date Of Joinning");
a10.setBounds(10,460,120,50);
cn.add(a10);
t10=new JTextField(10);
t10.setBounds(150,470,150,25);
cn.add(t10);

a11=new JLabel("Post");
a11.setBounds(10,520,100,25);
cn.add(a11);
cb1=new JComboBox(post);
cb1.setBounds(150,520,150,25);
cn.add(cb1);

a12=new JLabel("Salary");
a12.setBounds(10,550,50,50);
cn.add(a12);
t12=new JTextField(10);
t12.setBounds(150,560,150,25);
cn.add(t12);

a13=new JLabel("Password");
a13.setBounds(10,600,100,50);
cn.add(a13);
t13=new JTextField(10);
t13.setBounds(150,610,150,25);
cn.add(t13);

a14=new JLabel("Repassword");
a14.setBounds(10,650,100,50);
cn.add(a14);
t14=new JTextField(10);
t14.setBounds(150,660,150,25);
cn.add(t14);

bt=new JButton("Submit");
bt.setBounds(100,750,100,25);
cn.add(bt);

ct=new JButton("BACK");
ct.setBounds(300,750,100,25);
cn.add(ct);
 
bt.addActionListener(this);
ct.addActionListener(this);
 
setSize(800,1000);
setLocation(300,0);
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
con=DriverManager.getConnection("jdbc:odbc:employee");
if(ae.getSource()==bt)
{
 s1=t1.getText();
 s2=t2.getText();
 s3=t3.getText();
 s4=t4.getText();
 s5=t5.getText();
 
 s7=t7.getText();
 s8=t8.getText();
 s9=ta1.getText();
 s10=t10.getText();
 s12=t12.getText();
 s13=t13.getText();
 s14=t14.getText();

if(r1.isSelected())
{
s6="Male";
} 
if(r2.isSelected())
{
s6="Female";
}
if(r3.isSelected())
{
s6="Others";
}
s11=(String)cb1.getSelectedItem();

st=con.createStatement();

int k=st.executeUpdate("Insert into employee values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"','"+s11+"','"+s12+"','"+s13+"','"+s14+"')");


t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");

t7.setText("");
t8.setText("");
ta1.setText("");
t10.setText("");

t12.setText("");
t13.setText("");
t14.setText("");
}
if(ae.getSource()==ct)
{
new adpage();
}
}
catch(SQLException e)
{
System.out.print(e);
} 
setVisible(false);
}
public static void main(String arg[])
{
new employee();
}
}