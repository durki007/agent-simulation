package engine;

import org.fusesource.jansi.Ansi;

import agent.Agent;
import agent.AgentType;
import simulation.Organisation;

public class EngineUtils {
    public static String getAgentString(Agent agent) {
        return Ansi.ansi().fg(getAgentColor(agent.getOrganisation()))
                .a(surroundWithBraces(agent.type, getHPString(agent.getHp()))).reset()
                .toString();
    }

    private static String getHPString(int hp) {
        return String.format("%3d", hp);
    }

    private static Ansi.Color getAgentColor(Organisation o) {
        switch (o) {
            case MAFIA1:
                return Ansi.Color.BLUE;
            case MAFIA2:
                return Ansi.Color.RED;
            default:
                return Ansi.Color.WHITE;
        }
    }

    private static String surroundWithBraces(AgentType type, String string) {
        char b[] = { '(', ')' };
        switch (type) {
            case TANK:
                b[0] = '[';
                b[1] = ']';
                break;
            case SCOUT:
                b[0] = '<';
                b[1] = '>';
                break;
            default:
                break;
        }
        return String.format("%c%s%c", b[0], string, b[1]);
    }
}
