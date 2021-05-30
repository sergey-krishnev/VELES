package scanners;

import common.CommonConstants;
import common.CommonUtils;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import memory.ShortMemory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FuzzyWuzzyAnswersMemoryScanner extends MemoryScanner {

    public FuzzyWuzzyAnswersMemoryScanner(ShortMemory shortMemory) {
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
        if (getShortMemory().getConnection().containsValue(position)) {
            int distance = FuzzySearch.weightedRatio(getShortMemory().getResponse(), line);
            CommonUtils.log("Distance benween '" + getShortMemory().getResponse()
                    + "' and '" + line + "' " + distance);
            if (getShortMemory().getPreviousDistanceBetweenStrings() < distance && distance >= 50) {
                CommonUtils.log("Maybe answer with this position " + position + " is better");
                getShortMemory().setPreviousDistanceBetweenStrings(distance);
                return true;
            }
        }
        return false;
    }

    @Override
    public void scan() throws IOException {
        String line;
        int position = 0;
        BufferedReader bufferedReader = init();
        while ((line = bufferedReader.readLine()) != null) {
            if (checkNecessary(position, line)) {
                analyze(position, line);
            }
            position++;
        }
        bufferedReader.close();
    }

}
