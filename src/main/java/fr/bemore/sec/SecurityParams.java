package fr.bemore.sec;
/**
 * This Interface represents the securities params.
 *
 * @author Omar Moalla
 *
 * @version 1.0
 *
 */
public interface SecurityParams {
    public static final String JWT_HEADER_NAME = "Authorization";
    public static final String SECRET = "omar.moalla@bemore.com";
    public static final long EXPIRATION = 10 * 24 * 3600;
    public static final String HEADER_PREFIX = "Bearer ";
}
