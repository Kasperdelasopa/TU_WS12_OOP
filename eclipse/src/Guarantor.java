import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Guarantor(person="Manuel Schmitt")
@Retention( RetentionPolicy.RUNTIME )
public @interface Guarantor {
	//This Annotation is for annotate which person was responsible for developing a Method or a class
	String person();
}
