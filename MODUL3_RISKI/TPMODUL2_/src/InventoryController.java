import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class InventoryController {
    @FXML
    private TableView<Album> tableView;
    @FXML
    private TableColumn<Album, String> albumNameColumn;
    @FXML
    private TableColumn<Album, String> artistColumn;
    @FXML
    private TableColumn<Album, Integer> totalColumn;
    @FXML
    private TableColumn<Album, Integer> availableColumn;
    @FXML
    private TableColumn<Album, Integer> rentedColumn;

    @FXML
    private TextField albumNameField;
    @FXML
    private TextField artistField;
    @FXML
    private TextField totalField;
    @FXML
    private TextField availableField;

    private ObservableList<Album> albums = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        albumNameColumn.setCellValueFactory(new PropertyValueFactory<>("albumName"));
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("available"));
        rentedColumn.setCellValueFactory(new PropertyValueFactory<>("rented"));

        tableView.setItems(albums);
    }

    @FXML
    private void handleAdd() {
        try {
            String name = albumNameField.getText();
            String artist = artistField.getText();
            int total = Integer.parseInt(totalField.getText());
            int available = Integer.parseInt(availableField.getText());
            albums.add(new Album(name, artist, total, available, 0));
            showAlert("Success", "Album added successfully!");
        } catch (Exception e) {
            showAlert("Error", "Invalid input. Please check your fields.");
        }
    }

    @FXML
    private void handleDelete() {
        Album selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            albums.remove(selected);
            showAlert("Success", "Album removed successfully!");
        }
    }

    @FXML
    private void handleUpdate() {
        Album selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setAlbumName(albumNameField.getText());
            selected.setArtist(artistField.getText());
            selected.setTotal(Integer.parseInt(totalField.getText()));
            selected.setAvailable(Integer.parseInt(availableField.getText()));
            tableView.refresh();
            showAlert("Success", "Album updated successfully!");
        }
    }

    @FXML
    private void handleRent() {
        Album selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null && selected.getAvailable() > 0) {
            selected.setAvailable(selected.getAvailable() - 1);
            selected.setRented(selected.getRented() + 1);
            tableView.refresh();
            showAlert("Success", "Album rented successfully!");
        } else {
            showAlert("Error", "Album not available for rent.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
