import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class choose extends JFrame implements ActionListener
{
Label l1,l2,l3;
JLabel lb,lb1,lb2;
Button bt,ct,dt;
TextField tf1,tf2;
String a,b;
Font f1,f2;
ImageIcon img,img1;
Container cn;
choose()
{
super("Choose");
cn=getContentPane();
setLayout(null);

f1=new Font("CALIBIRI",Font.BOLD,30);
f2=new Font("CALIBIRI",Font.BOLD,50);

lb2=new JLabel("Who are you?");
lb2.setFont(f2);
lb2.setBounds(550,10,500,100);
add(lb2);

img=new ImageIcon("operator.jpg");
lb=new JLabel(img);
lb.setBounds(400,100,300,300);
add(lb);
l1=new Label("OPERATOR ");
l1.setFont(f1);
l1.setBounds(450,430,300,50);
add(l1);

img1=new ImageIcon("admin.jpg");
lb1=new JLabel(img1);
lb1.setBounds(800,100,300,300);
add(lb1);
l2=new Label("ADMIN");
l2.setFont(f1);
l2.setBounds(900,430,200,50);
add(l2);

bt=new Button("LOG IN");
bt.setBounds(500,500,100,50);
add(bt);
ct=new Button("LOG IN");
ct.setBounds(900,500,100,50);
add(ct);
dt=new Button("BACK");
dt.setBounds(700,600,100,50);
add(dt);

bt.addActionListener(this);
ct.addActionListener(this);
dt.addActionListener(this);

setSize(1920,1080);
setVisible(true);
setBackground(Color.PINK);

}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==bt)
{
new pagee();
}
if(ae.getSource()==ct)
{
new page();
}
if(ae.getSource()==dt)
{
new bank();
}
setVisible(false);
}
public static void main(String[]args)
{
new choose();
}
}
