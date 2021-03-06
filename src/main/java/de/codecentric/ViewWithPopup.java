package de.codecentric;

import com.github.wolfie.popupextension.PopupExtension;
import com.github.wolfie.popupextension.PopupExtension.PopupExtensionManualBundle;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ViewWithPopup extends VerticalLayout implements View {

    private Button button;

    public ViewWithPopup(String title) {
        addComponent(new Label(title));

        button = new Button("Open Popup");
        PopupExtensionManualBundle bundle = PopupExtension.extendWithManualBundle(button);

        addComponent(bundle.getDataTransferComponent());

        final PopupExtension popupExtension = bundle.getPopupExtension();
        popupExtension.setOffset(100, 50);
        popupExtension.setDirection(Alignment.BOTTOM_RIGHT);

        FormLayout popupLayout = new FormLayout();
        popupLayout.setWidth("500px");
        popupLayout.addComponent(new Label("Problematic Combobox (press F5)"));
        popupLayout.addComponent(new ComboBox("POPUP CONTENT"));
        popupExtension.setContent(popupLayout);

        button.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                popupExtension.toggle();
            }
        });
        addComponent(button);
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

}
