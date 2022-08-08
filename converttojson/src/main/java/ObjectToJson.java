
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Hebergement;

public class ObjectToJson {
    public static void main(String[] a)
    {
        // Creating object of Product
        Hebergement hebergement = new Hebergement();
        // Inserting the data into the object
       // hebergement = getObjectData(hebergement);
        // Creating Object of ObjectMapper define in Jackson API
        ObjectMapper Obj = new ObjectMapper();
        try {
            // Converting the Java object into a JSON string
            String jsonStr = Obj.writeValueAsString(hebergement);
            // Displaying Java object into a JSON string
            System.out.println(jsonStr);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Getting data that we want to insert into an object
  /*  public static Hebergement getObjectData(Hebergement product)
    {
        // Insert the data
        product.setId(101);
        product.setName("Spark 131");
        product.setPrice(10000);
        // Returning the product object
        return product;
    }*/
}
