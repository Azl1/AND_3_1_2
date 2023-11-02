package com.abdullaev.and_3_1_2;

public class CalculatorModel {

    private int firstArg;
    private int secondArg;

    private StringBuilder inputStr = new StringBuilder();
    private int actionSelected;
    private State state;

    private enum State {
        FIRSTARGINPUT,
        SECONDARGINPUT,
        RESULTSHOW

    }

    public CalculatorModel() {
        state = State.FIRSTARGINPUT;

    }

    public void onNumPressed(int buttonId){

        if (state == State.RESULTSHOW) {
            state = State.FIRSTARGINPUT;
            inputStr.setLength(0);
        }

        if(inputStr.length() < 9) {
            switch (buttonId) {
                case R.id.zero:
                    if (inputStr.length() != 0) {
                        inputStr.append("0");
                    }
                    break;
                case R.id.one:
                    inputStr.append("1");
                    break;
                case R.id.two:
                    inputStr.append("2");
                    break;
                case R.id.three:
                    inputStr.append("3");
                    break;
                case R.id.four:
                    inputStr.append("4");
                    break;
                case R.id.five:
                    inputStr.append("5");
                    break;
                case R.id.six:
                    inputStr.append("6");
                    break;
                case R.id.seven:
                    inputStr.append("7");
                    break;
                case R.id.eight:
                    inputStr.append("8");
                    break;
                case R.id.nine:
                    inputStr.append("9");
                    break;
            }
        }
    }

    public void onActionPressed(int actionId){

        if (actionId == R.id.equals && state == State.SECONDARGINPUT) {
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.RESULTSHOW;
            inputStr.setLength(0);
            switch (actionId) {
                case R.id.plus:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.minus:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.multiply:
                    inputStr.append(firstArg * secondArg);
                    break;
                case R.id.divsion:
                    inputStr.append(firstArg / secondArg);
                    break;
            }

        } else if (inputStr.length() > 0 && state == State.FIRSTARGINPUT) {
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.SECONDARGINPUT;
            inputStr.setLength(0);
            switch (actionId) {
                case R.id.plus:
                    actionSelected = R.id.plus;
                    break;
                case R.id.minus:
                    actionSelected = R.id.minus;
                    break;
                case R.id.multiply:
                    actionSelected = R.id.multiply;
                    break;
                case R.id.divsion:
                    actionSelected = R.id.plus;
                    break;
            }
        }
    }

    public String getText() {
        return inputStr.toString();
    }
}
