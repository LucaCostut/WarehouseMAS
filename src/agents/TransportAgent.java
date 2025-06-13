package agents;

import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.core.behaviours.CyclicBehaviour;

public class TransportAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " is ready for deliveries.");

        addBehaviour(new CyclicBehaviour() {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println(getLocalName() + " received: " + msg.getContent());

                    ACLMessage notify = new ACLMessage(ACLMessage.INFORM);
                    notify.addReceiver(new AID("Manager", AID.ISLOCALNAME));
                    notify.setContent("Item A delivered");
                    send(notify);
                    System.out.println(getLocalName() + " notified Manager of delivery.");
                } else {
                    block();
                }
            }
        });
    }
}
