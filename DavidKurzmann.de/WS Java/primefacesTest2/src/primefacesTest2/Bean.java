package primefacesTest2;



import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.event.ActionEvent;

@Model
public class Bean{

    public void testButtonAction() {
        System.out.println("testButtonAction invoked");
    }

    public void testButtonActionListener(ActionEvent event) {
        System.out.println("testButtonActionListener invoked");
    }
}
