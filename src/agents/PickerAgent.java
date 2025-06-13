package agents;

import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.core.behaviours.CyclicBehaviour;

public class PickerAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " is ready to pick items.");

        addBehaviour(new CyclicBehaviour() {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println(getLocalName() + " received: " + msg.getContent());

                    ACLMessage reply = new ACLMessage(ACLMessage.INFORM);
                    reply.addReceiver(new AID("Packer1", AID.ISLOCALNAME));
                    reply.setContent("Item A picked");
                    send(reply);
                    System.out.println(getLocalName() + " sent item to packer.");
                } else {
                    block();
                }
            }
        });
    }
}
