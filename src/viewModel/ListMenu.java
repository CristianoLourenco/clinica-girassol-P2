package viewModel;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import view.dashboard.MenuItem;
import javax.swing.DefaultListModel ;

public class ListMenu<E extends Object> extends JList<E> {

    private final DefaultListModel model;

    public ListMenu() {
        this.model = new DefaultListModel();
        setModel(model);
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                MenuModel data;
                if (value instanceof MenuModel menuModel) {
                    data = menuModel;
                } else {
                    data = new MenuModel("", value + "", MenuModel.MenuType.EMPTY);
                }
                MenuItem item = new MenuItem(data);

                return item;
            }

        }; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    public void addItem(MenuModel data){
        model.addElement(data);
    }

}
