package prog24parse;

import java.util.Arrays;

public class Prog4 {
    public static void main(String[] args) {
        String[] arrayOfRecords = Data.records.split(":");
        for(String record : arrayOfRecords){
            System.out.println(record.split(",")[0]);
        }

        /**
         * Result:
         * 231A
         * 113D
         * 521W
         * 440Q
         * 009G
         * 336C
         * 523E
         * 888A
         * 176A
         * 176B
         * 176C
         * 500D
         * 135B
         * 211Q
         * 932V
         * 678Q
         * 239A
         * 975B
         * 870K
         * 231S
         * 562M
         * 777X
         * 933W
         * 215A
         */
    }
}
