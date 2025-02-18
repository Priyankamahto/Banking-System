import  java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class enquiry1 extends JFrame implements ActionListener
{
	JLabel a,b;
	JTextField ta;
	JButton bt,ct;
	JTextArea t;
	ImageIcon x;
	Statement s;
	String Str="";
	Connection con;
	Container cn;
	enquiry1()
	{
		super("Enquiry");
		cn=getContentPane();
		cn.setLayout(null);
		
		a=new JLabel("Enter Account_No.");
		a.setBounds(50,20,150,30);
		cn.add(a);
		
		ta=new JTextField(10);
		ta.setBounds(200,20,200,25);
		cn.add(ta);
			
		bt=new JButton("Search");
		bt.setBounds(120,60,90,25);
		cn.add(bt);
		bt.addActionListener(this);

                ct=new JButton("Back");
		ct.setBounds(250,60,90,25);
		cn.add(ct);
		ct.addActionListener(this);

		t=new JTextArea(5,85);
		t.setBounds(10,110,1060,200);
		cn.add(t);

		x=new ImageIcon("a.jpg");
		b=new JLabel(x);
		b.setBounds(100,400,800,300);
		cn.add(b);

		setSize(1100,1000);
                setLocation(230,0);
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
			con=DriverManager.getConnection("jdbc:odbc:transaction");
			s=con.createStatement();
			Str="Account_No"+"\t\t"+"Date"+"\t\t"+"Deposited_By"+"\t\t"+"Amount"+"\t\t"+"status"+"\t\t"+"Total_Amount"+"\n\n";
			if(ae.getSource()==bt)
			{
				String no=ta.getText();
				String Str1="select* from transaction where(Account_No='"+no+"')";
				ResultSet rs=s.executeQuery(Str1);
                                
				if(rs.next())
				{
					Str=Str+rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6);
					t.setText(Str);
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
			System.out.println(e);
		}
	}
	public static void main(String arg[])
	{
		new enquiry1();
	}
}