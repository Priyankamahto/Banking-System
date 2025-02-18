import java. awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class delete extends JFrame implements ActionListener
{
String s1,s2;	
JLabel l1,l2;
JTextField t1,t2;
JButton bt,ct;
Font f1;
Connection con;

Statement st;
Container cn;
delete()
{
super("Delete Account");
cn=getContentPane();
cn.setLayout(null);

f1=new Font("CALIBIRI",Font.BOLD,30);

l1=new JLabel("ACCOUNT   NO");
l1.setFont(f1);
l1.setBounds(230,200,300,50);
cn.add(l1);
t1=new JTextField(10);
t1.setFont(f1);
t1.setBounds(200,300,300,50);
cn.add(t1);

bt=new JButton("DELETE");
bt.setFont(f1);
bt.setBounds(200,400,170,50);
cn.add(bt);
bt.addActionListener(this);

ct=new JButton("BACK");
ct.setFont(f1);
ct.setBounds(400,400,150,50);
cn.add(ct);
ct.addActionListener(this);

setSize(700,600);
setLocation(400,150);
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

			 /**con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");**/

con=DriverManager.getConnection("jdbc:odbc:account");


if(ae.getSource()==bt)
{
 s1=t1.getText();

st=con.createStatement();

int k=st.executeUpdate("delete from account where ACCOUNT_NO ='"+s1+"'");


t1.setText("");
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
new delete();
}
}
