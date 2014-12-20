

package FilesManager;




import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class FileNoComboSuggest extends AbstractListModel
                implements ComboBoxModel, KeyListener, ItemListener
{
    public List<HardCopy> database = new LinkedList<>();
    List<String> data = new LinkedList<>();
    String selection;
    JComboBox cb;
    ComboBoxEditor cbe;
    int currPos = 0;

    public FileNoComboSuggest(JComboBox jcb)
    {

        cb = jcb;
        cbe = jcb.getEditor();
        //here we add the key listener to the text field that the combobox is wrapped around
        cbe.getEditorComponent().addKeyListener(this);


        
    }

    public void updateModel(String in)
    {
        in=in.toUpperCase();
        data.clear();
//        //lets find any items which start with the string the user typed, and add it to the popup list
//        //here you would usually get your items from a database, or some other storage...
//        for(String s:database)
//            if(s.startsWith(in))
//                data.add(s);
        database.clear();
        database=Search.getByFileNo(in);
        for (HardCopy file : database) {
            data.add(file.fileNo);
        }
        super.fireContentsChanged(this, 0, data.size());

        //this is a hack to get around redraw problems when changing the list length of the displayed popups
        cb.hidePopup();
        cb.showPopup();
        if(database.size()!=0)
            cb.setSelectedIndex(0);
    }

    @Override
    public int getSize(){return data.size();}
    @Override
    public Object getElementAt(int index){return data.get(index);}
    @Override
    public void setSelectedItem(Object anItem)
                                 {selection = (String) anItem;}
    @Override
    public Object getSelectedItem(){return selection;}
    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyPressed(KeyEvent e){}

    @Override
    public void keyReleased(KeyEvent e)
    {
        String str = cbe.getItem().toString();
        JTextField jtf = (JTextField)cbe.getEditorComponent();
        currPos = jtf.getCaretPosition();

        if(e.getKeyChar() == KeyEvent.CHAR_UNDEFINED)
        {
            if(e.getKeyCode() != KeyEvent.VK_ENTER )
            {
                cbe.setItem(str);
                jtf.setCaretPosition(currPos);
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            cb.setSelectedIndex(cb.getSelectedIndex());
            updateModel(cb.getEditor().getItem().toString());
        }
        else
        {
            updateModel(cb.getEditor().getItem().toString());
            cbe.setItem(str);
            jtf.setCaretPosition(currPos);
        }
    }

    public void itemStateChanged(ItemEvent e)
    {
        cbe.setItem(e.getItem().toString());
        cb.setSelectedItem(e.getItem());
    }

}
