package agents;

import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.core.behaviours.OneShotBehaviour;

public class OrderAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " received an order.");

        addBehaviour(new OneShotBehaviour() {
            public void action() {
                ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                msg.addReceiver(new AID("Picker1", AID.ISLOCALNAME));
                msg.setContent("Please pick Item A");
                send(msg);
                System.out.println(getLocalName() + " sent pick request.");
            }
        });
    }
}
