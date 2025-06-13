package agents;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.core.behaviours.CyclicBehaviour;

public class ManagerAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println(getLocalName() + " is monitoring the system.");

        addBehaviour(new CyclicBehaviour() {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println("LOG: Manager received update — " + msg.getContent());
                } else {
                    block();
                }
            }
        });
    }
}
