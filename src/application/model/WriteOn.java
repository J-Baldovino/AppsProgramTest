package application.model;

import java.util.Random;

import application.inter.Toutput;

public class WriteOn implements Runnable {

    private String text;
    private int animationTime;
    private Toutput textOutput;
    private Random random = new Random();

    public WriteOn(String text, int animationTime, Toutput textField) {
        this.text = text;
        this.animationTime = animationTime;
        this.textOutput = textField;
    }

    @Override
    public void run() {

        try {
        for (int i = 0; i <= text.length(); i++) {
            String textAtThisPoint = text.substring(0,i);

                textOutput.writeText(textAtThisPoint);
                Thread.sleep(animationTime + random.nextInt(150));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
