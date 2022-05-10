import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
	JFrame frame;
	JTextField textfield;
	
	JButton[]numbersButtons= new JButton[10];
	JButton[] fungtionButtons= new JButton[9];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton,equButton,delButton,clrButton ,negButton;
	JPanel panel;
	
	Font myFont=new Font("Calibri Italic",Font.BOLD,30);
	double num1=0,num2=0, result=0;
	char operator;
	
      Calculator(){
    	  frame=new JFrame("Calculator");
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  frame.setSize(420, 550);
    	  frame.setLayout(null);
    	 
    	  textfield=new JTextField();
    	  textfield.setBounds(50, 25,310, 50);//300
    	  textfield.setFont(myFont);
    	  textfield.setEditable(false);
    	  addButton= new JButton("+");
    	  subButton= new JButton("-");
    	  mulButton= new JButton("*");
    	  divButton= new JButton("/");
    	  equButton= new JButton("=");
    	  delButton= new JButton("Delete");
    	  clrButton= new JButton("Clear");
    	  decButton= new JButton(".");
    	  negButton= new JButton("(-)");
    	  
    	  fungtionButtons[0]=addButton;
    	  fungtionButtons[1]=subButton;
    	  fungtionButtons[2]=mulButton;
    	  fungtionButtons[3]=divButton;
    	  fungtionButtons[4]=decButton;
    	  fungtionButtons[5]=equButton;
    	  fungtionButtons[6]=delButton;
    	  fungtionButtons[7]=clrButton;
    	  fungtionButtons[8]=negButton;
    	  
    	  for(int i=0;i<9;i++) {
    		  fungtionButtons[i].addActionListener(this);
    		  fungtionButtons[i].setFont(myFont);
    		  fungtionButtons[i].setFocusable(false);
    	  }
    	  for(int i=0;i<10;i++) {
    		  numbersButtons[i]=new JButton(String.valueOf(i));
    		  numbersButtons[i].addActionListener(this);
    		  numbersButtons[i].setFont(myFont);
    		  numbersButtons[i].setFocusable(false);
    	  }
    	  negButton.setBounds(50,430,105,50);
    	  delButton.setBounds(140,430,125,50);
    	  clrButton.setBounds(240,430,120,50);
    	  
    	  
    	  panel=new JPanel();
    	  panel.setBounds(50, 100, 310, 310);
    	  panel.setLayout(new GridLayout(4,4,15,15));
    	  panel.setBackground(Color.yellow);
    	  textfield.setBackground(Color.PINK);
    	  
    	  panel.add(numbersButtons[1]);
    	  panel.add(numbersButtons[2]);
    	  panel.add(numbersButtons[3]);
    	  panel.add(addButton);
    	  panel.add(numbersButtons[4]);
    	  panel.add(numbersButtons[5]);
    	  panel.add(numbersButtons[6]);
    	  panel.add(subButton);
    	  panel.add(numbersButtons[7]);
    	  panel.add(numbersButtons[8]);
    	  panel.add(numbersButtons[9]);
    	  panel.add(mulButton);
    	  panel.add(decButton);
    	  panel.add(numbersButtons[0]);
    	  panel.add(equButton);
    	  panel.add(divButton);
    	  frame.add(panel);
    	  frame.add(negButton);
    	  frame.add(delButton);
    	  frame.add(clrButton);
    	  frame.add(textfield);
    	  frame.setVisible(true);
	
      }
	public static void main(String[] args) {
		Calculator calc=new Calculator();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++) {
			if(e.getSource()==numbersButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton){
		textfield.setText(textfield.getText().concat(String.valueOf(".")));	
		}
		if(e.getSource()==addButton){
			num1=Double.parseDouble(textfield.getText());
			operator='+';
			textfield.setText("");
			}
		if(e.getSource()==subButton){
			num1=Double.parseDouble(textfield.getText());
			operator='-';
			textfield.setText("");
			}
		if(e.getSource()==mulButton){
			num1=Double.parseDouble(textfield.getText());
			operator='*';
			textfield.setText("");
			}
		if(e.getSource()==divButton){
			num1=Double.parseDouble(textfield.getText());
			operator='/';
			textfield.setText("");
			}
		if(e.getSource()==equButton){
			num2=Double.parseDouble(textfield.getText());
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton){
			textfield.setText("");
			}
		if(e.getSource()==delButton){
			String string =textfield.getText();
			textfield.setText("");
			for(int i=0; i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
			}
		if(e.getSource()==negButton){
			double temp=Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
			}
		
	}
}
