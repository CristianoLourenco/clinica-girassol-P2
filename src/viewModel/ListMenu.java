package viewModel;

import event.EventMenuSelected;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import view.dashboard.components.MenuItem;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public class ListMenu<E extends Object> extends JList<E> {

    private final DefaultListModel model;
    private int selectedIndex = -1;
    private int hoverIndex = -1;

    private EventMenuSelected event;

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
    }

    public ListMenu() {
        this.model = new DefaultListModel();
        setModel(model);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int index = locationToIndex(e.getPoint());
                    Object object = model.getElementAt(index);
                    if (object instanceof MenuModel menu) {
                        if (menu.getType() == MenuModel.MenuType.MENU) {
                            selectedIndex = index;
                            if (event != null) {
                                event.selected(index);
                            }
                        } else {
                            selectedIndex = index;
                        }
                        repaint();
                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverIndex = -1;
                repaint();
                super.mouseExited(e);
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int index = locationToIndex(e.getPoint());
                if (index != hoverIndex) {
                    Object object = model.getElementAt(index);
                    if (object instanceof MenuModel) {
                        MenuModel menu = (MenuModel) object;
                        if (menu.getType() == MenuModel.MenuType.MENU) {
                            hoverIndex = index;
                        } else {
                            hoverIndex = -1;
                        }
                        repaint();
                    }
                }
            }

        });

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
                item.setSelected(selectedIndex == index);
                item.setOver(hoverIndex == index);
                return item;
            }

        };
    }

    public void addItem(MenuModel data) {
        model.addElement(data);
    }
}
