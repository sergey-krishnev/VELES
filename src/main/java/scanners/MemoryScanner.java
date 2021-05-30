package scanners;

import memory.ShortMemory;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class MemoryScanner {

    private ShortMemory shortMemory;

    protected abstract BufferedReader init() throws IOException;
    protected abstract void analyze(int position, String line);
    protected abstract boolean checkNecessary(int position, String line);

    public MemoryScanner(ShortMemory shortMemory) {
        this.shortMemory = shortMemory;
    }

    public void scan() throws IOException {
        String line;
        int position = 0;
        BufferedReader bufferedReader = init();
        while ((line = bufferedReader.readLine()) != null) {
            if (checkNecessary(position, line)) {
                analyze(position, line);
                break;
            }
            position++;
        }
        bufferedReader.close();
    }

    protected ShortMemory getShortMemory() {
        return shortMemory;
    }

}
