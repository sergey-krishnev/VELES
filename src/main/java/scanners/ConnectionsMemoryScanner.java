package scanners;

import common.CommonConstants;
import memory.ShortMemory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConnectionsMemoryScanner extends MemoryScanner {

    public ConnectionsMemoryScanner(ShortMemory shortMemory) {
        super(shortMemory);
    }

    @Override
    protected BufferedReader init() throws IOException {
        return new BufferedReader(new FileReader(CommonConstants.CONNECTIONS_CSV));
    }

    @Override
    protected void analyze(int position, String line) {
        if (!"-".equals(line)) {
            String[] connections = line.split(",");
            for (String con : connections) {
                String[] connect = con.split(":");
                String posAnswerInConnection = connect[1];
                if (Integer.parseInt(posAnswerInConnection) == getShortMemory().getAnswerPositionFromAnswers()) {
                    getShortMemory().setQuestionPositionFromConnection(Integer.parseInt(connect[0]));
                    getShortMemory().setHasQuestion(true);
                }
            }
        }
    }

    @Override
    protected boolean checkNecessary(int position, String line) {
        return getShortMemory().getQuestionPositionFromConnection() == position;
    }
}
