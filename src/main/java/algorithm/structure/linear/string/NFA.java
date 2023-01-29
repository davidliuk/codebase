package algorithm.structure.linear.string;

import java.util.HashMap;
import java.util.Map;

public class NFA {
    public int myAtoi(String str) {
        Automaton automaton = new Automaton() {{
            for (int i = 0; i < str.length(); i++) {
                get(str.charAt(i));
            }
        }};

        return (int) (automaton.sign * automaton.ans);
    }
}

enum State {
    START,
    SIGNED,
    IN_NUMBER,
    END;
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private State state = State.START;
    private final Map<State, State[]> table = new HashMap<State, State[]>() {{
        put(State.START, new State[]{State.START, State.SIGNED, State.IN_NUMBER, State.END});
        put(State.SIGNED, new State[]{State.END, State.END, State.IN_NUMBER, State.END});
        put(State.IN_NUMBER, new State[]{State.END, State.END, State.IN_NUMBER, State.END});
        put(State.END, new State[]{State.END, State.END, State.END, State.END});
    }};

    public void get(char c) {
        state = table.get(state)[getCol(c)];
        switch (state) {
            case SIGNED:
                sign = c == '+' ? 1 : -1;
                break;
            case IN_NUMBER:
                ans = ans * 10 + c - '0';
                ans = sign == 1 ?
                        Math.min(ans, Integer.MAX_VALUE) :
                        Math.min(ans, -(long) Integer.MIN_VALUE);
                break;
        }
    }

    /**
     * @param c current char
     * @return column
     */
    private int getCol(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}
