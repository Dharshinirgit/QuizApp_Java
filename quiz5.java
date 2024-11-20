// importing required packages
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class quiz5 implements ActionListener{
    static int count;
  JFrame frame=new JFrame();
  JLabel title=new JLabel("Quiz Questions");
  JLabel question5=new JLabel("5) Which environment variable is used to set the java path?");
  
  JCheckBox ans1=new JCheckBox("a) MAVEN PATH");
  JCheckBox ans2=new JCheckBox("b) JAVAPATH");
  JCheckBox ans3=new JCheckBox("c) JAVA");
  JCheckBox ans4=new JCheckBox("d) JAVA_HOME");
  
  JButton submitbtn=new JButton("Submit");
  
  public void quiz5_init(int count)
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
      frame.setTitle("Question 5");
      frame.setBounds(300,300,1200,900);
      frame.getContentPane().setBackground(Color.white);
      frame.getContentPane().setLayout(null);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
  }    
  // setting location and size of components
  public void locationandsize()
  {
      title.setBounds(350,10,600,40);
      title.setBackground(Color.white);
      title.setFont(new Font("cambria",Font.CENTER_BASELINE,25));
      
      question5.setBounds(50,60,1200,40);
      question5.setBackground(Color.white);
      question5.setFont(new Font("cambria",Font.CENTER_BASELINE,18));
      
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
  // adding components to the frame
  public void addcomponent()
  {
      frame.add(title);
      frame.add(question5);
      frame.add(ans1);
      frame.add(ans2);
      frame.add(ans3);
      frame.add(ans4);
      frame.add(submitbtn);
  } 
  //action listener
  public void actionevent()
  {
      submitbtn.addActionListener(this);
  }      
  // quiz question answer validation and providing marks for right answer  
   @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==submitbtn)
      {
          String answer=null;
          if(ans1.isSelected())
          {
              answer="a. MAVEN PATH";
          }    
          if(ans2.isSelected())
          {    
              answer="b. JAVA PATH";
          }    
          if(ans3.isSelected())
          {
              answer="c. JAVA";
          }  
          if(ans4.isSelected())
          {
              answer="d. JAVA_HOME";
          }    
          if(answer=="d. JAVA_HOME")
          {
              JOptionPane.showMessageDialog(null,"Wait for results");
              JOptionPane.showMessageDialog(null,"Correct Answer");
              count+=1;
              JOptionPane.showMessageDialog(null,"Your Score is: "+count);
              HomePage h=new HomePage();
              h.init();
              frame.setVisible(false);   
          }  
          else
          {
              JOptionPane.showMessageDialog(null,"Wait for results");
              JOptionPane.showMessageDialog(null,"Wrong Answer");
              JOptionPane.showMessageDialog(null,"Your Score is: "+count);
              HomePage h=new HomePage();
              h.init();
              frame.setVisible(false); 
          }    
      }    
    }
    // main method
    public static void main(String[] args)
    {
        quiz5 q5=new quiz5();
        q5.quiz5_init(count);
    }        
}
