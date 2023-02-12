package channels;

public interface Channel {

    String welcome();

    String getChannelName();

    String serveClient();

    String farewell();
}