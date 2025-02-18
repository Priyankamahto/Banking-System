import  java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class withdraw extends JFrame implements ActionListener
{
JLabel a,b,c,d,e;
JTextField t1,t2,t3,t4,t5,t22;
JButton bt,ct,dt;
JTextArea t;
ImageIcon x;
Statement s,st,st1;
String Str="";
String s1,s2,s3,s4,s5,s6,s7,no,pk;
Integer i,j,add;
Connection con,con1;
Container cn;
withdraw()
{
super("Withdraw	");
cn=getContentPane();
cn.setLayout(null);
		
a=new JLabel("Enter Account no.");
a.setBounds(50,20,100,30);
/*a.setForeground(Color.RED);*/
cn.add(a);
t1=new JTextField(10);
t1.setBounds(180,20,150,25);
cn.add(t1);

b=new JLabel("Date");
b.setBounds(50,500,100,30);
cn.add(b);
t2=new JTextField(10);
t2.setBounds(180,500,150,25);
cn.add(t2);

c=new JLabel("Withdrawal by");
c.setBounds(50,550,150,30);
cn.add(c);
t3=new JTextField(10);
t3.setBounds(180,550,150,25);
cn.add(t3);

d=new JLabel("Amount to withdraw");
d.setBounds(50,600,150,30);
cn.add(d);
t4=new JTextField(10);
t4.setBounds(180,600,150,25);
cn.add(t4);

/*e=new JLabel("Balance");
e.setBounds(50,650,150,30);
cn.add(e);
t5=new JTextField(10);
t5.setBounds(180,650,150,25);
cn.add(t5);*/
			
bt=new JButton("Search");
bt.setBounds(350,20,90,25);
cn.add(bt);
ct=new JButton("Withdraw");
ct.setBounds(300,650,90,25);
cn.add(ct);
dt=new JButton("Back");
dt.setBounds(150,650,90,25);
cn.add(dt);
bt.addActionListener(this);
ct.addActionListener(this);
dt.addActionListener(this);

t=new JTextArea(5,85);
t.setBounds(10,50,1060,400);
cn.add(t);

setSize(1100,1000);
setLocation(230,0);
setBackground(Color.PINK);
setForeground(Color.PINK);
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
}
		
try
{

con=DriverManager.getConnection("jdbc:odbc:account");
s=con.createStatement();
if(ae.getSource()==bt)
{
no=t1.getText();
String Str1="select* from account where(Account_no='"+no+"')";
ResultSet rs=s.executeQuery(Str1);
if(rs.next())
{
s7=rs.getString(22);
Str="Name"+"\t\t"+rs.getString(1)+"\n\n"+"Phone No"+"\t\t"+rs.getString(2)+"\n\n"+"EMAIL"+"\t\t"+rs.getString(3)+"\n\n"+"Date Of Birth"+"\t\t"+rs.getString(4)+"\n\n"+"PAN NO"+"\t\t"+rs.getString(6)+"\n\n"+"Aadhar No"+"\t\t"+rs.getString(7)+"\n\n"+"Correspondence Address"+"\t"+rs.getString(13)+"\n\n"+"State"+"\t\t"+rs.getString(15)+"\n\n"+"PIN"+"\t\t"+rs.getString(14)+"\n\n"+"Country"+"\t\t"+rs.getString(16)+"\n\n"+"Account Type"+"\t\t"+rs.getString(21)+"\n\n"+"Balance"+"\t\t"+s7;

t.setText(Str);

i=Integer.parseInt(s7);
}
}
con=DriverManager.getConnection("jdbc:odbc:transaction");
con1=DriverManager.getConnection("jdbc:odbc:account");
if(ae.getSource()==ct)
{
s1=t1.getText();
s2=t2.getText();
s3=t3.getText();
s4=t4.getText();

j=Integer.parseInt(s4);
add=i-j;
pk="debit";
st=con.createStatement();
st1=con1.createStatement();
s5=String.valueOf(add);

int k=st.executeUpdate("Insert into transaction values('"+s1+"' ,'"+s2+"', '"+s3+"','"+s4+"','"+pk+"','"+s5+"')");
int m=st1.executeUpdate("update account set Opening_Balance='"+s5+"' where Account_No='"+no+"' ");

t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t.setText("");
}
if(ae.getSource()==dt)
{
new oppage();
setVisible(false);
}
}
catch(SQLException e)
{
System.out.println(e);
}
}
public static void main(String arg[])
{
new withdraw();
}
}