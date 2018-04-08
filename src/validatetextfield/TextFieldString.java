package validatetextfield;

import javafx.scene.control.TextField;

public class TextFieldString extends TextField{
    
    public TextFieldString()
    {this.setPromptText("Entrer la valeur exact");}
    
    @Override
    public void replaceText(int i, int i1,String string)
    {
    if (string.matches("[a-zA-Z]") || string.isEmpty())
    {super.replaceText(i1, i1, string);}
    } 
            
    @Override
    public void replaceSelection(String string)
    {
    super.replaceSelection(string);
    }
            
            
            
            
            
            
}
