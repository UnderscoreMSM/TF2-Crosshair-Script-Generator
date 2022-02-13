package group.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    Alert alertAbout = new Alert(Alert.AlertType.INFORMATION);
    FilenameFilter filter = ((dir, name) -> name.toLowerCase().endsWith(".vtf")); // Lambda expression for filtering files

    @FXML
    protected void onGenerateClick() {
        try {
            String targetDir = tfDirectory.getText();
            String scriptsDir = targetDir + "/Custom crosshairs/scripts";

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

            generate(cbScattergun, "tf_weapon_scattergun.txt", scriptsDir);
            generate(cbSodaPopper, "tf_weapon_soda_popper.txt", scriptsDir);
            generate(cbShortstop, "tf_weapon_handgun_scout_primary.txt", scriptsDir);
            generate(cbBabyFaceBlaster, "tf_weapon_pep_brawler_blaster.txt", scriptsDir);
            generate(cbScoutPistol, "tf_weapon_pistol_scout.txt", scriptsDir);
            generate(cbWinger, "tf_weapon_handgun_scout_secondary.txt", scriptsDir);
            generate(cbClassic, "tf_weapon_cleaver.txt", scriptsDir);
            generate(cbBonkDrink, "tf_weapon_lunchbox_drink.txt", scriptsDir);
            generate(cbMadMilk, "tf_weapon_jar_milk.txt", scriptsDir);
            generate(cbBat, "tf_weapon_bat.txt", scriptsDir);
            generate(cbFishMelee, "tf_weapon_bat_fish.txt", scriptsDir);
            generate(cbSandman, "tf_weapon_bat_wood.txt", scriptsDir);
            generate(cbWrapAssassin, "tf_weapon_bat_giftwarp.txt", scriptsDir);
            generate(cbRocketLauncher, "tf_weapon_rocketlauncher.txt", scriptsDir);
            generate(cbDirectHit, "tf_weapon_rocketlauncher_directhit.txt", scriptsDir);
            generate(cbMangler, "tf_weapon_particle_cannon.txt", scriptsDir);
            generate(cbAirStrike, "tf_weapon_rocketlauncher_airstrike.txt", scriptsDir);
            generate(cbSoldierSG, "tf_weapon_shotgun_soldier.txt", scriptsDir);
            generate(cbBuffs, "tf_weapon_buff_item.txt", scriptsDir);
            generate(cbBison, "tf_weapon_raygun.txt", scriptsDir);
            generate(cbShovel, "tf_weapon_shovel.txt", scriptsDir);
            generate(cbSoldierKatana, "tf_weapon_katana.txt", scriptsDir);
            generate(cbFlameThrower, "tf_weapon_flamethrower.txt", scriptsDir);
            generate(cbDragonFury, "tf_weapon_rocketlauncher_fireball.txt", scriptsDir);
            generate(cbPyroSG, "tf_weapon_shotgun_pyro.txt", scriptsDir);
            generate(cbFlareGun, "tf_weapon_flaregun.txt", scriptsDir);
            generate(cbManmelter, "tf_weapon_flaregun_revenge.txt", scriptsDir);
            generate(cbThrusters, "tf_weapon_rocketpack.txt", scriptsDir);
            generate(cbGasPasser, "tf_weapon_jar.txt", scriptsDir);
            generate(cbAxe, "tf_weapon_fireaxe.txt", scriptsDir);
            generate(cbHotHand, "tf_weapon_slap.txt", scriptsDir);
            generate(cbGrenadeLauncher, "tf_weapon_grenadelauncher.txt", scriptsDir);
            generate(cbCannon, "tf_weapon_cannon.txt", scriptsDir);
            generate(cbSticky, "tf_weapon_pipebomblauncher.txt", scriptsDir);
            generate(cbBottle, "tf_weapon_bottle.txt", scriptsDir);
            generate(cbSwords, "tf_weapon_sword.txt", scriptsDir);
            generate(cbCaber, "tf_weapon_stickbomb.txt", scriptsDir);
//            generate(cbDemoKatana, "tf_weapon_katana.txt", scriptsDir);
            generate(cbMiniGun, "tf_weapon_minigun.txt",  scriptsDir);
            generate(cbHeavySG, "tf_weapon_shotgun_hwg.txt", scriptsDir);
            generate(cbFood, "tf_weapon_lunchbox.txt", scriptsDir);
            generate(cbFists, "tf_weapon_fists.txt", scriptsDir);
            generate(cbEngiSG, "tf_weapon_shotgun_primary.txt", scriptsDir);
            generate(cbPomson, "tf_weapon_drg_pompson.txt", scriptsDir);
            generate(cbRescueRanger, "tf_weapon_shotgun_building_rescue.txt", scriptsDir);
            generate(cbFrontierJustice, "tf_weapon_sentry_revenge.txt", scriptsDir);
            generate(cbEngiPistol, "tf_weapon_pistol.txt", scriptsDir);
            generate(cbWrangler, "tf_weapon_laser_pointer.txt", scriptsDir);
            generate(cbShortCircuit, "tf_weapon_mechanical_arm.txt", scriptsDir);
            generate(cbWrench, "tf_weapon_wrench.txt", scriptsDir);
            generate(cbGunslinger, "tf_weapon_robot_arm.txt", scriptsDir);
            generate(cbSyringeGun, "tf_weapon_syringegun_medic.txt", scriptsDir);
            generate(cbCrossbow, "tf_weapon_crossbow.txt", scriptsDir);
            generate(cbMediGun, "tf_weapon_medigun.txt", scriptsDir);
            generate(cbBonesaw, "tf_weapon_bonesaw.txt", scriptsDir);
            generate(cbSniperRifle, "tf_weapon_sniperrifle.txt", scriptsDir);
            generate(cbHuntsman, "tf_weapon_compound_bow.txt", scriptsDir);
            generate(cbHitman, "tf_weapon_sniperrifle_decap.txt", scriptsDir);
            generate(cbClassic, "tf_weapon_sniperrifle_classic.txt", scriptsDir);
            generate(cbSMG, "tf_weapon_smg.txt", scriptsDir);
            generate(cbCarbine, "tf_weapon_charged_smg.txt", scriptsDir);
//            generate(cbJarate, "tf_weapon_jar.txt", scriptsDir);
            generate(cbKukri, "tf_weapon_club.txt", scriptsDir);
            generate(cbRevolver, "tf_weapon_revolver.txt", scriptsDir);
            generate(cbKnife, "tf_weapon_knife.txt", scriptsDir);
            generate(cbSapper, "tf_weapon_sapper.txt", scriptsDir);

            System.out.println("The following files will be copied:\n" + crosshairsGenerate);

            for (File e : crosshairsGenerate) { // Copies crosshair files to the generation path
                String src = "crosshairs/" + e.getName();
                String dest = destination + "/" + e.getName();
                System.out.println("Copying from " + src + " to " + dest);
                Files.copy(Path.of(src), Path.of(dest));
                System.out.println("Copying complete!");
            }
        } catch (Exception e) {
            System.out.println("Failed to generate; invalid path");
        }
    }

    public void generate(ChoiceBox<String> cbWeapon, String weaponTXT, String folderDir) throws IOException {
        addFileToList(removeExtension(cbWeapon.getValue()));
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
        ObservableList<String> list = FXCollections.observableList(Arrays.asList(crosshairFolder.list(filter)));
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

    public String removeExtension(String fileName) {
        if (fileName.contains(".")) {
            return fileName.substring(0, fileName.lastIndexOf("."));
        } else {
            return null;
        }
    }

    public String createScript(String vmtFile) { // Assuming the size is 64x64
        String template = """
                WeaponData
                {
                    TextureData
                    {
                        "crosshair"
                        {
                            "file"          "vgui/replay/thumbnails/""";
        template = template.concat(removeExtension(vmtFile) + """
                "
                            "x"		        "0"
                            "y"		        "0"
                            "width"		    "64"
                            "height"	    "64"
                        }
                    }
                }""");


        return template;
    }

    public void addFileToList(String crosshairName) {
        File vtfTemp = new File("crosshairs/" + crosshairName + ".vtf");
        File vmtTemp = new File("crosshairs/" + crosshairName + ".vmt");
        if (vtfTemp.exists() && vmtTemp.exists()) {
            if (!crosshairsGenerate.contains(vtfTemp) && !crosshairsGenerate.contains(vmtTemp)) {
                crosshairsGenerate.add(vtfTemp);
                crosshairsGenerate.add(vmtTemp);
            }
        }
    }
}