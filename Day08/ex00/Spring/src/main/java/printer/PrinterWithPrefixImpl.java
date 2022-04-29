package printer;

import renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer {
    private String prefix;
    private Renderer renderer;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
        prefix = "";
    }

    public void setPrefix(String prefix){
        this.prefix = prefix;
    }

    public void print(String str){
        renderer.print(this.prefix + " " + str);
    }
}
