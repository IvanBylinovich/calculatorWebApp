package by.IvanHWtms.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Session {

    private String userName;
    private int a;
    private int b;
    private String operation;
    private String result;

    @Override
    public String toString() {
        String s = "";
        switch (operation) {
            case ("sum"):
                s = "+";
                break;
            case ("min"):
                s = "-";
                break;
            case ("div"):
                s = "/";
                break;
            case ("mul"):
                s = "*";
                break;
        }

        return "{" + a + " " + s + " " + b +
                " = "  + result + "}";
    }
}
