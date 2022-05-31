package engine;

import org.fusesource.jansi.Ansi;

import agent.Agent;

public class EngineUtils {
    public static String getAgentString(Agent agent) {
        return Ansi.ansi().fg(Ansi.Color.BLUE).a("X").reset().toString();
    }
}
