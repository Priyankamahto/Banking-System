import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class bank extends JFrame implements ActionListener
{
JLabel l1,lb;
ImageIcon img,x;
JButton bt,ct;
Font f1,f2;
Container cn;
bank()
{
super("Bank Page");
cn=getContentPane();
cn.setLayout(null);
f1=new Font("CALIBIRI",Font.BOLD,50);
f2=new Font("AGASTINA",Font.BOLD,30);

l1=new JLabel("BANKING MANAGEMENT SYSTEM");
l1.setFont(f1);
l1.setBounds(400,230,1000,50);
l1.setForeground(Color.BLACK);
cn.add(l1);

img=new ImageIcon("aa.jpg");
lb=new JLabel(img);
lb.setBounds(0,20,1750,980);
cn.add(lb);

bt=new JButton("NEXT");
bt.setFont(f2);
bt.setBounds(500,700,150,50);
bt.setForeground(Color.BLACK);
bt.setBackground(Color.WHITE);
cn.add(bt);

ct=new JButton("EXIT");
ct.setFont(f2);
ct.setBounds(800,700,150,50);
ct.setForeground(Color.BLACK);
ct.setBackground(Color.WHITE);
cn.add(ct);

bt.addActionListener(this);
ct.addActionListener(this);

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
setVisible(false);
}
public static void main(String[]args)
{
new bank();
}
}





