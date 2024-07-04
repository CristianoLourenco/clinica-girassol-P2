package viewModel;

import javax.swing.Icon;

public class Card_model {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    private Icon icon;
    private String title;
    private String description;
    private String values;

    public Card_model() {
    }

    public Card_model(Icon icon, String title, String description,String values) {
        this.icon = icon;
        this.title = title;
        this.description = description;
        this.values = values;
    }

}
