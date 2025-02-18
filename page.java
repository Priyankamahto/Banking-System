import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class page extends JFrame implements ActionListener
{
JLabel l1,l2,l3;
JLabel lb;
Button bt,ct;
TextField tf1,tf2;
String a,b;
Font f1,f2;
ImageIcon img;
page()
{
setLayout(null);
f1=new Font("CALIBIRI",Font.ITALIC,30);
l1=new JLabel("ADMIN LOGIN  PAGE  HERE !! ");
l1.setFont(f1);
l1.setForeground(Color.WHITE);
l1.setBounds(130,50,450,50);
add(l1);

f2=new Font("CALIBIRI",Font.BOLD,30);
l2=new JLabel("User Id");
l2.setFont(f2);
l2.setForeground(Color.WHITE);
l2.setBounds(110,180,150,30);
add(l2);
tf1=new TextField(50);
tf1.setBounds(360,180,200,30);
add(tf1);

l3=new JLabel("Password");
l3.setFont(f2);
l3.setForeground(Color.WHITE);
l3.setBounds(110,230,150,30);
add(l3);
tf2=new TextField(50);
tf2.setBounds(360,230,200,30);
add(tf2);

bt=new Button("LOG IN");
bt.setBounds(400,300,60,40);
add(bt);            

ct=new Button("BACK");
ct.setBounds(200,300,60,40);
add(ct);

img=new ImageIcon("blue.jpg");
lb=new JLabel(img);
lb.setBounds(0,0,909,450);
add(lb);

bt.addActionListener(this);
  ct.addActionListener(this);

setSize(700,450);
setLocation(400,150);
setVisible(true);
setBackground(Color.pink);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==bt)
{
a=tf1.getText();
b=tf2.getText();
if(b.equals("1234") &&  a.equals("admin")) 
{
new adpage();
}
}
if (ae.getSource()==ct)
{
new choose();
}
setVisible(false);
}
public static void main(String[]args)
{
new page();
}
}