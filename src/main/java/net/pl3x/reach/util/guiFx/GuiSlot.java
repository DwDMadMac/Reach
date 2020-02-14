package net.pl3x.reach.util.guiFx;

/**
 * This class will set and get the amount of inventory slots the custom GUI has
 *
 * This is the concrete class (node)
 */
public class GuiSlot {
    private int inventorySlot;

    /**
     * Get the amount of inventory slots in the GUI
     *
     * @return Return amount of inventory slots
     */
    public int getInventorySlot() {
        return inventorySlot;
    }

    /**
     * Set the amount of inventory slots inside the GUI
     *
     * @param inventorySlot Set inventory slots
     */
    public void setInventorySlot(int inventorySlot) {
        // TODO: Add an if statement to check for correct slot amount
        this.inventorySlot = inventorySlot;
        //notifyGuiHandlers();
    }
}
