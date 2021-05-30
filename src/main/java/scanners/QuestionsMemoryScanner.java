package scanners;

import common.CommonConstants;
import common.CommonUtils;
import memory.ShortMemory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuestionsMemoryScanner extends MemoryScanner {

    public QuestionsMemoryScanner(ShortMemory shortMemory) {
        super(shortMemory);
    }

    @Override
    protected BufferedReader init() throws IOException {
        return new BufferedReader(new FileReader(CommonConstants.QUESTIONS_CSV));
    }

    @Override
    protected void analyze(int position, String line) {
        CommonUtils.say(line);
    }

    @Override
    protected boolean checkNecessary(int position, String line) {
        return getShortMemory().getQuestionPositionFromConnection() == position;
    }
}
