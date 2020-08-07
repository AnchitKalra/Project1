import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Calculator extends JFrame implements ActionListener
{
	int sum=0;
	//char al;
	JButton b[]=new JButton[17];
	JTextField tf=new JTextField("	    0");
	static int count=0;
	Calculator()
	{
		super("Calculator");
		//tf.setText("0");
		tf.setSize(200,200);
		add(tf);
		tf.setEditable(false);
		for(int i=0;i<10;i++)
	{
		b[i]=new JButton(String.valueOf(i));
		add(b[i]);
		b[i].addActionListener(this);
	}
		setVisible(true);
		b[10]=new JButton("+");
		add(b[10]);
		b[10].addActionListener(this);
		b[11]=new JButton("-");
		add(b[11]);
		b[11].addActionListener(this);
		b[12]=new JButton("/");
		add(b[12]);
		b[12].addActionListener(this);
		b[13]=new JButton("*");
		add(b[13]);
		b[13].addActionListener(this);
		b[14]=new JButton("=");
		add(b[14]);
		b[14].addActionListener(this);
		b[15]=new JButton("C");
		add(b[15]);
		b[15].addActionListener(this);
		b[16]=new JButton(".");
		add(b[16]);
		b[16].addActionListener(this);
	}
	
	
	
	public void actionPerformed(ActionEvent e)
		{	
			//i
			int a=0,c=0;
			count++;
			if(count==1)
			{
				tf.setText("0");
				System.out.println("Value of count once::");
				
			}
			String txt=tf.getText();
			//System.out.println(e.getSource());
			//tf.setText("OK Button Clicked!");
			for(int i=0;i<10;i++)
			{
				
				
				if(e.getSource()==b[i])
			{
				
				tf.setText(txt+String.valueOf(i));
			}
				
			}
			if(e.getSource()==b[10])
			{
				//System.out.println("HHHIIIII");
				
				tf.setText(tf.getText()+"+");
				//al='+';
			}
			if(e.getSource()==b[15])
			{
				//a=0;
				sum=0;
				tf.setText("0");
				//al=0;
			}
			if(e.getSource()==b[14])
			{
				int cal=0;
				String tx=tf.getText();
				String token[]=new String[10];
				for(int i=0;i<10;i++)
				{
					token[i]="";
				}
				int j=0,k=0;
				char op[]=new char[5];
				for(int i=0;i<tx.length();i++)
				{
				if(tx.charAt(i)=='+'||tx.charAt(i)=='-'||tx.charAt(i)=='/'||tx.charAt(i)=='*')
				{
				op[j]=tx.charAt(i);
				j++;
				if(j>1)
				{
				switch(op[j-2])
				{
					case '+':
					if(j==2)
					{
					a=Integer.parseInt(token[j-2]);
					c=Integer.parseInt(token[j-1]);
					cal=a+c;
					}
					else{
							a=Integer.parseInt(token[j-1]);
							cal+=a;
						}
					break;
					case '-':
					if(j==2)
					{
					a=Integer.parseInt(token[j-2]);
					c=Integer.parseInt(token[j-1]);
					cal=a-c;
					}
					else{
							a=Integer.parseInt(token[j-1]);
							cal-=a;
						}
						break;
					case '/':
					if(j==2)
					{
					a=Integer.parseInt(token[j-2]);
					c=Integer.parseInt(token[j-1]);
					cal=a/c;
					}
					else{
							a=Integer.parseInt(token[j-1]);
							cal/=a;
						}
					
					break;
					case '*':
					if(j==2)
					{
					a=Integer.parseInt(token[j-2]);
					c=Integer.parseInt(token[j-1]);
					cal=a*c;
					}
					else{
							a=Integer.parseInt(token[j-1]);
							cal*=a;
						}
					break;
				}
				}
				}
				else
				{
					token[j]=token[j]+tx.charAt(i);
					System.out.println(token[j]);
					if(i==tx.length()-1)
					{
						switch(op[j-1])
						{
					case '+':
					 if(j==1)
					{
					 a=Integer.parseInt(token[j-1]);
					c=Integer.parseInt(token[j]);
					cal=a+c;
					tf.setText(String.valueOf(cal));
					System.out.println(cal);
					}
					else{
					a=Integer.parseInt(token[j]);
					cal+=a;
					tf.setText(String.valueOf(cal));
					System.out.println(cal);
					}
					break;
					case '-':
					if(j==1)
					{
					 a=Integer.parseInt(token[j-1]);
					c=Integer.parseInt(token[j]);
					cal=a-c;
					tf.setText(String.valueOf(cal));
					}
					else{
					a=Integer.parseInt(token[j]);
					cal-=a;
					tf.setText(String.valueOf(cal));
					}
					break;
					case '/':
					 if(j==1)
					{
					 a=Integer.parseInt(token[j-1]);
					c=Integer.parseInt(token[j]);
					cal=a/c;
					tf.setText(String.valueOf(cal));
					}
					else{
					a=Integer.parseInt(token[j]);
					cal/=a;
					tf.setText(String.valueOf(cal));
					}
					break;
					case '*':
					 if(j==1)
					{
					 a=Integer.parseInt(token[j-1]);
					c=Integer.parseInt(token[j]);
					cal=a*c;
					tf.setText(String.valueOf(cal));
					}
					else{
					a=Integer.parseInt(token[j]);
					cal*=a;
					tf.setText(String.valueOf(cal));
					}
					break;
				}
					}
				}
				}
				}
				if(e.getSource()==b[11])
			{
				
				tf.setText(txt+"-");
				}
					if(e.getSource()==b[12])
			{
				
				tf.setText(txt+"/");
				}
					if(e.getSource()==b[13])
			{
					tf.setText(txt+"*");
				}
		}
		public static void main(String args[])
		{
			Calculator c=new Calculator();
			c.setSize(150,300);
			c.setResizable(false);
			c.setLayout(new FlowLayout());
			c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
}