package christmas.View;

import static christmas.Global.PrintPhrase.GREETING;
import static christmas.Global.PrintPhrase.MENU_ORDER_INPUT_NOTICE;
import static christmas.Global.PrintPhrase.RESULT_PREVIEW_OUTPUT;
import static christmas.Global.PrintPhrase.VISIT_INPUT_NOTICE;

import christmas.DTO.ResultDTO;
import christmas.Global.ResultPhrase;
import java.util.HashMap;

public class View {
    private InputView inputView;
    private OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void putGreetings() {
        outputView.print(GREETING.getPhrase());
    }

    public int getVisitDate() {
        outputView.print(VISIT_INPUT_NOTICE.getPhrase());
        return inputView.getDateInput();
    }

    public HashMap<String, Integer> getMenuOrder() {
        outputView.print(MENU_ORDER_INPUT_NOTICE.getPhrase());
        return inputView.getMenuInput();
    }

    public void printOrderResult(int date, ResultDTO resultDTO) {
        outputView.print(RESULT_PREVIEW_OUTPUT.getPhrase(date));
        for (ResultPhrase rp : ResultPhrase.values()) {
            outputView.print(rp.getPhrase(resultDTO));
        }
    }

    public void printError(String error) {
        outputView.print(error);
    }
}
