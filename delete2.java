import java. awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class delete2 extends JFrame implements ActionListener
{
String s1,s2;	
JLabel l1,l2;
JTextField t1,t2;
JButton bt,ct;
Font f1;
Connection con;

Statement st;
Container cn;
delete2()
{
super("Delete Employee details");
cn=getContentPane();
cn.setLayout(null);

f1=new Font("CALIBIRI",Font.BOLD,30);

l1=new JLabel("Employee Id");
l1.setFont(f1);
l1.setBounds(250,200,300,50);
cn.add(l1);
t1=new JTextField(10);
t1.setFont(f1);
t1.setBounds(200,300,300,50);
cn.add(t1);

bt=new JButton("DELETE");
bt.setFont(f1);
bt.setBounds(150,400,200,50);
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

			/** con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","employee");**/

con=DriverManager.getConnection("jdbc:odbc:employee");

 


if(ae.getSource()==bt)
{
 s1=t1.getText();

st=con.createStatement();

int k=st.executeUpdate("delete from employee where Employee_Id ='"+s1+"'");


t1.setText("");
}
if(ae.getSource()==ct)
{
new adpage();
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
new delete2();
}
}