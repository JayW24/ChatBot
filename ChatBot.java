import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;

public abstract class ChatBot {
    private String[] arr = { "PUTLER HAVE TO DIE", "RUSSIA - THE CANCER OF EUROPE",
            "RUSSIAN ECONOMY WILL DIE DUE TO WESTERN SANCTIONS", "F00CK PUTIN", "RUSSIA WILL DIE" };

    private String choosePropagandaText() {
        int min = 0;
        int max = arr.length;
        int rand = (int) (Math.random() * max) + min;
        System.out.print("Choosen propaganda text: " + arr[rand]);
        return arr[rand];
    }

    private int secToMills(int mills) {
        return mills * 1000;
    }

    private int generateMathRandom(int limit, int min) {
        return (int) (Math.random() * limit) + min;
    }

    private void clickItem(int xCoord, int yCoord) throws InterruptedException {
        try {
            int random = generateMathRandom(secToMills(1), 50);
            System.out.print("First delay time: " + random);
            Thread.sleep(random);
            Robot robot = new Robot();
            robot.mouseMove(xCoord, yCoord);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        } catch (AWTException e) {
        }
    }

    private void typeText(String text) throws InterruptedException {
        try {
            int random = generateMathRandom(secToMills(10), secToMills(1));
            System.out.print("First delay time: " + random);
            Thread.sleep(random);
            Robot r = new Robot();
            String a = text;
            char c;
            int d = a.length(), e = 0, f = 0;

            while (e < d) {
                System.out.print(" || Current letter index: " + e + "| Current letter: " + a.charAt(e) + "\n");
                int rand = generateMathRandom(200, 40);
                c = a.charAt(e);
                f = (int) c; // converts character to Unicode.
                r.keyPress(KeyEvent.getExtendedKeyCodeForChar(f));
                e++;
                System.out.print(" || Time of random between Letters: " + rand);
                Thread.sleep(rand);
            }
        } catch (AWTException e) {
        }
    }

    private void hitEnter() throws InterruptedException {
        try {
            int rand = generateMathRandom(150, 20);
            System.out.print(" || Delay time on enter: " + rand);
            Thread.sleep(rand);
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
        }
    }

    public void main(String[] args) throws InterruptedException {
        clickItem(1670, 1050); // click form
        int counter = 0;
        boolean go = true;
        int total = 10;
        while (go) {
            System.out.print("\n****************************** N E X T -- T E X T ******************************\n");
            counter++;
            typeText(choosePropagandaText()); // type comment
            hitEnter(); // EXECUTE
            if(counter >= total) {
                go = false;
            }
        }
    }
}