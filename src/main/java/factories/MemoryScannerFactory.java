package factories;

import memory.MemoryType;
import memory.ShortMemory;
import scanners.*;

public class MemoryScannerFactory {

    private ShortMemory shortMemory;

    public MemoryScannerFactory(ShortMemory shortMemory) {
        this.shortMemory = shortMemory;
    }

    public MemoryScanner createMemoryScanner(MemoryType memoryType) {
        MemoryScanner memoryScanner = null;

        switch (memoryType) {
            case QUESTIONS:
                memoryScanner = new QuestionsMemoryScanner(shortMemory);
                break;
            case CONNECTIONS:
                memoryScanner = new ConnectionsMemoryScanner(shortMemory);
                break;
            case ANSWERS:
                memoryScanner = new AnswersMemoryScanner(shortMemory);
                break;
            case FUZZY_WUZZY_ANSWERS:
                memoryScanner = new FuzzyWuzzyMemoryScanner(shortMemory);
                break;
        }

        return memoryScanner;

    }

}
