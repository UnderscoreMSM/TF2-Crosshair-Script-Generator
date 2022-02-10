package group.demo1;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class AppController {
    File crosshairFolder = new File("crosshairs");
    ArrayList<File> crosshairsGenerate = new ArrayList<>();

    @FXML // scattergun includes force-a-nature and back scatter
    private ChoiceBox<String> cbScattergun, cbSodaPopper, cbShortstop, cbBabyFaceBlaster;
    @FXML
    private ChoiceBox<String> cbScoutPistol, cbWinger, cbCleaver, cbBonkDrink, cbMadMilk;
    @FXML
    private ChoiceBox<String> cbBat, cbFishMelee, cbSandman, cbWrapAssassin;

    @FXML
    private ChoiceBox<String> cbRocketLauncher, cbDirectHit, cbCowMangler, cbAirStrike;
    @FXML
    private ChoiceBox<String> cbSoldierSG, cbBuffs, cbBison;
    @FXML
    private ChoiceBox<String> cbShovel, cbSoldierKatana;

    @FXML
    private ChoiceBox<String> cbFlameThrower, cbDragonFury;
    @FXML
    private ChoiceBox<String> cbPyroSG, cbFlareGun, cbManmelter, cbThrusters, cbGasPasser;
    @FXML
    private ChoiceBox<String> cbAxe, cbHotHand;

    @FXML
    private ChoiceBox<String> cbGrenadeLauncher, cbCannon;
    @FXML
    private ChoiceBox<String> cbSticky;
    @FXML
    private ChoiceBox<String> cbBottle, cbSwords, cbCaber, cbDemoKatana;

    @FXML
    private ChoiceBox<String> cbMiniGun;
    @FXML
    private ChoiceBox<String> cbHeavySG, cbFood;
    @FXML
    private ChoiceBox<String> cbFists;

    @FXML
    private ChoiceBox<String> cbEngiSG, cbPomson, cbRescue, cbFrontierJustice;
    @FXML
    private ChoiceBox<String> cbEngiPistol, cbWrangler, cbShortCircuit;
    @FXML
    private ChoiceBox<String> cbWrench, cbGunslinger;

    @FXML
    private ChoiceBox<String> cbSyringeGun, cbCrossbow;
    @FXML
    private ChoiceBox<String> cbMediGun;
    @FXML
    private ChoiceBox<String> cbBonesaw;

    @FXML
    private ChoiceBox<String> cbSniperRifle, cbHuntsman, cbHitman, cbClassic;
    @FXML
    private ChoiceBox<String> cbSMG, cbCarbine, cbJarate;
    @FXML
    private ChoiceBox<String> cbKukri;

    @FXML
    private ChoiceBox<String> cbRevolver;
    @FXML
    private ChoiceBox<String> cbKnife;
    @FXML
    private ChoiceBox<String> cbSapper;

    @FXML
    private TextField tfDirectory;
    @FXML
    private CheckBox chkBoxIncludeScout;

    Alert alertAbout = new Alert(Alert.AlertType.INFORMATION);
    FilenameFilter filter = ((dir, name) -> name.toLowerCase().endsWith(".vtf")); // Lambda expression for filtering files

    @FXML
    protected void onGenerateClick() {
//        String folderDir = tfDirectory.getText() + "/Custom crosshairs";
//        String scriptsDir = folderDir + "/scripts";
        try {
            String targetDir = tfDirectory.getText();
            String scriptsDir = targetDir + "/Custom crosshairs/scripts";
//        String crosshairsDir = folderDir + "/crosshairs";
//        String crosshairsDir = tfDirectory.getText() + "/Custom crosshairs/crosshairs";
//        String vguiDir = crosshairsDir + "/vgui";
            String destination = targetDir + "/Custom crosshairs/crosshairs/vgui/replay/thumbnails";
            File folder = new File(targetDir + "/Custom crosshairs");
            File scripts = new File(targetDir + "/Custom crosshairs/scripts");
            File crosshairs = new File(targetDir + "/Custom crosshairs/crosshairs");
            File vguiDir = new File(targetDir + "/Custom crosshairs/crosshairs/vgui");
            File replayDir = new File(targetDir + "/Custom crosshairs/crosshairs/vgui/replay");
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
//        if (chkBoxIncludeScout.isSelected()) {
            generate(cbScattergun, "tf_weapon_scattergun.txt", scriptsDir);
//        }

            for (File e : crosshairsGenerate) { // Copies crosshair files to the generation path
                String src = "crosshairs/" + e.getName();
                String dest = destination + "/" + e.getName();
                Files.copy(Path.of(src), Path.of(dest));
            }
        } catch (Exception e) {
            System.out.println("Failed to generate; invalid path");
        }
    }

    public void generate(ChoiceBox<String> cbWeapon, String weaponTXT, String folderDir) throws IOException {
        FileWriter script = new FileWriter(folderDir + "/" + weaponTXT);
        script.write(createScript(removeExtension(cbWeapon.getValue()) + ".vmt")); // Assuming the VMT file exists
        script.close();
    }

    @FXML
    protected void onBrowseClick() {
        DirectoryChooser dialog = new DirectoryChooser();
        File temp = dialog.showDialog(null);
        tfDirectory.setText(temp.getPath());
    }

    @FXML
    protected void onMenuAboutClick() {
        alertAbout.setContentText("TF2 Crosshair Generator\nCreated by MSM");
        alertAbout.show();
    }

    @FXML
    protected void onImportClick() throws IOException {
        FileChooser vtfDialog = new FileChooser();
        FileChooser vmtDialog = new FileChooser();
        vtfDialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("VTF Files (*.vtf)", "*.vtf"));
        vmtDialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("VMT Files (*.vmt)", "*.vmt"));
        File tempVTF = vtfDialog.showOpenDialog(null);

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
    }

    public void initialize() {
        addFileToList("bigcross", crosshairsGenerate); // I forgot what this was for...
        cbScattergun.setValue("Default");
        cbSodaPopper.setValue("Default");
        cbShortstop.setValue("Default");
        cbBabyFaceBlaster.setValue("Default");
        cbScoutPistol.setValue("Default");
        cbWinger.setValue("Default");
        cbCleaver.setValue("Default");
        cbBonkDrink.setValue("Default");
        cbMadMilk.setValue("Default");
        cbBat.setValue("Default");
        cbFishMelee.setValue("Default");
        cbSandman.setValue("Default");
        cbRocketLauncher.setValue("Default");


        // Scout
        cbScattergun.setItems(FXCollections.observableList(Arrays.asList(crosshairFolder.list(filter))));
        cbSodaPopper.setItems(FXCollections.observableList(Arrays.asList(crosshairFolder.list(filter))));
        cbShortstop.setItems(FXCollections.observableList(Arrays.asList(crosshairFolder.list(filter))));
        cbBabyFaceBlaster.setItems(FXCollections.observableList(Arrays.asList(crosshairFolder.list(filter))));
        cbScoutPistol.setItems(FXCollections.observableList(Arrays.asList(crosshairFolder.list(filter))));

        // Soldier
        cbRocketLauncher.setItems(FXCollections.observableList(Arrays.asList(crosshairFolder.list(filter))));
    }

    public String removeExtension(String fileName) {
        if (fileName.contains(".")) {
            return fileName.substring(0, fileName.lastIndexOf("."));
        } else {
            return null;
        }
    }

    public String createScript(String vmtFile) { // Assuming the size is 64x64
        String template = """
                "crosshair"
                {
                    "file"\t"vgui/replay/thumbnails/""";
        template = template.concat(vmtFile + """
                "\n    "x"\t"0"
                    "y"\t"0"
                    "width"\t"64"
                    "height"\t"64"
                }""");

        return template;
    }

    public boolean addFileToList(String crosshairName, ArrayList<File> list) { // true if the operation was successful, otherwise false
        File vtfTemp = new File("crosshairs/" + crosshairName + ".vtf");
        File vmtTemp = new File("crosshairs/" + crosshairName + ".vmt");
        if (vtfTemp.exists() && vmtTemp.exists()) {
            if (!list.contains(vtfTemp) && !list.contains(vmtTemp)) {
                list.add(vtfTemp);
                list.add(vmtTemp);
                return true;
            }
        }
        System.out.println("Files do not exist!");
        return false;
    }
}