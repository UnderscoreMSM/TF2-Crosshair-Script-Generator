package group.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AppController {
    private File crosshairFolder = new File("crosshairs");
    private ArrayList<File> crosshairsGenerate = new ArrayList<>();

    //
    // Some choiceBoxes are used for multiple weapons
    //

    // Please check the end of the appGUI.fxml to know the order of ComboBoxes
    @FXML
    private ArrayList<ComboBox<String>> cbList;
    @FXML
    private TextField tfDirectory;
    @FXML
    private CheckBox chkBoxNoScout, chkBoxNoSoldier, chkBoxNoPyro;
    @FXML
    private CheckBox chkBoxNoDemoman, chkBoxNoHeavy, chkBoxNoEngineer;
    @FXML
    private CheckBox chkBoxNoMedic, chkBoxNoSniper, chkBoxNoSpy;

    private FilenameFilter filter = ((dir, name) -> name.toLowerCase().endsWith(".vtf")); // Lambda expression for filtering files
    private ObservableList<String> list = FXCollections.observableList(Arrays.asList(crosshairFolder.list(filter)));

    @FXML
    private void onGenerateClick() throws IOException {
        String targetDir = tfDirectory.getText();
        String destination = targetDir + "/Custom crosshairs/materials/vgui/replay/thumbnails";
        File folder = new File(targetDir + "/Custom crosshairs");
        File scripts = new File(targetDir + "/Custom crosshairs/scripts");
        File crosshairs = new File(targetDir + "/Custom crosshairs/materials");
        File vguiDir = new File(targetDir + "/Custom crosshairs/materials/vgui");
        File replayDir = new File(targetDir + "/Custom crosshairs/materials/vgui/replay");
        File thumbnailsDir = new File(destination);

        boolean boolFolder = folder.mkdir();
        boolean boolScripts = scripts.mkdir();
        boolean boolCrosshairs = crosshairs.mkdir();
        boolean boolVgui = vguiDir.mkdir();
        boolean boolReplay = replayDir.mkdir();
        boolean boolthumb = thumbnailsDir.mkdir();

        if (boolFolder) { // TODO Clean this up
            System.out.println("Folder created!");
            if (boolScripts) {
                System.out.println("scripts folder created!");
            }
            if (boolCrosshairs) {
                System.out.println("crosshairs folder created!");
                if (boolVgui) {
                    System.out.println("vgui folder created!");
                    if (boolReplay) {
                        System.out.println("replay folder created!");
                        if (boolthumb) {
                            System.out.println("thumbnails folder created!");
                            System.out.println("All necessary folders have been created!");
                        }
                    }
                }
            }
        }

        if (!chkBoxNoScout.isSelected()) {
            generate(cbList.get(0), "tf_weapon_scattergun.txt", scripts);
            generate(cbList.get(1), "tf_weapon_soda_popper.txt", scripts);
            generate(cbList.get(2), "tf_weapon_handgun_scout_primary.txt", scripts);
            generate(cbList.get(3), "tf_weapon_pep_brawler_blaster.txt", scripts);
            generate(cbList.get(4), "tf_weapon_pistol_scout.txt", scripts);
            generate(cbList.get(5), "tf_weapon_handgun_scout_secondary.txt", scripts);
            generate(cbList.get(6), "tf_weapon_cleaver.txt", scripts);
            generate(cbList.get(7), "tf_weapon_lunchbox_drink.txt", scripts);
            generate(cbList.get(8), "tf_weapon_jar_milk.txt", scripts);
            generate(cbList.get(9), "tf_weapon_bat.txt", scripts);
            generate(cbList.get(10), "tf_weapon_bat_fish.txt", scripts);
            generate(cbList.get(11), "tf_weapon_bat_wood.txt", scripts);
            generate(cbList.get(12), "tf_weapon_bat_giftwrap.txt", scripts);

        }
        if (!chkBoxNoSoldier.isSelected()) {
            generate(cbList.get(13), "tf_weapon_rocketlauncher.txt", scripts);
            generate(cbList.get(14), "tf_weapon_rocketlauncher_directhit.txt", scripts);
            generate(cbList.get(15), "tf_weapon_particle_cannon.txt", scripts);
            generate(cbList.get(16), "tf_weapon_rocketlauncher_airstrike.txt", scripts);
            generate(cbList.get(17), "tf_weapon_shotgun_soldier.txt", scripts);
            generate(cbList.get(18), "tf_weapon_buff_item.txt", scripts);
            generate(cbList.get(19), "tf_weapon_raygun.txt", scripts);
            generate(cbList.get(20), "tf_weapon_shovel.txt", scripts);
            generate(cbList.get(21), "tf_weapon_katana.txt", scripts);
        }
        if (!chkBoxNoPyro.isSelected()) {
            generate(cbList.get(22), "tf_weapon_flamethrower.txt", scripts);
            generate(cbList.get(23), "tf_weapon_rocketlauncher_fireball.txt", scripts);
            generate(cbList.get(24), "tf_weapon_shotgun_pyro.txt", scripts);
            generate(cbList.get(25), "tf_weapon_flaregun.txt", scripts);
            generate(cbList.get(26), "tf_weapon_flaregun_revenge.txt", scripts);
            generate(cbList.get(27), "tf_weapon_rocketpack.txt", scripts);
            generate(cbList.get(28), "tf_weapon_jar.txt", scripts);
            generate(cbList.get(29), "tf_weapon_fireaxe.txt", scripts);
            generate(cbList.get(30), "tf_weapon_slap.txt", scripts);
        }
        if (!chkBoxNoDemoman.isSelected()) {
            generate(cbList.get(31), "tf_weapon_grenadelauncher.txt", scripts);
            generate(cbList.get(32), "tf_weapon_cannon.txt", scripts);
            generate(cbList.get(33), "tf_weapon_pipebomblauncher.txt", scripts);
            generate(cbList.get(34), "tf_weapon_bottle.txt", scripts);
            generate(cbList.get(35), "tf_weapon_sword.txt", scripts);
            generate(cbList.get(36), "tf_weapon_stickbomb.txt", scripts);
            generate(cbList.get(37), "tf_weapon_katana.txt", scripts);
        }
        if (!chkBoxNoHeavy.isSelected()) {
            generate(cbList.get(38), "tf_weapon_minigun.txt",  scripts);
            generate(cbList.get(39), "tf_weapon_shotgun_hwg.txt", scripts);
            generate(cbList.get(40), "tf_weapon_lunchbox.txt", scripts);
            generate(cbList.get(41), "tf_weapon_fists.txt", scripts);
        }
        if(!chkBoxNoEngineer.isSelected()) {
            generate(cbList.get(42), "tf_weapon_shotgun_primary.txt", scripts);
            generate(cbList.get(43), "tf_weapon_drg_pomson.txt", scripts);
            generate(cbList.get(44), "tf_weapon_shotgun_building_rescue.txt", scripts);
            generate(cbList.get(45), "tf_weapon_sentry_revenge.txt", scripts);
            generate(cbList.get(46), "tf_weapon_pistol.txt", scripts);
            generate(cbList.get(47), "tf_weapon_laser_pointer.txt", scripts);
            generate(cbList.get(48), "tf_weapon_mechanical_arm.txt", scripts);
            generate(cbList.get(49), "tf_weapon_wrench.txt", scripts);
            generate(cbList.get(50), "tf_weapon_robot_arm.txt", scripts);
        }
        if(!chkBoxNoMedic.isSelected()) {
            generate(cbList.get(51), "tf_weapon_syringegun_medic.txt", scripts);
            generate(cbList.get(52), "tf_weapon_crossbow.txt", scripts);
            generate(cbList.get(53), "tf_weapon_medigun.txt", scripts);
            generate(cbList.get(54), "tf_weapon_bonesaw.txt", scripts);
        }
        if (!chkBoxNoSniper.isSelected()) {
            generate(cbList.get(55), "tf_weapon_sniperrifle.txt", scripts);
            generate(cbList.get(56), "tf_weapon_compound_bow.txt", scripts);
            generate(cbList.get(57), "tf_weapon_sniperrifle_decap.txt", scripts);
            generate(cbList.get(58), "tf_weapon_sniperrifle_classic.txt", scripts);
            generate(cbList.get(59), "tf_weapon_smg.txt", scripts);
            generate(cbList.get(60), "tf_weapon_charged_smg.txt", scripts);
            generate(cbList.get(61), "tf_weapon_jar.txt", scripts);
            generate(cbList.get(62), "tf_weapon_club.txt", scripts);
        }
        if (!chkBoxNoSpy.isSelected()) {
            generate(cbList.get(63), "tf_weapon_revolver.txt", scripts);
            generate(cbList.get(64), "tf_weapon_knife.txt", scripts);
            generate(cbList.get(65), "tf_weapon_sapper.txt", scripts);
        }

        System.out.println("The following files will be copied:\n" + crosshairsGenerate);

        for (File e : crosshairsGenerate) { // Copies crosshair files to the generation path
            String src = "crosshairs/" + e.getName();
            String dest = destination + "/" + e.getName();
            System.out.println("Copying from " + src + " to " + dest);
            Files.copy(Path.of(src), Path.of(dest));
            System.out.println("Copying complete!");
        }
    }

    public void generate(ComboBox<String> cbWeapon, String weaponTXT, File folderDir) throws IOException {
        //
        // "Default" choice is causing the program to crash upon generation
        //

        String crosshair = removeExtension(cbWeapon.getValue());
        System.out.println(cbWeapon.getValue());
        // Reads crosshair data
        InputStream in = new FileInputStream("crosshairs/" + cbWeapon.getValue());
        DataInputStream crosshairData = new DataInputStream(in);
        crosshairData.skipBytes(17); // Skips over to the width
        int width = crosshairData.readUnsignedShort();
        int height = crosshairData.readUnsignedShort();

        FileWriter script = new FileWriter(folderDir.getPath() + "/" + weaponTXT);
        File template = new File("templates/" + weaponTXT);
        String contents = "";
        Scanner scanner = new Scanner(template);

        while (scanner.hasNextLine()) {
            contents = contents.concat(scanner.nextLine() + "\n");
        }
        scanner.close();

        // Writes crosshair data into the script
        contents = contents.replace("vgui/replay/thumbnails/", "vgui/replay/thumbnails/" + crosshair);
        contents = contents.replace("size_W", width + "");
        contents = contents.replace("size_H", height + "");

        script.write(contents);
        script.close();
        addFileToList(crosshair);
    }

    @FXML
    private void onBrowseClick() {
        DirectoryChooser dialog = new DirectoryChooser();
        File temp = dialog.showDialog(null);
        tfDirectory.setText(temp.getPath());
    }

    @FXML
    private void onImportClick() throws IOException {
        FileChooser vtfDialog = new FileChooser();
        FileChooser vmtDialog = new FileChooser();
        vtfDialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("VTF Files (*.vtf)", "*.vtf"));
        vmtDialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("VMT Files (*.vmt)", "*.vmt"));
        File tempVTF = vtfDialog.showOpenDialog(null);

        // TODO Properely handle the exception when cancelling the operation
        if (tempVTF != null) { // Will not show the VMT dialog if the user cancels half-way through the operation
            File tempVMT = vmtDialog.showOpenDialog(null);
            if (tempVMT != null && removeExtension(tempVTF.getName()).equals(removeExtension(tempVMT.getName()))) {
                // Copying files
                String vtfCopy = "crosshairs/" + tempVTF.getName();
                String vmtCopy = "crosshairs/" + tempVMT.getName();
                Files.copy(tempVTF.toPath(), Path.of(vtfCopy));
                Files.copy(tempVMT.toPath(), Path.of(vmtCopy));
            } else {
                System.out.println("Import failed! Files names are not identical");
            }
        }
        // Refreshes the choiceboxes
        list = FXCollections.observableList(Arrays.asList(crosshairFolder.list(filter)));
        refresh();
    }

    @FXML
    private void initialize() {
        refresh();
    }

    public String removeExtension(String fileName) {
        if (fileName.contains(".")) {
            return fileName.substring(0, fileName.lastIndexOf("."));
        } else {
            return null;
        }
    }

    public void addFileToList(String crosshairName) { // Eleminates duplicate copies
        File vtfTemp = new File("crosshairs/" + crosshairName + ".vtf");
        File vmtTemp = new File("crosshairs/" + crosshairName + ".vmt");
        if (vtfTemp.exists() && vmtTemp.exists()) {
            if (!crosshairsGenerate.contains(vtfTemp) && !crosshairsGenerate.contains(vmtTemp)) {
                crosshairsGenerate.add(vtfTemp);
                crosshairsGenerate.add(vmtTemp);
            }
        }
    }

    @FXML
    private void onManageClick() throws IOException {
        FXMLLoader manageWindow = new FXMLLoader(getClass().getResource("manageGUI.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(manageWindow.load()));
        stage.setTitle("Manage crosshairs");
        stage.show();
    }

    @FXML
    private void onAboutClick() throws IOException {
        FXMLLoader aboutWindow = new FXMLLoader(getClass().getResource("aboutGUI.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(aboutWindow.load()));
        stage.setTitle("About");
        stage.show();
    }

    public void refresh() {
        for (ComboBox<String> stringComboBox : cbList) {
            stringComboBox.setItems(list);
        }
    }
}