package de.dealexlp;

public class Password {

    private final int min;
    private final int max;
    private final char letter;
    private final String password;

    Password(final String line) {
        final int dashEnd = line.indexOf("-");
        final int spaceEnd = line.indexOf(" ");

        this.min = Integer.parseInt(line.substring(0, dashEnd));
        this.max = Integer.parseInt(line.substring(dashEnd + 1, spaceEnd));
        this.letter = line.substring(spaceEnd + 1, spaceEnd + 2).charAt(0);
        this.password = line.substring(spaceEnd + 4);
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public char getLetter() {
        return letter;
    }

    public String getPassword() {
        return password;
    }

}
