import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class viewall extends JFrame implements ActionListener
{  
   JButton b;
   Container c;
   Connection con;
   JTable jt;
   
 public viewall()
   {	
        c=getContentPane();
	c.setLayout(null);
	b=new JButton("Goto Previous Page");
	b.setBounds(650,400,160,40);
	c.add(b);
	b.addActionListener(this);
	String url="jdbc:odbc:account";
	try
	{  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   con=DriverManager.getConnection(url);
	}
	
	catch(ClassNotFoundException cf)
	{  System.out.println("Driver Class not found");
	   System.exit(1);
	}

	catch(SQLException se)
	{  System.out.println("Unable to connect");
	}
      	getTable();
	setVisible(true);
	setSize(1920,1080);
	show();
    }

    private void getTable()
    {	Statement st;
	ResultSet rs;
	try
	{  String qry="Select * from account";
	   st=con.createStatement();
	   rs=st.executeQuery(qry);
          	   displayResult(rs);
	   st.close();
	}

	catch(SQLException e)
	{  
         e.printStackTrace();
	}
    }

    private void displayResult(ResultSet rs)throws SQLException
    {  	boolean morerec=rs.next();  
	if(!morerec)
	{  JOptionPane.showMessageDialog(this,"Resultset Contained no records");
	   setTitle("No Transaction to display");
	   return;
	}
	setTitle("Xtreme Transactions");
	Vector colhead=new Vector();
	Vector rows=new Vector();
	try
	{  ResultSetMetaData rsmd=rs.getMetaData();
	   for(int i=1;i<=rsmd.getColumnCount();++i)
		colhead.addElement(rsmd.getColumnName(i));
	   do
            	   {	
rows.addElement(getNextRow(rs,rsmd));
	   }
while(rs.next());
	   
	   jt=new JTable(rows,colhead);
	   JScrollPane sc=new JScrollPane(jt);
sc.setBounds(10,10,1500,250);
	   getContentPane().add(sc);               
           //.BorderLayout.CENTER);
	}

	catch(SQLException sql)
	{  sql.printStackTrace();
	}
     }

     private Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd)throws SQLException
     {	Vector curow=new Vector();
	for(int i=1;i<=rsmd.getColumnCount();++i)
	 switch(rsmd.getColumnType(i))
	   {

            
 case Types.VARCHAR: curow.addElement(rs.getString(i));
   				  break;
default:
curow.addElement( new Long(rs.getLong(i)) );
break;
		
  }
 return curow;
 
	}
     
      public void shutDown()
      {	try
	{  con.close();
	}

	catch(SQLException sq){}
      }

      public void actionPerformed(ActionEvent ae)
      {
	if(ae.getSource()==b)
	{
            new adpage();
	}
setVisible(false);
 }

      public static void main (String arg[])
      {	 
         new viewall();
	 
      }

}

				   
	 
   
