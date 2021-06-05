package math;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;

public class QuestionPanel extends JPanel {

    private JLabel question;
    private JPanel p1, p2, p3;
    private InformationPanel informationPanel;
    private JButton answer1, answer2, answer3, answer4, start;
    private ButtonListener buttonListener;
    private int rightAnswer,score;
    private Boolean started, stopListener;
    private Timer timer;
    private final int totalTime = 100;
    Random random = new Random();


    private final Font QUESTION_FONT = new Font("Italic",Font.PLAIN,80);
    private final Font ANSWER_FONT = new Font("Italic",Font.BOLD,30);
    private final Color BACKGROUND = new Color(192,192,192);


    public QuestionPanel() {
        game();
    }

    private void game(){

        buttonListener = new ButtonListener();
        question = new JLabel();
        question.setFont(QUESTION_FONT);

        p1 = new JPanel();
        p1.setPreferredSize(new Dimension(300, 300));
        p1.add(question);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(2,2));

        answer1 = new JButton();
        answer1.setFont(ANSWER_FONT);
        answer1.addActionListener(buttonListener);
        p2.add(answer1);
        answer2 = new JButton();
        answer2.setFont(ANSWER_FONT);
        answer2.addActionListener(buttonListener);
        p2.add(answer2);
        answer3 = new JButton();
        answer3.setFont(ANSWER_FONT);
        answer3.addActionListener(buttonListener);
        p2.add(answer3);
        answer4 = new JButton();
        answer4.setFont(ANSWER_FONT);
        answer4.addActionListener(buttonListener);
        p2.add(answer4);

        p3 =new JPanel();
        p3.setPreferredSize(new Dimension(600, 300));
        p3.setLayout(new GridLayout(2,1));
        p3.add(p1);
        p3.add(p2);
        add(p3);

        informationPanel = new InformationPanel();
        add(informationPanel);

        newQuestion();
        started = false;
        stopListener = false;
        informationPanel.setTimer(String.valueOf(totalTime));

