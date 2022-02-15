package group.demo1;

import java.io.File;

/*
This class' purpose is to store the size of a crosshair.
 */

public class Crosshair {
    private File vtfFile;
    private File vmtFile;
    private int size;

    public Crosshair(File vtfFile, File vmtFile, int size) {
        this.vtfFile = vtfFile;
        this.vmtFile = vmtFile;
        this.size = size;
    }
}
