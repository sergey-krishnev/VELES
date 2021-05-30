package scanners;

import common.CommonConstants;
import memory.ShortMemory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnswersMemoryScanner extends MemoryScanner {

    public AnswersMemoryScanner(ShortMemory shortMemory) {
        super(shortMemory);
    }

    @Override
    protected BufferedReader init() throws IOException {
        return new BufferedReader(new FileReader(CommonConstants.ANSWER_TOKENS_CSV));
    }

    @Override
    protected void analyze(int position, String line) {
        getShortMemory().setAnswerPositionFromAnswers(position);
    }

    @Override
    protected boolean checkNecessary(int position, String line) {
        return getShortMemory().getResponse().equals(line);
    }
}
