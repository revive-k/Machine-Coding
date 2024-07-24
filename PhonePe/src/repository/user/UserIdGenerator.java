package repository.user;

/*
    * This class is responsible for generating unique user ids.
    * In case there multiple implementation of repository interface, then id counter should be shared across all implementations.
*/
public class UserIdGenerator {
    private static long userIdCounter = 1L;

    public static long generateUserId() {
        return userIdCounter++;
    }
}
