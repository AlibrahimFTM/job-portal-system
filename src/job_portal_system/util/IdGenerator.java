package job_portal_system.util;

import java.util.UUID;

/**
 * توليد معرف فريد لكل كائن.
 */
public class IdGenerator {
    /**
     * @return معرف UUID فريد كنص
     */
    public static String generate() {
        return UUID.randomUUID().toString();
    }
}
