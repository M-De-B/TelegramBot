import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            if (message.getText().equals("/help")) {
                sendMsg(message, "Hi");
            }
            if(message.getText().equals("/code")){
                sendMsg(message, "Ваш  промо-код: "+ Code.CodeCreate(8));
            }
            else
                sendMsg(message, "Я тестовый робот");
        }

    }

    private void sendMsg(Message message, String s) {
        SendMessage sendMessage = new SendMessage();
       // sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        //sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "M_De_Be_Bot";
    }

    @Override
    public String getBotToken() {
        return "717318421:AAGNSfkQ3YsHSaH_-MiJq6qpOd0yJ7GZ2Tg";
    }
}
