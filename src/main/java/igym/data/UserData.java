package igym.data;

import igym.entity.User;

public class UserData {
    public static User admin()
    {
        User user = new User();
        user.setEmail("admin@admin.com");
        user.setPassword("123456");

        return user;
    }

    public static User administrator()
    {
        User user = new User();
        user.setEmail("work@work.com");
        user.setPassword("123456");

        return user;
    }

    public static User trainer()
    {
        User user = new User();
        user.setEmail("trainer@trainer.com");
        user.setPassword("123456");

        return user;
    }
}
