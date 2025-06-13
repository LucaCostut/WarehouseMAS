package agents;

import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.core.behaviours.CyclicBehaviour;

public class PackerAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " is ready to pack items.");

        addBehaviour(new CyclicBehaviour() {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println(getLocalName() + " received: " + msg.getContent());

                    ACLMessage reply = new ACLMessage(ACLMessage.INFORM);
                    reply.addReceiver(new AID("Transport1", AID.ISLOCALNAME));
                    reply.setContent("Item A packed and ready to ship");
                    send(reply);
                    System.out.println(getLocalName() + " sent package to transport.");
                } else {
                    block();
                }
            }
        });
    }
}
