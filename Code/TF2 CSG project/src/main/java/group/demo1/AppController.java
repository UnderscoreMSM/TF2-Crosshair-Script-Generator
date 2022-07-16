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

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AppController {
    File crosshairFolder = new File("crosshairs");
    ArrayList<File> crosshairsGenerate = new ArrayList<>();

    // Some choiceBoxes are used for multiple weapons
    @FXML
    private ChoiceBox<String> cbScattergun, cbSodaPopper, cbShortstop, cbBabyFaceBlaster;
    @FXML
    private ChoiceBox<String> cbScoutPistol, cbWinger, cbCleaver, cbBonkDrink, cbMadMilk;
    @FXML
    private ChoiceBox<String> cbBat, cbFishMelee, cbSandman, cbWrapAssassin;

    @FXML
    private ChoiceBox<String> cbRocketLauncher, cbDirectHit, cbMangler, cbAirStrike;
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
    private ChoiceBox<String> cbEngiSG, cbPomson, cbRescueRanger, cbFrontierJustice;
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
    private CheckBox chkBoxNoScout, chkBoxNoSoldier, chkBoxNoPyro;
    @FXML
    private CheckBox chkBoxNoDemoman, chkBoxNoHeavy, chkBoxNoEngineer;
    @FXML
    private CheckBox chkBoxNoMedic, chkBoxNoSniper, chkBoxNoSpy;

    FilenameFilter filter = ((dir, name) -> name.toLowerCase().endsWith(".vtf")); // Lambda expression for filtering files
    ObservableList<String> list = FXCollections.observableList(Arrays.asList(crosshairFolder.list(filter)));

    @FXML
    protected void onGenerateClick() throws IOException {
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
            generate(cbScattergun, "tf_weapon_scattergun.txt", scripts);
            generate(cbSodaPopper, "tf_weapon_soda_popper.txt", scripts);
            generate(cbShortstop, "tf_weapon_handgun_scout_primary.txt", scripts);
            generate(cbBabyFaceBlaster, "tf_weapon_pep_brawler_blaster.txt", scripts);
            generate(cbScoutPistol, "tf_weapon_pistol_scout.txt", scripts);
            generate(cbWinger, "tf_weapon_handgun_scout_secondary.txt", scripts);
            generate(cbClassic, "tf_weapon_cleaver.txt", scripts);
            generate(cbBonkDrink, "tf_weapon_lunchbox_drink.txt", scripts);
            generate(cbMadMilk, "tf_weapon_jar_milk.txt", scripts);
            generate(cbBat, "tf_weapon_bat.txt", scripts);
            generate(cbFishMelee, "tf_weapon_bat_fish.txt", scripts);
            generate(cbSandman, "tf_weapon_bat_wood.txt", scripts);
            generate(cbWrapAssassin, "tf_weapon_bat_giftwrap.txt", scripts);
        }
        if (!chkBoxNoSoldier.isSelected()) {
            generate(cbRocketLauncher, "tf_weapon_rocketlauncher.txt", scripts);
            generate(cbDirectHit, "tf_weapon_rocketlauncher_directhit.txt", scripts);
            generate(cbMangler, "tf_weapon_particle_cannon.txt", scripts);
            generate(cbAirStrike, "tf_weapon_rocketlauncher_airstrike.txt", scripts);
            generate(cbSoldierSG, "tf_weapon_shotgun_soldier.txt", scripts);
            generate(cbBuffs, "tf_weapon_buff_item.txt", scripts);
            generate(cbBison, "tf_weapon_raygun.txt", scripts);
            generate(cbShovel, "tf_weapon_shovel.txt", scripts);
            generate(cbSoldierKatana, "tf_weapon_katana.txt", scripts);
        }
        if (!chkBoxNoPyro.isSelected()) {
            generate(cbFlameThrower, "tf_weapon_flamethrower.txt", scripts);
            generate(cbDragonFury, "tf_weapon_rocketlauncher_fireball.txt", scripts);
            generate(cbPyroSG, "tf_weapon_shotgun_pyro.txt", scripts);
            generate(cbFlareGun, "tf_weapon_flaregun.txt", scripts);
            generate(cbManmelter, "tf_weapon_flaregun_revenge.txt", scripts);
            generate(cbThrusters, "tf_weapon_rocketpack.txt", scripts);
            generate(cbGasPasser, "tf_weapon_jar.txt", scripts);
            generate(cbAxe, "tf_weapon_fireaxe.txt", scripts);
            generate(cbHotHand, "tf_weapon_slap.txt", scripts);
        }
        if (!chkBoxNoDemoman.isSelected()) {
            generate(cbGrenadeLauncher, "tf_weapon_grenadelauncher.txt", scripts);
            generate(cbCannon, "tf_weapon_cannon.txt", scripts);
            generate(cbSticky, "tf_weapon_pipebomblauncher.txt", scripts);
            generate(cbBottle, "tf_weapon_bottle.txt", scripts);
            generate(cbSwords, "tf_weapon_sword.txt", scripts);
            generate(cbCaber, "tf_weapon_stickbomb.txt", scripts);
            generate(cbDemoKatana, "tf_weapon_katana.txt", scripts);
        }
        if (!chkBoxNoHeavy.isSelected()) {
            generate(cbMiniGun, "tf_weapon_minigun.txt",  scripts);
            generate(cbHeavySG, "tf_weapon_shotgun_hwg.txt", scripts);
            generate(cbFood, "tf_weapon_lunchbox.txt", scripts);
            generate(cbFists, "tf_weapon_fists.txt", scripts);
        }
        if(!chkBoxNoEngineer.isSelected()) {
            generate(cbEngiSG, "tf_weapon_shotgun_primary.txt", scripts);
            generate(cbPomson, "tf_weapon_drg_pomson.txt", scripts);
            generate(cbRescueRanger, "tf_weapon_shotgun_building_rescue.txt", scripts);
            generate(cbFrontierJustice, "tf_weapon_sentry_revenge.txt", scripts);
            generate(cbEngiPistol, "tf_weapon_pistol.txt", scripts);
            generate(cbWrangler, "tf_weapon_laser_pointer.txt", scripts);
            generate(cbShortCircuit, "tf_weapon_mechanical_arm.txt", scripts);
            generate(cbWrench, "tf_weapon_wrench.txt", scripts);
            generate(cbGunslinger, "tf_weapon_robot_arm.txt", scripts);
        }
        if(!chkBoxNoMedic.isSelected()) {
            generate(cbSyringeGun, "tf_weapon_syringegun_medic.txt", scripts);
            generate(cbCrossbow, "tf_weapon_crossbow.txt", scripts);
            generate(cbMediGun, "tf_weapon_medigun.txt", scripts);
            generate(cbBonesaw, "tf_weapon_bonesaw.txt", scripts);
        }
        if (!chkBoxNoSniper.isSelected()) {
            generate(cbSniperRifle, "tf_weapon_sniperrifle.txt", scripts);
            generate(cbHuntsman, "tf_weapon_compound_bow.txt", scripts);
            generate(cbHitman, "tf_weapon_sniperrifle_decap.txt", scripts);
            generate(cbClassic, "tf_weapon_sniperrifle_classic.txt", scripts);
            generate(cbSMG, "tf_weapon_smg.txt", scripts);
            generate(cbCarbine, "tf_weapon_charged_smg.txt", scripts);
            generate(cbJarate, "tf_weapon_jar.txt", scripts);
            generate(cbKukri, "tf_weapon_club.txt", scripts);
        }
        if (!chkBoxNoSpy.isSelected()) {
            generate(cbRevolver, "tf_weapon_revolver.txt", scripts);
            generate(cbKnife, "tf_weapon_knife.txt", scripts);
            generate(cbSapper, "tf_weapon_sapper.txt", scripts);
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

    public void generate(ChoiceBox<String> cbWeapon, String weaponTXT, File folderDir) throws IOException {
        String crosshair = removeExtension(cbWeapon.getValue());
        FileWriter script = new FileWriter(folderDir.getPath() + "/" + weaponTXT);
        File template = new File("templates/" + weaponTXT);
        String contents = "";
        Scanner scanner = new Scanner(template);

        while (scanner.hasNextLine()) {
            contents = contents.concat(scanner.nextLine() + "\n");
        }
        scanner.close();

        contents = contents.replace("vgui/replay/thumbnails/", "vgui/replay/thumbnails/" + crosshair);
        script.write(contents);
        script.close();
        addFileToList(crosshair);
    }

    @FXML
    protected void onBrowseClick() {
        DirectoryChooser dialog = new DirectoryChooser();
        File temp = dialog.showDialog(null);
        tfDirectory.setText(temp.getPath());
    }

    @FXML
    protected void onImportClick() throws IOException {
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

    public void initialize() {
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
    protected void onManageClick() throws IOException {
        FXMLLoader manageWindow = new FXMLLoader(getClass().getResource("manageGUI.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(manageWindow.load()));
        stage.setTitle("Manage crosshairs");
        stage.show();
    }

    @FXML
    protected void onAboutClick() throws IOException {
        FXMLLoader aboutWindow = new FXMLLoader(getClass().getResource("aboutGUI.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(aboutWindow.load()));
        stage.setTitle("About");
        stage.show();
    }

    public void refresh() {
        // Scout
        cbScattergun.setItems(list);
        cbSodaPopper.setItems(list);
        cbShortstop.setItems(list);
        cbBabyFaceBlaster.setItems(list);
        cbScoutPistol.setItems(list);
        cbWinger.setItems(list);
        cbCleaver.setItems(list);
        cbBonkDrink.setItems(list);
        cbMadMilk.setItems(list);
        cbBat.setItems(list);
        cbFishMelee.setItems(list);
        cbSandman.setItems(list);
        cbWrapAssassin.setItems(list);

        // Soldier
        cbRocketLauncher.setItems(list);
        cbDirectHit.setItems(list);
        cbMangler.setItems(list);
        cbAirStrike.setItems(list);
        cbSoldierSG.setItems(list);
        cbBuffs.setItems(list);
        cbBison.setItems(list);
        cbShovel.setItems(list);
        cbSoldierKatana.setItems(list);

        // Pyro
        cbFlameThrower.setItems(list);
        cbDragonFury.setItems(list);
        cbPyroSG.setItems(list);
        cbFlareGun.setItems(list);
        cbManmelter.setItems(list);
        cbThrusters.setItems(list);
        cbGasPasser.setItems(list);
        cbAxe.setItems(list);
        cbHotHand.setItems(list);

        // Demoman
        cbGrenadeLauncher.setItems(list);
        cbCannon.setItems(list);
        cbSticky.setItems(list);
        cbBottle.setItems(list);
        cbSwords.setItems(list);
        cbCaber.setItems(list);
        cbDemoKatana.setItems(list);

        // Heavy
        cbMiniGun.setItems(list);
        cbHeavySG.setItems(list);
        cbFood.setItems(list);
        cbFists.setItems(list);

        // Engineer
        cbEngiSG.setItems(list);
        cbPomson.setItems(list);
        cbRescueRanger.setItems(list);
        cbFrontierJustice.setItems(list);
        cbEngiPistol.setItems(list);
        cbWrangler.setItems(list);
        cbShortCircuit.setItems(list);
        cbWrench.setItems(list);
        cbGunslinger.setItems(list);

        // Medic
        cbSyringeGun.setItems(list);
        cbCrossbow.setItems(list);
        cbMediGun.setItems(list);
        cbBonesaw.setItems(list);

        // Sniper
        cbSniperRifle.setItems(list);
        cbClassic.setItems(list);
        cbHitman.setItems(list);
        cbHuntsman.setItems(list);
        cbSMG.setItems(list);
        cbCarbine.setItems(list);
        cbJarate.setItems(list);
        cbKukri.setItems(list);

        // Spy
        cbRevolver.setItems(list);
        cbKnife.setItems(list);
        cbSapper.setItems(list);
    }
}