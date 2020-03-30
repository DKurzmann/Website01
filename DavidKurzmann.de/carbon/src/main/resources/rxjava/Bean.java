import javax.enterprise.context.SessionScoped;

@Model
public class Bean implements serializable{

    public void testButtonAction() {
        System.out.println("testButtonAction invoked");
    }

    public void testButtonActionListener(ActionEvent event) {
        System.out.println("testButtonActionListener invoked");
    }
}
