import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class oppage extends JFrame implements ActionListener
{
JLabel l1,lb;
ImageIcon img,x;
JButton bt,ct;
Font f1,f2;
JMenuBar mb;
JMenu a,c;
JMenuItem a1,a2,a3,a4,a5,a6,c1,c2,c3;
Container cn;
oppage()
{
super("Operator Page");
cn=getContentPane();
cn.setLayout(null);
f1=new Font("CALIBIRI",Font.BOLD,50);
f2=new Font("MONOSPACED",Font.ITALIC,30);

l1=new JLabel("OPERATOR  PAGE");
l1.setFont(f1);
l1.setBounds(500,300,900,50);
l1.setForeground(Color.BLACK);
cn.add(l1);

img=new ImageIcon("aa.jpg");
lb=new JLabel(img);
lb.setBounds(0,0,1920,1080);
cn.add(lb);

bt=new JButton("BACK");
bt.setFont(f2);
bt.setBounds(500,700,150,50);
bt.setForeground(Color.WHITE);
bt.setBackground(Color.BLACK);
cn.add(bt);

ct=new JButton("EXIT");
ct.setFont(f2);
ct.setBounds(800,700,150,50);
ct.setForeground(Color.WHITE);
ct.setBackground(Color.BLACK);
cn.add(ct);

bt.addActionListener(this);
ct.addActionListener(this);

mb=new JMenuBar();
a=new JMenu("ACCOUNT");
mb.add(a);
a1=new JMenuItem("CREATE");
a.add(a1);
a2=new JMenuItem("UPDATE");
a.add(a2);
a3=new JMenuItem("SEARCH");
a.add(a3);
a4=new JMenuItem("DELETE");
a.add(a4);
a5=new JMenuItem("EXIT");
a.add(a5);

c=new JMenu("TRANSACTION");
mb.add(c);
c1=new JMenuItem("DEPOSIT");
c.add(c1);
c2=new JMenuItem("WITHDRAWL");
c.add(c2);
c3=new JMenuItem("ENQUIRY");
c.add(c3);

a1.addActionListener(this);
a2.addActionListener(this);
a3.addActionListener(this);
a4.addActionListener(this);
a5.addActionListener(this);
c1.addActionListener(this);
c2.addActionListener(this);
c3.addActionListener(this);

mb.setBounds(0,0,500,30);
setJMenuBar(mb);
setSize(1920,1080);
setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if (ae.getSource()==bt)
{
new choose();
}
if (ae.getSource()==ct)
{
System.exit(0);
}
if (ae.getSource()==a1)
{
new account();
}
if (ae.getSource()==a2)
{
new update();
}
if (ae.getSource()==a3)
{
new search1();
}
if (ae.getSource()==a4)
{
new delete();
}
if (ae.getSource()==a5)
{
System.exit(0);
}
if (ae.getSource()==c1)
{
new deposit1();
}
if (ae.getSource()==c2)
{
new withdraw();
}
if (ae.getSource()==c3)
{
new enquiry1();
}
setVisible(false);
}
public static void main(String[]args)
{
new oppage();
}
}




