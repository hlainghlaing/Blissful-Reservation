package ojt.blissfulreservation.system.common;

/**
 * <h2>Constants Class</h2>
 * <p>
 * Process for Displaying Constants
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
public class Constants {
    public enum RoleType {
        ADMIN("0"), USER("1");

        private final String value;

        RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