        timer = new Timer();
        timer.schedule(new TimerTask() {
            int i = totalTime;
            @Override
            public void run() {
                if(started) informationPanel.setTimer(String.valueOf(i--));
                if(i < 0) {
                    started = false;
                    stopListener = true;
                    timer.cancel();
                }
            }
        },0, 1000);
    }

    private void newQuestion(){
        add10();
//        if (random.nextBoolean()) add100();
//        else minus100();
    }

    private void add10(){
        int num1 = random.nextInt(21);
        int num2 = random.nextInt(11);
        if (random.nextBoolean()){
            int temp = num1;
            num1 = num2;
            num2 =temp;
        }
        int sum = num1 + num2;
        Set<Integer> set=new HashSet();
        set.add(sum);
        while (set.size() < 4){
            int i = sum - 3 + random.nextInt(7);
            if (i >= 0)set.add(i);
        }
        ArrayList<Integer> list = new ArrayList(set);
        int a1 = list.get(random.nextInt(4));
        set.remove(a1);
        list = new ArrayList(set);
        int a2 = list.get(random.nextInt(3));
        set.remove(a2);
        list = new ArrayList(set);
        int a3 = list.get(random.nextInt(2));
        set.remove(a3);
        list = new ArrayList(set);
        int a4 = list.get(0);
        if (sum == a1)rightAnswer = 1;
        if (sum == a2)rightAnswer = 2;
        if (sum == a3)rightAnswer = 3;
        if (sum == a4)rightAnswer = 4;

        String questionString = num1 + " + " + num2 + " = ?";
        question.setText(questionString);
        answer1.setText(String.valueOf(a1));
        answer2.setText(String.valueOf(a2));
        answer3.setText(String.valueOf(a3));
        answer4.setText(String.valueOf(a4));
    }

    private void add100(){
        int num1 = random.nextInt(101);
        int num2 = random.nextInt(101);
        int sum = num1 + num2;
        Set<Integer> set=new HashSet();
        set.add(sum);
        while (set.size() < 4){
            int i;
            if (random.nextBoolean()) i = sum - 2 + random.nextInt(5);
            else i = sum + 20 * random.nextInt(2) - 10;
            if (i >= 0)set.add(i);
        }
        ArrayList<Integer> list = new ArrayList(set);
        int a1 = list.get(random.nextInt(4));
        set.remove(a1);
        list = new ArrayList(set);
        int a2 = list.get(random.nextInt(3));
        set.remove(a2);
        list = new ArrayList(set);
        int a3 = list.get(random.nextInt(2));
        set.remove(a3);
        list = new ArrayList(set);
        int a4 = list.get(0);
        if (sum == a1)rightAnswer = 1;
        if (sum == a2)rightAnswer = 2;
        if (sum == a3)rightAnswer = 3;
        if (sum == a4)rightAnswer = 4;

        String questionString = num1 + " + " + num2 + " = ?";
        question.setText(questionString);
        answer1.setText(String.valueOf(a1));
        answer2.setText(String.valueOf(a2));
        answer3.setText(String.valueOf(a3));
        answer4.setText(String.valueOf(a4));
    }

    private void minus100(){
        int num1 = random.nextInt(101);
        int num2 = random.nextInt(101);
        if (num1 < num2){
            int temp = num1;
            num1 = num2;
            num2 =temp;
        }
        int result = num1 - num2;
        Set<Integer> set=new HashSet();
        set.add(result);
        while (set.size() < 4){
            int i;
            if (random.nextBoolean()) i = result - 2 + random.nextInt(5);
            else i = result + 20 * random.nextInt(2) - 10;
            if (i >= 0)set.add(i);
        }
        ArrayList<Integer> list = new ArrayList(set);
        int a1 = list.get(random.nextInt(4));
        set.remove(a1);
        list = new ArrayList(set);
        int a2 = list.get(random.nextInt(3));
        set.remove(a2);
        list = new ArrayList(set);
        int a3 = list.get(random.nextInt(2));
        set.remove(a3);
        list = new ArrayList(set);
        int a4 = list.get(0);
        if (result == a1)rightAnswer = 1;
        if (result == a2)rightAnswer = 2;
        if (result == a3)rightAnswer = 3;
        if (result == a4)rightAnswer = 4;

        String questionString = num1 + " - " + num2 + " = ?";
        question.setText(questionString);
        answer1.setText(String.valueOf(a1));
        answer2.setText(String.valueOf(a2));
        answer3.setText(String.valueOf(a3));
        answer4.setText(String.valueOf(a4));
    }

    private void multiple(){
        int num1 = random.nextInt(11);
        int num2 = random.nextInt(11);
        int sum = num1 * num2;
        Set<Integer> set=new HashSet();
        set.add(sum);
        while (set.size() < 4){
            int i = sum - 10 + random.nextInt(21);
            if (i >= 0)set.add(i);
        }
        ArrayList<Integer> list = new ArrayList(set);
        int a1 = list.get(random.nextInt(4));
        set.remove(a1);
        list = new ArrayList(set);
        int a2 = list.get(random.nextInt(3));
        set.remove(a2);
        list = new ArrayList(set);
        int a3 = list.get(random.nextInt(2));
        set.remove(a3);
        list = new ArrayList(set);
        int a4 = list.get(0);
        if (sum == a1)rightAnswer = 1;
        if (sum == a2)rightAnswer = 2;
        if (sum == a3)rightAnswer = 3;
        if (sum == a4)rightAnswer = 4;

        String questionString = num1 + " x " + num2 + " = ?";
        question.setText(questionString);
        answer1.setText(String.valueOf(a1));
        answer2.setText(String.valueOf(a2));
        answer3.setText(String.valueOf(a3));
        answer4.setText(String.valueOf(a4));
    }


    private class ButtonListener implements ActionListener {

        public void actionPerformed (ActionEvent event) {

            if (event.getSource() == start){ game();}
            if(!stopListener){
                started = true;
                Boolean isCorrect = false;
                if (event.getSource() == answer1 && rightAnswer == 1)isCorrect = true;
                if (event.getSource() == answer2 && rightAnswer == 2)isCorrect = true;
                if (event.getSource() == answer3 && rightAnswer == 3)isCorrect = true;
                if (event.getSource() == answer4 && rightAnswer == 4)isCorrect = true;
                informationPanel.setMark(isCorrect);
                if (isCorrect){
                    Music.rightMusic();
                    newQuestion();
                    score++;
                }
                else {
                    Music.wrongMusic();
                    score = score - 2;
                }
                if (score < 0) score = 0;
                informationPanel.setScore(String.valueOf(score));
            }

        }
    }
}