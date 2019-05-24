package arayuzler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import org.beryx.textio.InputReader;
import org.beryx.textio.IntInputReader;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.web.RunnerData;
// import org.beryx.textio.web.TextIoApp;
import arayuzler.textio.AppUtil;

public class ShellDialogs  implements BiConsumer<TextIO,RunnerData>{
    @Override
    public void  accept(TextIO textIO,RunnerData runnerData){
        TextTerminal<?> terminal = textIO.getTextTerminal();
        String initData = (runnerData == null) ? null : runnerData.getInitData();
        AppUtil.printGsonMessage(terminal, initData);
        String user=textIO.newStringInputReader()
            .read("isminiz nedir?");

    InputReader<Integer,IntInputReader> g=textIO.newIntInputReader();
    // int g=textIO.newIntInputReader()
    List<String>hoba=new ArrayList();
    hoba.add("Lütfen bir tamsayi giriniz");
    // hoba.add("item");
    InputReader.ErrorMessagesProvider emp=(n1,n2)->hoba;
    int a=g.withParseErrorMessagesProvider(emp)
        .read("IPA Arşiv Yönetim Sistemine Hoşgeldiniz\n"+
        "Lütfen Yapmak İstediğiniz işlemi seçiniz:\n"+
                "1-Yeni Kayıt\n"+
                "2-Dokuman Arama\n"+
                "3-Güncelleme/Silme\n");

        terminal.printf("\n %s girişi: %d.\n", user, a);

        textIO.newStringInputReader().withMinLength(0).read("\nPress enter to terminate...");
        textIO.dispose("User '" + user + "' has left the building.");
    }
}
