import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;



class Myjpanel extends JPanel implements ActionListener,ItemListener
{
private JPopupMenu ppm;
private JLabel jl;
int selct=0;
private File fl=null;
private JFileChooser jfc;
private JList js;

private Dimension dm;
private JMenuBar jmb;
private JMenu file,edit,format,help,developers,size,f;
private JMenuItem New,open,save,saveas,copy,paste,cut,style,abt,help1,exit,print,select,names,a,b,c,e;
private JTextArea jt;
private JComboBox jc1,jc2;
public Myjpanel(Dimension d)
{
try
{
UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
}
catch(Exception ex)
{
}
jfc=new JFileChooser();
dm=d;
String [] fs={"10","12","14","16","18","20","22","24","26","28","30","36","48","72"};
String [] ft={"Plain","Bold","Italics","Bold+Italic"};
String [] jst={"Cut","Copy","Paste","Select All"};
jc1=new JComboBox(fs);
jc1.setSelectedIndex(5);
js=new JList(jst);
jc2=new JComboBox(ft);
jc2.setSelectedIndex(0);
jl=new JLabel();
jl.setBounds(0,0,dm.width,25);

this.add(jl);
ppm=new JPopupMenu("Select :");
jmb=new JMenuBar();
//jmb.setBackground(Color.lightGray);
file=new JMenu("File");
edit=new JMenu("Edit");
//format=new JMenu("Format");
help=new JMenu("Help");
developers=new JMenu("Developer");
New= new JMenuItem("New");
open=new JMenuItem("Open");
save=new JMenuItem("Save");
saveas=new JMenuItem("Save As");
f=new JMenu("Font : ");
style=new JMenuItem("Style");
paste=new JMenuItem("Paste");
cut=new JMenuItem("Cut");
copy=new JMenuItem("Copy");
print=new JMenuItem("print");
select=new JMenuItem("Select All");
a=new JMenuItem("Cut");
b=new JMenuItem("Copy");
c=new JMenuItem("Paste");
e=new JMenuItem("Select All");
size=new JMenu("Size");
abt=new JMenuItem("About Java Textpad");
help1=new JMenuItem("Help");
exit=new JMenuItem("Exit");
names=new JMenuItem("Names");
jmb.add(file);
jmb.add(edit);
//jmb.add(format);
jmb.add(help);
jmb.add(developers);
jmb.add(f);
jmb.add(jc1);
jmb.add(jc2);
file.add(New);
file.add(open);
file.add(save);
file.add(saveas);
file.add(print);
file.add(exit);
edit.add(copy);
edit.add(cut);
edit.add(paste);
edit.add(select);
developers.add(names);
paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
select.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
//format.add(size);
//size.add(jc1);
//format.add(style);
help.add(help1);
help.add(abt);
New.addActionListener(this);
open.addActionListener(this);
save.addActionListener(this);
saveas.addActionListener(this);
copy.addActionListener(this);
paste.addActionListener(this);
cut.addActionListener(this);
//size.addActionListener(this);
//style.addActionListener(this);
abt.addActionListener(this);
help1.addActionListener(this);
select.addActionListener(this);
exit.addActionListener(this);
print.addActionListener(this);
names.addActionListener(this);

a.addActionListener(this);
b.addActionListener(this);
c.addActionListener(this);
e.addActionListener(this);


jc1.addItemListener(this);
jc2.addItemListener(this);
this.add(jmb);
this.setLayout(null);
jmb.setBounds(0,0,dm.width-dm.width/2,25);
jt=new JTextArea();
jt.setLineWrap(true);
//jt.setBounds(0,21,dm.width,dm.height);
JScrollPane jsp=new JScrollPane(jt);
jsp.setBounds(0,22,dm.width-15,dm.height-90);
this.add(jsp);
ppm.add(a);
ppm.add(b);
ppm.add(c);
ppm.add(e);
jt.setFont(new Font("Regular",Font.PLAIN,20));
//jt.getScrollableUnitIncrement(new (d.width,dm.height-20),SwingConstants.VERTICAL,1);
	jt.addMouseListener(new MouseAdapter()
	{
	public void mouseClicked(MouseEvent e)
	{
	if(e.getButton()==MouseEvent.BUTTON3)
	ppm.show(jt, e.getX(), e.getY());
	}
	});

}
public void actionPerformed(ActionEvent ae)
{
if(b.isArmed())
{
jt.copy();
}
else if(c.isArmed())
{
jt.paste();
}
else if(a.isArmed())
{
jt.cut();
}
else if(copy.isArmed())
{
jt.copy();
}
else if(paste.isArmed())
{
jt.paste();
}
else if(cut.isArmed())
{
jt.cut();
}
else if(print.isArmed())
{
try
{
jt.print();
}
catch(Exception ex)
{
}
}
else if(select.isArmed())
{
jt.selectAll();
}
else if(e.isArmed())
{
jt.selectAll();
}
else if(open.isArmed())
{
	jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	//jfc.setCurrentDirectory(new File("D:\\")); 
	int choice=jfc.showOpenDialog(null);
	if(choice!=JFileChooser.CANCEL_OPTION)
	{
	selct=1;
	save.setEnabled(true);
	fl=jfc.getSelectedFile();
	}
	if(fl==null)
	JOptionPane.showMessageDialog(null,"You didn't select a file");		
	else
	{
	int option=JOptionPane.showConfirmDialog(null,"You selected "+fl.getName()+"\nDo you want to open it?");
	if(option==JOptionPane.YES_OPTION)
	{
	try
	{
						
	FileReader fr=new FileReader(fl);
	char []arr=new char[(int)fl.length()];
	fr.read(arr);
	jt.setText("");
	jt.setText(String.valueOf(arr));
	}
	catch(Exception obj)
	{
                  JOptionPane.showMessageDialog(null,"Problem reading file");	
						
	}
 	}
	}
}
else if(save.isArmed())
{
	try
	{
	if(selct==1)
	{
	String str=jt.getText();
	FileWriter fw=new FileWriter(fl);
	fw.write(str);
	fw.close();
	}
	else
	{
	while(true)
	{
	int choice=jfc.showSaveDialog(null);	
	if(choice==JFileChooser.APPROVE_OPTION)
	{
	String str=jt.getText();
	String path = jfc.getSelectedFile().getAbsolutePath();
	path+=".txt";	
	fl = new File(path);
	FileWriter fw=new FileWriter(fl);
	fw.write(str);
	fw.close();
	selct=1;
	break;
	}
	else if(choice==JFileChooser.CANCEL_OPTION)
	{
	int answer4=JOptionPane.showConfirmDialog(null,"Don't You wanna Save it ?","Save???",JOptionPane.YES_NO_OPTION);
	if(answer4==JOptionPane.NO_OPTION)
	{
 	break;
	}
	}
	}

    	}
	}
	catch(Exception ex)
	{
	}


}
else if(saveas.isArmed())
{
                   try
	{
	while(true)
	{
	int choice=jfc.showSaveDialog(null);	
	if(choice==JFileChooser.APPROVE_OPTION)
	{
	String str=jt.getText();
	String path = jfc.getSelectedFile().getAbsolutePath();
	path+=".txt";	
	fl = new File(path);
	FileWriter fw=new FileWriter(fl);
	fw.write(str);
	fw.close();
	selct=1;
	break;
	}
	else if(choice==JFileChooser.CANCEL_OPTION)
	{
	int answer3=JOptionPane.showConfirmDialog(null,"Don't You wanna Save it ?","Save???",JOptionPane.YES_NO_OPTION);
	if(answer3==JOptionPane.NO_OPTION)
	{
 	break;
	}
	}
	}

    	}
	catch(Exception ex)
	{
	}
}
if(New.isArmed())
{
	String str1=jt.getText();
	if(str1.length()!=0)
	{
	int answer2=JOptionPane.showConfirmDialog(null,"Don't You wanna Save it ?","Save???",JOptionPane.YES_NO_OPTION);
	if(answer2==JOptionPane.YES_OPTION)
	{	
	
	try
	{
	if(selct==1)
	{
	String str=jt.getText();
	FileWriter fw=new FileWriter(fl);
	fw.write(str1);
	fw.close();
	}
	else
	{
	while(true)
	{
	int choice=jfc.showSaveDialog(null);	
	if(choice==JFileChooser.APPROVE_OPTION)
	{
	String str=jt.getText();
	String path = jfc.getSelectedFile().getAbsolutePath();
	path+=".txt";	
	fl = new File(path);
	FileWriter fw=new FileWriter(fl);
	fw.write(str);
	fw.close();
	selct=1;
	break;
	}
	else if(choice==JFileChooser.CANCEL_OPTION)
	{
	int answer1=JOptionPane.showConfirmDialog(null,"Don't You wanna Save it ?","Save???",JOptionPane.YES_NO_OPTION);
	if(answer1==JOptionPane.NO_OPTION)
	{
 	break;
	}
	}
	}

    	}
	}
	catch(Exception ex)
	{
	}
	}
	}
selct=0;
jt.setText("");
}
else if(exit.isArmed())
{

String str1=jt.getText();
	if(str1.length()!=0)
	{
	int answer5=JOptionPane.showConfirmDialog(null,"Don't You wanna Save it ?","Save???",JOptionPane.YES_NO_OPTION);
	if(answer5==JOptionPane.YES_OPTION)
	{	
	
	try
	{
	if(selct==1)
	{
	String str=jt.getText();
	FileWriter fw=new FileWriter(fl);
	fw.write(str1);
	fw.close();
	}
	else
	{
	while(true)
	{
	int choice=jfc.showSaveDialog(null);	
	if(choice==JFileChooser.APPROVE_OPTION)
	{
	String str=jt.getText();
	String path = jfc.getSelectedFile().getAbsolutePath();
	path+=".txt";	
	fl = new File(path);
	FileWriter fw=new FileWriter(fl);
	fw.write(str);
	fw.close();
	selct=1;
	break;
	}
	else if(choice==JFileChooser.CANCEL_OPTION)
	{
	int answer6=JOptionPane.showConfirmDialog(null,"Don't You wanna Save it ?","Save???",JOptionPane.YES_NO_OPTION);
	if(answer6==JOptionPane.NO_OPTION)
	{
 	break;
	}
	}
	}

    	}
	}
	catch(Exception ex)
	{
	}
	}
	}
System.exit(0);
}
else if(abt.isArmed())
{
String message="This is a Simple Application that will help  you to create a Text based file \n that is .txt and  you can Simply work on it and save again it according to your need...\n and this is completly written in the language java...";
JOptionPane.showMessageDialog(null,message,"About : ?",3);
}
else if(help1.isArmed())
{
String message=" Some Shortcuts created in java :\n Save = ctrl+S, New= ctrl+N, \n Open=ctrl+O,Paste = ctrl+V, \n Print=ctrl+P, Cut= ctrl+C \n You can Exit only from the Menu File ";
JOptionPane.showMessageDialog(null,message,"Help :",1);
}
else if(names.isArmed())
{
JOptionPane.showMessageDialog(null," Monika & Sakshi","Made by :",1);
}




}
public void itemStateChanged(ItemEvent it)
{
	if(it.getStateChange()==ItemEvent.SELECTED)
		{
int sec=jc2.getSelectedIndex();
int fir=0;
if(sec==0)
sec=Font.PLAIN;
else if(sec==1)
sec=Font.BOLD;
else if(sec==2)
sec=Font.ITALIC;
else
{
sec=Font.BOLD;
fir=Font.ITALIC;
}
jt.setFont(new Font("",sec+fir,Integer.parseInt((String)jc1.getItemAt(jc1.getSelectedIndex()))));
		}


}
}


class Myjframe extends JFrame
{
private Myjpanel pj;
public Myjframe(String title)
{
super(title);
Toolkit tk=Toolkit.getDefaultToolkit();
Dimension dm=tk.getScreenSize();
this.setBounds(1,1,dm.width,dm.height);
this.setVisible(true);
pj=new Myjpanel(dm);
Container ct=this.getContentPane();
ct.add(pj);
this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE );

}
}


public class TextPad
{
public static void main(String [] args)
{
Myjframe frame=new Myjframe("Java Notepad");
}
}
