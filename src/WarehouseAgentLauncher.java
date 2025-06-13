import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.ContainerController;

public class WarehouseAgentLauncher {
    public static void main(String[] args) {
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();
        ContainerController cc = rt.createMainContainer(p);

        try {
            cc.createNewAgent("Manager", "agents.ManagerAgent", null).start();
            cc.createNewAgent("Order1", "agents.OrderAgent", null).start();
            cc.createNewAgent("Picker1", "agents.PickerAgent", null).start();
            cc.createNewAgent("Packer1", "agents.PackerAgent", null).start();
            cc.createNewAgent("Transport1", "agents.TransportAgent", null).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
