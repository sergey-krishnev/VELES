import common.CommonUtils;
import factories.MemoryScannerFactory;
import memory.MemoryType;
import memory.ShortMemory;
import scanners.*;

import java.io.*;

public class Dialog {

    private BufferedReader console;

    public void start() throws IOException {
        try {
            console = initConsoleReader();
            ShortMemory shortMemory = new ShortMemory();
            MemoryScannerFactory factory = new MemoryScannerFactory(shortMemory);
            MemoryScanner questions = factory.createMemoryScanner(MemoryType.QUESTIONS);
            MemoryScanner answers = factory.createMemoryScanner(MemoryType.FUZZY_WUZZY_ANSWERS);
            MemoryScanner connections = factory.createMemoryScanner(MemoryType.CONNECTIONS);
            shortMemory.setQuestionPositionFromConnection(0);
            while (shortMemory.isHasQuestion()) {
                shortMemory.setHasQuestion(false);
                questions.scan();
                shortMemory.setResponse(console.readLine());
                answers.scan();
                shortMemory.setPreviousDistanceBetweenStrings(0);
                connections.scan();
            }
            CommonUtils.say("Даже не знаю, что на это ответить");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (console != null) {
                console.close();
            }
        }
    }

    private BufferedReader initConsoleReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

}
