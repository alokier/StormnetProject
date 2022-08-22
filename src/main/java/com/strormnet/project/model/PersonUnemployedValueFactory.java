package com.strormnet.project.model;
import com.strormnet.project.model.users.Prepodavatel;
import com.strormnet.project.servant.Servant;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.util.Callback;


public class PersonUnemployedValueFactory implements Callback<TableColumn.CellDataFeatures<Prepodavatel, CheckBox>, ObservableValue<CheckBox>> {
    private Button apply;
    private Button cancel;

    public PersonUnemployedValueFactory(Button apply, Button cancel) {
        this.apply = apply;
        this.cancel = cancel;
    }

    @Override
    public ObservableValue<CheckBox> call(TableColumn.CellDataFeatures<Prepodavatel, CheckBox> param) {
        Prepodavatel person = param.getValue();
        CheckBox checkBox = new CheckBox();
        checkBox.selectedProperty().setValue(person.getAdmin());
        checkBox.selectedProperty().addListener((ov, old_val, new_val) -> {
            Servant.setVisibility(true, apply,cancel);
            person.setAdmin(new_val);
        });
        return new SimpleObjectProperty<>(checkBox);
    }
}
/*BooleanProperty property = new SimpleBooleanProperty();
          property.addListener((observable, oldValue, newValue) -> {
              if (newValue) {
                  Servant.setVisibility(true, applyUpdateId, cancelSaveID);
                  v.getValue().setAdmin(newValue);
              }
          });
          return property;
      });*/
