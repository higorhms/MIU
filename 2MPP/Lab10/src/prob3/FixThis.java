package prob3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixThis {
    List<String> processList(List<String> list) {
        return list.stream()
                .map((String x) ->
                        doNothingHelper(x))
                .collect(Collectors.toList());

    }

    public String doNothingHelper(String input) {
        try {
            return doNothingIfShort(input);
        } catch (InputTooLongException e) {
            throw new RuntimeException(e);
        }
    }

    String doNothingIfShort(String input) throws InputTooLongException {
        if (input.length() > 3) throw new InputTooLongException();
        else return input;
    }

    public static void main(String[] args) {
        FixThis ft = new FixThis();
        List<String> words1 = Arrays.asList("not", "too", "big", "yet");
    }

    class InputTooLongException extends Exception {
        private static final long serialVersionUID = 1L;

        public InputTooLongException() {
            super("Must be length 3 or less");
        }

        public InputTooLongException(String s) {
            super(s);
        }

        public InputTooLongException(Throwable t) {
            super(t);
        }
    }
}
