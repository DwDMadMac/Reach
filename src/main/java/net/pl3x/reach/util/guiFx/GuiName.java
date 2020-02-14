package net.pl3x.reach.util.guiFx;

/**
 * This class will set and get the inventory name for the custom GUI
 */
public class GuiName extends GuiEvent {
    private String inventoryName;

    /**
     * Gets the custom inventory name
     *
     * @return Return custom inventory name
     */
    public String getInventoryName() {
        return inventoryName;
    }

    /**
     * Sets the custom inventory name
     *
     * @param inventoryName Set custom inventory name
     */
    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

}
