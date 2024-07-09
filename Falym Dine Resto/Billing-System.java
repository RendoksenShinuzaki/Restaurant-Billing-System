package thisframe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BillingFrame extends JFrame implements KeyListener{

    @Override
    public void keyTyped(KeyEvent ke) {
    char a = ke.getKeyChar();
        if(Character.isLetter(a)|| Character.isISOControl(a)){
           Food_Item.setEditable(false);
        }
        else{
           Food_Item.setEditable(true);
        }
    char b = ke.getKeyChar();
        if(Character.isLetter(b) || Character.isWhitespace(b) || Character.isISOControl(b)){
           Food.setEditable(true);
        }
        else{
           Food.setEditable(false);
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
    class Add implements ActionListener{

        public Add(){
        Insert_Item.addActionListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
       if(Food.getText().isEmpty()){
           JOptionPane.showMessageDialog(null,"Food Name is Empty!"); 
         }
       else if(Food_Item.getText().isEmpty()){
           JOptionPane.showMessageDialog(null,"Food Price Is Empty!");
           }
       
       else{
       ItemsList.addElement(Food.getText());
       ItemsPrice.addElement(Food_Item.getText());
       PurchaseTotal.addElement(Food.getText() + " \t    \t     \t     \t" + Food_Item.getText());
       int add = Integer.parseInt(Food_Item.getText());
       int valAdd = add + add;
       int total = 0;
       for(int x=0;x<ItemsPrice.getSize();x++)
            {
                total += Integer.parseInt(ItemsPrice.getElementAt(x));
            }
            amount.setText(Integer.toString(total));
        
       Food.setText("");
       Food_Item.setText("");
       }
     }
    }
    class Reset implements ActionListener{

        public Reset(){
        Reset_Item.addActionListener(this);
        }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == Reset_Item){
       ItemsList.removeAllElements();
       ItemsPrice.removeAllElements();
       PurchaseTotal.removeAllElements();
       amount.setText("");
       }
    }
  }
////Components
    DefaultListModel<String> ItemsList , ItemsPrice, PurchaseTotal;
    JLabel Store_Name, Food_Name, Food_Price, Total_of_Purchase, Total_Price, amount, 
           List_of_Items, Price, Peso_Sign, Food_ItemL; 
    JTextArea Food, Food_Item;
    JButton Insert_Item, Reset_Item;
    JList ItemList, ItemPrice, TotalPurchase;
    Font font1 = new Font("Serif",Font.BOLD,30);
    Font font2 = new Font("Arial",Font.BOLD,13);
    
    
    public BillingFrame(){
    
    ItemsList = new DefaultListModel<>(); 
    ItemsPrice = new DefaultListModel<>();
    PurchaseTotal = new DefaultListModel<>();   
    
    Store_Name = new JLabel("FALYM DINE RESTO");  
    Store_Name.setFont(font1);

    List_of_Items = new JLabel("Product List");
    List_of_Items.setFont(font2);
    
    Food_Name = new JLabel("Food Name");
    Food_Name.setFont(font2);
    Food = new JTextArea();
    
    Food_Price = new JLabel("Food Price");
    Food_Price.setFont(font2);
    Food_Item = new JTextArea();
    
    Peso_Sign = new JLabel("₱");
    Peso_Sign.setFont(font2);
    
    Price = new JLabel("Price");
    Price.setFont(font2);
   
    ItemList = new JList(ItemsList);
    ItemPrice = new JList(ItemsPrice);
    TotalPurchase = new JList(PurchaseTotal);
    
    Insert_Item = new JButton("Insert");
    Reset_Item = new JButton("Reset");
    
    Total_of_Purchase = new JLabel("Item Purchased");
    Total_of_Purchase.setFont(font2);
    
    Total_Price = new JLabel("Total Price: ");
    Total_Price.setFont(font2);
    amount = new JLabel();
    amount.setFont(font2);
    
    Store_Name.setBounds(150, 0, 350, 50);
    Food_Name.setBounds(140, 40, 100, 50); 
    Food.setBounds(100, 80, 150, 20);
    Peso_Sign.setBounds(300, 80, 100, 20);
    Food_Price.setBounds(330, 60, 100, 10);
    Food_Item.setBounds(320, 80, 100, 20);
    Insert_Item.setBounds(170, 120, 100, 20);
    Reset_Item.setBounds(300, 120, 100, 20);
    List_of_Items.setBounds(75, 150, 100, 20);
    ItemList.setBounds(20, 180, 200, 375);
    Price.setBounds(260, 150, 100, 20);
    ItemPrice.setBounds(230, 180, 100, 375);
    Total_of_Purchase.setBounds(400, 150, 100, 20);
    TotalPurchase.setBounds(350, 180, 200, 375);
    Total_Price.setBounds(235, 570, 200, 20);
    amount.setBounds(310, 570, 200, 20);
    
    add(Store_Name);
    add(Food_Name);
    add(Food);
    add(Peso_Sign);
    add(Food_Price);
    add(Food_Item);
    add(Insert_Item);
    add(Reset_Item);
    add(List_of_Items);
    add(ItemList);
    add(Price);
    add(ItemPrice);
    add(Total_of_Purchase);
    add(TotalPurchase);
    add(Total_Price);
    add(amount);
    
    Food_Item.addKeyListener(this);
    Food.addKeyListener(this);
    
    setSize(600,650);
    setLayout(null);
    setTitle("Billing System");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BillingFrame frame = new BillingFrame();
        frame.setVisible(true);
        Add btnAdd = frame.new Add();
        Reset btnReset = frame.new Reset();
    }
}
