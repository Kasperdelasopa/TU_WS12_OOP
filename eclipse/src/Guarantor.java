import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Guarantor(person="Manuel Schmitt")
@Retention( RetentionPolicy.RUNTIME )
public @interface Guarantor {
	String person();
}
