package arayuzler;

import java.util.function.BiConsumer;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.web.RunnerData;
import islemler.Baglanti;
import textio.demo.app.AppUtil;
public class TextIoUiApp implements BiConsumer<TextIO,RunnerData>{
    @Override
    public void accept(TextIO textIO,RunnerData runnerData){
    TextTerminal<?> terminal = textIO.getTextTerminal();
        String initData = (runnerData == null) ? null : runnerData.getInitData();
        AppUtil.printGsonMessage(terminal, initData);
        Baglanti baglanti=new Baglanti();
    baglanti.ac();
        String deneme=textIO.newStringInputReader()
            .read("isminiz?");
        

        // TextTerminal<?> terminal=textIO.getTextTerminal();
        terminal.printf("\n İsminiz: %s",deneme);

        textIO.newStringInputReader().withMinLength(0).read("\nPress enter to terminate...");
    baglanti.kompleKapat();
        textIO.dispose("User '" + deneme + "' has left the building.");
    }
    public static void main(String[] args) {
        TextIO textIO = TextIoFactory.getTextIO();
        new TextIoUiApp().accept(textIO, null);
}

}
