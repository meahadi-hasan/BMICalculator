import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class BMICalculator extends JFrame {

  private static final long serialVersionUID = 1L;
  private JLabel weightLabel, heightLabel, bmiLabel, resultLabel;
  private JTextField weightField, heightField;
  private JButton calculateButton;
  private JButton btnClear;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private JTextField resultField;

  public BMICalculator() {
	  
    super("BMI Calculator");
    setForeground(Color.BLACK);
    setBackground(Color.BLACK);

    weightLabel = new JLabel("Weight (kg):");
    weightLabel.setForeground(Color.WHITE);
    weightLabel.setBounds(26, 150, 89, 27);
    weightLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    weightLabel.setBackground(new Color(240, 240, 240));
    heightLabel = new JLabel("Height (cm):");
    heightLabel.setForeground(Color.WHITE);
    heightLabel.setBounds(26, 99, 89, 27);
    heightLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    bmiLabel = new JLabel("BMI:");
    bmiLabel.setForeground(Color.WHITE);
    bmiLabel.setBounds(30, 239, 42, 27);
    bmiLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    resultLabel = new JLabel("Result:");
    resultLabel.setForeground(Color.WHITE);
    resultLabel.setBounds(30, 200, 85, 27);
    resultLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

    weightField = new JTextField(5);
    weightField.setBounds(125, 152, 150, 27);
    heightField = new JTextField(5);
    heightField.setBounds(125, 100, 150, 27);

    calculateButton = new JButton("Calculate");
    calculateButton.setFont(new Font("Tahoma", Font.BOLD, 14));
    calculateButton.setBounds(84, 240, 103, 27);

    JPanel panel = new JPanel();
    panel.setToolTipText("");
    panel.setForeground(new Color(227, 227, 227));
    panel.setBorder(UIManager.getBorder("Button.border"));
    panel.setBackground(Color.DARK_GRAY);
    panel.setLayout(null);
    panel.add(weightLabel);
    panel.add(weightField);
    panel.add(heightLabel);
    panel.add(heightField);
    panel.add(bmiLabel);
    panel.add(resultLabel);
    panel.add(calculateButton);
    getContentPane().add(panel, BorderLayout.CENTER);
    
    btnClear = new JButton("Clear");
    btnClear.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		heightField.setText(null);
    		weightField.setText(null);
    		resultField.setText(null);
    		
    	}
    });
    btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
    btnClear.setBounds(197, 240, 78, 27);
    buttonGroup.add(btnClear);
    panel.add(btnClear);
    
    Panel panel_1 = new Panel();
    panel_1.setBackground(new Color(60, 179, 113));
    panel_1.setForeground(new Color(46, 139, 87));
    panel_1.setBounds(0, 0, 303, 57);
    panel.add(panel_1);
    panel_1.setLayout(null);
    
    JLabel lblBodyMassIndex = new JLabel("BODY MASS INDEX");
    lblBodyMassIndex.setForeground(Color.WHITE);
    lblBodyMassIndex.setBounds(59, 19, 193, 25);
    lblBodyMassIndex.setFont(new Font("Tahoma", Font.BOLD, 20));
    panel_1.add(lblBodyMassIndex);
    
    resultField = new JTextField(5);
    resultField.setBounds(125, 192, 150, 27);
    panel.add(resultField);

    calculateButton.addActionListener(e -> calculateBMI());

    setSize(319, 370);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  private void calculateBMI() {
	  
    try {
      double weight = Double.parseDouble(weightField.getText());
      double height = Double.parseDouble(heightField.getText());

      double bmi = weight / Math.pow(height / 100, 2);

      String result;
      if (bmi < 18.5) {
        result = "Underweight";
      } else if (bmi >= 18.5 && bmi < 25) {
        result = "Normal";
      } else if (bmi >= 25 && bmi < 30) {
        result = "Overweight";
      } else {
        result = "Obese";
      }

      resultField.setText(String.format("%.2f (%s)", bmi, result));
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  public static void main(String[] args) {
    new BMICalculator();
  }
}
