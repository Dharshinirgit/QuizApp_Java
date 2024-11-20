// importing required packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class quiz3 implements ActionListener{
     static int count;
  JFrame frame=new JFrame();
  JLabel title=new JLabel("Quiz Questions");
  JLabel question2=new JLabel("3) Which of the following is not feature of Java ?");
  
  JCheckBox ans1=new JCheckBox("a. Object oriented");
  JCheckBox ans2=new JCheckBox("b. Use of pointers");
  JCheckBox ans3=new JCheckBox("c. Portable");
  JCheckBox ans4=new JCheckBox("d. Dynamic and extensible");
  
  JButton submitbtn=new JButton("Submit");
  
  public void quiz3_init(int count)
  {
   this.count=count;   
   createwindow();
   locationandsize();
   addcomponent();
   actionevent();   
  }    
  // creating new window
  public void createwindow()
  {
      frame=new JFrame();
      frame.setTitle("Question 3");
      frame.setBounds(300,300,1200,900);
      frame.getContentPane().setBackground(Color.white);
      frame.getContentPane().setLayout(null);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
  } 
  // setting size and location of the components
  public void locationandsize()
  {
      title.setBounds(350,10,600,40);
      title.setBackground(Color.white);
      title.setFont(new Font("cambria",Font.CENTER_BASELINE,25));
      
      question2.setBounds(50,60,1200,40);
      question2.setBackground(Color.white);
      question2.setFont(new Font("cambria",Font.CENTER_BASELINE,18));
      
      ans1.setBounds(50,130,400,40);
      ans1.setBackground(Color.white);
      ans1.setFont(new Font("cambria",Font.CENTER_BASELINE,18));
      
      ans2.setBounds(50,180,400,40);
      ans2.setBackground(Color.white);
      ans2.setFont(new Font("cambria",Font.CENTER_BASELINE,18));
      
      ans3.setBounds(50,230,400,40);
      ans3.setBackground(Color.white);
      ans3.setFont(new Font("cambria",Font.CENTER_BASELINE,18));
      
      ans4.setBounds(50,280,400,40);
      ans4.setBackground(Color.white);
      ans4.setFont(new Font("cambria",Font.CENTER_BASELINE,18));
      
      submitbtn.setBounds(50,330,200,40);
      submitbtn.setFont(new Font("cambria",Font.CENTER_BASELINE,18));
  }    
  // adding components to frame
  public void addcomponent()
  {
      frame.add(title);
      frame.add(question2);
      frame.add(ans1);
      frame.add(ans2);
      frame.add(ans3);
      frame.add(ans4);
      frame.add(submitbtn);
  } 
  // action listener
  public void actionevent()
  {
      submitbtn.addActionListener((ActionListener) this);
  } 
  // quiz question's answer validation and providing marks for right answer
  @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==submitbtn)
      {
          String answer=null;
          if(ans1.isSelected())
          {
              answer="a. Object oriented";
          }    
          if(ans2.isSelected())
          {    
              answer="b. Use of pointers";
          }    
          if(ans3.isSelected())
          {
              answer="c. Portable";
          }  
          if(ans4.isSelected())
          {
              answer="d. Dynamic and extensible";
          }    
          if(answer=="b. Use of pointers")
          {
              JOptionPane.showMessageDialog(null,"Wait for results");
              JOptionPane.showMessageDialog(null,"Correct Answer");
              count+=1;
              quiz4 q4=new quiz4();
              q4.quiz4_init(count);
              frame.setVisible(false);   
          }  
          else
          {
              JOptionPane.showMessageDialog(null,"Wait for results");
              JOptionPane.showMessageDialog(null,"Wrong Answer");
              quiz4 q4=new quiz4();
              q4.quiz4_init(count);
              frame.setVisible(false); 
          }    
      }    
    }
    // main method
    public static void main(String[] args)
    {
        quiz3 q3=new quiz3();
        q3.quiz3_init(count);
    }        
}
